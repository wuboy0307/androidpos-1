package net.pointbridge.android.sales.plugin.backgroundservice; 
 
import net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceListener;
interface BackgroundServiceApi {  
	String getLatestResult();     
	
	void addListener(BackgroundServiceListener listener);     
	
	void removeListener(BackgroundServiceListener listener); 
	
	boolean isTimerEnabled();
	
	void enableTimer(int milliseconds);
	
	void disableTimer();
	
	String getConfiguration();
	
	void setConfiguration(String configuration);
	String askJob(String configuration);
} 
