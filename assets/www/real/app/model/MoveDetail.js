Ext.define('AppUI.model.MoveDetail', {
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
	 /*md_id		varchar(50),
	mm_id		varchar(50),
	td_id		varchar(50),
	pod_id		varchar(50),
	po_no		varchar(30),
	tm_no		varchar(30),
	itm_code	varchar(30),
	itm_unit	varchar(10),
	md_qty		numeric(22,4) default 1,
	md_buyprice	numeric(22,4) default 0,
	md_sellprice	numeric(22,4) default 0,*/
	
	            {name: 'mm_id',          type: 'string'},
	            {name: 'md_id',        type: 'string'},
	            {name: 'itm_code',      type: 'string'},
	            {name: 'itm_name',      type: 'string'},
	            {name: 'itm_unit',		type:'string'},
	            {name: 'md_buyprice',      type: 'float'},
	            {name: 'md_sellprice',        type: 'float'},
	            {name: 'md_qty',      type: 'float'},
	            {name: 'md_subtotal', type: 'float'} 
	            {name:'tm_no',type:'string'},
	            {name:'pod_id',type:'string'},
	            {name:'po_no',type:'string'}
	            
	           
	           
	        ],
	 validations : [
          
        ]
}
});