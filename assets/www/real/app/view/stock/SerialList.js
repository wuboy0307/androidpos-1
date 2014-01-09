Ext.define('AppUI.view.stock.SerialList', {
	extend: 'Ext.List',
    xtype: 'seriallist',
    requires: [
         'Ext.data.Store',
        'Ext.List',
        'Ext.field.Search',
        'Ext.Toolbar',
        'Ext.Panel'
         
    ],
     
    config: {
       store: 'ItemSerials',
       ui:'round',
       cls: 'x-customlist',
         title: 'Serial List',
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
	           
	            '{shortname}({itm_code})',
	            '<span>Serial : {itm_qty} {itm_unit}</span>' 
	            
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
                                	me.up('seriallist').onSearchClearIconTap();
                                },
                                keyup:function(me,event){
                                	 
                                	me.up('seriallist').onSearchKeyUp(me);
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