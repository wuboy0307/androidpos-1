/**
 * A simple list item to show a picture, name and cuteness value of a kitten, from the
 * {@link Example.store.Kittens} store.
 */
Ext.define('SmartHomeUI.view.CameraListItem', {
    extend: 'Ext.dataview.component.DataItem',
    xtype : 'cameralistitem',

    requires: [
               'Ext'
           ],

    config: {
        /**
         * A custom cls for each item
         */
    	 
     
    	 
    	
       //  width:(Ext.getBody().getSize().width/2)-10,
        // height:(Ext.getBody().getSize().height/2)-10,
    	width:'150px',
    	height:'130px',
    	cls: 'smarthome-list-item',
         	
        /**
         * setup the dataMap. each property is a method in 'this' class, and then
         * inside that config, it will call the method you pass with the value you
         * want, form the record
         */
        dataMap: {
            //this will call: this.getImage()
            getVideo: {
                //and then this will call: this.getImage().setSrc() with the
                //'image' field value form the record
                setPosterUrl: 'posterUrl',
                setUrl: 'url',
                
                setCentered:true,
                setFlex:0 
                 
                 
            },

            getName: {
                setHtml: 'label'
            } 
           
        },
        
        /**
         * @cfg {Boolean/Object/Ext.Img} image
         * The config for the image component used in this dataitem.
         * In this case, we just pass true, because we just want it to create
         * a new Ext.Img.
         */
        video: true,

        /**
         * @cfg {Boolean/Object/Ext.Component} name
         * The component used to show an image. It is an Ext.Component, so we
         * just want to add a cls so we can style it, and add some flex so it
         * looks good.
         */
        name: {
            cls: 'x-name',
            
        },

       
        
        /**
         * We give it a hbox layout so the items are horizontally displayed, and then
         * give it an align of center so they are vertically centered.
         */
        layout: {
            type: 'vbox',
            align: 'center'
        } 
      
    },

    /**
     * Called when you set the {@link #image} configuration.
     *
     * Uses Ext.factory to return a proper instance using the configuration passed, the
     * default component, and the existing instance (if it exists).
     *
     * This should *never* be called manually. It will be called when you call {@link #setImage}.
     */
    applyVideo: function(config) {
    	
        return Ext.factory(config, Ext.Video, this.getVideo());
    },

    /**
     * Called when you set the {@link #image} configuration, and is passed both the new value
     * (from applyImage) and the old value.
     *
     * This should *never* be called manually. It will be called when you call {@link #setImage}.
     * @private
     */
    updateVideo: function(newVideo, oldVideo) {
    	newVideo.setWidth(130);
    	newVideo.setHeight(100); 
    	
      
        if (newVideo) {
        	newVideo.on('itemtap', this.onVideoTap, this);
            this.add(newVideo);
        }

        if (oldVideo) {
            this.remove(oldVideo);
        }
    }, 
    onVideoTap: function(avideo, e) {
        var record = this.getRecord();
        console.log('tapped');
        /*Ext.Msg.alert(
            record.get('name'), // the title of the alert
            "The age of this person is: " + record.get('age') // the message of the alert
        );
        */
    },
    
    
    /**
     * Called when you set the {@link #name} configuration.
     *
     * Uses Ext.factory to return a proper instance using the configuration passed, the
     * default component, and the existing instance (if it exists).
     *
     * This should *never* be called manually. It will be called when you call {@link #setName}.
     * @private
     */
    applyName: function(config) {
        return Ext.factory(config, Ext.Component, this.getName());
    },

    /**
     * Called when you set the {@link #name} configuration, and is passed both the new value
     * (from applyName) and the old value.
     *
     * This should *never* be called manually. It will be called when you call {@link #setName}.
     * @private
     */
    updateName: function(newName, oldName) {
        if (newName) {
            this.add(newName);
        }

        if (oldName) {
            this.remove(oldName);
        }
    }

    
});