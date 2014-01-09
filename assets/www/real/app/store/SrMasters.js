/*
 * - Sr Invoice
- Customer
- Stock
- Penerimaan Barang
- Transfer Barang
- Sr Return
 */
Ext.define('AppUI.store.SrMasters', {
    extend: 'Ext.data.Store',
    requires: ['AppUI.model.SrMaster','AppUI.data.proxy.Apx'],
    config: {
        model: 'AppUI.model.SrMaster',
        listeners : {
        	refresh:function (me,operation,opt){
        		 
        	},
        	load : function(me,record,success,operation,opt){
        		 
        	}
        }
        ,
        pageSize: 25,
	    sorters: 'sr_no',
 		clearOnPageLoad : false,
        //autoload the data from the server
        autoLoad: true,

        
        proxy :{
        	type:'memory',
        	id:'srmaster',
        	enablePagingParams:true
        }
       /* data : [
        	{cust_code:'ABC',cust_name:'TOKO ABC',cust_address1:'Jl. P,hlawan',cust_city:'RUTENG'},
          	{cust_code:'MULIA',cust_name:'TOKO MULIA',cust_address1:'Jl. Nusa Kambangan ',cust_city:'CILACAP'} 
            ]*/
        
    } 
});