/*
 * Copyright 2013 Red Folder Consultancy Ltd
 *   
 * Licensed under the Apache License, Version 2.0 (the "License");   
 * you may not use this file except in compliance with the License.   
 * You may obtain a copy of the License at       
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0   
 *
 * Unless required by applicable law or agreed to in writing, software   
 * distributed under the License is distributed on an "AS IS" BASIS,   
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   
 * See the License for the specific language governing permissions and   
 * limitations under the License.
 */

cordova.define(	'cordova/plugin/myService',	function(require, exports, module) {    
												CreateBackgroundService('net.pointbridge.android.sales.MainService', require, exports, module);
											});
var myService = cordova.require('cordova/plugin/myService');

	function handleSuccess(data) {
		console.log(data);
		//updateView(data);
	}
	
	function handleError(data) {
		alert("Error: " + data.ErrorMessage);
		alert(JSON.stringify(data));
		 
	}
 

/*
 * Button Handlers
 */ 			
	function getStatus() {
		myService.getStatus(	function(r){handleSuccess(r)},
								function(e){handleError(e)});
	};
	
	function startService() {
	myService.startService(	function(r){handleSuccess(r)},
							function(e){handleError(e)});
	}

	function stopService() {
		myService.stopService(	function(r){handleSuccess(r)},
								function(e){handleError(e)});
}

	function enableTimer() {
	myService.enableTimer(	5000,
							function(r){handleSuccess(r)},
							function(e){handleError(e)});
	}

	function disableTimer() {
		myService.disableTimer(	function(r){handleSuccess(r)},
								function(e){handleError(e)});
};
 			
	function registerForBootStart() {
	myService.registerForBootStart(	function(r){handleSuccess(r)},
									function(e){handleError(e)});
	}

	function deregisterForBootStart() {
	myService.deregisterForBootStart(	function(r){handleSuccess(r)},
										function(e){handleError(e)});
	}
	function doLogin(username,password){
		var config = { 
					"username" : username,
					"password" :password
				}; 
		myService.askJob(	config,
							function(r){handleSuccess(r)},
							function(e){handleError(e)});
	}
	function setConfig() {
	var helloToTxt = document.getElementById("helloToTxt");
		var helloToString = helloToTxt.value;
		var config = { 
						"HelloTo" : helloToString 
					}; 
	myService.setConfiguration(	config,
								function(r){handleSuccess(r)},
								function(e){handleError(e)});
	}
