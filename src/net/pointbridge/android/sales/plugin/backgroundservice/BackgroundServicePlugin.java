package net.pointbridge.android.sales.plugin.backgroundservice;

import net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServicePluginLogic.ExecuteResult;
import net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServicePluginLogic.ExecuteStatus;

import org.apache.cordova.api.CallbackContext;
import org.json.JSONArray;

import android.util.Log;

import org.apache.cordova.api.CordovaPlugin;
 
public class BackgroundServicePlugin extends CordovaPlugin {

	/*
	 ************************************************************************************************
	 * Static values 
	 ************************************************************************************************
	 */
	private static final String TAG = BackgroundServicePlugin.class.getSimpleName();

	/*
	 ************************************************************************************************
	 * Fields 
	 ************************************************************************************************
	 */
	private BackgroundServicePluginLogic mLogic;
	
	/*
	 ************************************************************************************************
	 * Overriden Methods 
	 ************************************************************************************************
	 */
	@Override
	public boolean execute(final String action, final JSONArray data, final CallbackContext callback) {
		boolean result = false;
		
		if (this.mLogic == null)
			this.mLogic = new BackgroundServicePluginLogic(this.cordova.getActivity());
		
		try {
			
			if (this.mLogic.isActionValid(action)) {

				cordova.getThreadPool().execute(new Runnable() {
					@Override
					public void run() {
						ExecuteResult pluginResult = mLogic.execute(action, data);

						if (pluginResult.getStatus() == ExecuteStatus.OK) {
							callback.success(pluginResult.getData());
							//result = true;
						}
						if (pluginResult.getStatus() == ExecuteStatus.ERROR) {
							callback.error(pluginResult.getData());
							//result = true;
						}
					}
				});

				result = true;
			} else {
				result = false;
			}
			
		} catch (Exception ex) {
			Log.d(TAG, "Exception - " + ex.getMessage());
		}

		return result;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		if (this.mLogic != null) {
			this.mLogic.onDestroy();
			this.mLogic = null;
		}
	}

}
