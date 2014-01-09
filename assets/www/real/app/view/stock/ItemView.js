Ext.define('AppUI.view.stock.ItemView', {
    extend: 'Ext.TabPanel',
    xtype: 'itemview',
    require : ['AppUI.view.stock.AddItem','AppUI.view.stock.SerialList'],
    config: {
        title:'Items',
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
       	 {
       	 	xtype:'additem'
       	 },
       	 {
       	 	xtype:'seriallist'
       	 }, {
		            	xtype: 'toolbar',
							    docked: 'bottom',
							    layout: { pack: 'left' },
							    items: [
							         
							        {
							            xtype: 'button',
							            text: 'Back',
							            handler: function(me) {
							                me.up('itemview').fireEvent("showlist");
							            }
							        } 
							    ]
		            }
            
        ],
        listeners : {
        	'initialize' :function(){
            	console.log("ItemView init");
            	var me = this;
            	me.fireEvent('onInit', me);
            	
            }
        }
    } ,
    
   
});
