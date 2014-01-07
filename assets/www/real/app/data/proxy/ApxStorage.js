Ext.define('AppUI.data.proxy.ApxStorage', {
 	 
    alternateClassName: 'AppUI.data.ApxStorage',
     constructor: function() {
     	console.log("apxstorage constructor");
     },
	getItem:function(id){
		if (id!== undefined) {
					console.log("getItem with id : "+id);
					console.log(id);
				  /* 	var config = { 
			       		"command": 'db_getrecord',
							"username" : username,
							"password" :password
						}; 
			      myService.askJob(config,
			       		 function (responseSuccess) {
			       		 
			       			 console.log(response.Data);
			       	 		if (response.Data!=""){ 
			                 	var res = Ext.JSON.decode(response.Data);
			       		 
			       				//console.log(loginResponse.success);
					       		 if (res){ 
					                   if (res.success ==   true ) {
					                        console.log("get Item (success) "+res.message);
					                   } else {
					                       console.log("get Item (failed) "+res.message);
					                   }
					       		 }else {
					       			 console.log("get Item (failed) no data available");
					       		 }
					       	 }
					       	 else {
					       		 console.log("get Item (failed) no response data");
					       	 } 
			       		 
			               },
			                function (responseFail) {
			                  
			                   console.log("get Item (failed) no respond");
			               });
		       
		      */
		}
	},
	setItem:function(id,data){
		console.log("setItem with id : "+id);
	},
	removeItem:function(id){
		console.log("removeItem with id : "+id);
	}
});