package live.cricket.cricketlive.trainrelated;

import android.app.SearchManager;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.helpers.ApiClient;
import live.cricket.cricketlive.helpers.ApiService;
import live.cricket.cricketlive.helpers.MyApplication;
import live.cricket.cricketlive.responses.CancelledTrainsResponse;
import live.cricket.cricketlive.trainadapters.CancelledTrainsAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CancelledTrains extends AppCompatActivity
{
    RecyclerView cancelld_recycler;
    TextView cancelled_trian;
    LinearLayout data_empty_layout;
    LinearLayoutManager llm;
    CancelledTrainsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancelled_trains);
        cancelled_trian=(TextView)findViewById(R.id.cancelled_trian);
        data_empty_layout=findViewById(R.id.data_empty_layout);
        cancelld_recycler=(RecyclerView) findViewById(R.id.cancelld_recycler);
        llm=new LinearLayoutManager(this);

        codeForDisplay();
    }
    public void codeForDisplay()
    {
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        String d = day + "-0" + (month + 1) + "-" + year;
        if (MyApplication.isNetworkAvailable(this))
        {
            ApiService service = ApiClient.getClient().create(ApiService.class);
            Call<CancelledTrainsResponse> cancelled= service.cancelledTrains("cancelled/date/"+d+"/apikey/msj3v9dlw4/");
            cancelled.enqueue(new Callback<CancelledTrainsResponse>()
            {
                @Override
                public void onResponse(Call<CancelledTrainsResponse> call, Response<CancelledTrainsResponse> response)
                {
                    if (response.body().getResponse_code()==200)
                    {
                        cancelled_trian.setText(""+response.body().getTotal());
                         adapter=new CancelledTrainsAdapter(response.body().getTrains(),CancelledTrains.this);
                        cancelld_recycler.setAdapter(adapter);
                        cancelld_recycler.setLayoutManager(llm);
                    }
                    else
                    {
                        data_empty_layout.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<CancelledTrainsResponse> call, Throwable t)
                {
                    data_empty_layout.setVisibility(View.VISIBLE);
                    Snackbar ss=Snackbar.make(CancelledTrains.this.findViewById(android.R.id.content),"something went wrong",Snackbar.LENGTH_LONG);
                    ss.show();
                }
            });
        }
        else
        {

        }
    }
}
