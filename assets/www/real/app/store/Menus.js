/*
 * - Sales Invoice
- Customer
- Stock
- Penerimaan Barang
- Transfer Barang
- Sales Return
 */
Ext.define('AppUI.store.Menus', {
    extend: 'Ext.data.Store',
    requires: ['AppUI.model.Menu'],
    config: {
        model: 'AppUI.model.Menu',
        data : [
                {id: 'customer', text: 'Customer'},
                {id: 'invoice',    text: 'Sales Invoice'},
                {id: 'order',    text: 'Sales Order'},
                {id: 'return', text: 'Sales Return'},
                {id: 'receive', text: 'Receive Item'},
                {id: 'transfer', text: 'Transfer Item'},
                {id: 'stock', text: 'Stock'} 
                
            ] 
	     
    }
});