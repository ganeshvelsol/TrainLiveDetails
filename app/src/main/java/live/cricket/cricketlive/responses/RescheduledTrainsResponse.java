package live.cricket.cricketlive.responses;

import java.util.List;

import live.cricket.cricketlive.models.Train;

/**
 * Created by Velsol 170016 on 8/17/2018.
 */

public class RescheduledTrainsResponse
{

    private List<Train> trains ;

    private Integer response_code;

    private Integer debit;

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
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
