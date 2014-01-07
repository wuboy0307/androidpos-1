Ext.define('AppUI.model.TransferMaster', {
extend: 'Ext.data.Model',
config: {
	/*
	 * inbox.addLongProperty("ibx_id").primaryKey().autoincrement();
		inbox.addIntProperty("ibx_cat").index();
		inbox.addStringProperty("ibx_sbj");
		inbox.addStringProperty("ibx_from").index();
		inbox.addStringProperty("ibx_to").index();
		inbox.addDateProperty("ibx_date");
		inbox.addStringProperty("ibx_cnt");
		inbox.addIntProperty("ibx_mark"); //0=unread,1=read,2=delete
		inbox.addStringProperty("src_code");
		inbox.addStringProperty("ori_code");
		inbox.addStringProperty("modi_by");
		inbox.addIntProperty("mark");
		inbox.addDateProperty("modi_date"); 
	 */
	 fields: [
	 
	
	            {name: 'tm_id',          type: 'string'},
	            {name: 'tm_no',        type: 'string'},
	           
	            {name: 'tm_date',        type: 'date'},
	           
	           
	            {name: 'tm_totbuyprice',   type: 'float'},
	            {name: 'tm_totsellprice',   type: 'float'}, 
	            {name: 'tm_wh_src',   type: 'string'},
	            {name: 'tm_wh_tgt',   type: 'string'},
	            {name: 'tm_totpack',   type: 'float'},
	            {name: 'tm_note',   type: 'string'} 
	             
	           
	        ],
	 validations : [
          
        ]
}
});