Ext.define('AppUI.view.transfer.AddTransfer', {
	 
	   extend: 'Ext.Container',
    xtype: 'addtransfer',

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
        	xtype:'transfermasterview'
        	},{
        	xtype:'transferitemlist'
        	},{
        	xtype:'transferseriallist'
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
						                 me.up('addtransfer').fireEvent('onBackTransfer');
						            }
						        },
						         {
						            xtype: 'button',
						            text: 'Save',
						            ui:'action',
						            handler: function(me) {
						                 me.up('addtransfer').fireEvent('onSaveTransfer');
						            }
						        },
						        {
						            xtype: 'button',
						            text: 'Cancel',
						            ui:'action',
						            handler: function(me) {
						                 me.up('addtransfer').fireEvent('onCancelTransfer');
						            }
						        },
						        {
						            xtype: 'button',
						            text: 'Next',
						            ui:'forward',
						            handler: function(me) {
						                 me.up('addtransfer').fireEvent('onNextTransfer');
						            }
						        } 
						    ]
		            } 
		  ]	    
        
	        
    } 
});