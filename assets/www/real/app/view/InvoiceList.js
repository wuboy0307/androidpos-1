Ext.define('AppUI.view.InvoiceList', {
	extend: 'Ext.List',
    xtype: 'invoicelist',
    requires: [
         'Ext.data.Store',
        'Ext.List',
        'Ext.field.Search',
        'Ext.Toolbar',
        'Ext.Panel'
         
    ],
     
    config: {
       store: 'SalesMasters',
       ui:'round',
       cls: 'x-customlist',
         title: 'Invoice List',
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
          '{sm_no} ({sm_date:date("d/m/Y")}) <span>{cust_name} ({cust_code}), Total : {[this.totalFormat(values.sm_total)]}</span>',{
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
                                	me.up('invoicelist').onSearchClearIconTap();
                                },
                                keyup:function(me,event){
                                	 
                                	me.up('invoicelist').onSearchKeyUp(me);
                                }
                           
                            } 
                        },
                        { xtype: 'spacer' } 
                    ]
                }],
         listeners: {
         		initialize: function(me,opt){
         			console.log('init invoice list')
         			me.fireEvent('onInit',me,opt);
         		},
                itemtap: function(me, list, index, item) {
                    var me=this;
                    me.fireEvent('itemLeafTap', me, list, index,item);
                    console.log('itemLeafTap');
                }
            	}
    		} ,
    			 
            	  
            	 onSearchKeyUp: function(field) { 
				    },
 
			    onSearchClearIconTap: function() {
			       this.getStore().clearFilter();
			    }
  
   
      
});