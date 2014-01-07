Ext.define('AppUI.view.SetupView', {
    extend: 'Ext.form.Panel',
    xtype:'setupview',
      
    config: {
        title: 'Setup',
     
        scrollable: true,
        layout: 'vbox',
        stored: false,
        items: [
           // {
              //  xtype: 'image',
              // src: Ext.Viewport.getOrientation() == 'portrait' ? 'resources/img/login.png' : 'resources/img/login-small.png',
              //  style: Ext.Viewport.getOrientation() == 'portrait' ? 'width:80px;height:80px;margin:auto' : 'width:40px;height:40px;margin:auto'
            //},
            {
                xtype: 'label',
                html: 'Please enter all required fields',
                itemId: 'setupFailedLabel',
                hidden: true,
                hideAnimation: 'fadeOut',
                showAnimation: 'fadeIn',
                style: 'color:#990000;margin:.5em'
            },
            {
                xtype: 'fieldset',
                title: 'Setup Server',
                defaults :{ labelWidth:'30%',labelWrap:true},
                items: [
                    {
                        xtype: 'textfield',
                        placeHolder: 'Server Address',
                        itemId: 'svrAddressField',
                        name: 'svrAddressField',
                        label :'Address',
                        required: true,
                        clearIcon:true
                    },
                    {
                        xtype: 'textfield',
                        placeHolder: 'Server Port',
                        itemId: 'svrPortField',
                        name: 'svrPortField',
                        label:'Port',
                        clearIcon:true,
                        required: true
                    } 
                      
                ]
            },
             {
                xtype: 'fieldset',
                title: 'Security',
                defaults :{ labelWidth:'30%',labelWrap:true},
                items: [
                    {
                        xtype: 'textfield',
                        placeHolder: 'Username',
                        itemId: 'usernameField',
                        name: 'usernameField',
                        label :'Username',
                        required: true,
                        clearIcon:true
                    },
                    {
                        xtype: 'passwordfield',
                        placeHolder: 'Password',
                        itemId: 'passwordField',
                        name: 'passwordField',
                        label:'Password',
                        clearIcon:true,
                        required: true
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
         ],
        listeners: [  {
            delegate: '#saveButton',
            event: 'tap',
            fn: 'onSaveButtonTap'
        } 
        ]
    },
    'initialize' : function (){
    	console.log("setupviewinit");
    	var me = this;
    	me.fireEvent('onInit', me);
    },
    'show':function(){
    	console.log("setupview on show");
    	var me = this;
    	me.fireEvent('onShow', me);
    },
    onSaveButtonTap: function () {
    	console.log('savebutton tap');
        var me = this,
	
            label = me.down('#setupFailedLabel'),
            svrAddress = me.down('#svrAddressField').getValue(),
            svrPort =  me.down('#svrPortField').getValue() ;
         	username=me.down('#usernameField').getValue();
         	password=me.down('#passwordField').getValue();
        label.hide();

        // Using a delayed task in order to give the hide animation above
        // time to finish before executing the next steps.
     //   me.fireEvent('signInCommand', me, username, password);
       var task = Ext.create('Ext.util.DelayedTask', function () {

            label.setHtml('');
            console.log('fire setupSaveCommand');
         
            me.fireEvent('setupSaveCommand', me, svrAddress, svrPort,username,password);
 
        });

        task.delay(500);
 
    },
    showSetupFailedLabel: function (message) {
        var label = this.down('#setupFailedLabel');
        label.setHtml(message);
        label.show();
    }
});