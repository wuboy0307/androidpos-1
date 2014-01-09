/**
 * Sales Order
 */
Ext.define('AppUI.controller.Order', { 

    extend: 'Ext.app.Controller',
    
    config: {
       refs: {
    	  addOrder :'addorder' ,
    	  orderList :'orderlist' 
        },
       
        control: {
        	  orderList:{
             	onInit: 'onInitOrderList',
             	onAddOrder : 'onAddOrder',
             	onEditOrder : 'onEditOrder',
             	onViewOrder : 'onViewOrder'
             },
             addOrder:{
             	showlist:'showlist',
             	onBackOrder:'onBackOrder',
             	onNextOrder:'onNextOrder',
             	onSaveOrder:'onSaveOrder',
             	onCancelOrder : 'onCancelOrder'
             }
        }
    },
    init:function(){
    	console.log("Order Controller Init");
    	 
    },
    onSaveOrder:function(){
    	 
    },
    onCancelOrder:function(){
    	this.showlist();
    },
    index:function(){
        console.log("its index");
    }, 
    onBackOrder:function(){
    	
    	var idx=this.getAddOrder().items.indexOf(this.getAddOrder().getActiveItem());
    	console.log(idx); 
    	idx=idx-1;
    	this.getAddOrder().setActiveItem(idx);
    },
    onNextOrder:function(){
    	var idx=this.getAddOrder().items.indexOf(this.getAddOrder().getActiveItem());
    		console.log( idx); 
    		idx=idx+1;
    	this.getAddOrder().setActiveItem(idx);
    },
    onInitOrderList:function(){
		console.log("on init orderlist");
		astore=Ext.getStore('SoMasters');
	 
	    
		astore.add({so_no: 'Sb020201.23201.1010',cust_code:'ABC',cust_name:'TOKO ABC',so_date:'2014-01-01',so_total:'1000000'}, 
			{so_no: 'Sb020201.23201.1011',cust_code:'ABC',cust_name:'TOKO ABC',so_date:'2014-01-01',so_total:'2000000'});
		astore.sync();
		astore.load();
	},
    onAddOrder:function(){
    	console.log("oAddOrder on Order controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Add Order');
        mainControl.showView("order.AddOrder");
        this.getAddOrder().setActiveItem(0);
    	console.log("after show view of add order");	 
    },
    onEditOrder:function(){
    	console.log("onEditOrder on Order controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Edit Order');
    		mainControl.showView("order.AddOrder");
    },
    onViewOrder:function(){
    	var mainControl=AppUI.app.getController('Main');
    	 
    	mainControl.getMainTitle().setTitle('View Order');
    		mainControl.showView("order.AddOrder");
    	console.log("onViewOrder on Order controller");
    	
    	this.getAddOrder().down('formpanel').down('toolbar').down('button[text=Save]').setHidden(true);
    	this.getAddOrder().down('formpanel').down('toolbar').down('button[text=Cancel]').setHidden(true);
    	this.getAddOrder().down('formpanel').down('toolbar').down('button[text=Back]').setHidden(false);
    	 
    	var allitems=this.getAddOrder().down('formpanel').getInnerItems();
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
    	mainControl.getMainTitle().setTitle('Order List');
    		mainControl.showView("order.OrderList");
    }

    
});