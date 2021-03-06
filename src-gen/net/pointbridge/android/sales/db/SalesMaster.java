package net.pointbridge.android.sales.db;

import java.util.List;
import net.pointbridge.android.sales.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table SALES_MASTER.
 */
public class SalesMaster {

    private String sm_id;
    private java.util.Date sm_date;
    private String sm_no;
    private String sm_invno;
    private Integer sm_type;
    private String wh_code;
    private String cust_code;
    private String slm_code;
    private String rsl_code;
    private String ptm_code;
    private Integer pay_type;
    private Integer pay_status;
    private String curr_code;
    private Float curr_val;
    private String cs_code;
    private Float sm_totpoint;
    private Float sm_valgetpoint;
    private Float sm_subtotal;
    private Float sm_totqty;
    private Float sm_tottax;
    private Float sm_discval;
    private Float sm_disc1;
    private Float sm_disc2;
    private Float sm_disc3;
    private Float sm_shipcost;
    private Float sm_shipweight;
    private Float sm_othercost;
    private Float sm_total;
    private Float sm_return;
    private Float sm_paid_cash;
    private Float sm_paid_voucher;
    private String sm_paid_voucherno;
    private Float sm_paid_card;
    private String sm_paid_cardno;
    private String sm_paid_cardtype;
    private String sm_paid_cardissuer;
    private String sm_paid_cardholder;
    private Float sm_paid_cardfee;
    private Float sm_paid_dcard;
    private String sm_paid_dcardno;
    private String sm_paid_dcardtype;
    private String sm_paid_dcardissuer;
    private String sm_paid_dcardholder;
    private Float sm_totaldiscount;
    private Integer sm_pending;
    private Float sm_totalgross;
    private Integer sm_inctax;
    private String sm_get_voucherno;
    private Float sm_get_vouchervalue;
    private Integer astate;
    private Integer locked;
    private Integer posted;
    private Integer proc;
    private String src_code;
    private Integer mark;
    private String modi_by;
    private java.util.Date modi_date;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient SalesMasterDao myDao;

    private List<SalesDetail> sd_detail_fk1;
    private List<SalesSerial> sd_serial_fk1;

    public SalesMaster() {
    }

    public SalesMaster(String sm_id) {
        this.sm_id = sm_id;
    }

