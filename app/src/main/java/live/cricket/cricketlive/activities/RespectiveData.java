package live.cricket.cricketlive.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.helpers.ApiClient;
import live.cricket.cricketlive.helpers.ApiClient2;
import live.cricket.cricketlive.helpers.ApiService;
import live.cricket.cricketlive.responses.ResponseData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RespectiveData extends AppCompatActivity
{
    TextView score,desc,times,team_one,team_two,vins,total;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.respective_data);
        Bundle b=getIntent().getExtras();
        id=(b.getString("userId"));
        initVies();
    }
    public void initVies()
    {
        score=(TextView)findViewById(R.id.score);
        desc=(TextView)findViewById(R.id.desc);
        times=(TextView)findViewById(R.id.times);
        team_one=(TextView)findViewById(R.id.team_one);
        team_two=(TextView)findViewById(R.id.team_two);
        vins=(TextView)findViewById(R.id.vins);
        total=(TextView)findViewById(R.id.total);
        ApiService ser= ApiClient2.getClient().create(ApiService.class);
        Call<ResponseData> data=ser.individuals(id);
        data.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response)
            {
                if (response.body().getCreditsLeft()==250)
                {
                    score.setText(""+response.body().getScore());
                    desc.setText(""+response.body().getDescription());
                    times.setText(""+response.body().getMatchStarted());
                    team_one.setText(""+response.body().getTeam1());
                    team_two.setText(""+response.body().getTeam2());
                    vins.setText(""+response.body().getV());
                    total.setText(""+response.body().getTtl());
                }
                else
                {
                    Toast.makeText(RespectiveData.this, "from total", Toast.LENGTH_SHORT).show();
                    score.setText(""+response.body().getScore());
                    desc.setText(""+response.body().getDescription());
                    times.setText(""+response.body().getMatchStarted());
                    team_one.setText(""+response.body().getTeam1());
                    team_two.setText(""+response.body().getTeam2());
                    vins.setText(""+response.body().getV());
                    total.setText(""+response.body().getTtl());
                }
            }
            @Override
            public void onFailure(Call<ResponseData> call, Throwable t)
            {
                Toast.makeText(RespectiveData.this, ""+t, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
