Ext.define('AppUI.view.invoice.SalesMasterView', {
	 
	   extend: 'Ext.Container',
    xtype: 'salesmasterview',

    requires: [
        'Ext.form.Panel',
        'Ext.form.FieldSet',
        'Ext.field.Text'
    ],

    config: {
        title: 'Sales',
        layout: 'fit',

        items: [
            {
                xtype: 'formpanel',
                layout: 'fit',
                items: [{
		                xtype: 'label',
		                html: 'Please enter all required fields',
		                salesId: 'failedLabel',
		                hidden: true,
		                hideAnimation: 'fadeOut',
		                showAnimation: 'fadeIn',
		                style: 'color:#990000;margin:.5em'
		            },
                    {
                        xtype: 'fieldset',
                        defaults: {
                            labelWidth: '35%'
                        },
                        title: 'Sales Data',
                        items: [
                            {
                                xtype: 'textfield',
                                label: 'No. Transaction',
                                name: 'sm_no',
                                value:'Automatic'
                            },
                            {
                                xtype: 'datepickerfield',
                                label: 'Date',
                                name: 'sm_date',
                                value: new Date()
                            },
                              {
                                xtype: 'textfield',
                                label: 'Customer',
                                name: 'cust_code'
                            },
                             {
                                xtype: 'textfield',
                                label: ' ',
                                name: 'cust_name'
                            } 
                             
                            
                             
                        ]
                    } 
                    
                    
                ]
            }
        ],
		'initialize' : function (){
	    	console.log("salesmasterview");
	    	var me = this;
	    	
	    //	me.fireEvent('onInit', me);
	    },
	    'show':function(){
	    	 
	    	var me = this;
	    	 
	    	 console.log('salesmasterview on show');
	    	// me.setRecord( Ext.create('AppUI.model.Sales'));
	   // 	me.fireEvent('onShow', me);
	    } 
         ,

        record: null
    }, 
    updateRecord: function(newRecord) {
        this.down('formpanel').setRecord(newRecord);
    },

    saveRecord: function() {
        var formPanel = this.down('formpanel'),
            record = formPanel.getRecord();

        formPanel.updateRecord(record);

        return record;
    },

    onKeyUp: function() {
        this.fireEvent('change', this);
    }
});