package net.pointbridge.android.sales.db;

import java.util.List;
import net.pointbridge.android.sales.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table ITEM.
 */
public class Item {

    private String itm_id;
    private String itm_code;
    private String itm_name;
    private String itm_shortname;
    private String itm_unit;
    private Integer itm_type;
    private Integer itm_source;
    private Integer itm_status;
    private Integer itm_slstax;
    private Integer itm_csg;
    private Float itm_min;
    private String grp_code;
    private String sgrp_code;
    private String vend_code;
    private String src_code;
    private Integer itm_serial;
    private Integer mark;
    private String modi_by;
    private java.util.Date modi_date;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ItemDao myDao;

    private List<ItemSerial> item_serial_fk1;
    private List<ItemUnit> item_unit_fk1;
    private List<ItemBarcode> item_barcode_fk1;
    private List<ItemPrice> item_price_fk1;

    public Item() {
    }

    public Item(String itm_code) {
        this.itm_code = itm_code;
    }

    public Item(String itm_id, String itm_code, String itm_name, String itm_shortname, String itm_unit, Integer itm_type, Integer itm_source, Integer itm_status, Integer itm_slstax, Integer itm_csg, Float itm_min, String grp_code, String sgrp_code, String vend_code, String src_code, Integer itm_serial, Integer mark, String modi_by, java.util.Date modi_date) {
        this.itm_id = itm_id;
        this.itm_code = itm_code;
        this.itm_name = itm_name;
        this.itm_shortname = itm_shortname;
        this.itm_unit = itm_unit;
        this.itm_type = itm_type;
        this.itm_source = itm_source;
        this.itm_status = itm_status;
        this.itm_slstax = itm_slstax;
        this.itm_csg = itm_csg;
        this.itm_min = itm_min;
        this.grp_code = grp_code;
        this.sgrp_code = sgrp_code;
        this.vend_code = vend_code;
        this.src_code = src_code;
        this.itm_serial = itm_serial;
        this.mark = mark;
        this.modi_by = modi_by;
        this.modi_date = modi_date;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getItemDao() : null;
    }

    public String getItm_id() {
        return itm_id;
    }

    public void setItm_id(String itm_id) {
        this.itm_id = itm_id;
    }

    public String getItm_code() {
        return itm_code;
    }

    public void setItm_code(String itm_code) {
        this.itm_code = itm_code;
    }

    public String getItm_name() {
        return itm_name;
    }

    public void setItm_name(String itm_name) {
        this.itm_name = itm_name;
    }

    public String getItm_shortname() {
        return itm_shortname;
    }

    public void setItm_shortname(String itm_shortname) {
        this.itm_shortname = itm_shortname;
    }

    public String getItm_unit() {
        return itm_unit;
    }

    public void setItm_unit(String itm_unit) {
        this.itm_unit = itm_unit;
    }

    public Integer getItm_type() {
        return itm_type;
    }

    public void setItm_type(Integer itm_type) {
        this.itm_type = itm_type;
    }

    public Integer getItm_source() {
        return itm_source;
    }

    public void setItm_source(Integer itm_source) {
        this.itm_source = itm_source;
    }

    public Integer getItm_status() {
        return itm_status;
    }

    public void setItm_status(Integer itm_status) {
        this.itm_status = itm_status;
    }

    public Integer getItm_slstax() {
        return itm_slstax;
    }

    public void setItm_slstax(Integer itm_slstax) {
        this.itm_slstax = itm_slstax;
    }

    public Integer getItm_csg() {
        return itm_csg;
    }

    public void setItm_csg(Integer itm_csg) {
        this.itm_csg = itm_csg;
    }

    public Float getItm_min() {
        return itm_min;
    }

    public void setItm_min(Float itm_min) {
        this.itm_min = itm_min;
    }

    public String getGrp_code() {
        return grp_code;
    }

    public void setGrp_code(String grp_code) {
        this.grp_code = grp_code;
    }

    public String getSgrp_code() {
        return sgrp_code;
    }

    public void setSgrp_code(String sgrp_code) {
        this.sgrp_code = sgrp_code;
    }

    public String getVend_code() {
        return vend_code;
    }

    public void setVend_code(String vend_code) {
        this.vend_code = vend_code;
    }

    public String getSrc_code() {
        return src_code;
    }

    public void setSrc_code(String src_code) {
        this.src_code = src_code;
    }

    public Integer getItm_serial() {
        return itm_serial;
    }

    public void setItm_serial(Integer itm_serial) {
        this.itm_serial = itm_serial;
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
    public List<ItemSerial> getItem_serial_fk1() {
        if (item_serial_fk1 == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ItemSerialDao targetDao = daoSession.getItemSerialDao();
            List<ItemSerial> item_serial_fk1New = targetDao._queryItem_Item_serial_fk1(itm_code);
            synchronized (this) {
                if(item_serial_fk1 == null) {
                    item_serial_fk1 = item_serial_fk1New;
                }
            }
        }
        return item_serial_fk1;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetItem_serial_fk1() {
        item_serial_fk1 = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<ItemUnit> getItem_unit_fk1() {
        if (item_unit_fk1 == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ItemUnitDao targetDao = daoSession.getItemUnitDao();
            List<ItemUnit> item_unit_fk1New = targetDao._queryItem_Item_unit_fk1(itm_code);
            synchronized (this) {
                if(item_unit_fk1 == null) {
                    item_unit_fk1 = item_unit_fk1New;
                }
            }
        }
        return item_unit_fk1;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetItem_unit_fk1() {
        item_unit_fk1 = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<ItemBarcode> getItem_barcode_fk1() {
        if (item_barcode_fk1 == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ItemBarcodeDao targetDao = daoSession.getItemBarcodeDao();
            List<ItemBarcode> item_barcode_fk1New = targetDao._queryItem_Item_barcode_fk1(itm_code);
            synchronized (this) {
                if(item_barcode_fk1 == null) {
                    item_barcode_fk1 = item_barcode_fk1New;
                }
            }
        }
        return item_barcode_fk1;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetItem_barcode_fk1() {
        item_barcode_fk1 = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<ItemPrice> getItem_price_fk1() {
        if (item_price_fk1 == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ItemPriceDao targetDao = daoSession.getItemPriceDao();
            List<ItemPrice> item_price_fk1New = targetDao._queryItem_Item_price_fk1(itm_code);
            synchronized (this) {
                if(item_price_fk1 == null) {
                    item_price_fk1 = item_price_fk1New;
                }
            }
        }
        return item_price_fk1;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetItem_price_fk1() {
        item_price_fk1 = null;
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