Ext.define('AppUI.view.InboxPanel', {
	extend: 'Ext.List',
    xtype: 'inboxpanel',
   
    config: {
       store: 'Inboxs',
       ui:'round',
       cls: 'x-inbox',
        docked: 'right',
        showAnimation: {
            type: 'slide',
            duration: 500,
            easing: 'ease-in',
            
            direction:'right'
        },
        hideAnimation: {
            type: 'slide',
            duration: 250,
            easing: 'ease-in',
            direction:'left'
        },
        hidden:true,
        width:200,
        layout: {
            type: 'fit' 
           
        },
        pinHeaders: false,
         itemTpl: [
	            '<div class="thumb" style="background-image:url(resources/images/doc_small.png);"></div>',
	            '{ibx_sbj}',
	            '<span>{ibx_shortcnt}</span>',
	            '<span>From : {ibx_from} </span>',
	            '<span>{ibx_date:date("d/m/Y H:i")}</span>'
	        ].join(''),
        items: [{
            xtype: 'titlebar',
            title: 'Inbox',
            docked: 'top' 
        } ],
         listeners: {
                itemtap: function(me, list, index, item) {
                    var me=this;
                    me.fireEvent('inboxLeafTap', me, list, index,item);
                    console.log('inboxLeafTap');
                }
            	}
    }
      
});