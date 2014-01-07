package net.pointbridge.android.sales;

import java.util.Map;

import org.apache.cordova.DroidGap;

import net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceListener;
import net.pointbridge.android.sales.R;

 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends DroidGap  implements BackgroundServiceListener{
//extends DroidGap implements BackgroundServiceListener{
	private int requestCode=0;
	private String basePath="file:///android_asset/www/real/index.html";
	private final static String TAG = MainActivity.class.getSimpleName();
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
      //  setContentView(R.layout.activity_main);
        
        //setIntegerProperty("loadUrlTimeoutValue", 60000);
       // getWindow().getDecorView().findViewById(android.R.id.content).invalidate();
        Log.d(TAG,"MainActivity onCreate");
        onNewIntent(getIntent());
        switch (requestCode){
        case  99 :
        	super.loadUrl(basePath+"#setup");
        	break;
        default :
        	super.loadUrl(basePath);
        }
        
    }
	@Override
	public void onNewIntent(Intent intent){
	    Bundle extras = intent.getExtras();
	    if(extras != null){
	       /* if(extras.containsKey("NotificationMessage"))
	        {
	           
	            // extract the extra-data in the Notification
	            String msg = extras.getString("NotificationMessage");
	            Log.d(TAG,"MainActivity Notification Message : "+msg);
	          
	            
	        }*/
	    	 Log.d(TAG,"MainActivity Request Code : "+extras.getInt("requestCode"));
	        if (extras.containsKey("requestCode")){
	        	requestCode= extras.getInt("requestCode");
	        }
	        else requestCode=0;
	       
	        
	    }
	    else requestCode= 0;


	}
	@Override
	public IBinder asBinder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleUpdate() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDataAvailable(Map o) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUniqueID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	 @Override
    public void onDestroy() {
	 	super.onDestroy();
        Log.d(TAG, "MainActivity stopped");            
        

    }
	 // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu, menu);
        return true;
    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
      	if (keyCode == KeyEvent.KEYCODE_MENU) {
       	     return false;
           }else{
        	   return super.onKeyDown(keyCode, event);
           }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.setting:
            	super.loadUrl(basePath+"#setup");
                return true;
             
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
