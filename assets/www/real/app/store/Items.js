/*
 * - Sales Invoice
- Customer
- Stock
- Penerimaan Barang
- Transfer Barang
- Sales Return
 */
Ext.define('AppUI.store.Items', {
    extend: 'Ext.data.Store',
    requires: ['AppUI.model.Item','AppUI.data.proxy.Apx'],
    config: {
        model: 'AppUI.model.Item',
        listeners : {
        	refresh:function (me,operation,opt){
        		 
        	},
        	load : function(me,record,success,operation,opt){
        		 
        	}
        }
        ,
        pageSize: 25,
	    sorters: 'itm_code',
 		clearOnPageLoad : false,
        //autoload the data from the server
        autoLoad: true,

        //setup the grouping functionality to group by the first letter of the firstName field
        grouper: {
            groupFn: function(record) {
                return record.get('itm_code')[0];
            }
        },
        proxy :{
        	type:'memory',
        	id:'item',
        	enablePagingParams:true
        }
       /* data : [
        	{cust_code:'ABC',cust_name:'TOKO ABC',cust_address1:'Jl. P,hlawan',cust_city:'RUTENG'},
          	{cust_code:'MULIA',cust_name:'TOKO MULIA',cust_address1:'Jl. Nusa Kambangan ',cust_city:'CILACAP'} 
            ]*/
        
    } 
});