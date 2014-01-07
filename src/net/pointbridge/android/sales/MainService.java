package net.pointbridge.android.sales;
 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

 
 
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 

 

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import net.pointbridge.android.sales.db.ConfigDao;
import net.pointbridge.android.sales.db.DaoMaster;
import net.pointbridge.android.sales.db.DaoSession;
import net.pointbridge.android.sales.db.DaoMaster.DevOpenHelper;
import net.pointbridge.android.sales.dbcontrol.ConfigControl;
import net.pointbridge.android.sales.networkcontroller.*;
import net.pointbridge.android.sales.plugin.backgroundservice.BackgroundService;
import net.pointbridge.android.sales.R;
public class MainService extends BackgroundService implements NetworkEvent{
	private NetworkController netControl;
    private ClientBootstrap bootstrap;
     
	private Properties config = new Properties();
	private final static String TAG = MainService.class.getSimpleName();
	private boolean onProcess;
	private  boolean onError;
	private  String lastERR="";
	private String lastCMD="";
	private String lastRES="";
	
	/* database section */
	private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
  
    /*-------------------------*/
    private ProcessControl procControl;
	 public MainService(){
		 Log.d(TAG,"MainService Instance");
		 
	 }
	@Override
	public void onCreate(){
		super.onCreate();
		Log.d(TAG,"MainService OnCreate");
		initAll();
	}
	private CountDownLatch latch = new CountDownLatch(1);
	 @Override
    public void onDestroy() {
		 super.onDestroy();
        Log.d(TAG, "MainService Destroy");            
         

    }
	 
	 
	private void initAll(){
		  //init database */
		 DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "sales_ver_1", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
      
		 //init things
		 bootstrap = new ClientBootstrap(
	                new NioClientSocketChannelFactory(
	                        Executors.newCachedThreadPool(),
	                        Executors.newCachedThreadPool()));
		 netControl=new NetworkController(config,bootstrap);
		 netControl.addListener(this);
	     // Configure the pipeline factory.
	     bootstrap.setPipelineFactory(new ClientPipeLineFactory(netControl));
		 
	     procControl=new ProcessControl(netControl,config, daoSession);
	     netControl.addListener(procControl);
	 	// System.out.println("Free Mem : "+Runtime.getRuntime(). maxMemory());
	}
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		Log.d(TAG, "MainService Start");
		
		//initAll();
	}
	 
	@Override
	protected JSONObject initialiseLatestResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected JSONObject doWork() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected JSONObject getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setConfig(JSONObject config) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDataAvailable(ChannelHandlerContext ctx, MessageEvent e) {
		System.out.println("ON DATA AVAI "+ctx);
		
	}
	@Override
	public    void onError(ChannelHandlerContext ctx, String message) {
	 
	}
	/**
	 * Response auth process and other simple command in here
	 * @see net.pointbridge.android.sales.networkcontroller.NetworkEvent#onProcess(java.lang.String, java.lang.String)
	 */
	@Override
	public   void onProcess(String cmd,String message) {
		 
		
	}
	@Override
	public void onLog(String message) {
		System.out.println("ON LOG in MainService "+message);
		if (message.equals("PING-PONG")) {
			showNotification("P.O.S", "PING - PONG");
		}
	}
	@Override
	protected   JSONObject doJob(JSONObject jobAsk) {
		System.out.println("Do JOB" + jobAsk);
		JSONObject jobResult= new JSONObject();
		
		 
		 
			try {
				String command=jobAsk.getString("command"); 
				System.out.println("Do Command :"+command);
				if (command.equals("login")){
					jobResult=procControl.processLogin(jobAsk, jobResult);
					 
				}
				else  if (command.equals("savesetup")) {
					jobResult=procControl.processSaveSetup(jobAsk,jobResult);
				}
				else if (command.equals("getconfig")){
					jobResult=procControl.processGetConfig(jobAsk,jobResult);
				}
				else if (command.equals("db")){
					 
					jobResult=procControl.processDB(jobAsk,jobResult);
					System.out.println("jobREsult on db "+jobResult);
				}
				else {
					jobResult.put("success", false);
					jobResult.put("sessionToken","");
					jobResult.put("message","Please specify command!");
					 
				}
					
			} catch (JSONException e) {
				 System.out.println("errror on json "+e.fillInStackTrace());
				 
			}
			 
		return jobResult;
		
		
	}
	public void showNotification( String contentTitle, String contentText ) {
		int icon = R.drawable.ic_stat_notification;
        long when = System.currentTimeMillis();
        
        Notification notification = new Notification(icon, contentTitle, when);
		
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
		Intent notificationIntent = new Intent(this, MainActivity.class);
		notificationIntent.putExtra("NotificationMessage", "TEST NOTICE");
		notificationIntent.putExtra("requestCode", 99);
		
        PendingIntent contentIntent = PendingIntent.getActivity(this, 9, notificationIntent, 0);
        notification.setLatestEventInfo(this, contentTitle, contentText, contentIntent);
        
        NotificationManager nm = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, notification);
	}
}
