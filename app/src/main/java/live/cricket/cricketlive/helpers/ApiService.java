package live.cricket.cricketlive.helpers;

import android.os.Bundle;

import live.cricket.cricketlive.responses.CancelledTrainsResponse;
import live.cricket.cricketlive.responses.LiteStatusResponse;
import live.cricket.cricketlive.responses.MatchResponse;
import live.cricket.cricketlive.responses.RescheduledTrainsResponse;
import live.cricket.cricketlive.responses.ResponseData;
import live.cricket.cricketlive.responses.TrainArrivalTimeResponse;
import live.cricket.cricketlive.responses.TrainBtwnStations;
import live.cricket.cricketlive.responses.TrainRouteResponse;
import live.cricket.cricketlive.trainrelated.LiveTrainStatus;
import live.cricket.cricketlive.trainrelated.RescheduledTrains;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import  live.cricket.cricketlive.trainrelated.LiveTrainStatus.*;
import retrofit2.http.Url;

import static live.cricket.cricketlive.trainrelated.LiveTrainStatus.*;

/**
 * Created by Velsol 170016 on 7/20/2018.
 */

public interface ApiService
{
    @GET("LKaZgvK1pFddx0dFqRwdFkWM4132")
    Call<MatchResponse> matchesResponse();


    @FormUrlEncoded
    @POST("LKaZgvK1pFddx0dFqRwdFkWM4132?")
    Call<ResponseData> individuals(@Field("unique_id") String unique_id);

    @GET
    Call<LiteStatusResponse> liveResponse(@Url String url);

    @GET
    Call<TrainRouteResponse> trainRoute(@Url String url);

    @GET
    Call<TrainBtwnStations> trainsBtwnStations(@Url String url);

    @GET
    Call<TrainArrivalTimeResponse> trainArrivalTimings(@Url String url);

    @GET
    Call<CancelledTrainsResponse> cancelledTrains(@Url String url);

    @GET
    Call<RescheduledTrainsResponse> rescheduledTrains(@Url String url);
}