    public SalesMaster(String sm_id, java.util.Date sm_date, String sm_no, String sm_invno, Integer sm_type, String wh_code, String cust_code, String slm_code, String rsl_code, String ptm_code, Integer pay_type, Integer pay_status, String curr_code, Float curr_val, String cs_code, Float sm_totpoint, Float sm_valgetpoint, Float sm_subtotal, Float sm_totqty, Float sm_tottax, Float sm_discval, Float sm_disc1, Float sm_disc2, Float sm_disc3, Float sm_shipcost, Float sm_shipweight, Float sm_othercost, Float sm_total, Float sm_return, Float sm_paid_cash, Float sm_paid_voucher, String sm_paid_voucherno, Float sm_paid_card, String sm_paid_cardno, String sm_paid_cardtype, String sm_paid_cardissuer, String sm_paid_cardholder, Float sm_paid_cardfee, Float sm_paid_dcard, String sm_paid_dcardno, String sm_paid_dcardtype, String sm_paid_dcardissuer, String sm_paid_dcardholder, Float sm_totaldiscount, Integer sm_pending, Float sm_totalgross, Integer sm_inctax, String sm_get_voucherno, Float sm_get_vouchervalue, Integer astate, Integer locked, Integer posted, Integer proc, String src_code, Integer mark, String modi_by, java.util.Date modi_date) {
        this.sm_id = sm_id;
        this.sm_date = sm_date;
        this.sm_no = sm_no;
        this.sm_invno = sm_invno;
        this.sm_type = sm_type;
        this.wh_code = wh_code;
        this.cust_code = cust_code;
        this.slm_code = slm_code;
        this.rsl_code = rsl_code;
        this.ptm_code = ptm_code;
        this.pay_type = pay_type;
        this.pay_status = pay_status;
        this.curr_code = curr_code;
        this.curr_val = curr_val;
        this.cs_code = cs_code;
        this.sm_totpoint = sm_totpoint;
        this.sm_valgetpoint = sm_valgetpoint;
        this.sm_subtotal = sm_subtotal;
        this.sm_totqty = sm_totqty;
        this.sm_tottax = sm_tottax;
        this.sm_discval = sm_discval;
        this.sm_disc1 = sm_disc1;
        this.sm_disc2 = sm_disc2;
        this.sm_disc3 = sm_disc3;
        this.sm_shipcost = sm_shipcost;
        this.sm_shipweight = sm_shipweight;
        this.sm_othercost = sm_othercost;
        this.sm_total = sm_total;
        this.sm_return = sm_return;
        this.sm_paid_cash = sm_paid_cash;
        this.sm_paid_voucher = sm_paid_voucher;
        this.sm_paid_voucherno = sm_paid_voucherno;
        this.sm_paid_card = sm_paid_card;
        this.sm_paid_cardno = sm_paid_cardno;
        this.sm_paid_cardtype = sm_paid_cardtype;
        this.sm_paid_cardissuer = sm_paid_cardissuer;
        this.sm_paid_cardholder = sm_paid_cardholder;
        this.sm_paid_cardfee = sm_paid_cardfee;
        this.sm_paid_dcard = sm_paid_dcard;
        this.sm_paid_dcardno = sm_paid_dcardno;
        this.sm_paid_dcardtype = sm_paid_dcardtype;
        this.sm_paid_dcardissuer = sm_paid_dcardissuer;
        this.sm_paid_dcardholder = sm_paid_dcardholder;
        this.sm_totaldiscount = sm_totaldiscount;
        this.sm_pending = sm_pending;
        this.sm_totalgross = sm_totalgross;
        this.sm_inctax = sm_inctax;
        this.sm_get_voucherno = sm_get_voucherno;
        this.sm_get_vouchervalue = sm_get_vouchervalue;
        this.astate = astate;
        this.locked = locked;
        this.posted = posted;
        this.proc = proc;
        this.src_code = src_code;
        this.mark = mark;
        this.modi_by = modi_by;
        this.modi_date = modi_date;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSalesMasterDao() : null;
    }

    public String getSm_id() {
        return sm_id;
    }

    public void setSm_id(String sm_id) {
        this.sm_id = sm_id;
    }

    public java.util.Date getSm_date() {
        return sm_date;
    }

    public void setSm_date(java.util.Date sm_date) {
        this.sm_date = sm_date;
    }

    public String getSm_no() {
        return sm_no;
    }

    public void setSm_no(String sm_no) {
        this.sm_no = sm_no;
    }

    public String getSm_invno() {
        return sm_invno;
    }

    public void setSm_invno(String sm_invno) {
        this.sm_invno = sm_invno;
    }

    public Integer getSm_type() {
        return sm_type;
    }

    public void setSm_type(Integer sm_type) {
        this.sm_type = sm_type;
    }

    public String getWh_code() {
        return wh_code;
    }

    public void setWh_code(String wh_code) {
        this.wh_code = wh_code;
    }

    public String getCust_code() {
        return cust_code;
    }

    public void setCust_code(String cust_code) {
        this.cust_code = cust_code;
    }

    public String getSlm_code() {
        return slm_code;
    }

    public void setSlm_code(String slm_code) {
        this.slm_code = slm_code;
    }

    public String getRsl_code() {
        return rsl_code;
    }

    public void setRsl_code(String rsl_code) {
        this.rsl_code = rsl_code;
    }

    public String getPtm_code() {
        return ptm_code;
    }

