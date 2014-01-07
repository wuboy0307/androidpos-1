/*
 * - Sales Invoice
- Customer
- Stock
- Penerimaan Barang
- Transfer Barang
- Sales Return
 */
Ext.define('AppUI.store.TransferSerials', {
    extend: 'Ext.data.Store',
    requires: ['AppUI.model.TransferSerial','AppUI.data.proxy.Apx'],
    config: {
        model: 'AppUI.model.TransferSerial',
        listeners : {
        	refresh:function (me,operation,opt){
        		 
        	},
        	load : function(me,record,success,operation,opt){
        		 
        	}
        }
        ,
        pageSize: 25,
	    sorters: 'ts_id',
 		clearOnPageLoad : false,
        
        proxy :{
        	type:'memory',
        	id:'transferserial',
        	enablePagingParams:true
        }
       /* data : [
        	{cust_code:'ABC',cust_name:'TOKO ABC',cust_address1:'Jl. P,hlawan',cust_city:'RUTENG'},
          	{cust_code:'MULIA',cust_name:'TOKO MULIA',cust_address1:'Jl. Nusa Kambangan ',cust_city:'CILACAP'} 
            ]*/
        
    } 
});