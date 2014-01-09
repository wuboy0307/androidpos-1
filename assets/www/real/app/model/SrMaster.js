Ext.define('AppUI.model.SrMaster', {
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
	 
	
	            {name: 'sr_id',          type: 'string'},
	            {name: 'sr_no',        type: 'string'},
	            {name: 'sm_no',        type: 'string'},
	            
	            {name: 'cust_code',      type: 'string'},
	            {name: 'cust_name',      type: 'string'},
	            {name: 'wh_code',      type: 'string'},
	            {name: 'sr_date',        type: 'date'},
	            {name: 'sr_subtotal',      type: 'float'},
	            {name: 'sr_tax', type: 'float'},
	            {name: 'sr_total',   type: 'float' } 
	           
	           
	        ],
	 validations : [
          
        ]
}
});