Ext.define('SmartHomeUI.store.Pages', {
    extend: 'Ext.data.Store',
    requires: ['SmartHomeUI.model.Page'],
    config: {
        model: 'SmartHomeUI.model.Page',
       
        
       
	    proxy: {
	        type: "ajax",
	        url : "pages.json",
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
      /*  grouper: {
            groupFn: function(record) {
                return record.get('pageId');
            }
        }*/ 
    }
});