/**
 * A simple list that uses {@link Example.view.KittensListItem} to show records from
 * the {@link Example.store.Kittens} store.
 */
Ext.define('SmartHomeUI.view.HomeViewList', {
    extend: 'Ext.Panel',
    xtype: 'homeviewlist',

    /**
     * We need to require the {@link Example.view.KittensListItem} class so we can
     * use it as the {@link #defaultType} below
     */
 

    config: {
    	 
    	/**
         * Tell the dataview to use components for each item
         */
     //   useComponents: true,

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
       //store: 'Pages',
        
        /**
         * Set the default item for this component list to be the {@link Example.view.KittensListItem}
         * class.
         */
      //  defaultType: 'homeviewlistitem',
        scrollable: {
    	    direction: 'vertical',
    	    directionLock: true
    	},
        inline: true,
        
        listeners :{ 
        	'initialize':function(){
            	console.log("homeviewlist init");
            	var me = this;
            	me.fireEvent('onInit', me);
            	
            }
        }
    },
    
});