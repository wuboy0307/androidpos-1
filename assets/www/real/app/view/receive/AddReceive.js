Ext.define('AppUI.view.receive.AddReceive', {
	 
	   extend: 'Ext.Container',
    xtype: 'addreceive',

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
        	xtype:'receivemasterview'
        	},{
        	xtype:'receiveitemlist'
        	},{
        	xtype:'receiveseriallist'
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
						                 me.up('addreceive').fireEvent('onBackReceive');
						            }
						        },
						         {
						            xtype: 'button',
						            text: 'Save',
						            ui:'action',
						            handler: function(me) {
						                 me.up('addreceive').fireEvent('onSaveReceive');
						            }
						        },
						        {
						            xtype: 'button',
						            text: 'Cancel',
						            ui:'action',
						            handler: function(me) {
						                 me.up('addreceive').fireEvent('onCancelReceive');
						            }
						        },
						        {
						            xtype: 'button',
						            text: 'Next',
						            ui:'forward',
						            handler: function(me) {
						                 me.up('addreceive').fireEvent('onNextReceive');
						            }
						        } 
						    ]
		            } 
		  ]	    
        
	        
    } 
});