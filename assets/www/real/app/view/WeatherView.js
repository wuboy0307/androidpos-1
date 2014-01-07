Ext.define('SmartHomeUI.view.WeatherView', {
    extend: 'Ext.Carousel',
    xtype:'weatherview',
    requires: [
               'Ext.Panel' 
           ],
    config: {
	    title: 'Weather',
        
	    iconCls: 'weather',
	    loadedStat:false,    
            items: [     
                    {
        	            docked: 'top',
        	            xtype: 'titlebar',
        	            title: 'Weather'
        	        } 
                    
            ],listeners : {
            	'initialized' :function(){
            		console.log("weatherviewinit");
                	var me = this;
                	me.fireEvent('onInit', me);
                	
                },
                'painted' :function(){
                    console.log("weatherviewpainted");
                    var me = this;
                    me.fireEvent('onPainted', me);
                    
                }
            }
         
    } 
});