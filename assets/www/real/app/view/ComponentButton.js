Ext.define('SmartHomeUI.view.ComponentButton', {
    extend : 'Ext.Container',
    xtype  : 'componentbutton',
  
    config : {
    	width:'90px',
   	 	height:'85px',
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
    
          
        ];
        if (record.get('compType')==='tooglefield') {
        	 items.push(  {
            	  cls: 'x-component',
            	  xtype:'togglefield',
            }
             );
        }
        else if (record.get('compType')==='button'){
        	items.push({
        		  cls: 'x-component',
            	  xtype:'button',
                  ui:'action',
            	  iconCls: record.get('compIcon'),
            	    iconMask: true,
            	  width:60,
            	  height:60
            
        	})
        }
        items.push(
        	{
          	  cls: 'x-name',
              html : record.get('compLabel')
          }
        )

        return this.callParent([items, collection]);
    }
});