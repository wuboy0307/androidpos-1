/**
 * @author McG
 *
 * Custom made based on WebStorageProxy
 * APX = Android Proxy. it can be used for
 * WebStorageProxy is simply a superclass for the {@link Ext.data.proxy.LocalStorage LocalStorage} proxy. It uses the
 * new HTML5 key/value client-side storage objects to save {@link Ext.data.Model model instances} for offline use.
 * @private
 */
Ext.define('AppUI.data.proxy.Apx', {
    extend: 'Ext.data.proxy.Client',
    alternateClassName: 'AppUI.data.Apx',
	 alias: 'proxy.apx',
    requires: ['Ext.Date','AppUI.data.proxy.ApxStorage'],
	storage:null,
    config: {
        /**
         * @cfg {String} id
         * The unique ID used as the key in which all record data are stored in the local storage object.
         */
        id: undefined,

        // WebStorage proxies dont use readers and writers
        /**
         * @cfg
         * @hide
         */
        reader: null,
        /**
         * @cfg
         * @hide
         */
        writer: null,

        /**
         * @cfg {Boolean} enablePagingParams This can be set to true if you want the webstorage proxy to comply
         * to the paging params set on the store.
         */
        enablePagingParams: false,

		defaultDateFormat: 'Y-m-d H:i:s.u'
    },

    /**
     * Creates the proxy, throws an error if local storage is not supported in the current browser.
     * @param {Object} config (optional) Config object.
     */
    constructor: function(config) {
        this.callParent(arguments);

        /**
         * @property {Object} cache
         * Cached map of records already retrieved by this Proxy. Ensures that the same instance is always retrieved.
         */
        this.cache = {};

        //<debug>
        //if (this.getStorageObject() === undefined) {
         //   Ext.Logger.error("Local Storage is not supported in this browser, please use another type of data proxy");
      //  }
        //</debug>
    },

    updateModel: function(model) {
        if (!this.getId()) {
            this.setId(model.modelName);
        }
    },
	//tetap gunakan per 1 record save, ga bisa semua, karena masalah di operation
    create: function (operation, callback, scope) {
        var me = this,
            
        records = operation.getRecords(),
        totalRecords = records.length,
		insertedRecords = [],
        errors = [];
        operation.setStarted();

        me.insertRecords(records, function(resultSet) {
                if (operation.process(operation.getAction(), resultSet) === false) {
                    me.fireEvent('exception', this, operation);
                }

                if (typeof callback == 'function') {
                    callback.call(scope || this, operation);
                }
            }, this);
        operation.setCompleted();
        operation.setSuccessful();

         
    }, 
    
	insertRecords: function(records, callback, scope) {
        var me = this,
            totalRecords = records.length,
            executed = 0,
            tmp = [],
            insertedRecords = [],
            errors = [],
            i, ln, result;
		
        result = new Ext.data.ResultSet({
            records: insertedRecords,
            success: true
        });

         
        Ext.each(records, function (record) {
           
        	console.log("*insert record========================");
         	console.dir(record.getData());
			console.log(Ext.encode(record.getData()));
			console.log("==========================");
			 var config = { 
			       		"command": 'db',
							"subcommand" : 'insert',
							"table" :this.getId(),
							"record" : Ext.encode(record.getData()) 
							
						}; 
			  myService.askJob(config,
				  function (response) {
	       	  		if (response.Data!=""){
	                 	var res = Ext.JSON.decode(response.Data);
			       		 if (res){
			                   if (res.success ==   true ) {
			                   
			                        console.log("insert Record (success) "+res.message);
			                   } else {
			                       console.log("insert Record (failed) "+res.message);
			                   }
			       		 }else {
			       			 console.log("insert Record (failed) no data available");
			       		 }
			       	 }
			       	 else {
			       		 console.log("insert Record (failed) no response data");
			       	 } 
	       		 
	               },
				    function (responseFail) {
				            console.log("insert Record (failed) no respond");
				    }
				);
         }); //end of loop record 
        	 
	        if (executed === totalRecords && typeof callback == 'function') {
	            callback.call(scope || me, result, errors);
	        }
         
    }, 
    //inherit docs
    read: function(operation, callback, scope) {
    	console.log("=======read function");
    	console.log(operation);
    	console.log("=================================");
    	
        var records    = [],
        	count=0,
            ids        = this.getIds(),
            model      = this.getModel(),
            idProperty = model.getIdProperty(),
            params     = operation.getParams() || {},
            sorters = operation.getSorters(),
            filters = operation.getFilters(),
            start = operation.getStart(),
            limit = operation.getLimit(),
            length     = ids.length,
            i, record, collection;
		console.log("idProperty :"+model.getIdProperty());
        //read a single record
		//bedakan single dengan multi karena ada nya start dan limit
        if (params[idProperty] !== undefined) {
            record = this.getRecord(params[idProperty]);
            if (record) {
                records.push(record);
                operation.setSuccessful();
            }
            count=1;
        }
        else {
        	var ares=this.getMultiRecord(operation);
        	count=ares['count'];
            records=ares['data'];
			  collection = Ext.create('Ext.util.Collection');
 
            collection.addAll(records);
 
             records = collection.items.slice();
          

            operation.setSuccessful();
        }

        operation.setCompleted();
 
        operation.setResultSet(Ext.create('Ext.data.ResultSet', {
            records: records,
            total  : count,
            loaded : true
        }));
        operation.setRecords(records);

        if (typeof callback == 'function') {
            callback.call(scope || this, operation);
        }
    },

    //inherit docs
    update: function(operation, callback, scope) {
    	 console.log("*update record========================");
        var records = operation.getRecords(),
            length  = records.length,
            ids     = this.getIds(),
            record, id, i;

        operation.setStarted();

        for (i = 0; i < length; i++) {
            record = records[i];
            this.setRecord(record);

            //we need to update the set of ids here because it's possible that a non-phantom record was added
            //to this proxy - in which case the record's id would never have been added via the normal 'create' call
            id = record.getId();
            if (id !== undefined && Ext.Array.indexOf(ids, id) == -1) {
                ids.push(id);
            }
        }
        this.setIds(ids);

        operation.setCompleted();
        operation.setSuccessful();

        if (typeof callback == 'function') {
            callback.call(scope || this, operation);
        }
    },

    //inherit
    destroy: function(operation, callback, scope) {
        var records = operation.getRecords(),
            length  = records.length,
            ids     = this.getIds(),

            //newIds is a copy of ids, from which we remove the destroyed records
            newIds  = [].concat(ids),
            i;

        operation.setStarted();

        for (i = 0; i < length; i++) {
            Ext.Array.remove(newIds, records[i].getId());
            this.removeRecord(records[i], false);
        }

        this.setIds(newIds);

        operation.setCompleted();
        operation.setSuccessful();

        if (typeof callback == 'function') {
            callback.call(scope || this, operation);
        }
    },
 
    getMultiRecord:function(operation){
    	console.log("##getMultiRecord of " + this.getId());
        var recordKey = this.getModel().getIdProperty(),
                records = [],
                data,result   = {},
                theclass=this,
                Model   = this.getModel(),
                fields  = Model.getFields().items,
                length  = fields.length,
                i, field, name, record, rawList,rawData, rawValue;
         var config = { 
			       		"command": 'db',
							"subcommand" : 'getmulti',
							"table" :this.getId(),
							"sorters" : operation.getSorters(),
				            "filters":operation.getFilters(),
				            "start":operation.getStart(),
				            "limit":operation.getLimit(),
				            "enablePaging":this.getEnablePagingParams()
							
						}; 
		 myService.askJob(config,
	       		 function (response) {
	       		 
	       		//	 console.log(response.Data);
	       	 		if (response.Data!=""){ 
	                 	var res = Ext.JSON.decode(response.Data);
	       		 
	       				//console.log(res.success);
			       		 if (res){ 
			                   if (res.success ==   true ) {
			                   		//processs
			                   		result['count']=res.count;
			                   		rawList = Ext.decode(res.data);
			                   		console.log("****Length of rawList "+result['count']+":"+rawList.length);
			                   		var id="";
									for (z=0;z< rawList.length;z++){
										rawData=rawList[z];
										id=rawData[Model.getIdProperty()];
										console.log("****ID of rawdata "+id);
										 
										 data={};
								            for (i = 0; i < length; i++) {
								                field = fields[i];
								                name  = field.getName();
								                rawValue = rawData[name]; 
												 
								
									                if (typeof field.getDecode() == 'function') {
									                    data[name] = field.getDecode()(rawValue);
									                } else {
									                    if (field.getType().type == 'date') {
															data[name] = theclass.readDate(field, rawValue);
									                    } else {
									                        data[name] = rawValue;
									                    }
									                }
								                 
								            }
								
								            record = new Model(data, id);
								            records.push(record);
										 
									}
									if (records.length===1) {
										result['count']=1;
									}
									result['data']=records;
									//console.log("resul data lenght"+result['data'].length+":"+records.length);
									//	console.log("resul count"+result['count']);
			                        console.log("get Record (success) "+res.message);
			                   } else {
			                       console.log("get Record (failed) "+res.message);
			                   }
			       		 }else {
			       			 console.log("get Record (failed) no data available");
			       		 }
			       	 }
			       	 else {
			       		 console.log("get Record (failed) no response data");
			       	 } 
	       		 
	               },
	                function (responseFail) {
	                  
	                   console.log("get Record (failed) no respond");
	                }
	       );
	      
	         return result
    },
    /**
     * @private
     * Fetches a model instance from the Proxy by ID. Runs each field's decode function (if present) to decode the data.
     * @param {String} id The record's unique ID
     * @return {Ext.data.Model} The model instance or undefined if the record did not exist in the storage.
     */
    getRecord: function(id,operation) {
    	
    	console.log("##getRecord id:"+id);
        var recordKey = this.getModel().getIdProperty(),
               theclass=this,
                data    = {},
                Model   = this.getModel(),
                fields  = Model.getFields().items,
                length  = fields.length,
                i, field, name, record, rawData, rawValue;
    	//dont forget to clear cache
    	 if (theclass.cache[id] === undefined) {
    			var config = { 
			       		"command": 'db',
							"subcommand" : 'getsingle',
							"table" :this.getId(),
							"id":id
							
						}; 
			      myService.askJob(config,
			       		 function (response) {
			       		 
			       		//	 console.log(response.Data);
			       	 		if (response.Data!=""){ 
			                 	var res = Ext.JSON.decode(response.Data);
			       		 
			       				//console.log(res.success);
					       		 if (res){ 
					                   if (res.success ==   true ) {
					                   		//processs
					                   		  rawData = Ext.decode(res.data);
												 
									            for (i = 0; i < length; i++) {
									                field = fields[i];
									                name  = field.getName();
									                if (rawData[name]!== undefined){
													rawValue = rawData[name];
									
										                if (typeof field.getDecode() == 'function') {
										                    data[name] = field.getDecode()(rawValue);
										                } else {
										                    if (field.getType().type == 'date') {
																data[name] = this.readDate(field, rawValue);
										                    } else {
										                        data[name] = rawValue;
										                    }
										                }
									                }
									            }
									
									            record = new Model(data, id);
									            theclass.cache[id] = record;
					                        console.log("get Record (success) "+res.message);
					                   } else {
					                       console.log("get Record (failed) "+res.message);
					                   }
					       		 }else {
					       			 console.log("get Record (failed) no data available");
					       		 }
					       	 }
					       	 else {
					       		 console.log("get Record (failed) no response data");
					       	 } 
			       		 
			               },
			                function (responseFail) {
			                  
			                   console.log("get Record (failed) no respond");
			                }
			       );
    	 }
    	  

        return theclass.cache[id];
			       /*
        if (this.cache[id] === undefined) {
            var recordKey = this.getRecordKey(id),
                item = this.getStorageObject().getItem(recordKey),
                data    = {},
                Model   = this.getModel(),
                fields  = Model.getFields().items,
                length  = fields.length,
                i, field, name, record, rawData, rawValue;

            if (!item) {
                return undefined;
            }

            rawData = Ext.decode(item);

            for (i = 0; i < length; i++) {
                field = fields[i];
                name  = field.getName();
				rawValue = rawData[name];

                if (typeof field.getDecode() == 'function') {
                    data[name] = field.getDecode()(rawValue);
                } else {
                    if (field.getType().type == 'date') {
						data[name] = this.readDate(field, rawValue);
                    } else {
                        data[name] = rawValue;
                    }
                }
            }

            record = new Model(data, id);
            this.cache[id] = record;
        }

        return this.cache[id];
        */
    },

    /**
     * Saves the given record in the Proxy. Runs each field's encode function (if present) to encode the data.
     * @param {Ext.data.Model} record The model instance
     * @param {String} [id] The id to save the record under (defaults to the value of the record's getId() function)
     */
    setRecord: function(record, id) {
        if (id) {
            record.setId(id);
        } else {
            id = record.getId();
        }

        var me = this,
            rawData = record.getData(),
            data    = {},
            Model   = me.getModel(),
            fields  = Model.getFields().items,
            length  = fields.length,
            i = 0,
            rawValue, field, name, obj, key;

        for (; i < length; i++) {
            field = fields[i];
            name  = field.getName();
			rawValue = rawData[name];

            if (field.getPersist() === false) {
                continue;
            }

            if (typeof field.getEncode() == 'function') {
                data[name] = field.getEncode()(rawValue, record);
            } else {
                if (field.getType().type == 'date' && Ext.isDate(rawValue)) {
					data[name] = this.writeDate(field, rawValue);
                } else {
                    data[name] = rawValue;
                }
            }
        }

        obj = me.getStorageObject();
        key = me.getRecordKey(id);

        //keep the cache up to date
        me.cache[id] = record;

        //iPad bug requires that we remove the item before setting it
        obj.removeItem(key);
        try {
            obj.setItem(key, Ext.encode(data));
        } catch(e){
            this.fireEvent('exception', this, e);
        }

        record.commit();
    },

    /**
     * @private
     * Physically removes a given record from the local storage. Used internally
     * by {@link #destroy}, which you should use instead because it updates the
     * list of currently-stored record ids.
     * @param {String/Number/Ext.data.Model} id The id of the record to remove,
     * or an Ext.data.Model instance.
     * @param {Boolean} [updateIds] False to skip saving the array of ids
     * representing the set of all records in the Proxy.
     */
    removeRecord: function(id, updateIds) {
        var me = this,
            ids;

        if (id.isModel) {
            id = id.getId();
        }

        if (updateIds !== false) {
            ids = me.getIds();
            Ext.Array.remove(ids, id);
            me.setIds(ids);
        }

        me.getStorageObject().removeItem(me.getRecordKey(id));
    },

    /**
     * @private
     * Given the id of a record, returns a unique string based on that id and the id of this proxy. This is used when
     * storing data in the local storage object and should prevent naming collisions.
     * @param {String/Number/Ext.data.Model} id The record id, or a Model instance
     * @return {String} The unique key for this record
     */
    getRecordKey: function(id) {
        if (id.isModel) {
            id = id.getId();
        }
        console.log("getRecordKey "+id);

        return Ext.String.format("{0}-{1}", this.getId(), id);
    },

    /**
     * @private
     * Returns the array of record IDs stored in this Proxy
     * @return {Number[]} The record IDs. Each is cast as a Number
     */
    getIds: function() {
    	console.log("getIds");
        var ids    = "",
            length = ids.length,
            i;

        if (length == 1 && ids[0] === "") {
            ids = [];
        }

        return ids;
    },

    /**
     * @private
     * Saves the array of ids representing the set of all records in the Proxy
     * @param {Number[]} ids The ids to set
     */
    setIds: function(ids) {
        var obj = this.getStorageObject(),
            str = ids.join(","),
            id  = this.getId();

        obj.removeItem(id);

        if (!Ext.isEmpty(str)) {
            try {
                obj.setItem(id, str);
            } catch(e){
                this.fireEvent('exception', this, e);
            }
        }
    },

	writeDate: function(field, date) {
		if (Ext.isEmpty(date)) {
			return null;
		}

		var dateFormat = field.getDateFormat() || this.getDefaultDateFormat();
		switch (dateFormat) {
			case 'timestamp':
				return date.getTime() / 1000;
			case 'time':
				return date.getTime();
			default:
				return Ext.Date.format(date, dateFormat);
		}
	},

	readDate: function(field, date) {
		if (Ext.isEmpty(date)) {
			return null;
		}

		var dateFormat = field.getDateFormat() || this.getDefaultDateFormat();
		switch (dateFormat) {
			case 'timestamp':
				return new Date(date * 1000);
			case 'time':
				return new Date(date);
			default:
				return Ext.Date.format(Ext.isDate(date) ? date : new Date(date), dateFormat);
		}
	},

    /**
     * @private
     * Sets up the Proxy by claiming the key in the storage object that corresponds to the unique id of this Proxy. Called
     * automatically by the constructor, this should not need to be called again unless {@link #clear} has been called.
     */
    initialize: function() {
        this.callParent(arguments);
        
    },

    /**
     * Destroys all records stored in the proxy and removes all keys and values used to support the proxy from the
     * storage object.
     */
    clear: function() {
       /* var obj = this.getStorageObject(),
            ids = this.getIds(),
            len = ids.length,
            i;

        //remove all the records
        for (i = 0; i < len; i++) {
            this.removeRecord(ids[i], false);
        }
		
        //remove the supporting objects
        obj.removeItem(this.getId());
        */
    } 

     
});