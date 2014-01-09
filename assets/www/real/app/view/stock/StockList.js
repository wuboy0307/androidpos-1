Ext.define('AppUI.view.stock.StockList', {
	extend: 'Ext.List',
    xtype: 'stocklist',
    requires: [
         'Ext.data.Store',
        'Ext.List',
        'Ext.field.Search',
        'Ext.Toolbar',
        'Ext.Panel',
         'AppUI.view.stock.AddItem',
         'AppUI.view.stock.ItemView',
          'AppUI.view.stock.SerialList'
    ],
     
    config: {
       store: 'Items',
       ui:'round',
       cls: 'x-customlist',
         title: 'Stock List',
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
         emptyText: '<div style="margin-top: 20px; text-align: center">No Matching Items</div>',
         itemTpl: [
	           
	            '{itm_shortname}({itm_code})',
	            '<span>Stock : {itm_qty} {itm_unit}</span>' 
	            
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
                                	me.up('stocklist').onSearchClearIconTap();
                                },
                                keyup:function(me,event){
                                	 
                                	me.up('stocklist').onSearchKeyUp(me);
                                }
                           
                            } 
                        },
                        { xtype: 'spacer' } 
                    ]
                }],
         listeners: {
         		initialize: function(me,opt){
         			me.fireEvent('onInit',me,opt);
         		},
                itemtap: function(me, list, index, item) {
                    var me=this;
                    me.fireEvent('onViewItem', me, list, index,item);
                    console.log('itemLeafTap on StockList');
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