 
Ext.define('SmartHomeUI.view.ComponentListing', {
    extend: 'Ext.Panel',
    xtype: 'componentlisting',
 
    config: {
    	 
        cls: 'smarthome-list',
 
        scrollable: {
    	    direction: 'vertical',
    	    directionLock: true
    	},
        inline: true,
        
        listeners :{ 
        	 
        }
    } 
});