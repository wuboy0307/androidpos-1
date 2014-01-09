Ext.define('AppUI.controller.Invoice', {
    extend: 'Ext.app.Controller',
    
    config: {
       refs: {
    	  addInvoice :'addinvoice' ,
    	  invoiceList :'invoicelist' 
        },
       
        control: {
        	  invoiceList:{
             	onInit: 'onInitInvoiceList',
             	onAddInvoice : 'onAddInvoice',
             	onEditInvoice : 'onEditInvoice',
             	onViewInvoice : 'onViewInvoice'
             },
             addInvoice:{
             	showlist:'showlist',
             	onBackInvoice:'onBackInvoice',
             	onNextInvoice:'onNextInvoice',
             	onSaveInvoice:'onSaveInvoice',
             	onCancelInvoice : 'onCancelInvoice'
             }
        }
    },
    init:function(){
    	console.log("Invoice Controller Init");
    	 
    },
    index:function(){
        console.log("its index");
    }, 
    onSaveInvoice:function(){
    	 
    },
    onCancelInvoice:function(){
    	this.showlist();
    },
    onBackInvoice:function(){
    	
    	var idx=this.getAddInvoice().items.indexOf(this.getAddInvoice().getActiveItem());
    	console.log(idx); 
    	idx=idx-1;
    	this.getAddInvoice().setActiveItem(idx);
    },
    onNextInvoice:function(){
    	var idx=this.getAddInvoice().items.indexOf(this.getAddInvoice().getActiveItem());
    		console.log( idx); 
    		idx=idx+1;
    	this.getAddInvoice().setActiveItem(idx);
    },
    onInitInvoiceList:function(){
		console.log("on init invoicelist");
		astore=Ext.getStore('SalesMasters');
	 
	    
		astore.add({sm_no: 'Sb020201.23201.1010',cust_code:'ABC',cust_name:'TOKO ABC',sm_date:'2014-01-01',sm_total:'1000000'}, 
			{sm_no: 'Sb020201.23201.1011',cust_code:'ABC',cust_name:'TOKO ABC',sm_date:'2014-01-01',sm_total:'2000000'});
		astore.sync();
		astore.load();
	},
    onAddInvoice:function(){
    	console.log("oAddInvoice on Invoice controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Add Invoice');
        mainControl.showView("invoice.AddInvoice");
        this.getAddInvoice().setActiveItem(0);
    	console.log("after show view of add invoice");	 
    },
    onEditInvoice:function(){
    	console.log("onEditInvoice on Invoice controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Edit Invoice');
    		mainControl.showView("invoice.AddInvoice");
    },
    onViewInvoice:function(){
    	var mainControl=AppUI.app.getController('Main');
    	 
    	mainControl.getMainTitle().setTitle('View Invoice');
    		mainControl.showView("invoice.AddInvoice");
    	console.log("onViewInvoice on Invoice controller");
    	
    	this.getAddInvoice().down('formpanel').down('toolbar').down('button[text=Save]').setHidden(true);
    	this.getAddInvoice().down('formpanel').down('toolbar').down('button[text=Cancel]').setHidden(true);
    	this.getAddInvoice().down('formpanel').down('toolbar').down('button[text=Back]').setHidden(false);
    	 
    	var allitems=this.getAddInvoice().down('formpanel').getInnerItems();
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
    	mainControl.getMainTitle().setTitle('Invoice List');
    		mainControl.showView("invoice.InvoiceList");
    }

    
});