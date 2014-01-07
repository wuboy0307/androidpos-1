Ext.define('AppUI.view.AddItem', {
	 
	   extend: 'Ext.Container',
    xtype: 'additem',

    requires: [
        'Ext.form.Panel',
        'Ext.form.FieldSet',
        'Ext.field.Text'
    ],

    config: {
        title: 'Item',
        layout: 'fit',

        items: [
            {
                xtype: 'formpanel',
                items: [{
		                xtype: 'label',
		                html: 'Please enter all required fields',
		                itemId: 'failedLabel',
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
                        title: 'Item Data',
                        items: [
                            {
                                xtype: 'textfield',
                                label: 'Code',
                                name: 'itm_code'
                            },
                            {
                                xtype: 'textfield',
                                label: 'Name',
                                name: 'itm_name'
                            },
                              {
                                xtype: 'textfield',
                                label: 'Short Name',
                                name: 'itm_shortname'
                            },
                             {
                                xtype: 'textfield',
                                label: 'Unit',
                                name: 'itm_unit'
                            },
                             {
                                xtype: 'textfield',
                                label: 'Status',
                                name: 'itm_status'
                            }, {
                                xtype: 'textfield',
                                label: 'Type',
                                name: 'itm_type2'
                            },
                             {
                                xtype: 'textfield',
                                label: 'Stock',
                                name: 'itm_qty'
                            }
                          
                            
                             
                        ]
                    },
                    
                     {
		            	xtype: 'toolbar',
							    docked: 'bottom',
							    layout: { pack: 'center' },
							    items: [
							         
							        {
							            xtype: 'button',
							            text: 'Back',
							            handler: function(me) {
							                me.up('additem').fireEvent("showlist");
							            }
							        } 
							    ]
		            }
                ]
            }
        ],
		'initialize' : function (){
	    	console.log("additem");
	    	var me = this;
	    	
	    //	me.fireEvent('onInit', me);
	    },
	    'show':function(){
	    	 
	    	var me = this;
	    	 
	    	 console.log('additem on show');
	    	// me.setRecord( Ext.create('AppUI.model.Item'));
	   // 	me.fireEvent('onShow', me);
	    },
        listeners:[  {
            delegate: 'textfield',
            keyup: 'onKeyUp'
        }],

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