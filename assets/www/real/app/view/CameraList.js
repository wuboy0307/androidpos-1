
Ext.define('SmartHomeUI.view.CameraList', {
    extend: 'Ext.dataview.DataView',
    xtype: 'cameralist',

    /**
     * We need to require the {@link Example.view.KittensListItem} class so we can
     * use it as the {@link #defaultType} below
     */
    

    config: {
    	 
    	/**
         * Tell the dataview to use components for each item
         */
        useComponents: true,

        /**
         * Give is a cls so we can style it
         */
        cls: 'smarthome-list',

        /**
         * Use the {@link Example.store.Kittens} store as it's data source.
         *
         * Note: we can use 'Kittens' because we have defined the store as a store in
         * our {@link Example.controller.Application} controller
         */
        store: 'Cameras',
        
        /**
         * Set the default item for this component list to be the {@link Example.view.KittensListItem}
         * class.
         */
        defaultType: 'cameralistitem',
        
        inline: true,
        listeners :{ 
        	   itemdoubletap:function(me,index,item,record,event,opt){
            	console.log('itemtap ');
             
            	console.log(index);
            	console.log(record.get('id'));
            	
            	if (!this.overlay) {
                    this.overlay = Ext.Viewport.add({
                        xtype: 'panel',
                        modal: true,
                        hideOnMaskTap: true,
                        showAnimation: {
                            type: 'popIn',
                            duration: 250,
                            easing: 'ease-out'
                        },
                        hideAnimation: {
                            type: 'popOut',
                            duration: 250,
                            easing: 'ease-out'
                        },
                        centered: true,
                        width:  Ext.getBody().getSize().width -50,
                        height:  Ext.getBody().getSize().height -50,
                        styleHtmlContent: true,
                       
                        items: [
                            {
                                docked: 'top',
                                xtype: 'toolbar',
                                title: 'Camera View #'+record.get('id')
                            }
                        ],
                        scrollable: true
                    });
                }
            	this.overlay.add(
                        	{
                       		 	xtype:'video', 
                       		 	url: record.get('url'),
                                width:   Ext.getBody().getSize().width -60,
                                height: Ext.getBody().getSize().height -60,
                                centered:true,
                                posterUrl: record.get('posterUrl')
                           });	
                this.overlay.show();
            }
            }
    },
    
});