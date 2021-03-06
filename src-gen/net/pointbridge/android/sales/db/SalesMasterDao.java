package net.pointbridge.android.sales.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import net.pointbridge.android.sales.db.SalesMaster;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table SALES_MASTER.
*/
public class SalesMasterDao extends AbstractDao<SalesMaster, String> {

    public static final String TABLENAME = "SALES_MASTER";

    /**
     * Properties of entity SalesMaster.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Sm_id = new Property(0, String.class, "sm_id", true, "SM_ID");
        public final static Property Sm_date = new Property(1, java.util.Date.class, "sm_date", false, "SM_DATE");
        public final static Property Sm_no = new Property(2, String.class, "sm_no", false, "SM_NO");
        public final static Property Sm_invno = new Property(3, String.class, "sm_invno", false, "SM_INVNO");
        public final static Property Sm_type = new Property(4, Integer.class, "sm_type", false, "SM_TYPE");
        public final static Property Wh_code = new Property(5, String.class, "wh_code", false, "WH_CODE");
        public final static Property Cust_code = new Property(6, String.class, "cust_code", false, "CUST_CODE");
        public final static Property Slm_code = new Property(7, String.class, "slm_code", false, "SLM_CODE");
        public final static Property Rsl_code = new Property(8, String.class, "rsl_code", false, "RSL_CODE");
        public final static Property Ptm_code = new Property(9, String.class, "ptm_code", false, "PTM_CODE");
        public final static Property Pay_type = new Property(10, Integer.class, "pay_type", false, "PAY_TYPE");
        public final static Property Pay_status = new Property(11, Integer.class, "pay_status", false, "PAY_STATUS");
        public final static Property Curr_code = new Property(12, String.class, "curr_code", false, "CURR_CODE");
        public final static Property Curr_val = new Property(13, Float.class, "curr_val", false, "CURR_VAL");
        public final static Property Cs_code = new Property(14, String.class, "cs_code", false, "CS_CODE");
        public final static Property Sm_totpoint = new Property(15, Float.class, "sm_totpoint", false, "SM_TOTPOINT");
        public final static Property Sm_valgetpoint = new Property(16, Float.class, "sm_valgetpoint", false, "SM_VALGETPOINT");
        public final static Property Sm_subtotal = new Property(17, Float.class, "sm_subtotal", false, "SM_SUBTOTAL");
        public final static Property Sm_totqty = new Property(18, Float.class, "sm_totqty", false, "SM_TOTQTY");
        public final static Property Sm_tottax = new Property(19, Float.class, "sm_tottax", false, "SM_TOTTAX");
        public final static Property Sm_discval = new Property(20, Float.class, "sm_discval", false, "SM_DISCVAL");
        public final static Property Sm_disc1 = new Property(21, Float.class, "sm_disc1", false, "SM_DISC1");
        public final static Property Sm_disc2 = new Property(22, Float.class, "sm_disc2", false, "SM_DISC2");
        public final static Property Sm_disc3 = new Property(23, Float.class, "sm_disc3", false, "SM_DISC3");
        public final static Property Sm_shipcost = new Property(24, Float.class, "sm_shipcost", false, "SM_SHIPCOST");
        public final static Property Sm_shipweight = new Property(25, Float.class, "sm_shipweight", false, "SM_SHIPWEIGHT");
        public final static Property Sm_othercost = new Property(26, Float.class, "sm_othercost", false, "SM_OTHERCOST");
        public final static Property Sm_total = new Property(27, Float.class, "sm_total", false, "SM_TOTAL");
        public final static Property Sm_return = new Property(28, Float.class, "sm_return", false, "SM_RETURN");
        public final static Property Sm_paid_cash = new Property(29, Float.class, "sm_paid_cash", false, "SM_PAID_CASH");
        public final static Property Sm_paid_voucher = new Property(30, Float.class, "sm_paid_voucher", false, "SM_PAID_VOUCHER");
        public final static Property Sm_paid_voucherno = new Property(31, String.class, "sm_paid_voucherno", false, "SM_PAID_VOUCHERNO");
        public final static Property Sm_paid_card = new Property(32, Float.class, "sm_paid_card", false, "SM_PAID_CARD");
        public final static Property Sm_paid_cardno = new Property(33, String.class, "sm_paid_cardno", false, "SM_PAID_CARDNO");
        public final static Property Sm_paid_cardtype = new Property(34, String.class, "sm_paid_cardtype", false, "SM_PAID_CARDTYPE");
        public final static Property Sm_paid_cardissuer = new Property(35, String.class, "sm_paid_cardissuer", false, "SM_PAID_CARDISSUER");
        public final static Property Sm_paid_cardholder = new Property(36, String.class, "sm_paid_cardholder", false, "SM_PAID_CARDHOLDER");
        public final static Property Sm_paid_cardfee = new Property(37, Float.class, "sm_paid_cardfee", false, "SM_PAID_CARDFEE");
        public final static Property Sm_paid_dcard = new Property(38, Float.class, "sm_paid_dcard", false, "SM_PAID_DCARD");
        public final static Property Sm_paid_dcardno = new Property(39, String.class, "sm_paid_dcardno", false, "SM_PAID_DCARDNO");
        public final static Property Sm_paid_dcardtype = new Property(40, String.class, "sm_paid_dcardtype", false, "SM_PAID_DCARDTYPE");
        public final static Property Sm_paid_dcardissuer = new Property(41, String.class, "sm_paid_dcardissuer", false, "SM_PAID_DCARDISSUER");
        public final static Property Sm_paid_dcardholder = new Property(42, String.class, "sm_paid_dcardholder", false, "SM_PAID_DCARDHOLDER");
        public final static Property Sm_totaldiscount = new Property(43, Float.class, "sm_totaldiscount", false, "SM_TOTALDISCOUNT");
        public final static Property Sm_pending = new Property(44, Integer.class, "sm_pending", false, "SM_PENDING");
        public final static Property Sm_totalgross = new Property(45, Float.class, "sm_totalgross", false, "SM_TOTALGROSS");
        public final static Property Sm_inctax = new Property(46, Integer.class, "sm_inctax", false, "SM_INCTAX");
        public final static Property Sm_get_voucherno = new Property(47, String.class, "sm_get_voucherno", false, "SM_GET_VOUCHERNO");
        public final static Property Sm_get_vouchervalue = new Property(48, Float.class, "sm_get_vouchervalue", false, "SM_GET_VOUCHERVALUE");
        public final static Property Astate = new Property(49, Integer.class, "astate", false, "ASTATE");
        public final static Property Locked = new Property(50, Integer.class, "locked", false, "LOCKED");
        public final static Property Posted = new Property(51, Integer.class, "posted", false, "POSTED");
        public final static Property Proc = new Property(52, Integer.class, "proc", false, "PROC");
        public final static Property Src_code = new Property(53, String.class, "src_code", false, "SRC_CODE");
        public final static Property Mark = new Property(54, Integer.class, "mark", false, "MARK");
        public final static Property Modi_by = new Property(55, String.class, "modi_by", false, "MODI_BY");
        public final static Property Modi_date = new Property(56, java.util.Date.class, "modi_date", false, "MODI_DATE");
    };

    private DaoSession daoSession;


    public SalesMasterDao(DaoConfig config) {
        super(config);
    }
    
    public SalesMasterDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'SALES_MASTER' (" + //
                "'SM_ID' TEXT PRIMARY KEY ASC NOT NULL ," + // 0: sm_id
                "'SM_DATE' INTEGER," + // 1: sm_date
                "'SM_NO' TEXT," + // 2: sm_no
                "'SM_INVNO' TEXT," + // 3: sm_invno
                "'SM_TYPE' INTEGER," + // 4: sm_type
                "'WH_CODE' TEXT," + // 5: wh_code
                "'CUST_CODE' TEXT," + // 6: cust_code
                "'SLM_CODE' TEXT," + // 7: slm_code
                "'RSL_CODE' TEXT," + // 8: rsl_code
                "'PTM_CODE' TEXT," + // 9: ptm_code
                "'PAY_TYPE' INTEGER," + // 10: pay_type
                "'PAY_STATUS' INTEGER," + // 11: pay_status
                "'CURR_CODE' TEXT," + // 12: curr_code
                "'CURR_VAL' REAL," + // 13: curr_val
                "'CS_CODE' TEXT," + // 14: cs_code
                "'SM_TOTPOINT' REAL," + // 15: sm_totpoint
                "'SM_VALGETPOINT' REAL," + // 16: sm_valgetpoint
                "'SM_SUBTOTAL' REAL," + // 17: sm_subtotal
                "'SM_TOTQTY' REAL," + // 18: sm_totqty
                "'SM_TOTTAX' REAL," + // 19: sm_tottax
                "'SM_DISCVAL' REAL," + // 20: sm_discval
                "'SM_DISC1' REAL," + // 21: sm_disc1
                "'SM_DISC2' REAL," + // 22: sm_disc2
                "'SM_DISC3' REAL," + // 23: sm_disc3
                "'SM_SHIPCOST' REAL," + // 24: sm_shipcost
                "'SM_SHIPWEIGHT' REAL," + // 25: sm_shipweight
                "'SM_OTHERCOST' REAL," + // 26: sm_othercost
                "'SM_TOTAL' REAL," + // 27: sm_total
                "'SM_RETURN' REAL," + // 28: sm_return
                "'SM_PAID_CASH' REAL," + // 29: sm_paid_cash
                "'SM_PAID_VOUCHER' REAL," + // 30: sm_paid_voucher
                "'SM_PAID_VOUCHERNO' TEXT," + // 31: sm_paid_voucherno
                "'SM_PAID_CARD' REAL," + // 32: sm_paid_card
                "'SM_PAID_CARDNO' TEXT," + // 33: sm_paid_cardno
                "'SM_PAID_CARDTYPE' TEXT," + // 34: sm_paid_cardtype
                "'SM_PAID_CARDISSUER' TEXT," + // 35: sm_paid_cardissuer
                "'SM_PAID_CARDHOLDER' TEXT," + // 36: sm_paid_cardholder
                "'SM_PAID_CARDFEE' REAL," + // 37: sm_paid_cardfee
                "'SM_PAID_DCARD' REAL," + // 38: sm_paid_dcard
                "'SM_PAID_DCARDNO' TEXT," + // 39: sm_paid_dcardno
                "'SM_PAID_DCARDTYPE' TEXT," + // 40: sm_paid_dcardtype
                "'SM_PAID_DCARDISSUER' TEXT," + // 41: sm_paid_dcardissuer
                "'SM_PAID_DCARDHOLDER' TEXT," + // 42: sm_paid_dcardholder
                "'SM_TOTALDISCOUNT' REAL," + // 43: sm_totaldiscount
                "'SM_PENDING' INTEGER," + // 44: sm_pending
                "'SM_TOTALGROSS' REAL," + // 45: sm_totalgross
                "'SM_INCTAX' INTEGER," + // 46: sm_inctax
                "'SM_GET_VOUCHERNO' TEXT," + // 47: sm_get_voucherno
                "'SM_GET_VOUCHERVALUE' REAL," + // 48: sm_get_vouchervalue
                "'ASTATE' INTEGER," + // 49: astate
                "'LOCKED' INTEGER," + // 50: locked
                "'POSTED' INTEGER," + // 51: posted
                "'PROC' INTEGER," + // 52: proc
                "'SRC_CODE' TEXT," + // 53: src_code
                "'MARK' INTEGER," + // 54: mark
                "'MODI_BY' TEXT," + // 55: modi_by
                "'MODI_DATE' INTEGER);"); // 56: modi_date
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_SALES_MASTER_SM_NO ON SALES_MASTER" +
                " (SM_NO);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_SALES_MASTER_SM_INVNO ON SALES_MASTER" +
                " (SM_INVNO);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SALES_MASTER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SalesMaster entity) {
        stmt.clearBindings();
 
        String sm_id = entity.getSm_id();
        if (sm_id != null) {
            stmt.bindString(1, sm_id);
        }
 
        java.util.Date sm_date = entity.getSm_date();
        if (sm_date != null) {
            stmt.bindLong(2, sm_date.getTime());
        }
 
        String sm_no = entity.getSm_no();
        if (sm_no != null) {
            stmt.bindString(3, sm_no);
        }
 
        String sm_invno = entity.getSm_invno();
        if (sm_invno != null) {
            stmt.bindString(4, sm_invno);
        }
 
        Integer sm_type = entity.getSm_type();
        if (sm_type != null) {
            stmt.bindLong(5, sm_type);
        }
 
        String wh_code = entity.getWh_code();
        if (wh_code != null) {
            stmt.bindString(6, wh_code);
        }
 
        String cust_code = entity.getCust_code();
        if (cust_code != null) {
            stmt.bindString(7, cust_code);
        }
 
        String slm_code = entity.getSlm_code();
        if (slm_code != null) {
            stmt.bindString(8, slm_code);
        }
 
        String rsl_code = entity.getRsl_code();
        if (rsl_code != null) {
            stmt.bindString(9, rsl_code);
        }
 
        String ptm_code = entity.getPtm_code();
        if (ptm_code != null) {
            stmt.bindString(10, ptm_code);
        }
 
        Integer pay_type = entity.getPay_type();
        if (pay_type != null) {
            stmt.bindLong(11, pay_type);
        }
 
        Integer pay_status = entity.getPay_status();
        if (pay_status != null) {
            stmt.bindLong(12, pay_status);
        }
 
        String curr_code = entity.getCurr_code();
        if (curr_code != null) {
            stmt.bindString(13, curr_code);
        }
 
        Float curr_val = entity.getCurr_val();
        if (curr_val != null) {
            stmt.bindDouble(14, curr_val);
        }
 
        String cs_code = entity.getCs_code();
        if (cs_code != null) {
            stmt.bindString(15, cs_code);
        }
 
        Float sm_totpoint = entity.getSm_totpoint();
        if (sm_totpoint != null) {
            stmt.bindDouble(16, sm_totpoint);
        }
 
        Float sm_valgetpoint = entity.getSm_valgetpoint();
        if (sm_valgetpoint != null) {
            stmt.bindDouble(17, sm_valgetpoint);
        }
 
        Float sm_subtotal = entity.getSm_subtotal();
        if (sm_subtotal != null) {
            stmt.bindDouble(18, sm_subtotal);
        }
 
        Float sm_totqty = entity.getSm_totqty();
        if (sm_totqty != null) {
            stmt.bindDouble(19, sm_totqty);
        }
 
        Float sm_tottax = entity.getSm_tottax();
        if (sm_tottax != null) {
            stmt.bindDouble(20, sm_tottax);
        }
 
        Float sm_discval = entity.getSm_discval();
        if (sm_discval != null) {
            stmt.bindDouble(21, sm_discval);
        }
 
        Float sm_disc1 = entity.getSm_disc1();
        if (sm_disc1 != null) {
            stmt.bindDouble(22, sm_disc1);
        }
 
        Float sm_disc2 = entity.getSm_disc2();
        if (sm_disc2 != null) {
            stmt.bindDouble(23, sm_disc2);
        }
 
        Float sm_disc3 = entity.getSm_disc3();
        if (sm_disc3 != null) {
            stmt.bindDouble(24, sm_disc3);
        }
 
        Float sm_shipcost = entity.getSm_shipcost();
        if (sm_shipcost != null) {
            stmt.bindDouble(25, sm_shipcost);
        }
 
        Float sm_shipweight = entity.getSm_shipweight();
        if (sm_shipweight != null) {
            stmt.bindDouble(26, sm_shipweight);
        }
 
        Float sm_othercost = entity.getSm_othercost();
        if (sm_othercost != null) {
            stmt.bindDouble(27, sm_othercost);
        }
 
        Float sm_total = entity.getSm_total();
        if (sm_total != null) {
            stmt.bindDouble(28, sm_total);
        }
 
        Float sm_return = entity.getSm_return();
        if (sm_return != null) {
            stmt.bindDouble(29, sm_return);
        }
 
        Float sm_paid_cash = entity.getSm_paid_cash();
        if (sm_paid_cash != null) {
            stmt.bindDouble(30, sm_paid_cash);
        }
 
        Float sm_paid_voucher = entity.getSm_paid_voucher();
        if (sm_paid_voucher != null) {
            stmt.bindDouble(31, sm_paid_voucher);
        }
 
        String sm_paid_voucherno = entity.getSm_paid_voucherno();
        if (sm_paid_voucherno != null) {
            stmt.bindString(32, sm_paid_voucherno);
        }
 
        Float sm_paid_card = entity.getSm_paid_card();
        if (sm_paid_card != null) {
            stmt.bindDouble(33, sm_paid_card);
        }
 
        String sm_paid_cardno = entity.getSm_paid_cardno();
        if (sm_paid_cardno != null) {
            stmt.bindString(34, sm_paid_cardno);
        }
 
        String sm_paid_cardtype = entity.getSm_paid_cardtype();
        if (sm_paid_cardtype != null) {
            stmt.bindString(35, sm_paid_cardtype);
        }
 
        String sm_paid_cardissuer = entity.getSm_paid_cardissuer();
        if (sm_paid_cardissuer != null) {
            stmt.bindString(36, sm_paid_cardissuer);
        }
 
        String sm_paid_cardholder = entity.getSm_paid_cardholder();
        if (sm_paid_cardholder != null) {
            stmt.bindString(37, sm_paid_cardholder);
        }
 
        Float sm_paid_cardfee = entity.getSm_paid_cardfee();
        if (sm_paid_cardfee != null) {
            stmt.bindDouble(38, sm_paid_cardfee);
        }
 
        Float sm_paid_dcard = entity.getSm_paid_dcard();
        if (sm_paid_dcard != null) {
            stmt.bindDouble(39, sm_paid_dcard);
        }
 
        String sm_paid_dcardno = entity.getSm_paid_dcardno();
        if (sm_paid_dcardno != null) {
            stmt.bindString(40, sm_paid_dcardno);
        }
 
        String sm_paid_dcardtype = entity.getSm_paid_dcardtype();
        if (sm_paid_dcardtype != null) {
            stmt.bindString(41, sm_paid_dcardtype);
        }
 
        String sm_paid_dcardissuer = entity.getSm_paid_dcardissuer();
        if (sm_paid_dcardissuer != null) {
            stmt.bindString(42, sm_paid_dcardissuer);
        }
 
        String sm_paid_dcardholder = entity.getSm_paid_dcardholder();
        if (sm_paid_dcardholder != null) {
            stmt.bindString(43, sm_paid_dcardholder);
        }
 
        Float sm_totaldiscount = entity.getSm_totaldiscount();
        if (sm_totaldiscount != null) {
            stmt.bindDouble(44, sm_totaldiscount);
        }
 
        Integer sm_pending = entity.getSm_pending();
        if (sm_pending != null) {
            stmt.bindLong(45, sm_pending);
        }
 
        Float sm_totalgross = entity.getSm_totalgross();
        if (sm_totalgross != null) {
            stmt.bindDouble(46, sm_totalgross);
        }
 
        Integer sm_inctax = entity.getSm_inctax();
        if (sm_inctax != null) {
            stmt.bindLong(47, sm_inctax);
        }
 
        String sm_get_voucherno = entity.getSm_get_voucherno();
        if (sm_get_voucherno != null) {
            stmt.bindString(48, sm_get_voucherno);
        }
 
        Float sm_get_vouchervalue = entity.getSm_get_vouchervalue();
        if (sm_get_vouchervalue != null) {
            stmt.bindDouble(49, sm_get_vouchervalue);
        }
 
        Integer astate = entity.getAstate();
        if (astate != null) {
            stmt.bindLong(50, astate);
        }
 
        Integer locked = entity.getLocked();
        if (locked != null) {
            stmt.bindLong(51, locked);
        }
 
        Integer posted = entity.getPosted();
        if (posted != null) {
            stmt.bindLong(52, posted);
        }
 
        Integer proc = entity.getProc();
        if (proc != null) {
            stmt.bindLong(53, proc);
        }
 
        String src_code = entity.getSrc_code();
        if (src_code != null) {
            stmt.bindString(54, src_code);
        }
 
        Integer mark = entity.getMark();
        if (mark != null) {
            stmt.bindLong(55, mark);
        }
 
        String modi_by = entity.getModi_by();
        if (modi_by != null) {
            stmt.bindString(56, modi_by);
        }
 
        java.util.Date modi_date = entity.getModi_date();
        if (modi_date != null) {
            stmt.bindLong(57, modi_date.getTime());
        }
    }

    @Override
    protected void attachEntity(SalesMaster entity) {
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
    public SalesMaster readEntity(Cursor cursor, int offset) {
        SalesMaster entity = new SalesMaster( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // sm_id
            cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)), // sm_date
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // sm_no
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sm_invno
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // sm_type
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // wh_code
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // cust_code
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // slm_code
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // rsl_code
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // ptm_code
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // pay_type
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // pay_status
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // curr_code
            cursor.isNull(offset + 13) ? null : cursor.getFloat(offset + 13), // curr_val
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // cs_code
            cursor.isNull(offset + 15) ? null : cursor.getFloat(offset + 15), // sm_totpoint
            cursor.isNull(offset + 16) ? null : cursor.getFloat(offset + 16), // sm_valgetpoint
            cursor.isNull(offset + 17) ? null : cursor.getFloat(offset + 17), // sm_subtotal
            cursor.isNull(offset + 18) ? null : cursor.getFloat(offset + 18), // sm_totqty
            cursor.isNull(offset + 19) ? null : cursor.getFloat(offset + 19), // sm_tottax
            cursor.isNull(offset + 20) ? null : cursor.getFloat(offset + 20), // sm_discval
            cursor.isNull(offset + 21) ? null : cursor.getFloat(offset + 21), // sm_disc1
            cursor.isNull(offset + 22) ? null : cursor.getFloat(offset + 22), // sm_disc2
            cursor.isNull(offset + 23) ? null : cursor.getFloat(offset + 23), // sm_disc3
            cursor.isNull(offset + 24) ? null : cursor.getFloat(offset + 24), // sm_shipcost
            cursor.isNull(offset + 25) ? null : cursor.getFloat(offset + 25), // sm_shipweight
            cursor.isNull(offset + 26) ? null : cursor.getFloat(offset + 26), // sm_othercost
            cursor.isNull(offset + 27) ? null : cursor.getFloat(offset + 27), // sm_total
            cursor.isNull(offset + 28) ? null : cursor.getFloat(offset + 28), // sm_return
            cursor.isNull(offset + 29) ? null : cursor.getFloat(offset + 29), // sm_paid_cash
            cursor.isNull(offset + 30) ? null : cursor.getFloat(offset + 30), // sm_paid_voucher
            cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31), // sm_paid_voucherno
            cursor.isNull(offset + 32) ? null : cursor.getFloat(offset + 32), // sm_paid_card
            cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33), // sm_paid_cardno
            cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34), // sm_paid_cardtype
            cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35), // sm_paid_cardissuer
            cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36), // sm_paid_cardholder
            cursor.isNull(offset + 37) ? null : cursor.getFloat(offset + 37), // sm_paid_cardfee
            cursor.isNull(offset + 38) ? null : cursor.getFloat(offset + 38), // sm_paid_dcard
            cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39), // sm_paid_dcardno
            cursor.isNull(offset + 40) ? null : cursor.getString(offset + 40), // sm_paid_dcardtype
            cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41), // sm_paid_dcardissuer
            cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42), // sm_paid_dcardholder
            cursor.isNull(offset + 43) ? null : cursor.getFloat(offset + 43), // sm_totaldiscount
            cursor.isNull(offset + 44) ? null : cursor.getInt(offset + 44), // sm_pending
            cursor.isNull(offset + 45) ? null : cursor.getFloat(offset + 45), // sm_totalgross
            cursor.isNull(offset + 46) ? null : cursor.getInt(offset + 46), // sm_inctax
            cursor.isNull(offset + 47) ? null : cursor.getString(offset + 47), // sm_get_voucherno
            cursor.isNull(offset + 48) ? null : cursor.getFloat(offset + 48), // sm_get_vouchervalue
            cursor.isNull(offset + 49) ? null : cursor.getInt(offset + 49), // astate
            cursor.isNull(offset + 50) ? null : cursor.getInt(offset + 50), // locked
            cursor.isNull(offset + 51) ? null : cursor.getInt(offset + 51), // posted
            cursor.isNull(offset + 52) ? null : cursor.getInt(offset + 52), // proc
            cursor.isNull(offset + 53) ? null : cursor.getString(offset + 53), // src_code
            cursor.isNull(offset + 54) ? null : cursor.getInt(offset + 54), // mark
            cursor.isNull(offset + 55) ? null : cursor.getString(offset + 55), // modi_by
            cursor.isNull(offset + 56) ? null : new java.util.Date(cursor.getLong(offset + 56)) // modi_date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SalesMaster entity, int offset) {
        entity.setSm_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setSm_date(cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)));
        entity.setSm_no(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSm_invno(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSm_type(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setWh_code(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setCust_code(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSlm_code(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setRsl_code(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPtm_code(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPay_type(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setPay_status(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        entity.setCurr_code(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setCurr_val(cursor.isNull(offset + 13) ? null : cursor.getFloat(offset + 13));
        entity.setCs_code(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setSm_totpoint(cursor.isNull(offset + 15) ? null : cursor.getFloat(offset + 15));
        entity.setSm_valgetpoint(cursor.isNull(offset + 16) ? null : cursor.getFloat(offset + 16));
        entity.setSm_subtotal(cursor.isNull(offset + 17) ? null : cursor.getFloat(offset + 17));
        entity.setSm_totqty(cursor.isNull(offset + 18) ? null : cursor.getFloat(offset + 18));
        entity.setSm_tottax(cursor.isNull(offset + 19) ? null : cursor.getFloat(offset + 19));
        entity.setSm_discval(cursor.isNull(offset + 20) ? null : cursor.getFloat(offset + 20));
        entity.setSm_disc1(cursor.isNull(offset + 21) ? null : cursor.getFloat(offset + 21));
        entity.setSm_disc2(cursor.isNull(offset + 22) ? null : cursor.getFloat(offset + 22));
        entity.setSm_disc3(cursor.isNull(offset + 23) ? null : cursor.getFloat(offset + 23));
        entity.setSm_shipcost(cursor.isNull(offset + 24) ? null : cursor.getFloat(offset + 24));
        entity.setSm_shipweight(cursor.isNull(offset + 25) ? null : cursor.getFloat(offset + 25));
        entity.setSm_othercost(cursor.isNull(offset + 26) ? null : cursor.getFloat(offset + 26));
        entity.setSm_total(cursor.isNull(offset + 27) ? null : cursor.getFloat(offset + 27));
        entity.setSm_return(cursor.isNull(offset + 28) ? null : cursor.getFloat(offset + 28));
        entity.setSm_paid_cash(cursor.isNull(offset + 29) ? null : cursor.getFloat(offset + 29));
        entity.setSm_paid_voucher(cursor.isNull(offset + 30) ? null : cursor.getFloat(offset + 30));
        entity.setSm_paid_voucherno(cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31));
        entity.setSm_paid_card(cursor.isNull(offset + 32) ? null : cursor.getFloat(offset + 32));
        entity.setSm_paid_cardno(cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33));
        entity.setSm_paid_cardtype(cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34));
        entity.setSm_paid_cardissuer(cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35));
        entity.setSm_paid_cardholder(cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36));
        entity.setSm_paid_cardfee(cursor.isNull(offset + 37) ? null : cursor.getFloat(offset + 37));
        entity.setSm_paid_dcard(cursor.isNull(offset + 38) ? null : cursor.getFloat(offset + 38));
        entity.setSm_paid_dcardno(cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39));
        entity.setSm_paid_dcardtype(cursor.isNull(offset + 40) ? null : cursor.getString(offset + 40));
        entity.setSm_paid_dcardissuer(cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41));
        entity.setSm_paid_dcardholder(cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42));
        entity.setSm_totaldiscount(cursor.isNull(offset + 43) ? null : cursor.getFloat(offset + 43));
        entity.setSm_pending(cursor.isNull(offset + 44) ? null : cursor.getInt(offset + 44));
        entity.setSm_totalgross(cursor.isNull(offset + 45) ? null : cursor.getFloat(offset + 45));
        entity.setSm_inctax(cursor.isNull(offset + 46) ? null : cursor.getInt(offset + 46));
        entity.setSm_get_voucherno(cursor.isNull(offset + 47) ? null : cursor.getString(offset + 47));
        entity.setSm_get_vouchervalue(cursor.isNull(offset + 48) ? null : cursor.getFloat(offset + 48));
        entity.setAstate(cursor.isNull(offset + 49) ? null : cursor.getInt(offset + 49));
        entity.setLocked(cursor.isNull(offset + 50) ? null : cursor.getInt(offset + 50));
        entity.setPosted(cursor.isNull(offset + 51) ? null : cursor.getInt(offset + 51));
        entity.setProc(cursor.isNull(offset + 52) ? null : cursor.getInt(offset + 52));
        entity.setSrc_code(cursor.isNull(offset + 53) ? null : cursor.getString(offset + 53));
        entity.setMark(cursor.isNull(offset + 54) ? null : cursor.getInt(offset + 54));
        entity.setModi_by(cursor.isNull(offset + 55) ? null : cursor.getString(offset + 55));
        entity.setModi_date(cursor.isNull(offset + 56) ? null : new java.util.Date(cursor.getLong(offset + 56)));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(SalesMaster entity, long rowId) {
        return entity.getSm_id();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(SalesMaster entity) {
        if(entity != null) {
            return entity.getSm_id();
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
