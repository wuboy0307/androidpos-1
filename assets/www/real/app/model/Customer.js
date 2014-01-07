Ext.define('AppUI.model.Customer', {
extend: 'Ext.data.Model',
config: {
	  idProperty: 'cust_code',// idproperty is a must if you want use apx proxy
	 fields: [
	
	
	            {name: 'cust_code',          type: 'string'},
	            {name: 'cust_name',        type: 'string'},
	            
	            {name: 'cust_address1',      type: 'string'},
	            {name: 'cust_address2',   type: 'string'},
	            {name: 'cust_city', type: 'string'},
	            {name: 'cust_prov',        type: 'string'},
	            {name: 'cust_country',        type: 'string'},
	            {name: 'cust_postal',        type: 'string'},
	            {name: 'cust_email',        type: 'string'},
	            {name: 'cust_phone1',        type: 'string'},
	            {name: 'cust_phone2',        type: 'string'},
	            {name: 'cust_fax',        type: 'string'},
	            {name: 'cust_religion',        type: 'string'},
	            {name: 'cust_taxno',        type: 'string'},
	            {name: 'cust_pkpno',        type: 'string'},
	            {name: 'ct_code',        type: 'string'},
	            {name: 'ct_pricelvl',        type: 'int'},
	            
	            {name: 'cust_sex',        type: 'int'},
	            {name: 'cust_active',        type: 'int'},
	            
	            	{name: 'cust_pkpdate',        type: 'date'},
	            {name: 'src_code',        type: 'string'},
	            {name: 'ori_code',        type: 'string'},
	            {name: 'modi_by',        type: 'string'},
	            {name: 'modi_date',        type: 'date'},
	               {
                name: 'cust_name2',
	                convert: function(value, record) {
	                	if (record.get('cust_name')!=null) {
	                    	var combinestr  = record.get('cust_name')+'('+record.get('cust_code')+')';
	                      	 return combinestr;
	               		 }
	               		 else return '';
	                }},{
	             name: 'cust_address',
	                convert: function(value, record) {
	                	if (record.get('cust_address1')!=null) {
	                    var combinestr  = record.get('cust_address1');
	                      	if (combinestr.length>50) {
		                        combinestr = combinestr.substring(0,50);
		                        return combinestr+'..., '+record.get('cust_city');
	                      	}
	                      	else {
	                      		return combinestr+', '+record.get('cust_city');
	                      	}
	                	}
	                	else 
	                    return '';
	                }
	                }
          
	        ],
	 validations: [
           /*  {type: 'presence',  field: 'ibx_sbj'} 
           {type: 'length',    field: 'name',     min: 2},
            {type: 'inclusion', field: 'gender',   list: ['Male', 'Female']},
            {type: 'exclusion', field: 'username', list: ['Admin', 'Operator']},
            {type: 'format',    field: 'username', matcher: /([a-z]+)[0-9]{2,3}/} */
        ]
}
});