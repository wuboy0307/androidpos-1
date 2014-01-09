/**
 *   Transfer
 */
Ext.define('AppUI.controller.Transfer', { 

    extend: 'Ext.app.Controller',
    
    config: {
       refs: {
    	  addTransfer :'addtransfer' ,
    	  transferList :'transferlist' 
        },
       
        control: {
        	  transferList:{
             	onInit: 'onInitTransferList',
             	onAddTransfer : 'onAddTransfer',
             	onEditTransfer : 'onEditTransfer',
             	onViewTransfer : 'onViewTransfer'
             },
             addTransfer:{
             	showlist:'showlist',
             	onBackTransfer:'onBackTransfer',
             	onNextTransfer:'onNextTransfer',
             	onSaveTransfer:'onSaveTransfer',
             	onCancelTransfer : 'onCancelTransfer'
             }
        }
    },
    init:function(){
    	console.log("Transfer Controller Init");
    	 
    },
    onSaveTransfer:function(){
    	 
    },
    onCancelTransfer:function(){
    	this.showlist();
    },
    index:function(){
        console.log("its index");
    }, 
    onBackTransfer:function(){
    	
    	var idx=this.getAddTransfer().items.indexOf(this.getAddTransfer().getActiveItem());
    	console.log(idx); 
    	idx=idx-1;
    	this.getAddTransfer().setActiveItem(idx);
    },
    onNextTransfer:function(){
    	var idx=this.getAddTransfer().items.indexOf(this.getAddTransfer().getActiveItem());
    		console.log( idx); 
    		idx=idx+1;
    	this.getAddTransfer().setActiveItem(idx);
    },
    onInitTransferList:function(){
		console.log("on init transferlist");
		astore=Ext.getStore('MoveMasters');
	 
	    
		/*astore.add({sr_no: 'Sb020201.23201.1010',cust_code:'ABC',cust_name:'TOKO ABC',sr_date:'2014-01-01',sr_total:'1000000'}, 
			{sr_no: 'Sb020201.23201.1011',cust_code:'ABC',cust_name:'TOKO ABC',so_date:'2014-01-01',sr_total:'2000000'});
		astore.sync();
		astore.load();
		*/
	},
    onAddTransfer:function(){
    	console.log("oAddTransfer on Transfer controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Add Transfer');
        mainControl.showView("transfer.AddTransfer");
        this.getAddTransfer().setActiveItem(0);
    	console.log("after show view of add transfer");	 
    },
    onEditTransfer:function(){
    	console.log("onEditTransfer on Transfer controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Edit Transfer');
    		mainControl.showView("transfer.AddTransfer");
    },
    onViewTransfer:function(){
    	var mainControl=AppUI.app.getController('Main');
    	 
    	mainControl.getMainTitle().setTitle('View Transfer');
    		mainControl.showView("transfer.AddTransfer");
    	console.log("onViewTransfer on Transfer controller");
    	
    	this.getAddTransfer().down('formpanel').down('toolbar').down('button[text=Save]').setHidden(true);
    	this.getAddTransfer().down('formpanel').down('toolbar').down('button[text=Cancel]').setHidden(true);
    	this.getAddTransfer().down('formpanel').down('toolbar').down('button[text=Back]').setHidden(false);
    	 
    	var allitems=this.getAddTransfer().down('formpanel').getInnerItems();
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
    	mainControl.getMainTitle().setTitle('Transfer List');
    		mainControl.showView("transfer.TransferList");
    }

    
});