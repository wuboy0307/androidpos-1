Ext.define('AppUI.model.Config', {
extend: 'Ext.data.Model',
config: {
	 fields: [
	            {name: 'id',          type: 'string'},
	            {name: 'conf_name',        type: 'string'},
	            {name: 'conf_val',      type: 'string'},
	            {name: 'conf_note',   type: 'string'} 
	        ] 
	  
}
});