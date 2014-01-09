Ext.define('AppUI.view.invoice.TransferMasterView', {
	 
	   extend: 'Ext.Container',
    xtype: 'transfermasterview',

    requires: [
        'Ext.form.Panel',
        'Ext.form.FieldSet',
        'Ext.field.Text'
    ],

    config: {
        title: 'Transfer',
        layout: 'fit',

        items: [
            {
                xtype: 'formpanel',
                layout: 'fit',
                items: [{
		                xtype: 'label',
		                html: 'Please enter all required fields',
		                transferId: 'failedLabel',
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
                        title: 'Transfer Data',
                        items: [
                            {
                                xtype: 'textfield',
                                label: 'No. Transaction',
                                name: 'mm_no',
                                value:'Automatic'
                            },
                            {
                                xtype: 'datepickerfield',
                                label: 'Date',
                                name: 'mm_date',
                                value: new Date()
                            },
                              {
                                xtype: 'textfield',
                                label: 'No. Transfer',
                                name: 'tm_no'
                            } 
                             
                            
                             
                        ]
                    } 
                    
                    
                ]
            }
        ],
		'initialize' : function (){
	    	console.log("transfermasterview");
	    	var me = this;
	    	
	    //	me.fireEvent('onInit', me);
	    },
	    'show':function(){
	    	 
	    	var me = this;
	    	 
	    	 console.log('transfermasterview on show');
	    	// me.setRecord( Ext.create('AppUI.model.Transfer'));
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