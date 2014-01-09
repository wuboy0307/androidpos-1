Ext.define('AppUI.view.invoice.AddInvoice', {
	 
	   extend: 'Ext.Container',
    xtype: 'addinvoice',

    requires: [ 
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
        	xtype:'salesmasterview'
        	},{
        	xtype:'salesitemlist'
        	},{
        	xtype:'salesseriallist'
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
						                 me.up('addinvoice').fireEvent('onBackInvoice');
						            }
						        },
						         {
						            xtype: 'button',
						            text: 'Save',
						            ui:'action',
						            handler: function(me) {
						                 me.up('addinvoice').fireEvent('onSaveInvoice');
						            }
						        },
						        {
						            xtype: 'button',
						            text: 'Cancel',
						            ui:'action',
						            handler: function(me) {
						                 me.up('addinvoice').fireEvent('onCancelInvoice');
						            }
						        },
						        {
						            xtype: 'button',
						            text: 'Next',
						            ui:'forward',
						            handler: function(me) {
						                 me.up('addinvoice').fireEvent('onNextInvoice');
						            }
						        } 
						    ]
		            } 
		  ]	    
        
	        
    } 
});