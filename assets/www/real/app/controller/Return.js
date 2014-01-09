/**
 * Sales Return
 */
Ext.define('AppUI.controller.Return', { 

    extend: 'Ext.app.Controller',
    
    config: {
       refs: {
    	  addReturn :'addreturn' ,
    	  returnList :'returnlist' 
        },
       
        control: {
        	  returnList:{
             	onInit: 'onInitReturnList',
             	onAddReturn : 'onAddReturn',
             	onEditReturn : 'onEditReturn',
             	onViewReturn : 'onViewReturn'
             },
             addReturn:{
             	showlist:'showlist',
             	onBackReturn:'onBackReturn',
             	onNextReturn:'onNextReturn',
             	onSaveReturn:'onSaveReturn',
             	onCancelReturn : 'onCancelReturn'
             }
        }
    },
    init:function(){
    	console.log("Return Controller Init");
    	 
    },
    onSaveReturn:function(){
    	 
    },
    onCancelReturn:function(){
    	this.showlist();
    },
    index:function(){
        console.log("its index");
    }, 
    onBackReturn:function(){
    	
    	var idx=this.getAddReturn().items.indexOf(this.getAddReturn().getActiveItem());
    	console.log(idx); 
    	idx=idx-1;
    	this.getAddReturn().setActiveItem(idx);
    },
    onNextReturn:function(){
    	var idx=this.getAddReturn().items.indexOf(this.getAddReturn().getActiveItem());
    		console.log( idx); 
    		idx=idx+1;
    	this.getAddReturn().setActiveItem(idx);
    },
    onInitReturnList:function(){
		console.log("on init returnlist");
		astore=Ext.getStore('SrMasters');
	 
	    
		astore.add({sr_no: 'Sb020201.23201.1010',cust_code:'ABC',cust_name:'TOKO ABC',sr_date:'2014-01-01',sr_total:'1000000'}, 
			{sr_no: 'Sb020201.23201.1011',cust_code:'ABC',cust_name:'TOKO ABC',so_date:'2014-01-01',sr_total:'2000000'});
		astore.sync();
		astore.load();
	},
    onAddReturn:function(){
    	console.log("oAddReturn on Return controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Add Return');
        mainControl.showView("return.AddReturn");
        this.getAddReturn().setActiveItem(0);
    	console.log("after show view of add return");	 
    },
    onEditReturn:function(){
    	console.log("onEditReturn on Return controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Edit Return');
    		mainControl.showView("return.AddReturn");
    },
    onViewReturn:function(){
    	var mainControl=AppUI.app.getController('Main');
    	 
    	mainControl.getMainTitle().setTitle('View Return');
    		mainControl.showView("return.AddReturn");
    	console.log("onViewReturn on Return controller");
    	
    	this.getAddReturn().down('formpanel').down('toolbar').down('button[text=Save]').setHidden(true);
    	this.getAddReturn().down('formpanel').down('toolbar').down('button[text=Cancel]').setHidden(true);
    	this.getAddReturn().down('formpanel').down('toolbar').down('button[text=Back]').setHidden(false);
    	 
    	var allitems=this.getAddReturn().down('formpanel').getInnerItems();
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
    	mainControl.getMainTitle().setTitle('Return List');
    		mainControl.showView("return.ReturnList");
    }

    
});