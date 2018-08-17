package live.cricket.cricketlive.models;

/**
 * Created by Velsol 170016 on 8/13/2018.
 */

public class FromStation
{

    private String code;

    private Double lng;

    private String name;

    private Double lat;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
