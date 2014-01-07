/**
 * A simple store that has predefined data. It uses the {@link Example.model.Kitten}
 * model for it's fields definition.
 */
Ext.define('SmartHomeUI.store.Weathers', {
    extend: 'Ext.data.Store',
    requires: ['SmartHomeUI.model.Weather'],
    config:{ 
   
	    model: 'SmartHomeUI.model.Weather', 
	    proxy: {
	        type: "ajax",
	        url : "weather.json",
	        reader: {
	            type: "json" 
	        }
	    },
	    sorters: [
	              {
	                  property : "q",
	                  direction: "ASC"
	              } 
	          ] 
    }
});
