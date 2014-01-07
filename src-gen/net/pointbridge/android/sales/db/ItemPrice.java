package net.pointbridge.android.sales.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table ITEM_PRICE.
 */
public class ItemPrice {

    private String ipc_id;
    private String itm_code;
    private String itm_unit;
    private Float ipc_margin;
    private Float ipc_vendprice;
    private Float ipc_buyprice;
    private Float ipc_sellprice;
    private Integer ipc_level;
    private String curr_code;
    private String brc_code;
    private String src_code;
    private Integer mark;
    private String modi_by;
    private java.util.Date modi_date;

    public ItemPrice() {
    }

    public ItemPrice(String ipc_id) {
        this.ipc_id = ipc_id;
    }

    public ItemPrice(String ipc_id, String itm_code, String itm_unit, Float ipc_margin, Float ipc_vendprice, Float ipc_buyprice, Float ipc_sellprice, Integer ipc_level, String curr_code, String brc_code, String src_code, Integer mark, String modi_by, java.util.Date modi_date) {
        this.ipc_id = ipc_id;
        this.itm_code = itm_code;
        this.itm_unit = itm_unit;
        this.ipc_margin = ipc_margin;
        this.ipc_vendprice = ipc_vendprice;
        this.ipc_buyprice = ipc_buyprice;
        this.ipc_sellprice = ipc_sellprice;
        this.ipc_level = ipc_level;
        this.curr_code = curr_code;
        this.brc_code = brc_code;
        this.src_code = src_code;
        this.mark = mark;
        this.modi_by = modi_by;
        this.modi_date = modi_date;
    }

    public String getIpc_id() {
        return ipc_id;
    }

    public void setIpc_id(String ipc_id) {
        this.ipc_id = ipc_id;
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

    public Float getIpc_margin() {
        return ipc_margin;
    }

    public void setIpc_margin(Float ipc_margin) {
        this.ipc_margin = ipc_margin;
    }

    public Float getIpc_vendprice() {
        return ipc_vendprice;
    }

    public void setIpc_vendprice(Float ipc_vendprice) {
        this.ipc_vendprice = ipc_vendprice;
    }

    public Float getIpc_buyprice() {
        return ipc_buyprice;
    }

    public void setIpc_buyprice(Float ipc_buyprice) {
        this.ipc_buyprice = ipc_buyprice;
    }

    public Float getIpc_sellprice() {
        return ipc_sellprice;
    }

    public void setIpc_sellprice(Float ipc_sellprice) {
        this.ipc_sellprice = ipc_sellprice;
    }

    public Integer getIpc_level() {
        return ipc_level;
    }

    public void setIpc_level(Integer ipc_level) {
        this.ipc_level = ipc_level;
    }

    public String getCurr_code() {
        return curr_code;
    }

    public void setCurr_code(String curr_code) {
        this.curr_code = curr_code;
    }

    public String getBrc_code() {
        return brc_code;
    }

    public void setBrc_code(String brc_code) {
        this.brc_code = brc_code;
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
