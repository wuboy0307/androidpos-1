package net.pointbridge.android.sales.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table MOVE_SERIAL.
 */
public class MoveSerial {

    private String ms_id;
    private String md_id;
    private String mm_id;
    private String itm_code;
    private String serial_no;
    private String src_code;
    private Integer no_seq;
    private Integer astate;
    private Integer locked;
    private Integer posted;
    private Integer mark;
    private String modi_by;
    private java.util.Date modi_date;

    public MoveSerial() {
    }

    public MoveSerial(String ms_id) {
        this.ms_id = ms_id;
    }

    public MoveSerial(String ms_id, String md_id, String mm_id, String itm_code, String serial_no, String src_code, Integer no_seq, Integer astate, Integer locked, Integer posted, Integer mark, String modi_by, java.util.Date modi_date) {
        this.ms_id = ms_id;
        this.md_id = md_id;
        this.mm_id = mm_id;
        this.itm_code = itm_code;
        this.serial_no = serial_no;
        this.src_code = src_code;
        this.no_seq = no_seq;
        this.astate = astate;
        this.locked = locked;
        this.posted = posted;
        this.mark = mark;
        this.modi_by = modi_by;
        this.modi_date = modi_date;
    }

    public String getMs_id() {
        return ms_id;
    }

    public void setMs_id(String ms_id) {
        this.ms_id = ms_id;
    }

    public String getMd_id() {
        return md_id;
    }

    public void setMd_id(String md_id) {
        this.md_id = md_id;
    }

    public String getMm_id() {
        return mm_id;
    }

    public void setMm_id(String mm_id) {
        this.mm_id = mm_id;
    }

    public String getItm_code() {
        return itm_code;
    }

    public void setItm_code(String itm_code) {
        this.itm_code = itm_code;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public String getSrc_code() {
        return src_code;
    }

    public void setSrc_code(String src_code) {
        this.src_code = src_code;
    }

    public Integer getNo_seq() {
        return no_seq;
    }

    public void setNo_seq(Integer no_seq) {
        this.no_seq = no_seq;
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