package live.cricket.cricketlive.responses;

import java.util.List;

import live.cricket.cricketlive.models.Route;
import live.cricket.cricketlive.models.Train;

/**
 * Created by Velsol 170016 on 8/10/2018.
 */

public class TrainRouteResponse
{


    private List<Route> route ;

    private Train train;

    private Integer response_code;

    private Integer debit;

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Integer getResponse_code() {
        return response_code;
    }

    public void setResponse_code(Integer response_code) {
        this.response_code = response_code;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }
}
