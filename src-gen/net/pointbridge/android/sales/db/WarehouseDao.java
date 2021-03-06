package net.pointbridge.android.sales.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import net.pointbridge.android.sales.db.Warehouse;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table WAREHOUSE.
*/
public class WarehouseDao extends AbstractDao<Warehouse, String> {

    public static final String TABLENAME = "WAREHOUSE";

    /**
     * Properties of entity Warehouse.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Wh_code = new Property(0, String.class, "wh_code", true, "WH_CODE");
        public final static Property Wh_name = new Property(1, String.class, "wh_name", false, "WH_NAME");
        public final static Property Wh_istransit = new Property(2, Integer.class, "wh_istransit", false, "WH_ISTRANSIT");
        public final static Property Wh_active = new Property(3, Integer.class, "wh_active", false, "WH_ACTIVE");
        public final static Property Brc_code = new Property(4, String.class, "brc_code", false, "BRC_CODE");
        public final static Property Src_code = new Property(5, String.class, "src_code", false, "SRC_CODE");
        public final static Property Mark = new Property(6, Integer.class, "mark", false, "MARK");
        public final static Property Modi_by = new Property(7, String.class, "modi_by", false, "MODI_BY");
        public final static Property Modi_date = new Property(8, java.util.Date.class, "modi_date", false, "MODI_DATE");
    };


    public WarehouseDao(DaoConfig config) {
        super(config);
    }
    
    public WarehouseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'WAREHOUSE' (" + //
                "'WH_CODE' TEXT PRIMARY KEY ASC NOT NULL ," + // 0: wh_code
                "'WH_NAME' TEXT," + // 1: wh_name
                "'WH_ISTRANSIT' INTEGER," + // 2: wh_istransit
                "'WH_ACTIVE' INTEGER," + // 3: wh_active
                "'BRC_CODE' TEXT," + // 4: brc_code
                "'SRC_CODE' TEXT," + // 5: src_code
                "'MARK' INTEGER," + // 6: mark
                "'MODI_BY' TEXT," + // 7: modi_by
                "'MODI_DATE' INTEGER);"); // 8: modi_date
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_WAREHOUSE_WH_NAME ON WAREHOUSE" +
                " (WH_NAME);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'WAREHOUSE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Warehouse entity) {
        stmt.clearBindings();
 
        String wh_code = entity.getWh_code();
        if (wh_code != null) {
            stmt.bindString(1, wh_code);
        }
 
        String wh_name = entity.getWh_name();
        if (wh_name != null) {
            stmt.bindString(2, wh_name);
        }
 
        Integer wh_istransit = entity.getWh_istransit();
        if (wh_istransit != null) {
            stmt.bindLong(3, wh_istransit);
        }
 
        Integer wh_active = entity.getWh_active();
        if (wh_active != null) {
            stmt.bindLong(4, wh_active);
        }
 
        String brc_code = entity.getBrc_code();
        if (brc_code != null) {
            stmt.bindString(5, brc_code);
        }
 
        String src_code = entity.getSrc_code();
        if (src_code != null) {
            stmt.bindString(6, src_code);
        }
 
        Integer mark = entity.getMark();
        if (mark != null) {
            stmt.bindLong(7, mark);
        }
 
        String modi_by = entity.getModi_by();
        if (modi_by != null) {
            stmt.bindString(8, modi_by);
        }
 
        java.util.Date modi_date = entity.getModi_date();
        if (modi_date != null) {
            stmt.bindLong(9, modi_date.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Warehouse readEntity(Cursor cursor, int offset) {
        Warehouse entity = new Warehouse( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // wh_code
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // wh_name
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // wh_istransit
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // wh_active
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // brc_code
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // src_code
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // mark
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // modi_by
            cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)) // modi_date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Warehouse entity, int offset) {
        entity.setWh_code(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setWh_name(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setWh_istransit(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setWh_active(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setBrc_code(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSrc_code(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setMark(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setModi_by(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setModi_date(cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Warehouse entity, long rowId) {
        return entity.getWh_code();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Warehouse entity) {
        if(entity != null) {
            return entity.getWh_code();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
