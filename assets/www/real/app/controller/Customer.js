Ext.define('AppUI.controller.Customer', {
    extend: 'Ext.app.Controller',
    
    config: {
       refs: {
    	  addCustomer :'addcustomer' ,
    	  customerList :'customerlist' 
        },
       
        control: {
        	  customerList:{
             	onInit: 'onInitCustomerList',
             	onAddCustomer : 'onAddCustomer',
             	onEditCustomer : 'onEditCustomer',
             	onViewCustomer : 'onViewCustomer'
             },
             addCustomer:{
             	showlist:'showlist'
             }
        }
    },
    init:function(){
    	console.log("Customer Controller Init");
    	 
    },
    index:function(){
        console.log("its index");
    }, 
    onInitCustomerList:function(){
		console.log("on init customerlist");
		custStore=Ext.getStore('Customers');
		custStore.add({cust_code: 'ABC',cust_name:'TOKO ABC',cust_address:'Jl. AAAA',cust_city:'RUTENG'}, 
			{cust_code: 'MULIA',cust_name:'TOKO MULIA',cust_address:'Jl. MULIA',cust_city:'RUTENG'});
		custStore.sync();
		custStore.load();
	},
    onAddCustomer:function(){
    	console.log("oAddCustomer on Customer controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Add Customer');
    		mainControl.showView("AddCustomer");
    		this.getAddCustomer().down('formpanel').down('toolbar').down('button[text=Save]').setHidden(false);
    	this.getAddCustomer().down('formpanel').down('toolbar').down('button[text=Cancel]').setHidden(false);
    	this.getAddCustomer().down('formpanel').down('toolbar').down('button[text=Back]').setHidden(true);
    	var allitems=this.getAddCustomer().down('formpanel').getInnerItems();
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
    onEditCustomer:function(){
    	console.log("onEditCustomer on Customer controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Edit Customer');
    		mainControl.showView("AddCustomer");
    },
    onViewCustomer:function(){
    	var mainControl=AppUI.app.getController('Main');
    	 
    	mainControl.getMainTitle().setTitle('View Customer');
    		mainControl.showView("AddCustomer");
    	console.log("onViewCustomer on Customer controller");
    	
    	this.getAddCustomer().down('formpanel').down('toolbar').down('button[text=Save]').setHidden(true);
    	this.getAddCustomer().down('formpanel').down('toolbar').down('button[text=Cancel]').setHidden(true);
    	this.getAddCustomer().down('formpanel').down('toolbar').down('button[text=Back]').setHidden(false);
    	 
    	var allitems=this.getAddCustomer().down('formpanel').getInnerItems();
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
    	mainControl.getMainTitle().setTitle('Customer List');
    		mainControl.showView("CustomerList");
    }

    
});