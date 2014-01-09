Ext.define('AppUI.view.invoice.ReceiveMasterView', {
	 
	   extend: 'Ext.Container',
    xtype: 'receivemasterview',

    requires: [
        'Ext.form.Panel',
        'Ext.form.FieldSet',
        'Ext.field.Text'
    ],

    config: {
        title: 'Receive',
        layout: 'fit',

        items: [
            {
                xtype: 'formpanel',
                layout: 'fit',
                items: [{
		                xtype: 'label',
		                html: 'Please enter all required fields',
		                receiveId: 'failedLabel',
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
                        title: 'Receive Data',
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
	    	console.log("receivemasterview");
	    	var me = this;
	    	
	    //	me.fireEvent('onInit', me);
	    },
	    'show':function(){
	    	 
	    	var me = this;
	    	 
	    	 console.log('receivemasterview on show');
	    	// me.setRecord( Ext.create('AppUI.model.Receive'));
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