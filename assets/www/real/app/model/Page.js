Ext.define('SmartHomeUI.model.Page', {
extend: 'Ext.data.Model',
config: {
    fields: ["id",
     		"pageId",
    		"unitId",
    		"unitName",
    		"carousel",
            "carouselTitle",
    		"compId",
    		"compOri",
    		"compType",
    		"compName",
    		"compLabel",
    		"compIcon",		
    		"compValue",
    		"compFunction",
    		"compParam",
    		"compImg"]
}
});