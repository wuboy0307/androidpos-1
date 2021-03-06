package net.pointbridge.android.sales.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table SO_DETAIL.
 */
public class SoDetail {

    private String sod_id;
    private String so_id;
    private String itm_code;
    private String itm_unit;
    private Float sod_qty;
    private Float sod_price;
    private Float sod_disc1;
    private Float sod_disc2;
    private Float sod_discval;
    private Integer sod_inctax;
    private Float sod_taxval;
    private Integer proc;
    private Integer astate;
    private Integer locked;
    private Integer posted;
    private String src_code;
    private Integer mark;
    private String modi_by;
    private java.util.Date modi_date;

    public SoDetail() {
    }

    public SoDetail(String sod_id) {
        this.sod_id = sod_id;
    }

    public SoDetail(String sod_id, String so_id, String itm_code, String itm_unit, Float sod_qty, Float sod_price, Float sod_disc1, Float sod_disc2, Float sod_discval, Integer sod_inctax, Float sod_taxval, Integer proc, Integer astate, Integer locked, Integer posted, String src_code, Integer mark, String modi_by, java.util.Date modi_date) {
        this.sod_id = sod_id;
        this.so_id = so_id;
        this.itm_code = itm_code;
        this.itm_unit = itm_unit;
        this.sod_qty = sod_qty;
        this.sod_price = sod_price;
        this.sod_disc1 = sod_disc1;
        this.sod_disc2 = sod_disc2;
        this.sod_discval = sod_discval;
        this.sod_inctax = sod_inctax;
        this.sod_taxval = sod_taxval;
        this.proc = proc;
        this.astate = astate;
        this.locked = locked;
        this.posted = posted;
        this.src_code = src_code;
        this.mark = mark;
        this.modi_by = modi_by;
        this.modi_date = modi_date;
    }

    public String getSod_id() {
        return sod_id;
    }

    public void setSod_id(String sod_id) {
        this.sod_id = sod_id;
    }

    public String getSo_id() {
        return so_id;
    }

    public void setSo_id(String so_id) {
        this.so_id = so_id;
    }

    public String getItm_code() {
        return itm_code;
    }

    public void setItm_code(String itm_code) {
        this.itm_code = itm_code;
    }

    public String getItm_unit() {
        return itm_unit;
    }

    public void setItm_unit(String itm_unit) {
        this.itm_unit = itm_unit;
    }

    public Float getSod_qty() {
        return sod_qty;
    }

    public void setSod_qty(Float sod_qty) {
        this.sod_qty = sod_qty;
    }

    public Float getSod_price() {
        return sod_price;
    }

    public void setSod_price(Float sod_price) {
        this.sod_price = sod_price;
    }

    public Float getSod_disc1() {
        return sod_disc1;
    }

    public void setSod_disc1(Float sod_disc1) {
        this.sod_disc1 = sod_disc1;
    }

    public Float getSod_disc2() {
        return sod_disc2;
    }

    public void setSod_disc2(Float sod_disc2) {
        this.sod_disc2 = sod_disc2;
    }

    public Float getSod_discval() {
        return sod_discval;
    }

    public void setSod_discval(Float sod_discval) {
        this.sod_discval = sod_discval;
    }

    public Integer getSod_inctax() {
        return sod_inctax;
    }

    public void setSod_inctax(Integer sod_inctax) {
        this.sod_inctax = sod_inctax;
    }

    public Float getSod_taxval() {
        return sod_taxval;
    }

    public void setSod_taxval(Float sod_taxval) {
        this.sod_taxval = sod_taxval;
    }

    public Integer getProc() {
        return proc;
    }

    public void setProc(Integer proc) {
        this.proc = proc;
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

}
