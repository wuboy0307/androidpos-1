Ext.define('AppUI.model.TransferSerial', {
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
	 /*
	  * ms_id		varchar(50),
	md_id		varchar(50),
	mm_id		varchar(50),
	itm_code	varchar(30),
	serial_no	varchar(50),
	src_code	varchar(20),
	no_seq integer default 0,
	  */
	
	            {name: 'ms_id',          type: 'string'},
	            {name: 'md_id',        type: 'string'},
	            {name: 'no_seq',        type: 'string'},
	            {name: 'mm_id',        type: 'string'},
	            {name: 'itm_code',      type: 'string'},
	            {name: 'itm_name',      type: 'string'},
	            {name: 'serial_no',		type:'string'} 
	           
	           
	        ],
	 validations : [
          
        ]
}
});