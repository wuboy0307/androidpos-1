Ext.define('AppUI.view.ReturnList', {
	extend: 'Ext.List',
    xtype: 'returnlist',
    requires: [
         'Ext.data.Store',
        'Ext.List',
        'Ext.field.Search',
        'Ext.Toolbar',
        'Ext.Panel'
         
    ],
     
    config: {
       store: 'Items',
       ui:'round',
       cls: 'x-customlist',
         title: 'Return List',
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
                                	me.up('returnlist').onSearchClearIconTap();
                                },
                                keyup:function(me,event){
                                	 
                                	me.up('returnlist').onSearchKeyUp(me);
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