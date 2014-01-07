Ext.define('AppUI.controller.Stock', {
    extend: 'Ext.app.Controller',
    
    config: {
       refs: {
    	  addStock :'addstock' ,
    	  stockList :'stocklist' 
        },
       
        control: {
        	  stockList:{
             	onInit: 'onInitStockList',
             	onAddStock : 'onAddStock',
             	onEditStock : 'onEditStock',
             	onViewStock : 'onViewStock'
             },
             addStock:{
             	showlist:'showlist'
             }
        }
    },
    init:function(){
    	console.log("Stock Controller Init");
    	 
    },
    index:function(){
        console.log("its index");
    }, 
    onInitStockList:function(){
		console.log("on init stocklist");
		astore=Ext.getStore('SalesMasters');
	 
	    /*  {name: 'itm_id',          type: 'string'},
	            {name: 'itm_code',        type: 'string'},
	            {name: 'itm_name',        type: 'string'},
	            {name: 'itm_shortname',      type: 'string'},
	        
	            {name: 'itm_unit', type: 'string'},
	            {name: 'itm_qty',type:'float'},
	             {name: 'itm_status',type:'int'},
	            {name: 'itm_type',        type: 'int'},
	            {name: 'itm_csg',        type: 'int'},
	            */
		astore.add({sm_no: 'Sb020201.23201.1010',cust_code:'ABC',cust_name:'TOKO ABC',sm_date:'2014-01-01',sm_total:'1000000'}, 
			{sm_no: 'Sb020201.23201.1011',cust_code:'ABC',cust_name:'TOKO ABC',sm_date:'2014-01-01',sm_total:'2000000'});
		astore.sync();
		astore.load();
	},
    onAddStock:function(){
    	console.log("oAddStock on Stock controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Add Stock');
    		mainControl.showView("AddStock");
    		this.getAddStock().down('formpanel').down('toolbar').down('button[text=Save]').setHidden(false);
    	this.getAddStock().down('formpanel').down('toolbar').down('button[text=Cancel]').setHidden(false);
    	this.getAddStock().down('formpanel').down('toolbar').down('button[text=Back]').setHidden(true);
    	var allitems=this.getAddStock().down('formpanel').getInnerItems();
    	for (i=0;i<allitems.length;i++){
   		 
   		 	if (allitems[i].isXType('fieldset')){
   		 		var subitems=allitems[i].getInnerItems();
   		 		for (z=0;z<subitems.length;z++){
   		 			if (subitems[z].isXType('textfield')){
   		 				subitems[z].setReadOnly(false);
   		 			}
   		 		}
   		 	}
    	}
    },
    onEditStock:function(){
    	console.log("onEditStock on Stock controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Edit Stock');
    		mainControl.showView("AddStock");
    },
    onViewStock:function(){
    	var mainControl=AppUI.app.getController('Main');
    	 
    	mainControl.getMainTitle().setTitle('View Stock');
    		mainControl.showView("AddStock");
    	console.log("onViewStock on Stock controller");
    	
    	this.getAddStock().down('formpanel').down('toolbar').down('button[text=Save]').setHidden(true);
    	this.getAddStock().down('formpanel').down('toolbar').down('button[text=Cancel]').setHidden(true);
    	this.getAddStock().down('formpanel').down('toolbar').down('button[text=Back]').setHidden(false);
    	 
    	var allitems=this.getAddStock().down('formpanel').getInnerItems();
    	for (i=0;i<allitems.length;i++){
   		 
   		 	if (allitems[i].isXType('fieldset')){
   		 		var subitems=allitems[i].getInnerItems();
   		 		for (z=0;z<subitems.length;z++){
   		 			if (subitems[z].isXType('textfield')){
   		 				subitems[z].setReadOnly(true);
   		 			}
   		 		}
   		 	}
    	}
    },
    showlist:function(){
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Stock List');
    		mainControl.showView("StockList");
    }

    
});