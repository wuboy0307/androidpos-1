package net.pointbridge.android.sales.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import net.pointbridge.android.sales.db.SrMaster;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table SR_MASTER.
*/
public class SrMasterDao extends AbstractDao<SrMaster, String> {

    public static final String TABLENAME = "SR_MASTER";

    /**
     * Properties of entity SrMaster.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Sr_id = new Property(0, String.class, "sr_id", true, "SR_ID");
        public final static Property Sr_no = new Property(1, String.class, "sr_no", false, "SR_NO");
        public final static Property Sr_date = new Property(2, java.util.Date.class, "sr_date", false, "SR_DATE");
        public final static Property Sm_no = new Property(3, String.class, "sm_no", false, "SM_NO");
        public final static Property Cust_code = new Property(4, String.class, "cust_code", false, "CUST_CODE");
        public final static Property Wh_code = new Property(5, String.class, "wh_code", false, "WH_CODE");
        public final static Property Slm_code = new Property(6, Integer.class, "slm_code", false, "SLM_CODE");
        public final static Property Pay_type = new Property(7, Integer.class, "pay_type", false, "PAY_TYPE");
        public final static Property Curr_code = new Property(8, Float.class, "curr_code", false, "CURR_CODE");
        public final static Property Curr_val = new Property(9, Float.class, "curr_val", false, "CURR_VAL");
        public final static Property Sr_totqty = new Property(10, Float.class, "sr_totqty", false, "SR_TOTQTY");
        public final static Property Sr_subtotal = new Property(11, Float.class, "sr_subtotal", false, "SR_SUBTOTAL");
        public final static Property Sr_tottax = new Property(12, Float.class, "sr_tottax", false, "SR_TOTTAX");
        public final static Property Sr_discval = new Property(13, Float.class, "sr_discval", false, "SR_DISCVAL");
        public final static Property Sr_disc1 = new Property(14, Float.class, "sr_disc1", false, "SR_DISC1");
        public final static Property Sr_disc2 = new Property(15, Float.class, "sr_disc2", false, "SR_DISC2");
        public final static Property Sr_disc3 = new Property(16, Float.class, "sr_disc3", false, "SR_DISC3");
        public final static Property Sr_shipcost = new Property(17, Float.class, "sr_shipcost", false, "SR_SHIPCOST");
        public final static Property Sr_shipweight = new Property(18, Float.class, "sr_shipweight", false, "SR_SHIPWEIGHT");
        public final static Property Sr_othercost = new Property(19, Float.class, "sr_othercost", false, "SR_OTHERCOST");
        public final static Property Sr_total = new Property(20, Float.class, "sr_total", false, "SR_TOTAL");
        public final static Property Sr_totalgross = new Property(21, Float.class, "sr_totalgross", false, "SR_TOTALGROSS");
        public final static Property Sr_proc = new Property(22, Integer.class, "sr_proc", false, "SR_PROC");
        public final static Property Sr_inctax = new Property(23, Integer.class, "sr_inctax", false, "SR_INCTAX");
        public final static Property Allproc = new Property(24, Integer.class, "allproc", false, "ALLPROC");
        public final static Property Src_code = new Property(25, Integer.class, "src_code", false, "SRC_CODE");
        public final static Property Astate = new Property(26, Integer.class, "astate", false, "ASTATE");
        public final static Property Locked = new Property(27, Integer.class, "locked", false, "LOCKED");
        public final static Property Posted = new Property(28, Integer.class, "posted", false, "POSTED");
        public final static Property Mark = new Property(29, Integer.class, "mark", false, "MARK");
        public final static Property Modi_by = new Property(30, String.class, "modi_by", false, "MODI_BY");
        public final static Property Modi_date = new Property(31, java.util.Date.class, "modi_date", false, "MODI_DATE");
    };

    private DaoSession daoSession;


    public SrMasterDao(DaoConfig config) {
        super(config);
    }
    
    public SrMasterDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'SR_MASTER' (" + //
                "'SR_ID' TEXT PRIMARY KEY ASC NOT NULL ," + // 0: sr_id
                "'SR_NO' TEXT," + // 1: sr_no
                "'SR_DATE' INTEGER," + // 2: sr_date
                "'SM_NO' TEXT," + // 3: sm_no
                "'CUST_CODE' TEXT," + // 4: cust_code
                "'WH_CODE' TEXT," + // 5: wh_code
                "'SLM_CODE' INTEGER," + // 6: slm_code
                "'PAY_TYPE' INTEGER," + // 7: pay_type
                "'CURR_CODE' REAL," + // 8: curr_code
                "'CURR_VAL' REAL," + // 9: curr_val
                "'SR_TOTQTY' REAL," + // 10: sr_totqty
                "'SR_SUBTOTAL' REAL," + // 11: sr_subtotal
                "'SR_TOTTAX' REAL," + // 12: sr_tottax
                "'SR_DISCVAL' REAL," + // 13: sr_discval
                "'SR_DISC1' REAL," + // 14: sr_disc1
                "'SR_DISC2' REAL," + // 15: sr_disc2
                "'SR_DISC3' REAL," + // 16: sr_disc3
                "'SR_SHIPCOST' REAL," + // 17: sr_shipcost
                "'SR_SHIPWEIGHT' REAL," + // 18: sr_shipweight
                "'SR_OTHERCOST' REAL," + // 19: sr_othercost
                "'SR_TOTAL' REAL," + // 20: sr_total
                "'SR_TOTALGROSS' REAL," + // 21: sr_totalgross
                "'SR_PROC' INTEGER," + // 22: sr_proc
                "'SR_INCTAX' INTEGER," + // 23: sr_inctax
                "'ALLPROC' INTEGER," + // 24: allproc
                "'SRC_CODE' INTEGER," + // 25: src_code
                "'ASTATE' INTEGER," + // 26: astate
                "'LOCKED' INTEGER," + // 27: locked
                "'POSTED' INTEGER," + // 28: posted
                "'MARK' INTEGER," + // 29: mark
                "'MODI_BY' TEXT," + // 30: modi_by
                "'MODI_DATE' INTEGER);"); // 31: modi_date
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_SR_MASTER_SR_NO ON SR_MASTER" +
                " (SR_NO);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_SR_MASTER_CUST_CODE ON SR_MASTER" +
                " (CUST_CODE);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SR_MASTER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SrMaster entity) {
        stmt.clearBindings();
 
        String sr_id = entity.getSr_id();
        if (sr_id != null) {
            stmt.bindString(1, sr_id);
        }
 
        String sr_no = entity.getSr_no();
        if (sr_no != null) {
            stmt.bindString(2, sr_no);
        }
 
        java.util.Date sr_date = entity.getSr_date();
        if (sr_date != null) {
            stmt.bindLong(3, sr_date.getTime());
        }
 
        String sm_no = entity.getSm_no();
        if (sm_no != null) {
            stmt.bindString(4, sm_no);
        }
 
        String cust_code = entity.getCust_code();
        if (cust_code != null) {
            stmt.bindString(5, cust_code);
        }
 
        String wh_code = entity.getWh_code();
        if (wh_code != null) {
            stmt.bindString(6, wh_code);
        }
 
        Integer slm_code = entity.getSlm_code();
        if (slm_code != null) {
            stmt.bindLong(7, slm_code);
        }
 
        Integer pay_type = entity.getPay_type();
        if (pay_type != null) {
            stmt.bindLong(8, pay_type);
        }
 
        Float curr_code = entity.getCurr_code();
        if (curr_code != null) {
            stmt.bindDouble(9, curr_code);
        }
 
        Float curr_val = entity.getCurr_val();
        if (curr_val != null) {
            stmt.bindDouble(10, curr_val);
        }
 
        Float sr_totqty = entity.getSr_totqty();
        if (sr_totqty != null) {
            stmt.bindDouble(11, sr_totqty);
        }
 
        Float sr_subtotal = entity.getSr_subtotal();
        if (sr_subtotal != null) {
            stmt.bindDouble(12, sr_subtotal);
        }
 
        Float sr_tottax = entity.getSr_tottax();
        if (sr_tottax != null) {
            stmt.bindDouble(13, sr_tottax);
        }
 
        Float sr_discval = entity.getSr_discval();
        if (sr_discval != null) {
            stmt.bindDouble(14, sr_discval);
        }
 
        Float sr_disc1 = entity.getSr_disc1();
        if (sr_disc1 != null) {
            stmt.bindDouble(15, sr_disc1);
        }
 
        Float sr_disc2 = entity.getSr_disc2();
        if (sr_disc2 != null) {
            stmt.bindDouble(16, sr_disc2);
        }
 
        Float sr_disc3 = entity.getSr_disc3();
        if (sr_disc3 != null) {
            stmt.bindDouble(17, sr_disc3);
        }
 
        Float sr_shipcost = entity.getSr_shipcost();
        if (sr_shipcost != null) {
            stmt.bindDouble(18, sr_shipcost);
        }
 
        Float sr_shipweight = entity.getSr_shipweight();
        if (sr_shipweight != null) {
            stmt.bindDouble(19, sr_shipweight);
        }
 
        Float sr_othercost = entity.getSr_othercost();
        if (sr_othercost != null) {
            stmt.bindDouble(20, sr_othercost);
        }
 
        Float sr_total = entity.getSr_total();
        if (sr_total != null) {
            stmt.bindDouble(21, sr_total);
        }
 
        Float sr_totalgross = entity.getSr_totalgross();
        if (sr_totalgross != null) {
            stmt.bindDouble(22, sr_totalgross);
        }
 
        Integer sr_proc = entity.getSr_proc();
        if (sr_proc != null) {
            stmt.bindLong(23, sr_proc);
        }
 
        Integer sr_inctax = entity.getSr_inctax();
        if (sr_inctax != null) {
            stmt.bindLong(24, sr_inctax);
        }
 
        Integer allproc = entity.getAllproc();
        if (allproc != null) {
            stmt.bindLong(25, allproc);
        }
 
        Integer src_code = entity.getSrc_code();
        if (src_code != null) {
            stmt.bindLong(26, src_code);
        }
 
        Integer astate = entity.getAstate();
        if (astate != null) {
            stmt.bindLong(27, astate);
        }
 
        Integer locked = entity.getLocked();
        if (locked != null) {
            stmt.bindLong(28, locked);
        }
 
        Integer posted = entity.getPosted();
        if (posted != null) {
            stmt.bindLong(29, posted);
        }
 
        Integer mark = entity.getMark();
        if (mark != null) {
            stmt.bindLong(30, mark);
        }
 
        String modi_by = entity.getModi_by();
        if (modi_by != null) {
            stmt.bindString(31, modi_by);
        }
 
        java.util.Date modi_date = entity.getModi_date();
        if (modi_date != null) {
            stmt.bindLong(32, modi_date.getTime());
        }
    }

    @Override
    protected void attachEntity(SrMaster entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public SrMaster readEntity(Cursor cursor, int offset) {
        SrMaster entity = new SrMaster( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // sr_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // sr_no
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // sr_date
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sm_no
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // cust_code
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // wh_code
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // slm_code
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // pay_type
            cursor.isNull(offset + 8) ? null : cursor.getFloat(offset + 8), // curr_code
            cursor.isNull(offset + 9) ? null : cursor.getFloat(offset + 9), // curr_val
            cursor.isNull(offset + 10) ? null : cursor.getFloat(offset + 10), // sr_totqty
            cursor.isNull(offset + 11) ? null : cursor.getFloat(offset + 11), // sr_subtotal
            cursor.isNull(offset + 12) ? null : cursor.getFloat(offset + 12), // sr_tottax
            cursor.isNull(offset + 13) ? null : cursor.getFloat(offset + 13), // sr_discval
            cursor.isNull(offset + 14) ? null : cursor.getFloat(offset + 14), // sr_disc1
            cursor.isNull(offset + 15) ? null : cursor.getFloat(offset + 15), // sr_disc2
            cursor.isNull(offset + 16) ? null : cursor.getFloat(offset + 16), // sr_disc3
            cursor.isNull(offset + 17) ? null : cursor.getFloat(offset + 17), // sr_shipcost
            cursor.isNull(offset + 18) ? null : cursor.getFloat(offset + 18), // sr_shipweight
            cursor.isNull(offset + 19) ? null : cursor.getFloat(offset + 19), // sr_othercost
            cursor.isNull(offset + 20) ? null : cursor.getFloat(offset + 20), // sr_total
            cursor.isNull(offset + 21) ? null : cursor.getFloat(offset + 21), // sr_totalgross
            cursor.isNull(offset + 22) ? null : cursor.getInt(offset + 22), // sr_proc
            cursor.isNull(offset + 23) ? null : cursor.getInt(offset + 23), // sr_inctax
            cursor.isNull(offset + 24) ? null : cursor.getInt(offset + 24), // allproc
            cursor.isNull(offset + 25) ? null : cursor.getInt(offset + 25), // src_code
            cursor.isNull(offset + 26) ? null : cursor.getInt(offset + 26), // astate
            cursor.isNull(offset + 27) ? null : cursor.getInt(offset + 27), // locked
            cursor.isNull(offset + 28) ? null : cursor.getInt(offset + 28), // posted
            cursor.isNull(offset + 29) ? null : cursor.getInt(offset + 29), // mark
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30), // modi_by
            cursor.isNull(offset + 31) ? null : new java.util.Date(cursor.getLong(offset + 31)) // modi_date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SrMaster entity, int offset) {
        entity.setSr_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setSr_no(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSr_date(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setSm_no(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCust_code(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setWh_code(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSlm_code(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setPay_type(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setCurr_code(cursor.isNull(offset + 8) ? null : cursor.getFloat(offset + 8));
        entity.setCurr_val(cursor.isNull(offset + 9) ? null : cursor.getFloat(offset + 9));
        entity.setSr_totqty(cursor.isNull(offset + 10) ? null : cursor.getFloat(offset + 10));
        entity.setSr_subtotal(cursor.isNull(offset + 11) ? null : cursor.getFloat(offset + 11));
        entity.setSr_tottax(cursor.isNull(offset + 12) ? null : cursor.getFloat(offset + 12));
        entity.setSr_discval(cursor.isNull(offset + 13) ? null : cursor.getFloat(offset + 13));
        entity.setSr_disc1(cursor.isNull(offset + 14) ? null : cursor.getFloat(offset + 14));
        entity.setSr_disc2(cursor.isNull(offset + 15) ? null : cursor.getFloat(offset + 15));
        entity.setSr_disc3(cursor.isNull(offset + 16) ? null : cursor.getFloat(offset + 16));
        entity.setSr_shipcost(cursor.isNull(offset + 17) ? null : cursor.getFloat(offset + 17));
        entity.setSr_shipweight(cursor.isNull(offset + 18) ? null : cursor.getFloat(offset + 18));
        entity.setSr_othercost(cursor.isNull(offset + 19) ? null : cursor.getFloat(offset + 19));
        entity.setSr_total(cursor.isNull(offset + 20) ? null : cursor.getFloat(offset + 20));
        entity.setSr_totalgross(cursor.isNull(offset + 21) ? null : cursor.getFloat(offset + 21));
        entity.setSr_proc(cursor.isNull(offset + 22) ? null : cursor.getInt(offset + 22));
        entity.setSr_inctax(cursor.isNull(offset + 23) ? null : cursor.getInt(offset + 23));
        entity.setAllproc(cursor.isNull(offset + 24) ? null : cursor.getInt(offset + 24));
        entity.setSrc_code(cursor.isNull(offset + 25) ? null : cursor.getInt(offset + 25));
        entity.setAstate(cursor.isNull(offset + 26) ? null : cursor.getInt(offset + 26));
        entity.setLocked(cursor.isNull(offset + 27) ? null : cursor.getInt(offset + 27));
        entity.setPosted(cursor.isNull(offset + 28) ? null : cursor.getInt(offset + 28));
        entity.setMark(cursor.isNull(offset + 29) ? null : cursor.getInt(offset + 29));
        entity.setModi_by(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
        entity.setModi_date(cursor.isNull(offset + 31) ? null : new java.util.Date(cursor.getLong(offset + 31)));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(SrMaster entity, long rowId) {
        return entity.getSr_id();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(SrMaster entity) {
        if(entity != null) {
            return entity.getSr_id();
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