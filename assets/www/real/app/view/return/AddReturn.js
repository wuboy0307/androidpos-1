Ext.define('AppUI.view.return.AddReturn', {
	 
	   extend: 'Ext.Container',
    xtype: 'addreturn',

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
        	xtype:'returnmasterview'
        	},{
        	xtype:'returnitemlist'
        	},{
        	xtype:'returnseriallist'
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
						                 me.up('addreturn').fireEvent('onBackReturn');
						            }
						        },
						         {
						            xtype: 'button',
						            text: 'Save',
						            ui:'action',
						            handler: function(me) {
						                 me.up('addreturn').fireEvent('onSaveReturn');
						            }
						        },
						        {
						            xtype: 'button',
						            text: 'Cancel',
						            ui:'action',
						            handler: function(me) {
						                 me.up('addreturn').fireEvent('onCancelReturn');
						            }
						        },
						        {
						            xtype: 'button',
						            text: 'Next',
						            ui:'forward',
						            handler: function(me) {
						                 me.up('addreturn').fireEvent('onNextReturn');
						            }
						        } 
						    ]
		            } 
		  ]	    
        
	        
    } 
});