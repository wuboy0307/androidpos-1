Ext.define('SmartHomeUI.view.CameraSingle', {
    extend: 'Ext.Carousel',
    xtype:'camerasingle',
    requires: [
               'Ext.Panel',
               'Ext.Video',
               
           ],
    config: {
        
            items: [     
           /* 	{
            		 xtype:'video', 
            		  url:  
                          'resources/media/BigBuck.webm',
                        
                      //loop: true,
                      flex:1,
                      posterUrl: 'resources/images/cover.jpg'
                }
            ,
            {
            	xtype:'video', 
       		 	url: ['http://localhost:9090/abc.webm'],
                 
                 flex:1,
                 posterUrl: 'resources/images/electric.png'
           } */
         
            ],
            listeners : {
            	'initialize':function(){
                	console.log("camera single init");
                	 var me = this;
                	  me.fireEvent('onInit', me);
                	
                }
            }
         
    } 
    
});