/**
 * A simple store that has predefined data. It uses the {@link Example.model.Kitten}
 * model for it's fields definition.
 */
Ext.define('SmartHomeUI.store.Cameras', {
    extend: 'Ext.data.Store',
    requires: ['SmartHomeUI.model.Camera'],
    config:{ 
   
	    model: 'SmartHomeUI.model.Camera', 
	    proxy: {
	        type: "ajax",
	        url : "cameras.json",
	        reader: {
	            type: "json" 
	        }
	    },
	    sorters: [
	              {
	                  property : "id",
	                  direction: "ASC"
	              } 
	          ] 
    }
});
