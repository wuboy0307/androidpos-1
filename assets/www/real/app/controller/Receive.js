/**
 *   Receive
 */
Ext.define('AppUI.controller.Receive', { 

    extend: 'Ext.app.Controller',
    
    config: {
       refs: {
    	  addReceive :'addreceive' ,
    	  receiveList :'receivelist' 
        },
       
        control: {
        	  receiveList:{
             	onInit: 'onInitReceiveList',
             	onAddReceive : 'onAddReceive',
             	onEditReceive : 'onEditReceive',
             	onViewReceive : 'onViewReceive'
             },
             addReceive:{
             	showlist:'showlist',
             	onBackReceive:'onBackReceive',
             	onNextReceive:'onNextReceive',
             	onSaveReceive:'onSaveReceive',
             	onCancelReceive : 'onCancelReceive'
             }
        }
    },
    init:function(){
    	console.log("Receive Controller Init");
    	 
    },
    onSaveReceive:function(){
    	 
    },
    onCancelReceive:function(){
    	this.showlist();
    },
    index:function(){
        console.log("its index");
    }, 
    onBackReceive:function(){
    	
    	var idx=this.getAddReceive().items.indexOf(this.getAddReceive().getActiveItem());
    	console.log(idx); 
    	idx=idx-1;
    	this.getAddReceive().setActiveItem(idx);
    },
    onNextReceive:function(){
    	var idx=this.getAddReceive().items.indexOf(this.getAddReceive().getActiveItem());
    		console.log( idx); 
    		idx=idx+1;
    	this.getAddReceive().setActiveItem(idx);
    },
    onInitReceiveList:function(){
		console.log("on init receivelist");
		astore=Ext.getStore('MoveMasters');
	 
	    
		/*astore.add({sr_no: 'Sb020201.23201.1010',cust_code:'ABC',cust_name:'TOKO ABC',sr_date:'2014-01-01',sr_total:'1000000'}, 
			{sr_no: 'Sb020201.23201.1011',cust_code:'ABC',cust_name:'TOKO ABC',so_date:'2014-01-01',sr_total:'2000000'});
		astore.sync();
		astore.load();
		*/
	},
    onAddReceive:function(){
    	console.log("oAddReceive on Receive controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Add Receive');
        mainControl.showView("receive.AddReceive");
        this.getAddReceive().setActiveItem(0);
    	console.log("after show view of add receive");	 
    },
    onEditReceive:function(){
    	console.log("onEditReceive on Receive controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Edit Receive');
    		mainControl.showView("receive.AddReceive");
    },
    onViewReceive:function(){
    	var mainControl=AppUI.app.getController('Main');
    	 
    	mainControl.getMainTitle().setTitle('View Receive');
    		mainControl.showView("receive.AddReceive");
    	console.log("onViewReceive on Receive controller");
    	
    	this.getAddReceive().down('formpanel').down('toolbar').down('button[text=Save]').setHidden(true);
    	this.getAddReceive().down('formpanel').down('toolbar').down('button[text=Cancel]').setHidden(true);
    	this.getAddReceive().down('formpanel').down('toolbar').down('button[text=Back]').setHidden(false);
    	 
    	var allitems=this.getAddReceive().down('formpanel').getInnerItems();
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
    	mainControl.getMainTitle().setTitle('Receive List');
    		mainControl.showView("receive.ReceiveList");
    }

    
});