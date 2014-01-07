
Ext.define('AppUI.view.Main', {
    extend: 'Ext.Container',
    xtype:'main',
    config: {
      
		layout:'fit',
        items: [
                
            {
               xtype:'menupanel'   
            },{
                    xtype:'mainpanel' 
             },
               {
                    xtype:'inboxpanel'  
                
               },
            {
                id: 'mainNavigationBar',
                xtype : 'titlebar', ui: 'dark',
                docked: 'top',
                title : 'Point of Sales',
              
                items: [ 
                {
                    xtype : 'button',
                    id: 'menuButton',
                    hidden: false,
                    align : 'left',
                    action:'menuAction',
                    
                    iconCls:'list',
                    iconMask: true,
                    ui: 'plain'
                    
                },
                {
                  
                    id: 'inboxButton',
                    
                    align : 'right',
                    action:'inboxAction',
                     ui: 'plain',
                    iconCls:'inbox',
                    iconMask: true,
                    badgeText: '1'
                    
                }
                ]
            }
        ],
       listeners : {
            	'initialize' :function(){
            		console.log("mainviewinit");
                	var me = this;
                	me.fireEvent('onInit', me);
                	
                } 
       }
    }
});