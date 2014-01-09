/*
    This file is generated and updated by Sencha Cmd. You can edit this file as
    needed for your application, but these edits will have to be merged by
    Sencha Cmd when it performs code generation tasks such as generating new
    models, controllers or views and when running "sencha app upgrade".

    Ideally changes to this file would be limited and most work would be done
    in other places (such as Controllers). If Sencha Cmd cannot merge your
    changes and its generated code, it will produce a "merge conflict" that you
    will need to resolve manually.
*/

// DO NOT DELETE - this directive is required for Sencha Cmd packages to work.
//@require @packageOverrides

//<debug>
Ext.Loader.setPath({
    'Ext': 'touch/src',
    'AppUI': 'app'
});
//</debug>

Ext.application({
    name: 'AppUI',
    requires: [
        'Ext.Array',
        'Ext.Container',
        'Ext.Button',
        'Ext.Toolbar',
        'Ext.TitleBar',
        'Ext.data.JsonP',
        'Ext.Ajax',
        'Ext.XTemplate',
        'Ext.field.Number',
        'Ext.Img',
        'Ext.SegmentedButton',
        'Ext.Label',
        'Ext.form.FieldSet',
        'Ext.data.proxy.LocalStorage' 
      //  'SmartHomeUI.view.ComponentContainer',
       // 'SmartHomeUI.view.ComponentListing',
        //'SmartHomeUI.view.ComponentItem',
     //   'SmartHomeUI.view.ComponentButton'
    ],

    
   // controllers: ['Main','Camera','Home','Login','Setup'],
    //stores: ['Cookie','Cameras','Pages','Weathers'],
   
    //views: [
     //   'MainView','SetupView','Main','CameraView','CameraList','CameraListItem','CameraSingle','HomeView','HomeViewList','LightView',
      //   'MMView','WeatherView','LoginView','MainMenu' 
        
        
    //],
    controllers : ['Main','Customer','Invoice','Stock','Order','Return','Receive','Transfer'],
    models: ['Customer','Item'],
    stores : ['Menus','Inboxs','Configs','Customers','Items','SalesMasters','SalesDetails','SalesSerials',
    'SoMasters','SoDetails','SrMasters','SrDetails','SrSerials'],
    views : ['Main','MainPanel','MenuPanel','InboxPanel','SetupView','HomeView'],//,'AddCustomer','CustomerList','StockList' ],
    //,'AddInvoice','SerialList','SalesMasterView','SalesItemList',  'SalesSerialList'
    glossOnIcon: true,
    
    icon: {
        '57': 'resources/icons/Icon.png',
        '72': 'resources/icons/Icon~ipad.png',
        '114': 'resources/icons/Icon@2x.png',
        '144': 'resources/icons/Icon~ipad@2x.png'
    },

    isIconPrecomposed: true,

    startupImage: {
        '320x460': 'resources/startup/320x460.jpg',
        '640x920': 'resources/startup/640x920.png',
        '768x1004': 'resources/startup/768x1004.png',
        '748x1024': 'resources/startup/748x1024.png',
        '1536x2008': 'resources/startup/1536x2008.png',
        '1496x2048': 'resources/startup/1496x2048.png'
    },

    launch: function() {
        // Destroy the #appLoadingIndicator element
    	
        Ext.fly('appLoadingIndicator').destroy();
      
        console.log("now load main");
        // Initialize the main view
       // Ext.Viewport.add(Ext.create('SmartHomeUI.view.Main'));
       // Ext.Viewport.add({xtype:'main'});
    //  Ext.ViewPort.add(Ext.create('Main'));
        //Ext.Viewport.add(Ext.create('SmartHomeUI.view.CameraSingle'));
       Ext.Viewport.add([
                       { xtype: 'main' }
                      ]);

                     
                    
    },

    onUpdated: function() {
        Ext.Msg.confirm(
            "Application Update",
            "This application has just successfully been updated to the latest version. Reload now?",
            function(buttonId) {
                if (buttonId === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
}); 
