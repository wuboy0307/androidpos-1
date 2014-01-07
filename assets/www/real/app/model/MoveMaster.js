Ext.define('AppUI.model.MoveMaster', {
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
	 * mm_id		varchar(50),
	mm_no		varchar(30),
	mm_date		date,
	mm_wh_code			varchar(20),
	src_brc_code		varchar(20),
	src_vend_code	varchar(20),
	mm_totqty	numeric(22,4),
    mm_totbuyprice	numeric(22,4),
	mm_totsellprice	numeric(22,4),
	mv_code		smallint default 0,
	 */
	            {name: 'mm_id',          type: 'string'},
	            {name: 'mm_no',        type: 'string'},
	           
	            {name: 'mm_date',        type: 'date'},
	            {name: 'src_brc_code',        type: 'string'},
	            {name: 'src_vend_code',        type: 'string'},
	            {name: 'mm_wh_code',      type: 'float'},
	           
	            {name: 'mm_totbuyprice',   type: 'float'},
	            {name: 'mm_totsellprice',   type: 'float'}, 
	           
	            {name: 'mv_code',   type: 'int'} 
	           
	             
	           
	        ],
	 validations : [
          
        ]
}
});