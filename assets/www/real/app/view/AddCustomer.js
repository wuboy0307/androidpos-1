Ext.define('AppUI.view.AddCustomer', {
	/*
    extend: 'Ext.Container',
    xtype:'addcustomer',
    requires:['AppUI.model.Customer',
        'Ext.form.Panel',
        'Ext.form.FieldSet',
        'Ext.field.Text'
    ],
    config: {
        //title: 'Customer',
     	   title: 'Add Customers',
    
         layout: 'fit',
           
  		 record: null,
        items: [
        {
        
		        xtype:'formpanel',
		         items :[ 
		           // {
		              //  xtype: 'image',
		              // src: Ext.Viewport.getOrientation() == 'portrait' ? 'resources/img/login.png' : 'resources/img/login-small.png',
		              //  style: Ext.Viewport.getOrientation() == 'portrait' ? 'width:80px;height:80px;margin:auto' : 'width:40px;height:40px;margin:auto'
		            //},
		            {
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
		                title: 'Customer',
		                defaults :{ labelWidth:'40%',labelWrap:true},
		                items: [
		                    {
		                        xtype: 'textfield',
		                        placeHolder: 'Code',
		                        itemId: 'cust_code1',
		                        name: 'cust_code',
		                        label :'Code',
		                        required: true,
		                        clearIcon:true
		                    },
		                    {
		                        xtype: 'textfield',
		                        placeHolder: 'Name',
		                        itemId: 'cust_name1',
		                        name: 'cust_name',
		                        label:'Name',
		                        clearIcon:true,
		                        required: true
		                    } 
		                      
		                ]
		            },
		             {
		                xtype: 'fieldset',
		                title: 'Address',
		                defaults :{ labelWidth:'40%',labelWrap:true},
		                items: [
		                    {
		                        xtype: 'textfield',
		                        placeHolder: 'Address 1',
		                        itemId: 'cust_address1a',
		                        name: 'cust_address1',
		                        label :'Address 1',
		                        required: true,
		                        clearIcon:true
		                    },
		                     {
		                        xtype: 'textfield',
		                        placeHolder: 'Address 2',
		                        itemId: 'cust_address1b',
		                        name: 'cust_address2',
		                        label :'Address 2',
		                        required: true,
		                        clearIcon:true
		                    },
		                    
		                      {
		                        xtype: 'textfield',
		                        placeHolder: 'City',
		                        itemId: 'cust_city1',
		                        name: 'cust_city',
		                        label :'City',
		                        required: true,
		                        clearIcon:true
		                    } 
		                      
		                ]
		            },
		            {
		                xtype: 'button',
		                itemId: 'saveButton',
		                ui: 'confirm',
		                padding: '10px',
		                text: 'Save',
		                style:'margin : .5em'
		            }
		         ]
		        
        }]
    },
    'initialize' : function (){
    	console.log("addcustomer");
    	var me = this;
    	
    //	me.fireEvent('onInit', me);
    },
    'show':function(){
    	 
    	var me = this;
    	 
    	 console.log('addcustomer on show');
    	// me.setRecord( Ext.create('AppUI.model.Customer'));
   // 	me.fireEvent('onShow', me);
    },
    onSaveButtonTap: function () {
    	console.log('savebutton tap');
        var me = this;
	   var label = this.down('#failedLabel');
        label.hide();

        // Using a delayed task in order to give the hide animation above
        // time to finish before executing the next steps.
     //   me.fireEvent('signInCommand', me, username, password);
       
		   me.updateRecord(me.getRecord());
            label.setHtml('');
            console.log('fire save');
            console.log("the records :"+Ext.encode(me.getRecord()));
 			 console.log("the values :"+Ext.encode(me.getValues()));
 			var custStore = Ext.getStore("Customers");
 			custStore.add(me.getRecord());
 		    custStore.sync();
      

       
 
    },
    showFailedLabel: function (message) {
        var label = this.down('#failedLabel');
        label.setHtml(message);
        label.show();
    }
    */
	   extend: 'Ext.Container',
    xtype: 'addcustomer',

    requires: [
        'Ext.form.Panel',
        'Ext.form.FieldSet',
        'Ext.field.Text'
    ],

    config: {
        title: 'Customer',
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
                        title: 'Information',
                        items: [
                            {
                                xtype: 'textfield',
                                label: 'Code',
                                name: 'cust_code'
                            },
                            {
                                xtype: 'textfield',
                                label: 'Name',
                                name: 'cust_name'
                            },
                             
                        ]
                    },
                    {
                        xtype: 'fieldset',
                        defaults: {
                            labelWidth: '35%'
                        },
                        title: 'Contact Information',
                        items: [
                            {
                                xtype: 'textfield',
                                label: 'Telephone',
                                name: 'cust_phone1'
                            },
                             {
                                xtype: 'textfield',
                                label: ' ',
                                name: 'cust_phone2'
                            },
                             {
                                xtype: 'textfield',
                                label: 'Fax',
                                name: 'cust_fax'
                            }
                            ,
                             {
                                xtype: 'textfield',
                                label: 'Email',
                                name: 'cust_email'
                            }
                            
                        ]
                    },
                    {
                        xtype: 'fieldset',
                        title: 'Address',
                        defaults: {
                            labelWidth: '35%'
                        },
                        items: [
                            {
                                xtype: 'textfield',
                                label: 'Address ',
                                name: 'cust_address1'
                            },
                            {
                                xtype: 'textfield',
                                label: ' ',
                                name: 'cust_address2'
                            },
                            {
                                xtype: 'textfield',
                                label: 'City',
                                name: 'cust_city'
                            },
                            {
                                xtype: 'textfield',
                                label: 'Country',
                                name: 'cust_country'
                            }
                            ,
                            {
                                xtype: 'textfield',
                                label: 'Postal Code',
                                name: 'cust_postal'
                            }
                            
                        ]
                    },{
		            	xtype: 'toolbar',
							    docked: 'bottom',
							    layout: { pack: 'center' },
							    items: [
							        {
							            xtype: 'button',
							            text: 'Save',
							            handler: function() {
							                 this.onSaveButtonTap
							            }
							        },
							        {
							            xtype: 'button',
							            text: 'Cancel',
							            handler: function(me) {
							                me.up('addcustomer').fireEvent("showlist");
							            }
							        },
							        {
							            xtype: 'button',
							            text: 'Back',
							            handler: function(me) {
							                me.up('addcustomer').fireEvent("showlist");
							            }
							        } 
							    ]
		            }
                ]
            }
        ],
		'initialize' : function (){
	    	console.log("addcustomer");
	    	var me = this;
	    	
	    //	me.fireEvent('onInit', me);
	    },
	    'show':function(){
	    	 
	    	var me = this;
	    	 
	    	 console.log('addcustomer on show');
	    	// me.setRecord( Ext.create('AppUI.model.Customer'));
	   // 	me.fireEvent('onShow', me);
	    },
        listeners:[  {
            delegate: '#saveButton',
            event: 'tap',
            fn: 'onSaveButtonTap'
        } , {
            delegate: 'textfield',
            keyup: 'onKeyUp'
        }],

        record: null
    },
	onSaveButtonTap: function () {
    	console.log('savebutton tap');
        var me = this;
	   var label = this.down('#failedLabel');
        label.hide();

        // Using a delayed task in order to give the hide animation above
        // time to finish before executing the next steps.
     //   me.fireEvent('signInCommand', me, username, password);
       
		   me.updateRecord(me.getRecord());
            label.setHtml('');
            console.log('fire save');
            console.log("the records :"+Ext.encode(me.getRecord()));
 			 console.log("the values :"+Ext.encode(me.getValues()));
 			var custStore = Ext.getStore("Customers");
 			custStore.add(me.getRecord());
 		    custStore.sync();
      

       
 
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