package net.pointbridge.android.sales.db;

import java.util.List;
import net.pointbridge.android.sales.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table MOVE_MASTER.
 */
public class MoveMaster {

    private String mm_id;
    private String mm_no;
    private java.util.Date mm_date;
    private String mm_wh_code;
    private String src_brc_code;
    private String src_vend_code;
    private Float mm_totqty;
    private Float mm_totbuyprice;
    private Float mm_totsellprice;
    private String mv_code;
    private String tm_no;
    private Integer astate;
    private String src_code;
    private Integer allproc;
    private Integer locked;
    private Integer posted;
    private Integer mark;
    private String modi_by;
    private java.util.Date modi_date;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient MoveMasterDao myDao;

    private List<MoveDetail> mv_detail_fk1;
    private List<MoveSerial> mv_serial_fk1;

    public MoveMaster() {
    }

    public MoveMaster(String mm_id) {
        this.mm_id = mm_id;
    }

    public MoveMaster(String mm_id, String mm_no, java.util.Date mm_date, String mm_wh_code, String src_brc_code, String src_vend_code, Float mm_totqty, Float mm_totbuyprice, Float mm_totsellprice, String mv_code, String tm_no, Integer astate, String src_code, Integer allproc, Integer locked, Integer posted, Integer mark, String modi_by, java.util.Date modi_date) {
        this.mm_id = mm_id;
        this.mm_no = mm_no;
        this.mm_date = mm_date;
        this.mm_wh_code = mm_wh_code;
        this.src_brc_code = src_brc_code;
        this.src_vend_code = src_vend_code;
        this.mm_totqty = mm_totqty;
        this.mm_totbuyprice = mm_totbuyprice;
        this.mm_totsellprice = mm_totsellprice;
        this.mv_code = mv_code;
        this.tm_no = tm_no;
        this.astate = astate;
        this.src_code = src_code;
        this.allproc = allproc;
        this.locked = locked;
        this.posted = posted;
        this.mark = mark;
        this.modi_by = modi_by;
        this.modi_date = modi_date;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMoveMasterDao() : null;
    }

    public String getMm_id() {
        return mm_id;
    }

    public void setMm_id(String mm_id) {
        this.mm_id = mm_id;
    }

    public String getMm_no() {
        return mm_no;
    }

    public void setMm_no(String mm_no) {
        this.mm_no = mm_no;
    }

    public java.util.Date getMm_date() {
        return mm_date;
    }

    public void setMm_date(java.util.Date mm_date) {
        this.mm_date = mm_date;
    }

    public String getMm_wh_code() {
        return mm_wh_code;
    }

    public void setMm_wh_code(String mm_wh_code) {
        this.mm_wh_code = mm_wh_code;
    }

    public String getSrc_brc_code() {
        return src_brc_code;
    }

    public void setSrc_brc_code(String src_brc_code) {
        this.src_brc_code = src_brc_code;
    }

    public String getSrc_vend_code() {
        return src_vend_code;
    }

    public void setSrc_vend_code(String src_vend_code) {
        this.src_vend_code = src_vend_code;
    }

    public Float getMm_totqty() {
        return mm_totqty;
    }

    public void setMm_totqty(Float mm_totqty) {
        this.mm_totqty = mm_totqty;
    }

    public Float getMm_totbuyprice() {
        return mm_totbuyprice;
    }

    public void setMm_totbuyprice(Float mm_totbuyprice) {
        this.mm_totbuyprice = mm_totbuyprice;
    }

    public Float getMm_totsellprice() {
        return mm_totsellprice;
    }

    public void setMm_totsellprice(Float mm_totsellprice) {
        this.mm_totsellprice = mm_totsellprice;
    }

    public String getMv_code() {
        return mv_code;
    }

    public void setMv_code(String mv_code) {
        this.mv_code = mv_code;
    }

    public String getTm_no() {
        return tm_no;
    }

    public void setTm_no(String tm_no) {
        this.tm_no = tm_no;
    }

    public Integer getAstate() {
        return astate;
    }

    public void setAstate(Integer astate) {
        this.astate = astate;
    }

    public String getSrc_code() {
        return src_code;
    }

    public void setSrc_code(String src_code) {
        this.src_code = src_code;
    }

    public Integer getAllproc() {
        return allproc;
    }

    public void setAllproc(Integer allproc) {
        this.allproc = allproc;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer getPosted() {
        return posted;
    }

    public void setPosted(Integer posted) {
        this.posted = posted;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getModi_by() {
        return modi_by;
    }

    public void setModi_by(String modi_by) {
        this.modi_by = modi_by;
    }

    public java.util.Date getModi_date() {
        return modi_date;
    }

    public void setModi_date(java.util.Date modi_date) {
        this.modi_date = modi_date;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<MoveDetail> getMv_detail_fk1() {
        if (mv_detail_fk1 == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MoveDetailDao targetDao = daoSession.getMoveDetailDao();
            List<MoveDetail> mv_detail_fk1New = targetDao._queryMoveMaster_Mv_detail_fk1(mm_id);
            synchronized (this) {
                if(mv_detail_fk1 == null) {
                    mv_detail_fk1 = mv_detail_fk1New;
                }
            }
        }
        return mv_detail_fk1;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetMv_detail_fk1() {
        mv_detail_fk1 = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<MoveSerial> getMv_serial_fk1() {
        if (mv_serial_fk1 == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MoveSerialDao targetDao = daoSession.getMoveSerialDao();
            List<MoveSerial> mv_serial_fk1New = targetDao._queryMoveMaster_Mv_serial_fk1(mm_id);
            synchronized (this) {
                if(mv_serial_fk1 == null) {
                    mv_serial_fk1 = mv_serial_fk1New;
                }
            }
        }
        return mv_serial_fk1;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetMv_serial_fk1() {
        mv_serial_fk1 = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
