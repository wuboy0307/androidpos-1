Ext.define('AppUI.model.SrDetail', {
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
	            {name: 'srd_id',        type: 'string'},
	            {name: 'itm_code',      type: 'string'},
	            {name: 'itm_name',      type: 'string'},
	            {name: 'itm_unit',      type: 'string'},
	            {name: 'srd_buyprice',      type: 'float'},
	            {name: 'srd_sellprice',        type: 'float'},
	            {name: 'srd_qty',      type: 'float'},
	            {name: 'srd_subtotal', type: 'float'},
	            {name: 'srd_disc1',   type: 'float'} 
	           
	           
	        ],
	 validations : [
          
        ]
}
});