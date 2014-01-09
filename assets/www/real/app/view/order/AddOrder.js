Ext.define('AppUI.view.order.AddOrder', {
	 
	   extend: 'Ext.Container',
    xtype: 'addorder',

    requires: [ 
    	'AppUI.view.order.SoMasterView',
    	'AppUI.view.order.SoItemList' 
    ],

     config: {
     	layout:'card',
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
        items:[
        	{
        	xtype:'somasterview'
        	},{
        	xtype:'soitemlist'
        	} 
        ,{
	            	xtype: 'toolbar',
						    docked: 'bottom',
						    layout: { pack: 'center' },
						    items: [
						        {
						            xtype: 'button',
						            text: 'Back',
						            ui:'back',
						            handler: function(me) {
						                 me.up('addorder').fireEvent('onBackOrder');
						            }
						        },
						         {
						            xtype: 'button',
						            text: 'Save',
						            ui:'action',
						            handler: function(me) {
						                 me.up('addorder').fireEvent('onSaveOrder');
						            }
						        },  {
						            xtype: 'button',
						            text: 'Cancel',
						            ui:'action',
						            handler: function(me) {
						                 me.up('addorder').fireEvent('onCancelOrder');
						            }
						        },
						        {
						            xtype: 'button',
						            text: 'Next',
						            ui:'forward',
						            handler: function(me) {
						                 me.up('addorder').fireEvent('onNextOrder');
						            }
						        } 
						    ]
		            } 
		  ]	    
        
	        
    } 
});