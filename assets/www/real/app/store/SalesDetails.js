/*
 * - Sales Invoice
- Customer
- Stock
- Penerimaan Barang
- Transfer Barang
- Sales Return
 */
Ext.define('AppUI.store.SalesDetails', {
    extend: 'Ext.data.Store',
    requires: ['AppUI.model.SalesDetail','AppUI.data.proxy.Apx'],
    config: {
        model: 'AppUI.model.SalesDetail',
        listeners : {
        	refresh:function (me,operation,opt){
        		 
        	},
        	load : function(me,record,success,operation,opt){
        		 
        	}
        }
        ,
        pageSize: 25,
	    sorters: 'sd_id',
 		clearOnPageLoad : false,
        
        proxy :{
        	type:'memory',
        	id:'salesdetail',
        	enablePagingParams:true
        }
       /* data : [
        	{cust_code:'ABC',cust_name:'TOKO ABC',cust_address1:'Jl. P,hlawan',cust_city:'RUTENG'},
          	{cust_code:'MULIA',cust_name:'TOKO MULIA',cust_address1:'Jl. Nusa Kambangan ',cust_city:'CILACAP'} 
            ]*/
        
    } 
});