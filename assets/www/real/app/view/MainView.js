Ext.define('SmartHomeUI.view.MainView', {
    extend: 'Ext.tab.Panel',
    xtype: 'mainview',
    requires: [
        'Ext.TitleBar',
        'Ext.Video'
    ],
    config: {
       // tabBarPosition: 'bottom',
        // Give the tabBar a custom configuration
        tabBar: {
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
        },
        items: [
                {xtype:'cameraview'
                },
            {
                xtype:'homeview'
            },
           {
            	xtype:'lightview'
           },
            {
                title: 'Alarm',
                iconCls: 'alarm',

                items: [
                    {
                        docked: 'top',
                        xtype: 'titlebar',
                        title: 'Alarm'
                    } 
                ]
            },
            {
               xtype:'weatherview'
            },
            {
              xtype:'mmview'
            }
        ]
    }
});
