Ext.define('AppUI.view.MainPanel', {
  extend: 'Ext.Container',
    xtype: 'mainpanel',
   requires: [
        'AppUI.view.CustomerList',
        'AppUI.view.AddCustomer' 
    ],

	
    config: {
    	layout:'card',	
    	/* tabBar: {
            // Dock it to the bottom
            docked: 'bottom',

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
        },*/
        iconCls: 'main',
       flex:1,
      
       // items: [ {xtype:'homeview'},{xtype:'addcustomer'},{xtype:'customerlist'}]
        items:[]	    
        
	        
    } 
   
   
    
});