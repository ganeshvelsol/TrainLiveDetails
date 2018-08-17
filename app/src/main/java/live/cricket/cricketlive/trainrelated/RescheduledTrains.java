package live.cricket.cricketlive.trainrelated;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Calendar;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.helpers.ApiClient;
import live.cricket.cricketlive.helpers.ApiService;
import live.cricket.cricketlive.helpers.MyApplication;
import live.cricket.cricketlive.responses.RescheduledTrainsResponse;
import live.cricket.cricketlive.trainadapters.RescheduledTrainAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RescheduledTrains extends AppCompatActivity
{
    RecyclerView recycler_rescheduled;
    LinearLayoutManager llm;
    LinearLayout data_empty_layout;
    int year,month,date;
    String d;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rescheduled_trains);
        recycler_rescheduled=(RecyclerView)findViewById(R.id.recycler_rescheduled);
        llm=new LinearLayoutManager(this);
        data_empty_layout=(LinearLayout)findViewById(R.id.data_empty_layout);
        Calendar cc=Calendar.getInstance();
        year=cc.get(Calendar.YEAR);
        month=cc.get(Calendar.MONTH);
        date=cc.get(Calendar.DAY_OF_MONTH);
        d=""+date+"-"+(month+1)+"-"+year;
        reshceduledBundies();
    }
    public void reshceduledBundies()
    {
        if (MyApplication.isNetworkAvailable(this))
        {
            ApiService service = ApiClient.getClient().create(ApiService.class);
            Call<RescheduledTrainsResponse> resch= service.rescheduledTrains("rescheduled/date/"+d+"/apikey/msj3v9dlw4/");
            resch.enqueue(new Callback<RescheduledTrainsResponse>() {
                @Override
                public void onResponse(Call<RescheduledTrainsResponse> call, Response<RescheduledTrainsResponse> response)
                {
                    if (response.body().getResponse_code()==200)
                    {
                        //call adapter here
                        RescheduledTrainAdapter adapter=new RescheduledTrainAdapter(response.body().getTrains(),RescheduledTrains.this);
                        recycler_rescheduled.setAdapter(adapter);
                        recycler_rescheduled.setLayoutManager(llm);
                    }
                    else
                    {
                        data_empty_layout.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onFailure(Call<RescheduledTrainsResponse> call, Throwable t)
                {
                    Snackbar ss=Snackbar.make(RescheduledTrains.this.findViewById(android.R.id.content),"something went  wrong",Snackbar.LENGTH_LONG);
                    ss.show();
                }
            });
        }
        else
        {
            Snackbar ss=Snackbar.make(RescheduledTrains.this.findViewById(android.R.id.content),"no! internet connection",Snackbar.LENGTH_LONG);
            ss.show();
        }
    }
}
