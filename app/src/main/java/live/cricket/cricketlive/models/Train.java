package live.cricket.cricketlive.models;

import java.util.List;

/**
 * Created by Velsol 170016 on 8/10/2018.
 */

public class Train
{

    private String name;

    //private List<classes> classes ;

    private List<days> days = null;

    private String number;



    private FromStation from_station;

    //private List<Class> classes;

    private String src_departure_time;

    private String travel_time;

    private String dest_arrival_time;

    private ToStation to_station;


    private String rescheduled_time;

    private String rescheduled_date;

    public String getRescheduled_time() {
        return rescheduled_time;
    }

    public void setRescheduled_time(String rescheduled_time) {
        this.rescheduled_time = rescheduled_time;
    }

    public String getRescheduled_date() {
        return rescheduled_date;
    }

    public void setRescheduled_date(String rescheduled_date) {
        this.rescheduled_date = rescheduled_date;
    }

    private String scharr;

    private String actarr;

    private String schdep;

    private String actdep;

    private String delayarr;

    private String delaydep;



    private Source source;

    private String type;

    private String start_time;

    private Dest dest;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public Dest getDest() {
        return dest;
    }

    public void setDest(Dest dest) {
        this.dest = dest;
    }

    public String getScharr() {
        return scharr;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }

    public String getActarr() {
        return actarr;
    }

    public void setActarr(String actarr) {
        this.actarr = actarr;
    }

    public String getSchdep() {
        return schdep;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }

    public String getActdep() {
        return actdep;
    }

    public void setActdep(String actdep) {
        this.actdep = actdep;
    }

    public String getDelayarr() {
        return delayarr;
    }

    public void setDelayarr(String delayarr) {
        this.delayarr = delayarr;
    }

    public String getDelaydep() {
        return delaydep;
    }

    public void setDelaydep(String delaydep) {
        this.delaydep = delaydep;
    }

    public FromStation getFrom_station() {
        return from_station;
    }

    public void setFrom_station(FromStation from_station) {
        this.from_station = from_station;
    }

    public String getSrc_departure_time() {
        return src_departure_time;
    }

    public void setSrc_departure_time(String src_departure_time) {
        this.src_departure_time = src_departure_time;
    }

    public String getTravel_time() {
        return travel_time;
    }

    public void setTravel_time(String travel_time) {
        this.travel_time = travel_time;
    }

    public String getDest_arrival_time() {
        return dest_arrival_time;
    }

    public void setDest_arrival_time(String dest_arrival_time) {
        this.dest_arrival_time = dest_arrival_time;
    }

    public ToStation getTo_station() {
        return to_station;
    }

    public void setTo_station(ToStation to_station) {
        this.to_station = to_station;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<live.cricket.cricketlive.models.days> getDays() {
        return days;
    }

    public void setDays(List<live.cricket.cricketlive.models.days> days) {
        this.days = days;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
