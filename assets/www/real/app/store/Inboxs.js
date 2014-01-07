/*
 * - Sales Invoice
- Customer
- Stock
- Penerimaan Barang
- Transfer Barang
- Sales Return
 */
Ext.define('AppUI.store.Inboxs', {
    extend: 'Ext.data.Store',
    requires: ['AppUI.model.Inbox'],
    config: {
        model: 'AppUI.model.Inbox',
        data : [
        {ibx_id:1,ibx_sbj:'Test Subject',ibx_cnt:'What is up dude!',ibx_from:'System',ibx_date:'2013-10-01'},
          {ibx_id:2,ibx_sbj:'Test Subject',ibx_cnt:'What is up dudesdfsdfd hj vhjhjhbjhj jhb jhbj hbjhbjhbjhb jhbjh jhbj h!',ibx_from:'System',ibx_date:'2013-10-01'}
            ] 
	     
    }
});