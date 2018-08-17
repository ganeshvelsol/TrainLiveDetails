package live.cricket.cricketlive.helpers;

/**
 * Created by Velsol 170016 on 8/14/2018.
 */

public class ModelDays
{
    String code,runs;

    public ModelDays(String code, String runs) {
        this.code = code;
        this.runs = runs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }
}
