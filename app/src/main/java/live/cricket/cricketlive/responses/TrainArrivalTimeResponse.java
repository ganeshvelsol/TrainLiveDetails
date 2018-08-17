package live.cricket.cricketlive.responses;

import java.util.List;

import live.cricket.cricketlive.models.Train;

/**
 * Created by Velsol 170016 on 8/16/2018.
 */

public class TrainArrivalTimeResponse
{

    private Integer total;

    private Integer debit;

    private List<Train> trains;

    private Integer response_code;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

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
}
