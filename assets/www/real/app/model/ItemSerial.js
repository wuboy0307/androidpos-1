Ext.define('AppUI.model.ItemSerial', {
extend: 'Ext.data.Model',
config: {
	 
	 fields: [
	 
	
	            {name: 'serial_id',          type: 'string'},
	            {name: 'itm_code',        type: 'string'},
	            {name: 'serial_no',        type: 'string'},
	            {name: 'serial_buydate',      type: 'string'},
	            {name: 'serial_state',   type: 'string'},
	            {name: 'serial_selldate', type: 'string'},
	            {name: 'wh_code',type:'string'},
	             {name: 'cust_code',type:'string'},
	            {name: 'cust_name',        type: 'string'} 
           
	        ],
	 validations : [
          
        ]
}
});