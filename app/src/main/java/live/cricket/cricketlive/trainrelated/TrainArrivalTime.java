package live.cricket.cricketlive.trainrelated;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.helpers.ApiClient;
import live.cricket.cricketlive.helpers.ApiService;
import live.cricket.cricketlive.helpers.MyApplication;
import live.cricket.cricketlive.responses.TrainArrivalTimeResponse;
import live.cricket.cricketlive.trainadapters.TrainArrivalTimeAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainArrivalTime extends AppCompatActivity
{
    RecyclerView train_arrival_time;
    LinearLayoutManager llm;
    Spinner select_station_code,spinner_hours;
    Button serarch_button;
    TextView total_trains;
    LinearLayout data_empty_layout,data_loading_screen_layout;
    String stns[]={"-- select station-- ","SECUNDRABAD ( SC )","WARANGAL (WL)","KACHIGUDA (KCG)","KAZIPET (KZJ)","Adilabad (ADB)","Basar (BSX)",
            "Nizamabad (NZB)","Kamareddi (KMC)","Maula Ali (MLY)","Charlapalli (CHZ)","Bhongir (BG)","Jangaon (ZN)","Mahbubabad (MABD)",
            "Khammam (KMT)","Vijayawada Junction (BZA)","Ongole (OGL)","Nellore (NLR)","Tirupati (TPTY)"};

    String codes[]={"","SC","WL","KCG","KZJ","ADB","BSX","NZB","KMC","MLY","CHZ","BG","ZN","MABD","KMT","BZA","OGL","NLR","TPTY"};
    String selectedCode,selectedTimed;
    String times[]={"--hrs--","1 hr","2 hrs","3 hrs","4 hrs","5 hrs"};
    String Selectedtimes[]={"","1","2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_arrival_time);
        train_arrival_time=(RecyclerView)findViewById(R.id.train_arrival_time);
        llm=new LinearLayoutManager(this);
        select_station_code=(Spinner)findViewById(R.id.select_station_code);
        spinner_hours=(Spinner)findViewById(R.id.spinner_hours);
        total_trains=(TextView)findViewById(R.id.total_trains);
        serarch_button=(Button) findViewById(R.id.serarch_button);
        data_empty_layout=(LinearLayout)findViewById(R.id.data_empty_layout);
        data_loading_screen_layout=(LinearLayout)findViewById(R.id.data_loading_screen_layout);

        ArrayAdapter aa=new ArrayAdapter(TrainArrivalTime.this,android.R.layout.simple_spinner_dropdown_item,stns);
        select_station_code.setAdapter(aa);
        select_station_code.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                if (stns[i].equals("-- select station-- "))
                {

                }else
                {
                    selectedCode=codes[i];
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
        ArrayAdapter ads=new ArrayAdapter(TrainArrivalTime.this,android.R.layout.simple_spinner_dropdown_item,times);
        spinner_hours.setAdapter(ads);
        spinner_hours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                if (times[i].equals("--hrs--"))
                {

                }
                else
                {
                    selectedTimed=Selectedtimes[i];
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
        serarch_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                clickToDisplay();
            }
        });
    }
    public void clickToDisplay()
    {
        if (MyApplication.isNetworkAvailable(this))
        {
            data_loading_screen_layout.setVisibility(View.VISIBLE);
            ApiService service = ApiClient.getClient().create(ApiService.class);
            //https://api.railwayapi.com/v2/arrivals/station/<stn code>/hours/<window period in hours>/apikey/msj3v9dlw4/
            Call<TrainArrivalTimeResponse> arrival = service.trainArrivalTimings("arrivals/station/" + selectedCode + "/hours/" + selectedTimed + "/apikey/msj3v9dlw4/");
            arrival.enqueue(new Callback<TrainArrivalTimeResponse>() {
                @Override
                public void onResponse(Call<TrainArrivalTimeResponse> call, Response<TrainArrivalTimeResponse> response) {
                    data_loading_screen_layout.setVisibility(View.GONE);
                    if (response.body().getResponse_code() == 200) {
                        total_trains.setText("" + response.body().getTotal());
                        TrainArrivalTimeAdapter adapter = new TrainArrivalTimeAdapter(response.body().getTrains(), TrainArrivalTime.this);
                        train_arrival_time.setAdapter(adapter);
                        train_arrival_time.setLayoutManager(llm);
                    } else {
                        data_empty_layout.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<TrainArrivalTimeResponse> call, Throwable t) {
                    data_loading_screen_layout.setVisibility(View.GONE);
                    Snackbar sp = Snackbar.make(TrainArrivalTime.this.findViewById(android.R.id.content), "something went wrong", Snackbar.LENGTH_LONG);
                    sp.show();
                }
            });
        }
        else
        {
            data_loading_screen_layout.setVisibility(View.GONE);
            Snackbar snackbar = Snackbar
                    .make(TrainArrivalTime.this.findViewById(android.R.id.content), "No internet connection! Turn on ", Snackbar.LENGTH_LONG)
                    .setAction("YES", new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View view)
                                {
                                    TrainArrivalTime.this.startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                                }
                            }
                    );
            snackbar.show();
        }
    }
}
