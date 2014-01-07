/**
 * A simple store that has predefined data. It uses the {@link Example.model.Kitten}
 * model for it's fields definition.
 */
Ext.define('SmartHomeUI.store.Cookie', {
    extend: 'Ext.data.Store',
    requires: ['SmartHomeUI.model.Cookie'],
    config:{ 
   
	    model: 'SmartHomeUI.model.Cookie', 
	    identifier:'uuid', // needed to avoid console warnings!
	    proxy: {
            type: 'localstorage',
            id  : 'SHCookie'
        }
	     
    }
});
