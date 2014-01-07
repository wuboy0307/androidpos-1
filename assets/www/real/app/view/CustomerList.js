Ext.define('AppUI.view.CustomerList', {
	extend: 'Ext.List',
    xtype: 'customerlist',
    requires: [
         'Ext.data.Store',
        'Ext.List',
        'Ext.field.Search',
        'Ext.Toolbar',
        'Ext.Panel'
         
    ],
     
    config: {
       store: 'Customers',
       ui:'round',
       cls: 'x-customlist',
       title: 'Customer',
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
         emptyText: '<div  ">No Matching Items</div>',
         itemTpl: [
	           
	            '{cust_name2}',
	            '<span>{cust_address}</span>' 
	            
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
                                	me.up('customerlist').onSearchClearIconTap();
                                },
                                keyup:function(me,event){
                                	 
                                	me.up('customerlist').onSearchKeyUp(me);
                                }
                           
                            } 
                        },
                        { xtype: 'spacer' },
                       	 { text:'Add',ui:'masked',
		                        handler: function(me) {
		                        	console.log("addcustomer");
		                       	me.up('customerlist').onAddCustomer();
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
                    me.fireEvent('onViewCustomer', me, list, index,item);
                    console.log('customerLeafTap');
                } 
            	}
    		} ,
    			onAddCustomer:function(){
    				console.log("onAddCustomer");
    				this.fireEvent("onAddCustomer");
    			},
            	 /**
			     * Called when the search field has a keyup event.
			     *
			     * This will filter the store based on the fields content.
			     */
            	 onSearchKeyUp: function(field) {
				        //get the store and the value of the field
				        var value = field.getValue(),
				            store = this.getStore();
				
				        //first clear any current filters on the store. If there is a new value, then suppress the refresh event
				        store.clearFilter(!!value);
				
				        //check if a value is set first, as if it isnt we dont have to do anything
				        if (value) {
				            //the user could have entered spaces, so we must split them so we can loop through them all
				            var searches = value.split(','),
				                regexps = [],
				                i, regex;
				
				            //loop them all
				            for (i = 0; i < searches.length; i++) {
				                //if it is nothing, continue
				                if (!searches[i]) continue;
				
				                regex = searches[i].trim();
				                regex = regex.replace(/[\-\[\]\/\{\}\(\)\*\+\?\.\\\^\$\|]/g, "\\$&");
				
				                //if found, create a new regular expression which is case insenstive
				                regexps.push(new RegExp(regex.trim(), 'i'));
				            }
				
				            //now filter the store by passing a method
				            //the passed method will be called for each record in the store
				            store.filter(function(record) {
				                var matched = [];
				
				                //loop through each of the regular expressions
				                for (i = 0; i < regexps.length; i++) {
				                    var search = regexps[i],
				                        didMatch = search.test(record.get('cust_code') + ' ' + record.get('cust_name'));
				
				                    //if it matched the first or last name, push it into the matches array
				                    matched.push(didMatch);
				                }
				
				                return (regexps.length && matched.indexOf(true) !== -1);
				            });
				        }
				    },

			    /**
			     * Called when the user taps on the clear icon in the search field.
			     * It simply removes the filter form the store
			     */
			    onSearchClearIconTap: function() {
			       this.getStore().clearFilter();
			    }
  
   
      
});