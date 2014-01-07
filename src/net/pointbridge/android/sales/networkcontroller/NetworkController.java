package net.pointbridge.android.sales.networkcontroller;

 
import java.net.InetSocketAddress;
 
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Vector;
 
 

 
import net.pointbridge.android.sales.MainActivity;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
 
import org.jboss.netty.util.Timeout;
import org.jboss.netty.util.TimerTask;
 
import com.google.protobuf.ByteString;
 
import com.pointbridge.swc3.protocol.TheProtocol.TheProto;

/**
 * the forms send request to this class and next to be process by NetworkRequestController
 * @author michael
 *
 */
public class NetworkController extends SimpleChannelUpstreamHandler  {
	private Vector networkEventListener = new Vector();
	private final ClientBootstrap bootstrap;
	private final Properties config;
	private ChannelFuture connectFuture;
	private Channel channel;
	private boolean logged;
	private final static String TAG = NetworkController.class.getSimpleName();
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public NetworkController(Properties config,ClientBootstrap bootstrap){
		this.config=config;
		this.bootstrap=bootstrap;
		this.logged=false;
	}
	public boolean isLogged() {
		return logged;
	}
	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	public void disconnect(){
		if (channel.isConnected())
		channel.close();
	}
	public void connect()  {
		 
		fireProcess("CONNECT","Connecting to server...");
		connectFuture = bootstrap.connect(new InetSocketAddress(config.getProperty("SERVER_ADDRESS"), Integer.parseInt(config.getProperty("SERVER_PORT"))));
		 
///		connectFuture = bootstrap.connect(new InetSocketAddress("127.0.0.1",9001));
		
		// Wait until the connection is made successfully.
	    channel = connectFuture.awaitUninterruptibly().getChannel();
		 
	}
	 
