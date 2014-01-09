Ext.define('AppUI.controller.Stock', {
    extend: 'Ext.app.Controller',
    requires:[ ],
    config: {
       refs: {
    	  addItem :'additem' ,
    	  stockList :'stocklist',
    	  itemView:'itemview'
        },
       
        control: {
        	  stockList:{
             	onInit: 'onInitStockList',
             	onAddStock : 'onAddStock',
             	onEditStock : 'onEditStock',
             	onViewItem : 'onViewItem'
             },
             addItem:{
             	showlist:'showlist'
             },
             itemView:{
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
		astore=Ext.getStore('Items');
	 
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
		astore.add({itm_id:'123',itm_code: '0120301',itm_name:'NOKIA 123',itm_shortname:'NOKIA 123',itm_unit:'PCS',itm_qty:'10',itm_status:'1',itm_type:'1'}, 
			{itm_id:'124',itm_code: '01202221',itm_name:'NOKIA AAAA',itm_shortname:'NOKIA AAA',itm_unit:'PCS',itm_qty:'20',itm_status:'1',itm_type:'1'});
		astore.sync();
		astore.load();
	},
    onAddItem:function(){
    	console.log("oAddStock on Stock controller");
    	 
    },
    onEditItem:function(){
    	console.log("onEditStock on Stock controller");
    	var mainControl=AppUI.app.getController('Main');
    	mainControl.getMainTitle().setTitle('Edit Stock');
    		mainControl.showView("stock.AddStock");
    },
    onViewItem:function(){
    	var mainControl=AppUI.app.getController('Main');
    	 
    	mainControl.getMainTitle().setTitle('View Item');
    		mainControl.showView("stock.ItemView");
    	console.log("onViewItem on Stock controller");
    	
    	 
    	 
    	 
    	var allitems=this.getAddItem().down('formpanel').getInnerItems();
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
    		mainControl.showView("stock.StockList");
    }

    
});