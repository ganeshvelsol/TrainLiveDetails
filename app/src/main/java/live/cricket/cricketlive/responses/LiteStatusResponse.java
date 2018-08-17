package live.cricket.cricketlive.responses;

import java.util.List;

import live.cricket.cricketlive.models.CurrentStation;
import live.cricket.cricketlive.models.Route;

/**
 * Created by Velsol 170016 on 8/10/2018.
 */

public class LiteStatusResponse
{

    private CurrentStation current_station;

    private List<Route> route ;

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    private Integer debit;

    private String position;

    private Integer response_code;

    private String start_date;

   // private Train train;

    public CurrentStation getCurrent_station() {
        return current_station;
    }

    public void setCurrent_station(CurrentStation current_station) {
        this.current_station = current_station;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getResponse_code() {
        return response_code;
    }

    public void setResponse_code(Integer response_code) {
        this.response_code = response_code;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
}
