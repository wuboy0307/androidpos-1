Ext.define('AppUI.view.MenuPanel', {
	extend: 'Ext.Container',
    xtype: 'menupanel',
   
    config: {
       
        docked: 'left',
       /* showAnimation: {
            type: 'slide',
            duration: 500,
            easing: 'ease-out',
            out:true,
            direction:'right'
        },
        hideAnimation: {
            type: 'slide',
            duration: 250,
            easing: 'ease-in',
            direction:'left'
        },*/
        hidden:true,
        width:200,
        layout: {
            type: 'fit',
           
        },
        items: [{
            xtype: 'titlebar',
            title: 'Menu',
            docked: 'top' 
        },
           {
            xtype: 'list',
            store: 'Menus',
            id:'menuPanelList',
            listeners: {
                itemtap: function(me, index, item, record) {
                    var me=this;
                    me.fireEvent('menuLeafTap', me, index, item, record);
                    console.log('menuLeafTap');
                }
            	}
       		} ]
    }
      
});