Ext.define('AppUI.view.transfer.TransferList', {
	extend: 'Ext.List',
    xtype: 'transferlist',
    requires: [
         'Ext.data.Store',
        'Ext.List',
        'Ext.field.Search',
        'Ext.Toolbar',
        'Ext.Panel',
        'AppUI.view.transfer.AddTransfer',
         'AppUI.view.transfer.TransferMasterView',
         'AppUI.view.transfer.TransferItemList',
         'AppUI.view.transfer.TransferSerialList'
         
    ],
     
    config: {
       store: 'Items',
       ui:'round',
       cls: 'x-customlist',
         title: 'Transfer List',
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
                                	me.up('transferlist').onSearchClearIconTap();
                                },
                                keyup:function(me,event){
                                	 
                                	me.up('transferlist').onSearchKeyUp(me);
                                }
                           
                            } 
                        },
                        { xtype: 'spacer' } ,
                        { text:'Add',ui:'masked',
		                        handler: function(me) {
		                         console.log("onAddTransfer");
		                       	me.up('transferlist').fireEvent('onAddTransfer');
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