    public void setPtm_code(String ptm_code) {
        this.ptm_code = ptm_code;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public Integer getPay_status() {
        return pay_status;
    }

    public void setPay_status(Integer pay_status) {
        this.pay_status = pay_status;
    }

    public String getCurr_code() {
        return curr_code;
    }

    public void setCurr_code(String curr_code) {
        this.curr_code = curr_code;
    }

    public Float getCurr_val() {
        return curr_val;
    }

    public void setCurr_val(Float curr_val) {
        this.curr_val = curr_val;
    }

    public String getCs_code() {
        return cs_code;
    }

    public void setCs_code(String cs_code) {
        this.cs_code = cs_code;
    }

    public Float getSm_totpoint() {
        return sm_totpoint;
    }

    public void setSm_totpoint(Float sm_totpoint) {
        this.sm_totpoint = sm_totpoint;
    }

    public Float getSm_valgetpoint() {
        return sm_valgetpoint;
    }

    public void setSm_valgetpoint(Float sm_valgetpoint) {
        this.sm_valgetpoint = sm_valgetpoint;
    }

    public Float getSm_subtotal() {
        return sm_subtotal;
    }

    public void setSm_subtotal(Float sm_subtotal) {
        this.sm_subtotal = sm_subtotal;
    }

    public Float getSm_totqty() {
        return sm_totqty;
    }

    public void setSm_totqty(Float sm_totqty) {
        this.sm_totqty = sm_totqty;
    }

    public Float getSm_tottax() {
        return sm_tottax;
    }

    public void setSm_tottax(Float sm_tottax) {
        this.sm_tottax = sm_tottax;
    }

    public Float getSm_discval() {
        return sm_discval;
    }

    public void setSm_discval(Float sm_discval) {
        this.sm_discval = sm_discval;
    }

    public Float getSm_disc1() {
        return sm_disc1;
    }

    public void setSm_disc1(Float sm_disc1) {
        this.sm_disc1 = sm_disc1;
    }

    public Float getSm_disc2() {
        return sm_disc2;
    }

    public void setSm_disc2(Float sm_disc2) {
        this.sm_disc2 = sm_disc2;
    }

    public Float getSm_disc3() {
        return sm_disc3;
    }

    public void setSm_disc3(Float sm_disc3) {
        this.sm_disc3 = sm_disc3;
    }

    public Float getSm_shipcost() {
        return sm_shipcost;
    }

    public void setSm_shipcost(Float sm_shipcost) {
        this.sm_shipcost = sm_shipcost;
    }

    public Float getSm_shipweight() {
        return sm_shipweight;
    }

    public void setSm_shipweight(Float sm_shipweight) {
        this.sm_shipweight = sm_shipweight;
    }

    public Float getSm_othercost() {
        return sm_othercost;
    }

    public void setSm_othercost(Float sm_othercost) {
        this.sm_othercost = sm_othercost;
    }

    public Float getSm_total() {
        return sm_total;
    }

    public void setSm_total(Float sm_total) {
        this.sm_total = sm_total;
    }

    public Float getSm_return() {
        return sm_return;
    }

    public void setSm_return(Float sm_return) {
        this.sm_return = sm_return;
    }

    public Float getSm_paid_cash() {
        return sm_paid_cash;
    }

    public void setSm_paid_cash(Float sm_paid_cash) {
        this.sm_paid_cash = sm_paid_cash;
    }

    public Float getSm_paid_voucher() {
        return sm_paid_voucher;
    }

    public void setSm_paid_voucher(Float sm_paid_voucher) {
        this.sm_paid_voucher = sm_paid_voucher;
    }

    public String getSm_paid_voucherno() {
        return sm_paid_voucherno;
    }

    public void setSm_paid_voucherno(String sm_paid_voucherno) {
        this.sm_paid_voucherno = sm_paid_voucherno;
    }

    public Float getSm_paid_card() {
        return sm_paid_card;
    }

    public void setSm_paid_card(Float sm_paid_card) {
        this.sm_paid_card = sm_paid_card;
    }

    public String getSm_paid_cardno() {
        return sm_paid_cardno;
    }

    public void setSm_paid_cardno(String sm_paid_cardno) {
        this.sm_paid_cardno = sm_paid_cardno;
    }

    public String getSm_paid_cardtype() {
        return sm_paid_cardtype;
    }

    public void setSm_paid_cardtype(String sm_paid_cardtype) {
        this.sm_paid_cardtype = sm_paid_cardtype;
    }

    public String getSm_paid_cardissuer() {
        return sm_paid_cardissuer;
    }

    public void setSm_paid_cardissuer(String sm_paid_cardissuer) {
        this.sm_paid_cardissuer = sm_paid_cardissuer;
    }

    public String getSm_paid_cardholder() {
        return sm_paid_cardholder;
    }

    public void setSm_paid_cardholder(String sm_paid_cardholder) {
        this.sm_paid_cardholder = sm_paid_cardholder;
    }

    public Float getSm_paid_cardfee() {
        return sm_paid_cardfee;
    }

    public void setSm_paid_cardfee(Float sm_paid_cardfee) {
        this.sm_paid_cardfee = sm_paid_cardfee;
    }

    public Float getSm_paid_dcard() {
        return sm_paid_dcard;
    }

    public void setSm_paid_dcard(Float sm_paid_dcard) {
        this.sm_paid_dcard = sm_paid_dcard;
    }

    public String getSm_paid_dcardno() {
        return sm_paid_dcardno;
    }

    public void setSm_paid_dcardno(String sm_paid_dcardno) {
        this.sm_paid_dcardno = sm_paid_dcardno;
    }

    public String getSm_paid_dcardtype() {
        return sm_paid_dcardtype;
    }

    public void setSm_paid_dcardtype(String sm_paid_dcardtype) {
        this.sm_paid_dcardtype = sm_paid_dcardtype;
    }

    public String getSm_paid_dcardissuer() {
        return sm_paid_dcardissuer;
    }

    public void setSm_paid_dcardissuer(String sm_paid_dcardissuer) {
        this.sm_paid_dcardissuer = sm_paid_dcardissuer;
    }

    public String getSm_paid_dcardholder() {
        return sm_paid_dcardholder;
    }

    public void setSm_paid_dcardholder(String sm_paid_dcardholder) {
        this.sm_paid_dcardholder = sm_paid_dcardholder;
    }

    public Float getSm_totaldiscount() {
        return sm_totaldiscount;
    }

    public void setSm_totaldiscount(Float sm_totaldiscount) {
        this.sm_totaldiscount = sm_totaldiscount;
    }

    public Integer getSm_pending() {
        return sm_pending;
    }

    public void setSm_pending(Integer sm_pending) {
        this.sm_pending = sm_pending;
    }

    public Float getSm_totalgross() {
        return sm_totalgross;
    }

    public void setSm_totalgross(Float sm_totalgross) {
        this.sm_totalgross = sm_totalgross;
    }

    public Integer getSm_inctax() {
        return sm_inctax;
    }

    public void setSm_inctax(Integer sm_inctax) {
        this.sm_inctax = sm_inctax;
    }

    public String getSm_get_voucherno() {
        return sm_get_voucherno;
    }

    public void setSm_get_voucherno(String sm_get_voucherno) {
        this.sm_get_voucherno = sm_get_voucherno;
    }

    public Float getSm_get_vouchervalue() {
        return sm_get_vouchervalue;
    }

    public void setSm_get_vouchervalue(Float sm_get_vouchervalue) {
        this.sm_get_vouchervalue = sm_get_vouchervalue;
    }

    public Integer getAstate() {
        return astate;
    }

    public void setAstate(Integer astate) {
        this.astate = astate;
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

    public Integer getProc() {
        return proc;
    }

    public void setProc(Integer proc) {
        this.proc = proc;
    }

    public String getSrc_code() {
        return src_code;
    }

    public void setSrc_code(String src_code) {
        this.src_code = src_code;
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
    public List<SalesDetail> getSd_detail_fk1() {
        if (sd_detail_fk1 == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SalesDetailDao targetDao = daoSession.getSalesDetailDao();
            List<SalesDetail> sd_detail_fk1New = targetDao._querySalesMaster_Sd_detail_fk1(sm_id);
            synchronized (this) {
                if(sd_detail_fk1 == null) {
                    sd_detail_fk1 = sd_detail_fk1New;
                }
            }
        }
        return sd_detail_fk1;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetSd_detail_fk1() {
        sd_detail_fk1 = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<SalesSerial> getSd_serial_fk1() {
        if (sd_serial_fk1 == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SalesSerialDao targetDao = daoSession.getSalesSerialDao();
            List<SalesSerial> sd_serial_fk1New = targetDao._querySalesMaster_Sd_serial_fk1(sm_id);
            synchronized (this) {
                if(sd_serial_fk1 == null) {
                    sd_serial_fk1 = sd_serial_fk1New;
                }
            }
        }
        return sd_serial_fk1;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetSd_serial_fk1() {
        sd_serial_fk1 = null;
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
