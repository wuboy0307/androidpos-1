package net.pointbridge.android.sales.db;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import net.pointbridge.android.sales.db.SalesDetail;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table SALES_DETAIL.
*/
public class SalesDetailDao extends AbstractDao<SalesDetail, String> {

    public static final String TABLENAME = "SALES_DETAIL";

    /**
     * Properties of entity SalesDetail.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Sd_id = new Property(0, String.class, "sd_id", true, "SD_ID");
        public final static Property Sm_id = new Property(1, String.class, "sm_id", false, "SM_ID");
        public final static Property So_no = new Property(2, String.class, "so_no", false, "SO_NO");
        public final static Property Sod_id = new Property(3, String.class, "sod_id", false, "SOD_ID");
        public final static Property Itm_code = new Property(4, String.class, "itm_code", false, "ITM_CODE");
        public final static Property Itm_unit = new Property(5, String.class, "itm_unit", false, "ITM_UNIT");
        public final static Property Sd_qty = new Property(6, Float.class, "sd_qty", false, "SD_QTY");
        public final static Property Sd_price = new Property(7, Float.class, "sd_price", false, "SD_PRICE");
        public final static Property Sd_buyprice = new Property(8, Float.class, "sd_buyprice", false, "SD_BUYPRICE");
        public final static Property Sd_disc1 = new Property(9, Float.class, "sd_disc1", false, "SD_DISC1");
        public final static Property Sd_disc2 = new Property(10, Float.class, "sd_disc2", false, "SD_DISC2");
        public final static Property Sd_discval = new Property(11, Float.class, "sd_discval", false, "SD_DISCVAL");
        public final static Property Sd_inctax = new Property(12, Integer.class, "sd_inctax", false, "SD_INCTAX");
        public final static Property Sd_taxval = new Property(13, Float.class, "sd_taxval", false, "SD_TAXVAL");
        public final static Property Sd_csg = new Property(14, Integer.class, "sd_csg", false, "SD_CSG");
        public final static Property Sd_calcpoint = new Property(15, Integer.class, "sd_calcpoint", false, "SD_CALCPOINT");
        public final static Property Sd_othercost = new Property(16, Float.class, "sd_othercost", false, "SD_OTHERCOST");
        public final static Property Locked = new Property(17, Integer.class, "locked", false, "LOCKED");
        public final static Property Posted = new Property(18, Integer.class, "posted", false, "POSTED");
        public final static Property Src_code = new Property(19, String.class, "src_code", false, "SRC_CODE");
        public final static Property Astate = new Property(20, Integer.class, "astate", false, "ASTATE");
        public final static Property Spg = new Property(21, String.class, "spg", false, "SPG");
        public final static Property No_seq = new Property(22, Integer.class, "no_seq", false, "NO_SEQ");
        public final static Property Mark = new Property(23, Integer.class, "mark", false, "MARK");
        public final static Property Modi_by = new Property(24, String.class, "modi_by", false, "MODI_BY");
        public final static Property Modi_date = new Property(25, java.util.Date.class, "modi_date", false, "MODI_DATE");
    };

    private Query<SalesDetail> salesMaster_Sd_detail_fk1Query;

    public SalesDetailDao(DaoConfig config) {
        super(config);
    }
    
    public SalesDetailDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'SALES_DETAIL' (" + //
                "'SD_ID' TEXT PRIMARY KEY ASC NOT NULL ," + // 0: sd_id
                "'SM_ID' TEXT," + // 1: sm_id
                "'SO_NO' TEXT," + // 2: so_no
                "'SOD_ID' TEXT," + // 3: sod_id
                "'ITM_CODE' TEXT," + // 4: itm_code
                "'ITM_UNIT' TEXT," + // 5: itm_unit
                "'SD_QTY' REAL," + // 6: sd_qty
                "'SD_PRICE' REAL," + // 7: sd_price
                "'SD_BUYPRICE' REAL," + // 8: sd_buyprice
                "'SD_DISC1' REAL," + // 9: sd_disc1
                "'SD_DISC2' REAL," + // 10: sd_disc2
                "'SD_DISCVAL' REAL," + // 11: sd_discval
                "'SD_INCTAX' INTEGER," + // 12: sd_inctax
                "'SD_TAXVAL' REAL," + // 13: sd_taxval
                "'SD_CSG' INTEGER," + // 14: sd_csg
                "'SD_CALCPOINT' INTEGER," + // 15: sd_calcpoint
                "'SD_OTHERCOST' REAL," + // 16: sd_othercost
                "'LOCKED' INTEGER," + // 17: locked
                "'POSTED' INTEGER," + // 18: posted
                "'SRC_CODE' TEXT," + // 19: src_code
                "'ASTATE' INTEGER," + // 20: astate
                "'SPG' TEXT," + // 21: spg
                "'NO_SEQ' INTEGER," + // 22: no_seq
                "'MARK' INTEGER," + // 23: mark
                "'MODI_BY' TEXT," + // 24: modi_by
                "'MODI_DATE' INTEGER);"); // 25: modi_date
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_SALES_DETAIL_SM_ID ON SALES_DETAIL" +
                " (SM_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SALES_DETAIL'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SalesDetail entity) {
        stmt.clearBindings();
 
        String sd_id = entity.getSd_id();
        if (sd_id != null) {
            stmt.bindString(1, sd_id);
        }
 
        String sm_id = entity.getSm_id();
        if (sm_id != null) {
            stmt.bindString(2, sm_id);
        }
 
        String so_no = entity.getSo_no();
        if (so_no != null) {
            stmt.bindString(3, so_no);
        }
 
        String sod_id = entity.getSod_id();
        if (sod_id != null) {
            stmt.bindString(4, sod_id);
        }
 
        String itm_code = entity.getItm_code();
        if (itm_code != null) {
            stmt.bindString(5, itm_code);
        }
 
        String itm_unit = entity.getItm_unit();
        if (itm_unit != null) {
            stmt.bindString(6, itm_unit);
        }
 
        Float sd_qty = entity.getSd_qty();
        if (sd_qty != null) {
            stmt.bindDouble(7, sd_qty);
        }
 
        Float sd_price = entity.getSd_price();
        if (sd_price != null) {
            stmt.bindDouble(8, sd_price);
        }
 
        Float sd_buyprice = entity.getSd_buyprice();
        if (sd_buyprice != null) {
            stmt.bindDouble(9, sd_buyprice);
        }
 
        Float sd_disc1 = entity.getSd_disc1();
        if (sd_disc1 != null) {
            stmt.bindDouble(10, sd_disc1);
        }
 
        Float sd_disc2 = entity.getSd_disc2();
        if (sd_disc2 != null) {
            stmt.bindDouble(11, sd_disc2);
        }
 
        Float sd_discval = entity.getSd_discval();
        if (sd_discval != null) {
            stmt.bindDouble(12, sd_discval);
        }
 
        Integer sd_inctax = entity.getSd_inctax();
        if (sd_inctax != null) {
            stmt.bindLong(13, sd_inctax);
        }
 
        Float sd_taxval = entity.getSd_taxval();
        if (sd_taxval != null) {
            stmt.bindDouble(14, sd_taxval);
        }
 
        Integer sd_csg = entity.getSd_csg();
        if (sd_csg != null) {
            stmt.bindLong(15, sd_csg);
        }
 
        Integer sd_calcpoint = entity.getSd_calcpoint();
        if (sd_calcpoint != null) {
            stmt.bindLong(16, sd_calcpoint);
        }
 
        Float sd_othercost = entity.getSd_othercost();
        if (sd_othercost != null) {
            stmt.bindDouble(17, sd_othercost);
        }
 
        Integer locked = entity.getLocked();
        if (locked != null) {
            stmt.bindLong(18, locked);
        }
 
        Integer posted = entity.getPosted();
        if (posted != null) {
            stmt.bindLong(19, posted);
        }
 
        String src_code = entity.getSrc_code();
        if (src_code != null) {
            stmt.bindString(20, src_code);
        }
 
        Integer astate = entity.getAstate();
        if (astate != null) {
            stmt.bindLong(21, astate);
        }
 
        String spg = entity.getSpg();
        if (spg != null) {
            stmt.bindString(22, spg);
        }
 
        Integer no_seq = entity.getNo_seq();
        if (no_seq != null) {
            stmt.bindLong(23, no_seq);
        }
 
        Integer mark = entity.getMark();
        if (mark != null) {
            stmt.bindLong(24, mark);
        }
 
        String modi_by = entity.getModi_by();
        if (modi_by != null) {
            stmt.bindString(25, modi_by);
        }
 
        java.util.Date modi_date = entity.getModi_date();
        if (modi_date != null) {
            stmt.bindLong(26, modi_date.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public SalesDetail readEntity(Cursor cursor, int offset) {
        SalesDetail entity = new SalesDetail( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // sd_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // sm_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // so_no
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sod_id
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // itm_code
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // itm_unit
            cursor.isNull(offset + 6) ? null : cursor.getFloat(offset + 6), // sd_qty
            cursor.isNull(offset + 7) ? null : cursor.getFloat(offset + 7), // sd_price
            cursor.isNull(offset + 8) ? null : cursor.getFloat(offset + 8), // sd_buyprice
            cursor.isNull(offset + 9) ? null : cursor.getFloat(offset + 9), // sd_disc1
            cursor.isNull(offset + 10) ? null : cursor.getFloat(offset + 10), // sd_disc2
            cursor.isNull(offset + 11) ? null : cursor.getFloat(offset + 11), // sd_discval
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // sd_inctax
            cursor.isNull(offset + 13) ? null : cursor.getFloat(offset + 13), // sd_taxval
            cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14), // sd_csg
            cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15), // sd_calcpoint
            cursor.isNull(offset + 16) ? null : cursor.getFloat(offset + 16), // sd_othercost
            cursor.isNull(offset + 17) ? null : cursor.getInt(offset + 17), // locked
            cursor.isNull(offset + 18) ? null : cursor.getInt(offset + 18), // posted
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // src_code
            cursor.isNull(offset + 20) ? null : cursor.getInt(offset + 20), // astate
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // spg
            cursor.isNull(offset + 22) ? null : cursor.getInt(offset + 22), // no_seq
            cursor.isNull(offset + 23) ? null : cursor.getInt(offset + 23), // mark
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // modi_by
            cursor.isNull(offset + 25) ? null : new java.util.Date(cursor.getLong(offset + 25)) // modi_date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SalesDetail entity, int offset) {
        entity.setSd_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setSm_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSo_no(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSod_id(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setItm_code(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setItm_unit(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSd_qty(cursor.isNull(offset + 6) ? null : cursor.getFloat(offset + 6));
        entity.setSd_price(cursor.isNull(offset + 7) ? null : cursor.getFloat(offset + 7));
        entity.setSd_buyprice(cursor.isNull(offset + 8) ? null : cursor.getFloat(offset + 8));
        entity.setSd_disc1(cursor.isNull(offset + 9) ? null : cursor.getFloat(offset + 9));
        entity.setSd_disc2(cursor.isNull(offset + 10) ? null : cursor.getFloat(offset + 10));
        entity.setSd_discval(cursor.isNull(offset + 11) ? null : cursor.getFloat(offset + 11));
        entity.setSd_inctax(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setSd_taxval(cursor.isNull(offset + 13) ? null : cursor.getFloat(offset + 13));
        entity.setSd_csg(cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14));
        entity.setSd_calcpoint(cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15));
        entity.setSd_othercost(cursor.isNull(offset + 16) ? null : cursor.getFloat(offset + 16));
        entity.setLocked(cursor.isNull(offset + 17) ? null : cursor.getInt(offset + 17));
        entity.setPosted(cursor.isNull(offset + 18) ? null : cursor.getInt(offset + 18));
        entity.setSrc_code(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setAstate(cursor.isNull(offset + 20) ? null : cursor.getInt(offset + 20));
        entity.setSpg(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setNo_seq(cursor.isNull(offset + 22) ? null : cursor.getInt(offset + 22));
        entity.setMark(cursor.isNull(offset + 23) ? null : cursor.getInt(offset + 23));
        entity.setModi_by(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setModi_date(cursor.isNull(offset + 25) ? null : new java.util.Date(cursor.getLong(offset + 25)));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(SalesDetail entity, long rowId) {
        return entity.getSd_id();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(SalesDetail entity) {
        if(entity != null) {
            return entity.getSd_id();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "sd_detail_fk1" to-many relationship of SalesMaster. */
    public List<SalesDetail> _querySalesMaster_Sd_detail_fk1(String sm_id) {
        synchronized (this) {
            if (salesMaster_Sd_detail_fk1Query == null) {
                QueryBuilder<SalesDetail> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Sm_id.eq(null));
                queryBuilder.orderRaw("SD_ID ASC");
                salesMaster_Sd_detail_fk1Query = queryBuilder.build();
            }
        }
        Query<SalesDetail> query = salesMaster_Sd_detail_fk1Query.forCurrentThread();
        query.setParameter(0, sm_id);
        return query.list();
    }

}