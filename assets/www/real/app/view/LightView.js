Ext.define('SmartHomeUI.view.LightView', {
    extend: 'Ext.TabPanel',
    xtype: 'lightview',
    require : ['SmartHomeUI.view.ComponentContainer','SmartHomeUI.view.ComponentListing','SmartHomeUI.view.ComponentItem'],
    config: {
        title:'Lights',
        iconCls:'light',
        tabBar: {
            // Dock it to the bottom
            docked: 'top',
             
            // Change the layout so each of the tabs are centered vertically and horizontally
            layout: { 
                pack: 'center',
                align: 'center'
            },

            // Make the tabbar scrollable horizontally, and disabled the indicators
            scrollable: {
                direction: 'horizontal',
                indicators: false
            }
        },
        items: [
            
            
        ],
        listeners : {
        	'initialize' :function(){
            	console.log("lightviewinit");
            	var me = this;
            	me.fireEvent('onInit', me);
            	
            }
        }
    } ,
    
   
});
