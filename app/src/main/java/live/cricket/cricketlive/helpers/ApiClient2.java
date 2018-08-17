package live.cricket.cricketlive.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Velsol 170016 on 7/21/2018.
 */

public class ApiClient2
{
    public static final String BASE_URL = "http://cricapi.com/api/cricketScore/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient()
    {
        if (retrofit==null)
        {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
