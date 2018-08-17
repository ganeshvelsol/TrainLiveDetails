package live.cricket.cricketlive.trainrelated;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.helpers.ApiClient;
import live.cricket.cricketlive.helpers.ApiService;
import live.cricket.cricketlive.helpers.MyApplication;
import live.cricket.cricketlive.responses.LiteStatusResponse;
import live.cricket.cricketlive.responses.MatchResponse;
import live.cricket.cricketlive.trainadapters.LiveTrainRouteAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class LiveTrainStatus extends AppCompatActivity
{
    RecyclerView recycler_live_station;
    TextView current_station,position;
    EditText train_number;
    LinearLayout data_empty_layout,data_loading_screen_layout;
    public static  String tno;
    LinearLayoutManager ll;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_train_status);
        recycler_live_station=(RecyclerView)findViewById(R.id.recycler_live_station);
        current_station=(TextView)findViewById(R.id.current_station);
        position=(TextView)findViewById(R.id.position);
        train_number=(EditText)findViewById(R.id.train_number);
        data_empty_layout=(LinearLayout)findViewById(R.id.data_empty_layout);
        data_loading_screen_layout=(LinearLayout)findViewById(R.id.data_loading_screen_layout);

        ll=new LinearLayoutManager(this);
        search=findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //onclicking the functionality do something
                respondToBUttonClick();
            }
        });

    }
    public void respondToBUttonClick()
    {
        tno=train_number.getText().toString().trim();
        if (!tno.isEmpty())
        {
            Calendar cal = Calendar.getInstance();
            int yyy = cal.get(Calendar.YEAR);
            int mon = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            String d = day + "-0" + (mon + 1) + "-" + yyy;

            if (MyApplication.isNetworkAvailable(this))
            {
                data_loading_screen_layout.setVisibility(View.VISIBLE);
                ApiService service = ApiClient.getClient().create(ApiService.class);
                Call<LiteStatusResponse> statuss = service.liveResponse("live/train/" + tno + "/date/" + d + "/apikey/msj3v9dlw4/");
                statuss.enqueue(new Callback<LiteStatusResponse>()
                {
                    @Override
                    public void onResponse(Call<LiteStatusResponse> call, Response<LiteStatusResponse> response)
                    {
                        data_loading_screen_layout.setVisibility(View.GONE);
                        if (response.body().getResponse_code() == 200) {
                            current_station.setText("" + response.body().getCurrent_station().getName());
                            position.setText("" + response.body().getPosition());
                            LiveTrainRouteAdapter da = new LiveTrainRouteAdapter(response.body().getRoute(), LiveTrainStatus.this);
                            recycler_live_station.setAdapter(da);
                            recycler_live_station.setLayoutManager(ll);
                        } else {
                            data_empty_layout.setVisibility(View.VISIBLE);
//                                 Toast.makeText(LiveTrainStatus.this, "no response", Toast.LENGTH_SHORT).show();
//                                 LiveTrainRouteAdapter da = new LiveTrainRouteAdapter(response.body().getRoute(), LiveTrainStatus.this);
//                                 recycler_live_station.setAdapter(da);
//                                 recycler_live_station.setLayoutManager(ll);
                        }
                    }

                    @Override
                    public void onFailure(Call<LiteStatusResponse> call, Throwable t)
                    {
                        data_loading_screen_layout.setVisibility(View.GONE);
                        data_empty_layout.setVisibility(View.VISIBLE);
                        Snackbar ss = Snackbar.make(LiveTrainStatus.this.findViewById(android.R.id.content), "from failure case", Snackbar.LENGTH_LONG);
                        ss.show();
                    }
                });
            }
            else
            {
                data_loading_screen_layout.setVisibility(View.GONE);
                Snackbar snackbar = Snackbar
                        .make(LiveTrainStatus.this.findViewById(android.R.id.content), "No internet connection! Turn on ", Snackbar.LENGTH_LONG)
                        .setAction("YES", new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View view)
                                    {
                                        LiveTrainStatus.this.startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                                    }
                                }
                        );
                snackbar.show();
            }

        } else {
            Snackbar ss = Snackbar.make(LiveTrainStatus.this.findViewById(android.R.id.content), "enter valid number", Snackbar.LENGTH_LONG);
            ss.show();
        }
    }

}
