Ext.define('AppUI.model.SalesMaster', {
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
	 
	
	            {name: 'sm_id',          type: 'string'},
	            {name: 'sm_no',        type: 'string'},
	            {name: 'cust_code',      type: 'string'},
	            {name: 'cust_name',      type: 'string'},
	            {name: 'wh_code',      type: 'string'},
	            {name: 'sm_date',        type: 'date'},
	            {name: 'sm_subtotal',      type: 'float'},
	            {name: 'sm_tax', type: 'float'},
	            {name: 'sm_total',   type: 'float' } 
	           
	           
	        ],
	 validations : [
          
        ]
}
});