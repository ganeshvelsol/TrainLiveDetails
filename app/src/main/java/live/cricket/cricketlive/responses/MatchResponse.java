package live.cricket.cricketlive.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import live.cricket.cricketlive.models.Datum;
import live.cricket.cricketlive.models.Provider;

/**
 * Created by Velsol 170016 on 7/20/2018.
 */

public class MatchResponse
{

    @SerializedName("creditsLeft")
    @Expose
    private Integer creditsLeft;
    @SerializedName("provider")
    @Expose
    private Provider provider;
    @SerializedName("ttl")
    @Expose
    private Integer ttl;
    @SerializedName("v")
    @Expose
    private String v;
    @SerializedName("cache")
    @Expose
    private Boolean cache;
    @SerializedName("data")
    @Expose
    private List<Datum> Datum = null;
    @SerializedName("cache2")
    @Expose
    private Boolean cache2;

    public Integer getCreditsLeft() {
        return creditsLeft;
    }

    public void setCreditsLeft(Integer creditsLeft) {
        this.creditsLeft = creditsLeft;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public Boolean getCache() {
        return cache;
    }

    public void setCache(Boolean cache) {
        this.cache = cache;
    }

    public List<live.cricket.cricketlive.models.Datum> getDatum() {
        return Datum;
    }

    public void setDatum(List<live.cricket.cricketlive.models.Datum> datum) {
        Datum = datum;
    }

    public Boolean getCache2() {
        return cache2;
    }

    public void setCache2(Boolean cache2) {
        this.cache2 = cache2;
    }
}
