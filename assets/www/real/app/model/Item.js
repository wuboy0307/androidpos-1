Ext.define('AppUI.model.Item', {
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
	 
	
	            {name: 'itm_id',          type: 'string'},
	            {name: 'itm_code',        type: 'string'},
	            {name: 'itm_name',        type: 'string'},
	            {name: 'itm_shortname',      type: 'string'},
	           
	            {name: 'itm_unit', type: 'string'},
	            {name: 'itm_qty',type:'float'},
	             {name: 'itm_status',type:'int'},
	            {name: 'itm_type',        type: 'int'},
	            {name: 'itm_csg',        type: 'int'},
	             {name: 'itm_serial',        type: 'int'},//means it has serial or no
	               {
                name: 'itm_type2',
                convert: function(value, record) {
                	if (record.get('itm_type')===0) 
	                  	return 'Service'
                	
                	else  if (record.get('itm_type')===1)
                			return 'Stock'
                			
                	else if (record.get('itm_type')===2)
                		return 'Non-Stock'
                	else if (record.get('itm_type')===3)
                		return 'Material'
                	else
                    return '';
                }
            }
	        ],
	 validations : [
          
        ]
}
});