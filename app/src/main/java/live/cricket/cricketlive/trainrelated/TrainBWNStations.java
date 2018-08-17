package live.cricket.cricketlive.trainrelated;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.helpers.ApiClient;
import live.cricket.cricketlive.helpers.ApiService;
import live.cricket.cricketlive.helpers.MyApplication;
import live.cricket.cricketlive.responses.TrainBtwnStations;
import live.cricket.cricketlive.trainadapters.TrainBtwnStationsAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainBWNStations extends AppCompatActivity
{
    Spinner source,destination;
    String one,two,ss,ss1;
    TextView mtext;
    RecyclerView recycler_bwnstns;
    LinearLayoutManager llm;
    LinearLayout data_loading_screen_layout;
    String stns[]={"-- select station-- ","SECUNDRABAD ( SC )","WARANGAL (WL)","KACHIGUDA (KCG)","KAZIPET (KZJ)","Adilabad (ADB)","Basar (BSX)",
    "Nizamabad (NZB)","Kamareddi (KMC)","Maula Ali (MLY)","Charlapalli (CHZ)","Bhongir (BG)","Jangaon (ZN)","Mahbubabad (MABD)",
    "Khammam (KMT)","Vijayawada Junction (BZA)","Ongole (OGL)","Nellore (NLR)","Tirupati (TPTY)"};

    String codes[]={"","SC","WL","KCG","KZJ","ADB","BSX","NZB","KMC","MLY","CHZ","BG","ZN","MABD","KMT","BZA","OGL","NLR","TPTY"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_bwnstns);
        source=(Spinner)findViewById(R.id.spinner_source);
        destination=(Spinner)findViewById(R.id.spinner_destination);
        mtext=(TextView)findViewById(R.id.mtext);
        recycler_bwnstns=(RecyclerView)findViewById(R.id.recycler_bwnstns);

        data_loading_screen_layout=(LinearLayout)findViewById(R.id.data_loading_screen_layout);
        llm=new LinearLayoutManager(this);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,stns);
        source.setAdapter(aa);

        ArrayAdapter dest=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,stns);
        destination.setAdapter(dest);

        source.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                 one=stns[i];
                 ss=codes[i];
                if (one.equals("-- select station-- "))
                {
                    Toast.makeText(TrainBWNStations.this, "select valid station", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        destination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                 two=stns[i];
                ss1=codes[i];
                if (two.equals("-- select station-- "))
                {
                    Toast.makeText(TrainBWNStations.this, "select valid station", Toast.LENGTH_SHORT).show();
                }else if (one.equals(two))
                {
                    Toast.makeText(TrainBWNStations.this, "select different stations", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
            }
        });
    }
    public void serach(View v6)
    {
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int mon=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        String d = day + "-0" + (mon + 1) + "-" + year;
        try
        {
            if (MyApplication.isNetworkAvailable(this))
            {
                data_loading_screen_layout.setVisibility(View.VISIBLE);
                ApiService service = ApiClient.getClient().create(ApiService.class);
                //https://api.railwayapi.com/v2/between/source/<stn code>/dest/<stn code>/date/<dd-mm-yyyy>/apikey/msj3v9dlw4/
                Call<TrainBtwnStations> btwnStations = service.trainsBtwnStations("between/source/"+ss+"/dest/" +ss1+"/date/"+d+"/apikey/msj3v9dlw4/");
                btwnStations.enqueue(new Callback<TrainBtwnStations>()
                {
                    @Override
                    public void onResponse(Call<TrainBtwnStations> call, Response<TrainBtwnStations> response)
                    {
                        data_loading_screen_layout.setVisibility(View.GONE);
                        if (response.body().getResponse_code()==200)
                        {
                            mtext.setText(""+response.body().getTotal());
                            TrainBtwnStationsAdapter adapter=new TrainBtwnStationsAdapter(response.body().getTrains(),TrainBWNStations.this);
                            recycler_bwnstns.setAdapter(adapter);
                            recycler_bwnstns.setLayoutManager(llm);
                        }
                        else
                        {
                            Toast.makeText(TrainBWNStations.this, "from 100 case", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<TrainBtwnStations> call, Throwable t) {
                        data_loading_screen_layout.setVisibility(View.GONE);
                        Toast.makeText(TrainBWNStations.this, "something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else
            {
                data_loading_screen_layout.setVisibility(View.GONE);
                Snackbar snackbar = Snackbar
                        .make(TrainBWNStations.this.findViewById(android.R.id.content), "No internet connection! Turn on ", Snackbar.LENGTH_LONG)
                        .setAction("YES", new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View view)
                                    {
                                        TrainBWNStations.this.startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                                    }
                                }
                        );
                snackbar.show();
            }
        }catch (Exception e)
        {
        }
    }
}
