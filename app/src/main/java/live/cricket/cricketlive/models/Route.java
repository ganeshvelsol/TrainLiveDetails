package live.cricket.cricketlive.models;

/**
 * Created by Velsol 170016 on 8/10/2018.
 */

public class Route
{

    private String scharr;

    private String actdep;

    private Integer day;

    private String actarr;

    private Boolean has_arrived;

    private String actarr_date;

    private Integer latemin;

    private Integer distance;

    private String status;

    private Station station;

    private String schdep;

    private String scharr_date;

    private Boolean has_departed;


    private Integer no;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getHalt() {
        return halt;
    }

    public void setHalt(Integer halt) {
        this.halt = halt;
    }

    private Integer halt;



    public String getScharr() {
        return scharr;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }

    public String getActdep() {
        return actdep;
    }

    public void setActdep(String actdep) {
        this.actdep = actdep;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getActarr() {
        return actarr;
    }

    public void setActarr(String actarr) {
        this.actarr = actarr;
    }

    public Boolean getHas_arrived() {
        return has_arrived;
    }

    public void setHas_arrived(Boolean has_arrived) {
        this.has_arrived = has_arrived;
    }

    public String getActarr_date() {
        return actarr_date;
    }

    public void setActarr_date(String actarr_date) {
        this.actarr_date = actarr_date;
    }

    public Integer getLatemin() {
        return latemin;
    }

    public void setLatemin(Integer latemin) {
        this.latemin = latemin;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getSchdep() {
        return schdep;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }

    public String getScharr_date() {
        return scharr_date;
    }

    public void setScharr_date(String scharr_date) {
        this.scharr_date = scharr_date;
    }

    public Boolean getHas_departed() {
        return has_departed;
    }

    public void setHas_departed(Boolean has_departed) {
        this.has_departed = has_departed;
    }
}
