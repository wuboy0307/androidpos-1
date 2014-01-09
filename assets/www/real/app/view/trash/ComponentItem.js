Ext.define('SmartHomeUI.view.ComponentItem', {
    extend : 'Ext.Container',
    xtype  : 'ComponentItem',
  
    config : {
    	width:'120px',
   	 	height:'150px',
        record : null,
        items  : true,
        layout: {
            type: 'vbox',
            align: 'center'
        },
        cls: 'smarthome-list-item' 
    },

    applyItems : function(items, collection) {
        var record = this.getRecord();

        items = [
            {
              
                xtype:'image',
                src:record.get('compImg')
            },
            {
            	  cls: 'x-name',
                html : record.get('compLabel')
            } 
        ];
        if (record.get('compType')==='togglefield') {
        	 items.push(  {
                cls: 'x-component',
            	xtype:'togglefield',
            });
        }

        return this.callParent([items, collection]);
    }
});