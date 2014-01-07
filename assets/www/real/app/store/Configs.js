 
Ext.define('AppUI.store.Configs', {
    extend: 'Ext.data.Store',
    requires: ['AppUI.model.Config'],
    config: {
        model: 'AppUI.model.Config' /*,
        
		proxy: {
	        type: "ajax",
	        url : "config.json",
	        reader: {
	            type: "json" 
	        }
	    } 
	    */
    }
	 
});