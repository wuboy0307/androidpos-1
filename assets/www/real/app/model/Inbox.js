Ext.define('AppUI.model.Inbox', {
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
	            {name: 'ibx_id',          type: 'string'},
	            {name: 'ibx_cat',        type: 'string'},
	            {name: 'ibx_date',        type: 'date'},
	            {name: 'ibx_sbj',      type: 'string'},
	            {name: 'ibx_from',   type: 'string'},
	            {name: 'ibx_to', type: 'string'},
	            {name: 'ibx_cnt',        type: 'string'},
	            {name: 'ibx_mark',        type: 'int'},
	            {name: 'src_code',        type: 'string'},
	            {name: 'ori_code',        type: 'string'},
	            {name: 'modi_by',        type: 'string'},
	            {name: 'modi_date',        type: 'date'},
	               {
                name: 'ibx_shortcnt',
                convert: function(value, record) {
                	if (record.get('ibx_cnt')!=null) {
                    var shortCnt  = record.get('ibx_cnt');
                      	if (shortCnt.length>100) {
	                        shortCnt = shortCnt.substring(0,100);
	                        return shortCnt+'...';
                      	}
                      	else {
                      		return shortCnt;
                      	}
                	}
                	else 
                    return '';
                }
            }
	        ],
	 validations: [
            {type: 'presence',  field: 'ibx_sbj'} 
          /*  {type: 'length',    field: 'name',     min: 2},
            {type: 'inclusion', field: 'gender',   list: ['Male', 'Female']},
            {type: 'exclusion', field: 'username', list: ['Admin', 'Operator']},
            {type: 'format',    field: 'username', matcher: /([a-z]+)[0-9]{2,3}/} */
        ]
}
});