package net.pointbridge.android.sales.plugin.backgroundservice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import java.util.TimerTask;

import org.json.JSONObject;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.util.Log;

import net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceApi;
import net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceListener;

public abstract class BackgroundService extends Service {
	
	/*
	 ************************************************************************************************
	 * Static values 
	 ************************************************************************************************
	 */
	private static final String TAG = BackgroundService.class.getSimpleName();

	/*
	 ************************************************************************************************
	 * Fields 
	 ************************************************************************************************
	 */
	private Timer mTimer;
	
	private final Object mResultLock = new Object();
	private JSONObject mLatestResult = null;

	private List<BackgroundServiceListener> mListeners = new ArrayList<BackgroundServiceListener>();
	
	private TimerTask mUpdateTask;
	
	private Date mPausedUntil = null;

	public void setPauseDuration(long pauseDuration) {
		this.mPausedUntil = new Date(new Date().getTime() + pauseDuration);
		
		// Call the onPause event
		onPause();
	}
	
	private Boolean getEnabled() {
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);  

		return sharedPrefs.getBoolean(this.getClass().getName() + ".Enabled", false);
	}

	private void setEnabled(Boolean enabled) {
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);  

		SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean(this.getClass().getName() + ".Enabled", enabled);
        editor.commit(); // Very important
	}
	
	private int getMilliseconds() {
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);  

		// Should default to a minute
		return sharedPrefs.getInt(this.getClass().getName() + ".Milliseconds", 60000 );	
	}

	private void setMilliseconds(int milliseconds) {
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);  

		SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt(this.getClass().getName() + ".Milliseconds", milliseconds);
        editor.commit(); // Very important
	}


	/*
	 ************************************************************************************************
	 * Overriden Methods 
	 ************************************************************************************************
	 */

	@Override  
	public IBinder onBind(Intent intent) {
		 
		Log.i(TAG, "onBind called");
		return apiEndpoint;
	}     
	
	@Override  
	public void onCreate() {     
		super.onCreate();     
		Log.i(TAG, "Service creating");

		// Initialise the LatestResult object
		JSONObject tmp = initialiseLatestResult();

		synchronized (mResultLock) {
			Log.i(TAG, "Syncing result");
			mLatestResult = tmp;
		};

		
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.i(TAG, "Service started");       

		if (getEnabled())
			this.setupTimerTask();
	}
	
	@Override  
	public void onDestroy() {     
		super.onDestroy();     
		Log.i(TAG, "Service destroying");
		
		Log.i(TAG, "Stopping timer task");
		stopTimerTask();

		Log.i(TAG, "Removing the timer");
		if (this.mTimer != null) {
			Log.i(TAG, "Timer is not null");
			try {
				this.mTimer.cancel();     
				Log.i(TAG, "Timer.cancel has been called");
				this.mTimer = null;
			} catch (Exception ex) {
				Log.i(TAG, "Exception has occurred - " + ex.getMessage());
			}
		}
	}

	/*
	 ************************************************************************************************
	 * Private methods 
	 ************************************************************************************************
	 */
	private BackgroundServiceApi.Stub apiEndpoint = new BackgroundServiceApi.Stub() {

		/*
		 ************************************************************************************************
		 * Overriden Methods 
		 ************************************************************************************************
		 */
		@Override
		public String getLatestResult() throws RemoteException {
			synchronized (mResultLock) {
				return mLatestResult.toString();
			}
		}

		@Override
		public void addListener(BackgroundServiceListener listener)
				throws RemoteException {

			synchronized (mListeners) {
				if (mListeners.add(listener))
					Log.d(TAG, "Listener added");
				else
					Log.d(TAG, "Listener not added");
			}
		}

		@Override
		public void removeListener(BackgroundServiceListener listener)
				throws RemoteException {

			synchronized (mListeners) {
				if (mListeners.size() > 0) {
					boolean removed = false;
					for (int i = 0; i < mListeners.size() && !removed; i++)
					{
						if (listener.getUniqueID().equals(mListeners.get(i).getUniqueID())) {
							mListeners.remove(i);
							removed = true;
						}
					}
					
					if (removed)
						Log.d(TAG, "Listener removed");
					else 
						Log.d(TAG, "Listener not found");
				}
			}
		}

		@Override
		public void enableTimer(int milliseconds) throws RemoteException {
			// First stop it just to be on the safe side
			stopTimerTask();
			
			// Then enable and set the milliseconds
			setEnabled(true);
			setMilliseconds(milliseconds);
			
			// Finally setup the TimerTask
			setupTimerTask();
		}

		@Override
		public void disableTimer() throws RemoteException {
			// Set to disabled
			setEnabled(false);
			
			// Stop the timer task
			stopTimerTask();
		}

		@Override
		public boolean isTimerEnabled() throws RemoteException {
			return getEnabled();
		}

		@Override
		public String getConfiguration() throws RemoteException {
			JSONObject array = getConfig();
			if (array == null)
				return "";
			else 
				return array.toString();
		}

		@Override
		public void setConfiguration(String configuration) throws RemoteException {
			try {
				JSONObject array = null;
				if (configuration.length() > 0) {
					array = new JSONObject(configuration);
				} else {
					array = new JSONObject();
				}	
				setConfig(array);
			} catch (Exception ex) {
				throw new RemoteException();
			}
		}
		
		@Override
		public String askJob(String configuration) throws RemoteException {
			try {
				JSONObject array = null;
				if (configuration.length() > 0) {
					array = new JSONObject(configuration);
				} else {
					array = new JSONObject();
				}	
				return doJob(array).toString();
			} catch (Exception ex) {
				return "";
				 
				
			}
			
		}

	};
	protected void onDataAvailable(Map obj){
		for (int i = 0; i < mListeners.size(); i++)
		{
			try {
				mListeners.get(i).onDataAvailable(obj);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.i(TAG, "Sent listener - " + i);
		}
	}
	private void setupTimerTask () {
		// Only create a timer if the timer is null
		if (this.mTimer == null) {
			this.mTimer = new Timer(this.getClass().getName());
		}
		
		// Only create the updateTask if is null
		if (this.mUpdateTask == null) {
			this.mUpdateTask	= new TimerTask() {

				@Override    
				public void run() {       
					Log.i(TAG, "Timer task starting work");

					Log.d(TAG, "Is the service paused?");
					Boolean paused = false;
					if (mPausedUntil != null) {
						Log.d(TAG, "Service is paused until " + (new SimpleDateFormat("dd/MM/yyyy hh:mm:ss")).format(mPausedUntil));
						Date current = new Date();
						Log.d(TAG, "Current is " + (new SimpleDateFormat("dd/MM/yyyy hh:mm:ss")).format(current));
						if (mPausedUntil.after(current)) {
							Log.d(TAG, "Service should be paused");
							paused = true;					// Still paused
						} else {
							Log.d(TAG, "Service should not be paused");
							mPausedUntil = null;				// Paused time has past so we can clear the pause
							onPauseComplete();
						}
					}

					if (paused) {
						Log.d(TAG, "Service is paused");
					} else {
						Log.d(TAG, "Service is not paused");
						JSONObject tmp = null;
						tmp = doWork();

						synchronized (mResultLock) {
							Log.i(TAG, "Syncing result");
							mLatestResult = tmp;
						};

						// Now call the listeners
						Log.i(TAG, "Sending to all listeners");
						for (int i = 0; i < mListeners.size(); i++)
						{
							try {
								mListeners.get(i).handleUpdate();
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Log.i(TAG, "Sent listener - " + i);
						}
					}

					Log.i(TAG, "Timer task completing work");
				}   
			};
			
			int milliseconds = getMilliseconds();
			this.mTimer.schedule(this.mUpdateTask, 1000L, milliseconds);
		}

		onTimerEnabled();
	}
	
	private void stopTimerTask() {
		
		Log.i(TAG, "stopTimerTask called");
		if (this.mUpdateTask != null)
		{
			Log.i(TAG, "updateTask is not null");
			if (this.mUpdateTask.cancel() )
			{
				Log.i(TAG, "updateTask.cancel returned true");
			} else {
				Log.i(TAG, "updateTask.cancel returned false");
			}
			this.mUpdateTask = null;
		}
		
		onTimerDisabled();
	}
	
	/*
	 ************************************************************************************************
	 * Methods for subclasses to override 
	 ************************************************************************************************
	 */
	protected abstract JSONObject initialiseLatestResult(); 
	protected abstract JSONObject doWork();
	protected abstract JSONObject doJob(JSONObject job);
	protected abstract JSONObject getConfig();
	protected abstract void setConfig(JSONObject config);
	
	protected void onTimerEnabled() {
	}

	protected void onTimerDisabled() {
	}
	
	protected void onPause() {
	}
	
	protected void onPauseComplete() {
	}
}
