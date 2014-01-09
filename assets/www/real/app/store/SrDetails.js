/*
 * - Sr Invoice
- Customer
- Stock
- Penerimaan Barang
- Transfer Barang
- Sr Return
 */
Ext.define('AppUI.store.SrDetails', {
    extend: 'Ext.data.Store',
    requires: ['AppUI.model.SrDetail','AppUI.data.proxy.Apx'],
    config: {
        model: 'AppUI.model.SrDetail',
        listeners : {
        	refresh:function (me,operation,opt){
        		 
        	},
        	load : function(me,record,success,operation,opt){
        		 
        	}
        }
        ,
        pageSize: 25,
	    sorters: 'srd_id',
 		clearOnPageLoad : false,
        
        proxy :{
        	type:'memory',
        	id:'srdetail',
        	enablePagingParams:true
        }
       /* data : [
        	{cust_code:'ABC',cust_name:'TOKO ABC',cust_address1:'Jl. P,hlawan',cust_city:'RUTENG'},
          	{cust_code:'MULIA',cust_name:'TOKO MULIA',cust_address1:'Jl. Nusa Kambangan ',cust_city:'CILACAP'} 
            ]*/
        
    } 
});