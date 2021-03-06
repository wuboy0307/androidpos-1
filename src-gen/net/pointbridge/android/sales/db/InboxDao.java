package net.pointbridge.android.sales.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import net.pointbridge.android.sales.db.Inbox;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table INBOX.
*/
public class InboxDao extends AbstractDao<Inbox, Long> {

    public static final String TABLENAME = "INBOX";

    /**
     * Properties of entity Inbox.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Ibx_id = new Property(0, Long.class, "ibx_id", true, "IBX_ID");
        public final static Property Ibx_cat = new Property(1, Integer.class, "ibx_cat", false, "IBX_CAT");
        public final static Property Ibx_sbj = new Property(2, String.class, "ibx_sbj", false, "IBX_SBJ");
        public final static Property Ibx_from = new Property(3, String.class, "ibx_from", false, "IBX_FROM");
        public final static Property Ibx_to = new Property(4, String.class, "ibx_to", false, "IBX_TO");
        public final static Property Ibx_date = new Property(5, java.util.Date.class, "ibx_date", false, "IBX_DATE");
        public final static Property Ibx_cnt = new Property(6, String.class, "ibx_cnt", false, "IBX_CNT");
        public final static Property Ibx_mark = new Property(7, Integer.class, "ibx_mark", false, "IBX_MARK");
        public final static Property Src_code = new Property(8, String.class, "src_code", false, "SRC_CODE");
        public final static Property Ori_code = new Property(9, String.class, "ori_code", false, "ORI_CODE");
        public final static Property Modi_by = new Property(10, String.class, "modi_by", false, "MODI_BY");
        public final static Property Mark = new Property(11, Integer.class, "mark", false, "MARK");
        public final static Property Modi_date = new Property(12, java.util.Date.class, "modi_date", false, "MODI_DATE");
    };


    public InboxDao(DaoConfig config) {
        super(config);
    }
    
    public InboxDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'INBOX' (" + //
                "'IBX_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: ibx_id
                "'IBX_CAT' INTEGER," + // 1: ibx_cat
                "'IBX_SBJ' TEXT," + // 2: ibx_sbj
                "'IBX_FROM' TEXT," + // 3: ibx_from
                "'IBX_TO' TEXT," + // 4: ibx_to
                "'IBX_DATE' INTEGER," + // 5: ibx_date
                "'IBX_CNT' TEXT," + // 6: ibx_cnt
                "'IBX_MARK' INTEGER," + // 7: ibx_mark
                "'SRC_CODE' TEXT," + // 8: src_code
                "'ORI_CODE' TEXT," + // 9: ori_code
                "'MODI_BY' TEXT," + // 10: modi_by
                "'MARK' INTEGER," + // 11: mark
                "'MODI_DATE' INTEGER);"); // 12: modi_date
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_INBOX_IBX_CAT ON INBOX" +
                " (IBX_CAT);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_INBOX_IBX_FROM ON INBOX" +
                " (IBX_FROM);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_INBOX_IBX_TO ON INBOX" +
                " (IBX_TO);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'INBOX'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Inbox entity) {
        stmt.clearBindings();
 
        Long ibx_id = entity.getIbx_id();
        if (ibx_id != null) {
            stmt.bindLong(1, ibx_id);
        }
 
        Integer ibx_cat = entity.getIbx_cat();
        if (ibx_cat != null) {
            stmt.bindLong(2, ibx_cat);
        }
 
        String ibx_sbj = entity.getIbx_sbj();
        if (ibx_sbj != null) {
            stmt.bindString(3, ibx_sbj);
        }
 
        String ibx_from = entity.getIbx_from();
        if (ibx_from != null) {
            stmt.bindString(4, ibx_from);
        }
 
        String ibx_to = entity.getIbx_to();
        if (ibx_to != null) {
            stmt.bindString(5, ibx_to);
        }
 
        java.util.Date ibx_date = entity.getIbx_date();
        if (ibx_date != null) {
            stmt.bindLong(6, ibx_date.getTime());
        }
 
        String ibx_cnt = entity.getIbx_cnt();
        if (ibx_cnt != null) {
            stmt.bindString(7, ibx_cnt);
        }
 
        Integer ibx_mark = entity.getIbx_mark();
        if (ibx_mark != null) {
            stmt.bindLong(8, ibx_mark);
        }
 
        String src_code = entity.getSrc_code();
        if (src_code != null) {
            stmt.bindString(9, src_code);
        }
 
        String ori_code = entity.getOri_code();
        if (ori_code != null) {
            stmt.bindString(10, ori_code);
        }
 
        String modi_by = entity.getModi_by();
        if (modi_by != null) {
            stmt.bindString(11, modi_by);
        }
 
        Integer mark = entity.getMark();
        if (mark != null) {
            stmt.bindLong(12, mark);
        }
 
        java.util.Date modi_date = entity.getModi_date();
        if (modi_date != null) {
            stmt.bindLong(13, modi_date.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Inbox readEntity(Cursor cursor, int offset) {
        Inbox entity = new Inbox( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // ibx_id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // ibx_cat
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // ibx_sbj
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // ibx_from
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // ibx_to
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)), // ibx_date
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // ibx_cnt
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // ibx_mark
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // src_code
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // ori_code
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // modi_by
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // mark
            cursor.isNull(offset + 12) ? null : new java.util.Date(cursor.getLong(offset + 12)) // modi_date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Inbox entity, int offset) {
        entity.setIbx_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIbx_cat(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setIbx_sbj(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIbx_from(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setIbx_to(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIbx_date(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
        entity.setIbx_cnt(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setIbx_mark(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setSrc_code(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setOri_code(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setModi_by(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setMark(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        entity.setModi_date(cursor.isNull(offset + 12) ? null : new java.util.Date(cursor.getLong(offset + 12)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Inbox entity, long rowId) {
        entity.setIbx_id(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Inbox entity) {
        if(entity != null) {
            return entity.getIbx_id();
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
