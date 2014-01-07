Ext.define('AppUI.view.HomeView', {
    extend: 'Ext.Panel',
    xtype:'homeview',
    requires: [
               'Ext.Panel' 
           ],
    config: {
	    title: 'Home',
	    iconCls: 'home3',
	    loadedStat:false, 
	     layout:   'fit',
           
        
            items: [     
                     
                    {
                         itemId: 'homeContentView',
                    	xtype: 'panel',
                    	scrollable: {
                    	    direction: 'vertical',
                    	    directionLock: true
                    	},
                    	cls:'x-content',
                        styleHtmlContent: true,
                        
                        html: ['<div style=" auto;margin-top: 20px; text-align: center;  "><img src="resources/images/sales.png"',
                               ' height= ',Ext.filterPlatform('ie10') ? "256" : (Ext.os.deviceType == 'Phone') ? "256" : "256",
                        		' /><div>' 
                        		 
                        		 ].join("") 
                        
                    } 
                   
            ],listeners : {
            	'initialize' :function(){
            		console.log("homeviewinit");
                	var me = this;
                	me.fireEvent('onInit', me);
                	
                },
                'painted' :function(){
                    console.log("homeviewpainted");
                    var me = this;
                    me.fireEvent('onPainted', me);
                   
                    
                }
            }
         
    } 
});