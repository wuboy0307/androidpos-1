Ext.define('SmartHomeUI.view.CameraView', {
    extend: 'Ext.Panel',
    xtype: 'cameraview',
   

    config: {
        iconCls: 'camera2',
        title: 'Camera',
        
        layout: {
	        type: 'card',
	        align: 'center',
	        pack: 'top'
	    },
	    flex: 1,
        	    items: [
        	        {
        	        	xtype:'cameralist'
        	        },
        	        {
        	        	xtype:'camerasingle'
        	        },/*{
                    	 ui:'neutral',
                    	 
        	            xtype:'toolbar',
        	            docked: 'bottom',
        	            items: [
        	               
        	                { iconCls: 'multibox',  iconMask: true,  ui: 'plain',action:'multiview' },
        	                { iconCls: 'singlebox',  iconMask: true,  ui: 'plain',action:'singleview' } 
        	            ]
        	        }*/
        	        {
                        //toolbar xtype
                        xtype: 'toolbar',

                        //dock it to the top
                        docked: 'bottom',

                        //give it a UI of light
                        ui: 'light',

                        //give the layout configuration a pack of center so the items of this toolbar will be centered horizontally
                        layout: {
                            pack: 'center'
                        },

                        //specify the items of this toolbar
                        items: [
                            {
                                //insert a segmented button
                                xtype: 'segmentedbutton',

                                //give the segmented button a few items (defaults to Ext.Button's)
                                items: [

                    	                { iconCls: 'multibox',  iconMask: true,  action:'multiview' },
                    	                { iconCls: 'singlebox',  iconMask: true,  action:'singleview' } 
                                ]
                            }
                        ]
                    },
        	        {
        	            docked: 'top',
        	            xtype: 'titlebar',
        	            title: 'Camera' 
        	            
        	        }, 
        	    ],
        	    listeners : {
        	    	 'initialize' : function(){
        	   		  
        	    		 this.setActiveItem(0);
        	    	 }
        	    }
        	    
        
	        
    } 
   
   
    
});