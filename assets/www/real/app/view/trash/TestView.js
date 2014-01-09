
Ext.define('AppUI.view.TestView', {
    extend: 'Ext.Container',
    xtype:'testview',
    config: {
        fullscreen: true,

        layout: {
            type: 'card',
            animation: {
                type: 'slide',
                direction: 'left',
                duration: 250
            }
        },

        items: [
                {
                    id: 'launchscreen',
                    cls : 'card',
                    scrollable: true             },
            {
                id: 'mainMenuList',
                xtype : 'list',
                useTitleAsBackText: false,
                docked: 'left',
               
                hidden:false,
                width:200,
                store: 'Menus',
                useToolbar:false 
                
               
            },
            {
                id: 'mainNavigationBar',
                xtype : 'titlebar',
                docked: 'top',
                title : 'Point of Sales',
              
                items: [ 
                {
                    xtype : 'button',
                    id: 'menuButton',
                    hidden: false,
                    align : 'left',
                   
                    
                    iconCls:'list',
                    iconMask: true,
                    ui: 'plain'
                    
                }
                ]
            }
        ]
    }
});