	/**
	 * send login
	 * @param username
	 * @param password
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	public void login(String username,String password)   {
		 
		System.out.println("SERVER_ADDRESS"+config.getProperty("SERVER_ADDRESS"));
		System.out.println("SERVER_PORT"+config.getProperty("SERVER_PORT"));
		System.out.println("NODE_ID"+config.getProperty("NODE_ID"));
		System.out.println("NODE_PASS"+ByteString.copyFromUtf8(config.getProperty("NODE_PASS")));
		 connect();
	 
		 TheProto.Builder builder=TheProto.newBuilder().setNdApp(config.getProperty("NODE_APP")).
	        		setNdCmd("AUTH_USER").
	        		setNdName(config.getProperty("NODE_ID")).
	        		setNdCnt(ByteString.copyFrom(config.getProperty("NODE_PASS").getBytes())).
	        		setNdId(config.getProperty("NODE_ID")).
	        		setNdPackid(IDGenerator.getRandomID(config.getProperty("NODE_ID"),"AUTH_USER")).
 	   				setNdOri(config.getProperty("NODE_ID"));
	     
		 channel.write(builder.build());
		 
		 fireProcess("AUTH_USER","Authentication sent...");
	}
	/**
	 * send pong in other to response of PING
	 */
	public void pong(){
		 TheProto.Builder builder=TheProto.newBuilder().setNdApp(config.getProperty("NODE_APP")).
	        		setNdCmd("PONG").
	        		setNdName(config.getProperty("NODE_NAME")).
	        	 
	        		setNdId(config.getProperty("NODE_ID")).
	        		setNdPackid(IDGenerator.getRandomID(config.getProperty("NODE_ID"),"AUTH_USER")).
	   				setNdOri(config.getProperty("NODE_ID"));
	       
		 channel.write(builder.build());
	}
	public void addListener(NetworkEvent event){
		
	      //add main frame to vector of listeners
	      if (!networkEventListener.contains(event)) {
	         
	    	  networkEventListener.addElement(event);
	      }
	     
	}
	public void removeListener(NetworkEvent event){
		
	      //add main frame to vector of listeners
	      if ( networkEventListener.contains(event)) {
	         
	    	  networkEventListener.remove(event);
	      }
	     
	}
	/**
	 * send event when request available
	 * @param proto
	 */
	public void fireDataAvailable(ChannelHandlerContext ctx, final MessageEvent e){
		 Vector vtemp = (Vector)networkEventListener.clone();
	      for (int x = 0; x < vtemp.size(); x++){
	    	  NetworkEvent target = null;
	        target = (NetworkEvent)vtemp.elementAt(x);
	        try {
	        	target.onDataAvailable(ctx, e);
	        }catch (Exception ex){
	        	removeListener(target);
	        }
	      }
	}
	/**
	 * send event when error
	 * @param msg
	 */
	public void fireError(ChannelHandlerContext ctx, ExceptionEvent e){
		Vector vtemp = (Vector)networkEventListener.clone();
	      for (int x = 0; x < vtemp.size(); x++){
	    	  NetworkEvent target = null;
		        target = (NetworkEvent)vtemp.elementAt(x);
		      try {
		        target.onError(ctx, e.getCause().getMessage());
		      }catch (Exception ex){
		    	  //if error remove
		    	  removeListener(target);
		      }
	      }
	}
	public void fireProcess(String cmd,String msg){
		Vector vtemp = (Vector)networkEventListener.clone();
	      for (int x = 0; x < vtemp.size(); x++){
	    	  NetworkEvent target = null;
	        target = (NetworkEvent)vtemp.elementAt(x);
	          try {
	        	 
	    	   target.onProcess(cmd,msg);
		      }catch (Exception ex){
		    	  //if error remove
		    	  removeListener(target);
		      }
	       
	        
	      }
	}
	public void fireLog(String msg){
		Vector vtemp = (Vector)networkEventListener.clone();
		 
	      for (int x = 0; x < vtemp.size(); x++){
	    	  NetworkEvent target = null;
	        target = (NetworkEvent)vtemp.elementAt(x);
	        try {
	        	target.onLog(msg);
	        }
	        catch (Exception ex){
	        	 
	        	 removeListener(target);
	        }
	      }
	}
	 @Override
	    public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e)
	            throws Exception {
	        channel = e.getChannel();
	        super.channelOpen(ctx, e);
	    }

	    @Override
	    public void messageReceived(
	            ChannelHandlerContext ctx, final MessageEvent e) throws Exception {
	    	final TheProto swcProto= (TheProto)e.getMessage();
	    	 if (swcProto.getNdCmd().equals("PING")){
		   	   	   this.pong();
		   	   	   fireLog("PING-PONG");
		   	}  
	    	 
	      	if (swcProto.getNdCnt().toString()!=null) {
		  			 fireProcess(swcProto.getNdCmd() ,swcProto.getNdCnt().toStringUtf8() );
		  			 fireLog(swcProto.getNdCnt().toStringUtf8());
	    	}
		  		 
	    	fireDataAvailable(ctx, e);
	    	 
	    }

	 @Override
    public void exceptionCaught(
            ChannelHandlerContext ctx, ExceptionEvent e) {
		System.out.println("ERRROR "+e);
		 fireError(ctx,e);
		
        e.getChannel().close();
    }
	 InetSocketAddress getRemoteAddress() {
	        return (InetSocketAddress) bootstrap.getOption("remoteAddress");
	    }
	 
	 @Override
	 public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
	       System.out.println("Disconnected from: " + getRemoteAddress());
	       fireProcess("DISCONNECTED","Disconnected");
	 }

	    @Override
	    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) {
	    	 fireProcess("CLOSED","Connection closed");
	    	/* println("Sleeping for: " + UptimeClient.RECONNECT_DELAY + 's');
	        
	        timer.newTimeout(new TimerTask() {
	            public void run(Timeout timeout) throws Exception {
	                println("Reconnecting to: " + getRemoteAddress());
	                bootstrap.connect();
	            }
	        }, UptimeClient.RECONNECT_DELAY, TimeUnit.SECONDS);
	        */
	    }

	    @Override
	    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
	    	 fireProcess("CONNECTED","Connected");
	    	/* if (startTime < 0) {
	            startTime = System.currentTimeMillis();
	        }

	        println("Connected to: " + getRemoteAddress());
	    	*/
	    }

}
