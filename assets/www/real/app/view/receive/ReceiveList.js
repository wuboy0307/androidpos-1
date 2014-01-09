Ext.define('AppUI.view.receive.ReceiveList', {
	extend: 'Ext.List',
    xtype: 'receivelist',
    requires: [
         'Ext.data.Store',
        'Ext.List',
        'Ext.field.Search',
        'Ext.Toolbar',
        'Ext.Panel',
        'AppUI.view.receive.AddReceive',
         'AppUI.view.receive.ReceiveMasterView',
         'AppUI.view.receive.ReceiveItemList',
         'AppUI.view.receive.ReceiveSerialList'
         
    ],
     
    config: {
       store: 'MoveMasters',
       ui:'round',
       cls: 'x-customlist',
         title: 'Receive List',
        plugins: [
        {
            xclass: 'Ext.plugin.ListPaging',
            autoPaging: true
        }
    	],
        
        //grouped: true,

            //enable the indexBar
            indexBar: true,

            infinite: true,

           
            variableHeights: true,
        layout: {
            type: 'fit' 
           
        },
         emptyText: '<div style="margin-top: 20px; text-align: center">No Matching Data</div>',
         itemTpl: [
	           
	            '{so_no}({so_date})',
	            '<span>{cust_name} ({cust_code})</span>' 
	            
	        ].join(''),
        items: [{
                    xtype: 'toolbar',
                    docked: 'top',
					  ui:'light',
                    items: [
                        { xtype: 'spacer' },
                        {
                            xtype: 'searchfield',
                           
                            placeHolder: 'Search...',
                            listeners: {
                             
                                scope: this,
                                clearicontap: function (me){
                                	me.up('receivelist').onSearchClearIconTap();
                                },
                                keyup:function(me,event){
                                	 
                                	me.up('receivelist').onSearchKeyUp(me);
                                }
                           
                            } 
                        },
                        { xtype: 'spacer' },
                        { text:'Add',ui:'masked',
		                        handler: function(me) {
		                         console.log("onAddReceive");
		                       	me.up('receivelist').fireEvent('onAddReceive');
		                    }
		                    
                        }
                    ]
                }],
         listeners: {
         		initialize: function(me,opt){
         			me.fireEvent('onInit',me,opt);
         		},
                itemtap: function(me, list, index, item) {
                    var me=this;
                    me.fireEvent('itemLeafTap', me, list, index,item);
                    console.log('itemLeafTap');
                }
            	}
    		} ,
    			 
            	 /**
			     * Called when the search field has a keyup event.
			     *
			     * This will filter the store based on the fields content.
			     */
            	 onSearchKeyUp: function(field) { 
				    },

			    /**
			     * Called when the user taps on the clear icon in the search field.
			     * It simply removes the filter form the store
			     */
			    onSearchClearIconTap: function() {
			       this.getStore().clearFilter();
			    }
  
   
      
});