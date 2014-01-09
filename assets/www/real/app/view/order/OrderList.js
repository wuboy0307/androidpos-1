Ext.define('AppUI.view.order.OrderList', {
	extend: 'Ext.List',
    xtype: 'orderlist',
    requires: [
         'Ext.data.Store',
        'Ext.List',
        'Ext.field.Search',
        'Ext.Toolbar',
        'Ext.Panel',
        'AppUI.view.order.AddOrder'
    ],
     
    config: {
       store: 'SoMasters',
       ui:'round',
       cls: 'x-customlist',
         title: 'Order List',
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
         itemTpl: new Ext.XTemplate(
          '{so_no} ({so_date:date("d/m/Y")}) <span>{cust_name} ({cust_code}), Total : {[this.totalFormat(values.so_total)]}</span>',{
	           		 totalFormat : function(nStr) {
						     nStr += '';
							x = nStr.split('.');
							x1 = x[0];
							x2 = x.length > 1 ? '.' + x[1] : '';
							var rgx = /(\d+)(\d{3})/;
							while (rgx.test(x1)) {
							    x1 = x1.replace(rgx, '$1' + ',' + '$2');
							}
							return x1 + x2;
				          //return sm_total.toFixed(4) ;
				      }}
        ),
        
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
                                	me.up('orderlist').onSearchClearIconTap();
                                },
                                keyup:function(me,event){
                                	 
                                	me.up('orderlist').onSearchKeyUp(me);
                                }
                           
                            } 
                        },
                        { xtype: 'spacer' },
                       	 { text:'Add',ui:'masked',
		                        handler: function(me) {
		                         console.log("onAddOrder");
		                       	me.up('orderlist').fireEvent('onAddOrder');
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