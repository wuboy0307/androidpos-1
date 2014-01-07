Ext.define('AppUI.controller.Main', {
    extend: 'Ext.app.Controller',
    id:'maincontrol',
    config: {
    	   id:'maincontrol',
    	 viewCache: [],
		cacheX: [],
		logged:false,
       refs: {
    	   menuPanel :'menupanel',
    	   customerList :'customerlist',
    	   mainTitle :'#mainNavigationBar',
    	   menuPanelList : '#menuPanelList',
    	   inboxPanel :'inboxpanel',
    	   inboxPanelList : '#inboxPanelList',
           mainPanel : {
    		   selector: 'mainpanel',
               xtype: 'mainpanel',
               autoCreate: true
    	   },
    	   main :{
    		   selector: 'main',
               xtype: 'main',
               autoCreate: true
    	   }, 
    	   setupView :'setupview',
    	   
    	   menuButt:    'button[action=menuAction]',
    	   inboxButt:    'button[action=inboxAction]'  
    	    
        },
       
        control: {
        	main: {
                onInit: 'onInitMain' 
             },
            
        	menuButt: {
                tap: 'menuButtAction'
            },
            menuPanelList :{
            	menuLeafTap : 'onMenuLeafTap'
            },
            inboxButt: {
                tap: 'inboxButtAction'
            },
            inboxPanelList :{
            	menuLeafTap : 'onInboxLeafTap'
            },
        	 
            setupView: {
            
               setupSaveCommand: 'onSetupSaveCommand', //referensikan method dari view ke controller
           
                onShow:'onShowSetupView'
            } 
        },
         routes: {
            '':'showIndex',
            'setup': 'showSetup',
         //   'camera':'showCamera',
          //  'alarm':'showAlarm',
            'main':'showMain',
            'login':'showLogin',
            'user/:id': 'showUserById'
        } 
    },
     /**
     * @private
     * In the  here we have a large number of dynamic views. If we were to keep all of them rendered
     * we'd risk causing the browser to run out of memory, especially on older devices. If we destroy them as
     * soon as we're done with them, the app can appear sluggish. Instead, we keep a small number of rendered
     * views in a viewCache so that we can easily reuse recently used views while destroying those we haven't
     * used in a while.
     * @param {String} name The full class name of the view to create (e.g. "App.view.Forms")
     * @return {Ext.Component} The component, which may be from the cache
     */
    createView: function(name) {
        var cache = this.getViewCache(),
            ln = cache.length,
            limit = 20,
            view, i, oldView;
 
        Ext.each(cache, function(item) {
            if (item.viewName === name) {
                view = item;
                return;
            }
        }, this);

        if (view) {
            return view;
        }
	
        if (ln >= limit) {
            for (i = 0; i < ln; i++) {
                oldView = cache[i];
                if (!oldView.isPainted()) {
                    oldView.destroy();
                    cache.splice(i, 1);
                    break;
                }
            }
        }
		 
        view = Ext.create(name);
        view.viewName = name;
        cache.push(view);
        this.setViewCache(cache);

        return view;
    },
    getViewName: function(name) {
       
            ns   = 'AppUI.view.';
/*
        if (name == 'TouchEvents') {
            if (this.getApplication().getCurrentProfile().getName() === 'Tablet') {
                return ns + 'tablet.' + name;
            } else {
                return ns + 'phone.' + name;
            }
        } else {
        */
            return ns + name;
        //}
    },
   
     showView: function(viewname) {
      
       
       var cachex = this.getCacheX();
       console.log('size of cachex '+cachex.length);
       var idxPos=-1;
       for (var i = 0; i < cachex.length; i++) {
		 
		    if (cachex[i]===viewname) {
		    	idxPos=i;
		    	break;
		    }
		}
	 
       console.log('index of view '+idxPos +':'+viewname);
    	if (Ext.Array.indexOf(cachex,viewname) == -1) {
    		
    		 cachex.push(viewname);
    		aview   = this.createView(this.getViewName(viewname));
    	    this.getMainPanel().add([aview]);
    		for (var i = 0; i < cachex.length; i++) {
			    
			    if (cachex[i]===viewname) {
			    	idxPos=i;
			    	break;
			    }
			}
    	 	 console.log('index of view2 '+idxPos +':'+viewname);
    		this.getMainPanel().setActiveItem(idxPos);
    	 	// this.getMainPanel().activeItem=idxPos;
    	}
    	else {
    		console.log('index of view3 '+idxPos +':'+viewname);
    			// this.getMainPanel().activeItem=idxPos;
    		this.getMainPanel().setActiveItem(idxPos);
    	}  
     
    	 console.log("length of items in panel :"+this.getMainPanel().getItems().length+":"+idxPos);
		//  this.getMainPanel().setActiveItem(idxPos);
		 
    	 
    },
    onShowSetupView : function(me){
    	 console.log("onShowsetupview");
    },
	
    onInitMain : function (){
    	console.log("onInitMain in controller");
    	console.log("Get Config");
    	this.getMainTitle().setTitle("Point of Sales");
     		this.showView('HomeView');
    	var me=this;
    	  var command = { 
       		"command": 'getconfig' 
			}; 
		//disable while creating view	
    	/* 		 function (successResponse) {
       		    
       			 console.log(successResponse.Data);
       	 		if (successResponse.Data!=""){ 
                 	var theResponse = Ext.JSON.decode(successResponse.Data);
       		  
		       		 if (theResponse){ 
		                   if (theResponse.success ==   true ) {
		                       console.log(theResponse.data);
		                       configStore=Ext.getStore('Configs');
		                       configStore.setData(theResponse.data);
		                       

		                       console.log('count of record '+configStore.getCount());
		                     
		                      
		                      svrAddrRec=configStore.getAt(configStore.findExact('conf_name','svr_addr',0));
		                      console.log("server address "+svrAddrRec.get("conf_name")+"="+svrAddrRec.get("conf_val"));
		                      if (svrAddrRec.get("conf_val")==''){
		                      	me.showSetup();
		                       
		                      }
		                   } else {
		                        console.log("response success=failed");
		                   }
		       		 }else {
		       			console.log("Response is undefined")
		       		 }
		       	 }
		       	 else {
		       		 me.signInFailure(me,"undefined?? program bug2");
		       	 } 
       		 
               },
                function (failResponse) {
                  console.log("Failed Response");
               });
              
               */
    },
    onMenuLeafTap : function (owner,  index, item, record) {
    	console.log('onMenuLeafTap');
    	console.log(index+":"+item+":"+record.get("id"));
    	this.getMenuPanel().hide(true);
    	/*
    	 *   {id: 'order',    text: 'Sales Order'},
                {id: 'return', text: 'Sales Return'},
                {id: 'receive', text: 'Receive Item'},
                {id: 'transfer', text: 'Transfer Item'},
    	 */
    	if (record.get("id")=='customer') {
    		this.getMainTitle().setTitle(record.get("text"));
    		this.showView("CustomerList");
    	}
    	else 
    	 
    	 
    	if (record.get("id")==='stock') {
    		this.getMainTitle().setTitle(record.get("text"));
    		 this.showView("StockList");
    		
    	}else 
    	if (record.get("id")==='invoice') {
    		this.getMainTitle().setTitle(record.get("text"));
    		 this.showView("InvoiceList");
    		
    	}else 
    	if (record.get("id")==='order') {
    		this.getMainTitle().setTitle(record.get("text"));
    		 this.showView("OrderList");
    		
    	}else 
    	if (record.get("id")==='return') {
    		this.getMainTitle().setTitle(record.get("text"));
    		 this.showView("ReturnList");
    		
    	}
    	else 
    	if (record.get("id")==='receive') {
    		this.getMainTitle().setTitle(record.get("text"));
    		 this.showView("ReceiveList");
    		
    	}
    	else 
    	if (record.get("id")==='transfer') {
    		this.getMainTitle().setTitle(record.get("text"));
    		 this.showView("TransferList");
    		
    	}
    	else {
    		this.getMainTitle().setTitle("Point of Sales");
     		this.showView('HomeView');
    	}
    	
    	
    },
    onInboxLeafTap : function (owner, list, index,item) {
    	console.log('onInboxLeafTap');
    	this.getInboxPanel().hide(true); 
    },
    menuButtAction: function() {
    	console.log('menuButtAction');
       if (this.getMenuPanel().getHidden())
        this.getMenuPanel().show(true);
       else
    	   this.getMenuPanel().hide(true);
     if (!this.getInboxPanel().getHidden())
        this.getInboxPanel().hide(true);
    },
    inboxButtAction: function() {
    	console.log('inboxButtAction');
    	console.log(this.getInboxPanel());
       if (this.getInboxPanel().getHidden())
        this.getInboxPanel().show(true);
       else
    	   this.getInboxPanel().hide(true);
       //kebalikan untuk menu panel biar gak nutup semua
      if (!this.getMenuPanel().getHidden())
        this.getMenuPanel().hide(true);
       
    },
    
    showLogin:function(){
        this.getMain().add(this.getLoginView());
    },
    onLoggedLoginView : function (){
    	console.log('on loggedview');
    	this.showView(this.getMainView());
    },
    showIndex:function(){
        console.log('index');
   //  if (!this.getLoginView().logged){
     //  	this.showView(this.getLoginView());
      //}
       // else 
        //	this.showView(this.getMainView());
        
    },
     showSetup: function() {
     	
      me= this.showView('SetupView');
       configStore=Ext.getStore('Configs');
    	 
    	  me.down('#svrAddressField').setValue(configStore.getAt(configStore.findExact('conf_name','svr_addr',0)).get("conf_val"));
   	       me.down('#svrPortField').setValue(configStore.getAt(configStore.findExact('conf_name','svr_port',0)).get("conf_val"));
   	         me.down('#usernameField').setValue(configStore.getAt(configStore.findExact('conf_name','username',0)).get("conf_val"));
   	          me.down('#passwordField').setValue(configStore.getAt(configStore.findExact('conf_name','password',0)).get("conf_val"));
   	   
     	/*var overlay = this.getSetupView();
        

        if (!overlay.getParent()) {
            Ext.Viewport.add(overlay);
        }

        overlay.show();
        */
       /* this.getMain().add({
            xtype: 'loginpanel'
        });
        */
      
    },

    // Loads the User then adds a 'userprofile' view to the main TabPanel
    showUserById: function(id) {
     /*   MyApp.model.User.load(id, {
            scope: this,
            success: function(user) {
                this.getMain().add({
                    xtype: 'userprofile',
                    user: user
                });
            }
        });
*/
        console.log('showuserbyid '+id);
    },
     
   onSignInCommand: function (view, username, password) {

       console.log('Username: ' + username + '\n' + 'Password: ' + password+ '\n' );

       var me = this ;
 
       view.setMasked({
           xtype: 'loadmask',
           message: 'Signing In...'
       });
       var config = { 
       		"command": 'login',
				"username" : username,
				"password" :password
			}; 
       myService.askJob(	config,
       		 function (response) {
       		//	console.log(JSON.stringify(response));
       			// console.log(JSON.stringify(response.Data));
       			 console.log(response.Data);
       	 if (response.Data!=""){ 
                 var loginResponse = Ext.JSON.decode(response.Data);
       		 
       			//console.log(loginResponse.success);
       		 if (loginResponse){ 
                   if (loginResponse.success ==   true ) {
                       
                       me.signInSuccess(view);     //Just simulating success.
                   } else {
                       me.signInFailure(view,loginResponse.message);
                   }
       		 }else {
       			 me.signInFailure(view,"undefined?? program bug");
       		 }
       	 }
       	 else {
       		 me.signInFailure(view,"undefined?? program bug2");
       	 } 
       		 
               },
                function (response) {
                  
                   me.signInFailure(view,'Login failed. Please try again later.');
               });
       
      
   },

   signInSuccess: function (view) {
       console.log('Signed in.');
       view.setMasked(false);
       this.setLogged(true);
       
       console.log('fire on logged');
       this.showView('HomeView');
   },

   signInFailure: function (view,message) {
   	  console.log('Signed Failure.');
     
     
	    view.showSetupFailedLabel(message);
	    view.setMasked(false)
   },

   onSignOffCommand: function () {

       var me = this;

       Ext.Ajax.request({
           url: '../../services/logoff.ashx',
           method: 'post',
           params: {
               sessionToken: me.sessionToken
           },
           success: function (response) {

               // TODO: You need to handle this condition.
           },
           failure: function (response) {

               // TODO: You need to handle this condition.
           }
       });

       Ext.Viewport.animateActiveItem(this.getLoginView(), this.getSlideRightTransition());
   },
   onSetupSaveCommand: function (view, svrAddr, svrPort,username,password) {
    	   
        console.log('svrAddr: ' + svrAddr + ':, svrPort: ' + svrPort );
        var me=this;

        if (svrAddr.length === 0 || svrPort.length === 0 || username.length ===0 || password ===0 ) {

            view.showSetupFailedLabel('Please enter all required fields.');
            return;
        }

        view.setMasked({
            xtype: 'loadmask',
            message: 'Saving ...'
        });
        var config = { 
        		"command": 'savesetup',
				"svr_addr" : svrAddr,
				"svr_port" : svrPort,
				"username": username,
				"password":password
			}; 
        myService.askJob(	config,
        		 function (response) {
        		//	console.log(JSON.stringify(response));
        			// console.log(JSON.stringify(response.Data));
        			 console.log(response.Data);
        	 if (response.Data!=""){ 
                  var feedback = Ext.JSON.decode(response.Data);
        		 
        			//console.log(loginResponse.success);
        		 if (feedback){ 
                    if (feedback.success ==   true ) {
                        // The server will send a token that can be used throughout the app to confirm that the user is authenticated.
                       
                      
                     	me.saveSuccess();
                     	me.onSignInCommand(view,username, password);
                    } else {
                        me.saveFailure(feedback.message);
                    }
        		 }else {
        			 me.saveFailure("undefined?? program bug");
        		 }
        	 }
        	 else {
        		 me.saveFailure("undefined?? program bug2");
        	 } 
        		 
                },
                 function (response) {
                   
                    me.saveFailure('Save failed. Please try again later.');
                });
        
       
    },

    saveSuccess: function () {
        console.log('Setup saved.');
         
    },

    saveFailure: function (me,message) {
    	  console.log('Setup  Failure.');
         
        me.showSetupFailedLabel(message);
        me.setMasked(false);
    },
    testread:function (operation,callback,scope){
    	console.log('testread');
    	console.log(operation);
    }
 
});