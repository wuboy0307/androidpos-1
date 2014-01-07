Ext.define('AppUI.view.ItemView', {
    extend: 'Ext.TabPanel',
    xtype: 'itemview',
    require : [''],
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
       	 	xtype:'itemserial'
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
