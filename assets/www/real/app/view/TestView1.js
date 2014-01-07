
Ext.define('AppUI.view.TestView1', {
    extend: 'Ext.Container',
    xtype:'testview1',
    config: {
    	style:'text-overflow: clip; overflow: visible;',
    	  
    	 
    	layout: {
            type : 'hbox',
            pack:'center',
            align: 'start'
        },
       
         
            defaults: {
                xtype : 'button',
                minHeight:'50',
                margin: 10
             
        },
        items: [
            
                    {text: 'Normal'},
                    {ui: 'round', text: 'Round'},
                    {ui: 'round', text: 'Round'},
                    {ui: 'round', text: 'Round'},
                    {ui: 'round', text: 'Round'},
          
                    {ui: 'decline', text: 'Decline'},
                    {ui: 'decline-round', text: 'Round'},
                    {ui: 'decline-small', text: 'Small'},
             
                    {ui: 'confirm', text: 'Confirm'},
                    {ui: 'confirm-round', text: 'Round'},
                    {ui: 'confirm-small', text: 'Small'},
                    {ui: 'back', text: 'Back'}
                ]
           
         
    }
});