package net.pointbridge.android.sales.plugin.backgroundservice;

 
interface BackgroundServiceListener {     
	void handleUpdate(); 
	void onDataAvailable(in Map o);
	String getUniqueID();
} 