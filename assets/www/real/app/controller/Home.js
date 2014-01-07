Ext.define('SmartHomeUI.controller.Home', {
    extend: 'Ext.app.Controller',
    
    config: {
       refs: {
    	   homeView : 'homeview',
    	   homeViewList : 'homeviewlist',
    	   lightView: 'lightview',
    	   mmView:'mmview',
           homeContentView : '#homeContentView',
           weatherView:'weatherview'
        },
       
        control: {
        	homeView: {
                onInit: 'onInitHomeView', //referensikan method dari view ke controller
                onPainted: 'onPaintedHomeView'
             },
            homeViewList : {
            	onInit:'onInitHomeViewList'
            },
            lightView: {
            	onInit:'onInitLightView'
            },
            mmView: {
            	onInit:'onInitMMView'
            },
            weatherView:{
                onPainted:'onPaintedWeatherView'
            }
        }
    },
    init:function(){
    	console.log("Home Controller Init");
    	 
    },
    index:function(){
        console.log("its index");
    },
    onInitHomeView : function (me){

    },
    onPaintedHomeView : function(me){
    	console.log("onPaintedHomeView");
	    var tpl = this.getWeatherTemplate();
        var contentView = this.getHomeContentView();
	    Ext.getStore('Weathers').load(function(records, operation, success) {
	    		Ext.getStore('Weathers').filter('main', 1);
    			var  theStore=Ext.getStore('Weathers');
    			if (theStore.getCount()>0) {

                    console.log('start to load ajax');
                    contentView.setHtml('');
                    contentView.setMasked({
                        xtype: 'loadmask',
                        message: 'Loading...'
                    });

                     //next we use Ext.data.JsonP to make a request
                    Ext.data.JsonP.request({
                        //we give it the url to the free worldweatheronline.com api
                        url: 'http://api.worldweatheronline.com/free/v1/weather.ashx',

                        //the callbackKey is used for JSONP requests
                        callbackKey: 'callback',

                        //now we define the params to be sent to the server
                        params: {
                            //first it is the API key so we can use the site
                            key: theStore.getAt(0).get('key'),

                            //nexgt is the `q` param which is a valid US zipcode (palo alto in this case)
                            q: theStore.getAt(0).get('q'),

                            //next we define the format, json
                            format: 'json',

                            //and finally the number of days we want
                            num_of_days: theStore.getAt(0).get('days')
                        },

                        //now we define a callback method which is called when the JSONP response is successful.
                        success: function(result) {
                            contentView.unmask();     
                            //the result is a json object which is returned by the API we just requested.
                            //in this case all we want is the data.weather property, which is an array
                            var weather = result.data.current_condition[0];
                            console.log(weather);
                            //now we check if the weather is actually defined
                            if (weather) {
                                //if it is defined, we use the setHtml method on contentView to update the html
                                //using the tpl.apply method.
                                //Ext.XTemplate.apply will bind the data you pass into the xtemplate provided
                                //and return a string
                                contentView.setHtml(tpl.apply(weather));
                            } else {
                               console.error('There was an error retrieving the weather.');
                            }

                            
                        },
                        failure : function (){
                            contentView.unmask();
                            contentView.setHtml("Unable to load statistic, please check your internet connection");
                        }
                    });
                }
                else {
                    console.log('nothing to load');
                }
				
	    	}, this);
    	//load ajax silent
    },
    
    onInitHomeViewList : function(me){
    	console.log("onInitHomeViewList");
    	 
	Ext.getStore('Pages').load(function(records, operation, success) {
		Ext.getStore('Pages').filter('pageId', 'home');
			console.log('loaded pages records  in onInitHomeViewList'+records.length);
			Ext.getStore('Pages').each(function(xrecord,id){
			   // console.log(xrecord);
			    aitem=Ext.create('SmartHomeUI.view.ComponentItem',  {
				record: xrecord 
			    });
			    me.add(aitem);
			   // console.log(aitem);
			});
			
	}, this);
		 
    	
    },
    onInitLightView : function(me){
    	console.log("onInitLightViewList");
    	Ext.getStore('Pages').load(function(records, operation, success) {
	    		 Ext.getStore('Pages').filter('pageId', 'light');
	    		 Ext.getStore('Pages').setGroupField('unitName');
    			 var grouper=Ext.getStore('Pages').getGroups();
    			// console.log(grouper);
	    			 for (var i in grouper) {
	    				 /// console.log(grouper[i]);
	    				  motheritem=Ext.create('SmartHomeUI.view.ComponentContainer',  {
		  				        title:grouper[i].name 
		  				         
	 		  				    });
	    				  var aftermother;
	    				  var carousel=-1;
	    				  for (var x in grouper[i].children){
	    					  if (carousel != grouper[i].children[x].get("carousel")) {
	    						  carousel=grouper[i].children[x].get("carousel");
	    						  aftermother=Ext.create('SmartHomeUI.view.ComponentListing');
	    						  motheritem.add(aftermother);
	    					  }
	    					  
		    				  
	    					  //its a record
	    					  //console.log(grouper[i].children[x].get("compType"));
	    					  childitem=Ext.create('SmartHomeUI.view.ComponentItem',  {
	    					        record: grouper[i].children[x] 
	    					    });
	    					  aftermother.add(childitem);
	    					  
	    				  }
	    				 
	    				
		  			me.add(motheritem);
		  				    
	    			 }
    			 
	}, this);
	    	
		 
    	
    },
    onInitMMView : function (me){
    	console.log("onInitMMView");
    	 Ext.getStore('Pages').load(function(records, operation, success) {
    		 Ext.getStore('Pages').filter('pageId', 'multimedia');
    		 Ext.getStore('Pages').setGroupField('unitName');
			 var grouper=Ext.getStore('Pages').getGroups();
			// console.log(grouper);
    			 for (var i in grouper) {
    				 /// console.log(grouper[i]);
    				  motheritem=Ext.create('SmartHomeUI.view.ComponentContainer',  {
	  				        title:grouper[i].name 
	  				         
 		  				    });
    				  var aftermother;
    				  var carousel=-1;
    				  for (var x in grouper[i].children){
    					  if (carousel != grouper[i].children[x].get("carousel")) {
    						  carousel=grouper[i].children[x].get("carousel");
    						  aftermother=Ext.create('SmartHomeUI.view.ComponentListing');
                              if (grouper[i].children[x].get("carouselTitle")) { 
                                  aftermother.add({
                                    xtype:'toolbar',
                                    title:grouper[i].children[x].get("carouselTitle")
                                  });
                                 }
    						  motheritem.add(aftermother);
    					  }
    					  
	    				  
    					  //its a record
    					//  console.log(grouper[i].children[x].get("compId"));
    					 
    					  childitem=Ext.create('SmartHomeUI.view.ComponentButton',  {
    					        record: grouper[i].children[x] 
    					    });
    					  aftermother.add(childitem);
    					  
    				  }
    				 
    				
	  				 me.add(motheritem);
	  				    
    			 }
			 
    	}, this);
    },
    onPaintedWeatherView :function (me){
        console.log('weatherview painted');
         var tpl = this.getWeatherTemplate2();
         
       
        Ext.getStore('Weathers').load(function(records, operation, success) {
        	
                var  theStore=Ext.getStore('Weathers');
                if (theStore.getCount()>0) {
                    if (!me.getLoadedStat()){ 
                        Ext.getStore('Weathers').each(function(xrecord,id){
                            me.setLoadedStat(true);
                            console.log('start to load ajax');
                            var contentView=Ext.create('SmartHomeUI.view.ComponentListing',{
                                cls:'x-content'
                            });
                            me.add(contentView);
                            contentView.add({
                                    xtype: 'toolbar',
                                    docked: 'top',  
                                    title: xrecord.get('q'),
                                    ui: 'light'
                               
                            });
                            contentView.setHtml('');
                            contentView.setMasked({
                                xtype: 'loadmask',
                                message: 'Loading...'
                            });

                             //next we use Ext.data.JsonP to make a request
                            Ext.data.JsonP.request({
                                //we give it the url to the free worldweatheronline.com api
                                url: 'http://api.worldweatheronline.com/free/v1/weather.ashx',
                                callbackKey: 'callback',
                                params: {
                                    //first it is the API key so we can use the site
                                    key: xrecord.get('key'),

                                    //nexgt is the `q` param which is a valid US zipcode (palo alto in this case)
                                    q: xrecord.get('q'),

                                    //next we define the format, json
                                    format: 'json',

                                    //and finally the number of days we want
                                    num_of_days: xrecord.get('days')
                                },

                                //now we define a callback method which is called when the JSONP response is successful.
                                success: function(result) {
                                    contentView.unmask();     
                                    
                                    var weather = result.data.weather;
                                    console.log(weather);
                                    //now we check if the weather is actually defined
                                    if (weather) {
                                        
                                        contentView.setHtml( tpl.apply(weather));
                                    } else {
                                       console.error('There was an error retrieving the weather.');
                                    }

                                    
                                },
                                failure : function (){
                                    contentView.unmask();
                                    contentView.setHtml("Unable to load statistic, please check your internet connection");
                                }
                            });
                        }); 
                    }
                }
                else {
                    console.log('nothing to load');
                }
                
            }, this);
        //load ajax silent
    },
    getWeatherTemplate: function() {
        return new Ext.XTemplate([
            '<tpl for=".">',
                '<div class="day">',
                    '<div class="date">{observation_time+7}</div>',
                    '<div class="iconx">',
                        '<tpl for="weatherIconUrl">',
                            '<img src="{value}" />',
                        '</tpl>',
                    '</div>',
                    '<div class="temp">{temp_C}&deg;</div>',
                '</div>',
            '</tpl>'
        ].join(''));
    },
     getWeatherTemplate2: function() {
        return new Ext.XTemplate([
            '<tpl for=".">',
                '<div class="day">',
                    '<div class="date">{date:date("M d, Y")}</div>',
                    '<div class="iconx">',
                        '<tpl for="weatherIconUrl">',
                            '<img src="{value}" />',
                        '</tpl>',
                    '</div>',
                    '<div class="temp">{tempMaxC}&deg;<span class="temp_low">{tempMinC}&deg;</span></div>',
                '</div>',
            '</tpl>'
        ].join(''));
    }

    
});