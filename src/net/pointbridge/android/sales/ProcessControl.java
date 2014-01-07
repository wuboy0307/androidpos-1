package net.pointbridge.android.sales;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import net.pointbridge.android.sales.db.DaoSession;
import net.pointbridge.android.sales.dbcontrol.ConfigControl;
import net.pointbridge.android.sales.dbcontrol.General;
import net.pointbridge.android.sales.networkcontroller.NetworkController;
import net.pointbridge.android.sales.networkcontroller.NetworkEvent;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public class ProcessControl  implements NetworkEvent{
	private final NetworkController netControl;
	
	private boolean onProcess;
	private  boolean onError;
	private  String lastERR="";
	private String lastCMD="";
	private String lastRES="";
	private CountDownLatch latch = new CountDownLatch(1);
    private ConfigControl confControl;
    private General genControl;
    private final DaoSession session;
	private final static String TAG = ProcessControl.class.getSimpleName();
	private final Properties config;
	public ProcessControl(NetworkController netControl,Properties config, DaoSession session){
		this.netControl=netControl;
		this.config=config;
		this.session=session;
		confControl = new ConfigControl();
	    confControl.initConfig(session);
	    genControl=new General();
	}
	public JSONObject processDB(JSONObject jobAsk,JSONObject jobResult) throws JSONException{
		Map<String, String> params = new HashMap();
		System.out.println("in Process DB");
		/*"table" :this.getId(),
		"sorters" : operation.getSorters(),
        "filters":operation.getFilters(),
        "start":operation.getStart(),
        "limit":operation.getLimit(),
        "enablePaging":this.getEnablePagingParams()*/
		params.put("table", jobAsk.getString("table")); 
		if (jobAsk.opt("sorters")!=null)
			params.put("sorters", jobAsk.getString("sorters")); 
		if (jobAsk.opt("filters")!=null)
			params.put("filters", jobAsk.getString("filters")); 
		if (jobAsk.opt("start")!=null)
			params.put("start", jobAsk.getString("start")); 
		if (jobAsk.opt("limit")!=null)
			params.put("limit", jobAsk.getString("limit")); 
		if (jobAsk.opt("enablePaging")!=null)
			params.put("enablePaging", jobAsk.getString("enablePaging")); 
		if (jobAsk.opt("id")!=null)
			params.put("id", jobAsk.getString("id"));
		 
		if (jobAsk.opt("record")!=null)
			params.put("record", jobAsk.getString("record"));
		//============================================================
		if (jobAsk.getString("subcommand").equals("getmulti")){
			System.out.println("process getmulti");
			Map recList = genControl.getRecordList(this.session,params);
			System.out.println(" done process getmulti");
			jobResult.put("success", true);
			jobResult.put("message","Got Record List"); 
			System.out.println("data "+(String)recList.get("data"));
			System.out.println("count "+(String)recList.get("count"));
			jobResult.put("data",(String)recList.get("data"));
			jobResult.put("count",(String)recList.get("count"));
		}
		else if (jobAsk.getString("subcommand").equals("getsingle")){
			String recList = genControl.getRecord(this.session,params);
			jobResult.put("success", true);
			jobResult.put("message","Got Record"); 
			 
			jobResult.put("data",recList);
		}
		else if (jobAsk.getString("subcommand").equals("insert")){
			jobResult.put("success", true);
			jobResult.put("message","Insert Record"); 
			
		   System.out.println("record :"+jobAsk.getString("record"));
		   long res=genControl.insertRecord(this.session, params);
		   System.out.println("res (long) :"+res);
		}
		
		return jobResult;
	}
	
	public JSONObject processLogin(JSONObject jobAsk,JSONObject jobResult) throws JSONException{
		if (!netControl.isLogged()) { 
			lastCMD="AUTH_USER";
			lastERR="";
			onProcess=true;
			onError=false;
		 
				try {
					 
					netControl.login(jobAsk.getString("username"),jobAsk.getString("password"));
				} catch (Exception e1) {
					e1.printStackTrace();
					onError=true;
				}
			 
			 
			int i=0;
			long start = System.nanoTime();    
		 
			
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long elapsedTime = System.nanoTime() - start;
			Log.d(TAG,"ELAPSE "+elapsedTime);
			/* while(onProcess && !onError && i < 20) {
				System.out.println("I "+i);
				i++;
				try {
					Thread.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
			Log.d(TAG,"ON THIS "+onProcess+" : "+onError+": "+i+":"+lastERR);
			if (!onProcess) {
			    if (!onError){
			    	jobResult.put("success", false);
					jobResult.put("sessionToken","");
					jobResult.put("message","Authentication Time Out, Please check your connection");
			    }
			    else {
			    	jobResult.put("success", false);
			    	jobResult.put("sessionToken","");
			    	jobResult.put("message","Error occurr "+lastERR);
			    }
		     }
			else {
				//System.out.println("HERE1");
				if (lastCMD.equals("AUTH_USER") && lastRES.equals("AUTH_USER_OK")){
					netControl.setLogged(true);
					jobResult.put("success", true);
					jobResult.put("sessionToken","adsfds");
					jobResult.put("message","You are logged in!");
				}
				else {
					//System.out.println("HERE2"); 
					if (!onError){
						jobResult.put("success", false);
						jobResult.put("sessionToken","");
						jobResult.put("message","Invalid username or password");
					}
					else {
						jobResult.put("success", false);
						jobResult.put("sessionToken","");
						jobResult.put("message","Error occurr "+lastERR);
					}
				}
			}
		}
		else {
			jobResult.put("success", true);
			jobResult.put("sessionToken","adsfds");
			jobResult.put("message","You are logged in!");
		}
		return jobResult;
	}
	public JSONObject processSaveSetup(JSONObject jobAsk,JSONObject jobResult) throws JSONException{
		confControl.saveSetup(session, jobAsk);
		jobResult.put("success", true);
		jobResult.put("message","Config was saved"); 
		config.put("SERVER_ADDRESS",jobAsk.get("svr_addr"));
		config.put("SERVER_PORT",jobAsk.get("svr_port"));
		config.put("NODE_ID",jobAsk.get("username"));
		config.put("NODE_NAME",jobAsk.get("username"));
		config.put("NODE_PASS",jobAsk.get("password"));
		config.put("NODE_APP", "POS");
		 
		 return jobResult;
	}
	public JSONObject processGetConfig(JSONObject jobAsk,JSONObject jobResult) throws JSONException{
		String conf = confControl.getConfigList(this.session);
		jobResult.put("success", true);
		jobResult.put("message","Got Config List"); 
		 
		jobResult.put("data",conf);
		return jobResult;
	}
	@Override
	public void onDataAvailable(ChannelHandlerContext ctx, MessageEvent e) {
		System.out.println("ON DATA AVAI "+ctx);
		
	}
	@Override
	public void onError(ChannelHandlerContext ctx, String message) {
		System.out.println("ON ERROR "+message);
		if (message!=null)
			lastERR=lastERR+message;
		onError=true;
		latch.countDown();
	}
	@Override
	public void onProcess(String cmd, String message) {
		System.out.println("ONPROCESS "+cmd+":"+message);
		// TODO Auto-generated method stub
		if (cmd.equals("AUTH_USER_OK")){
			onProcess=true;
			lastRES=cmd;
			latch.countDown();
		}
		else if (cmd.equals("AUTH_USER_FAILED")){
			onProcess=true;
			lastRES=cmd;
			latch.countDown();
		}
		else if (cmd.equals("CLOSED")){
			onProcess=false;
			lastRES=cmd;
			
			latch.countDown();
		}
		
	}
	@Override
	public void onLog(String message) {
		System.out.println("ON LOG "+message);
		 
		
	}
}
