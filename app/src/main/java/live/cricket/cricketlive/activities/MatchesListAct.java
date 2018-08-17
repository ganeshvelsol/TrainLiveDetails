package live.cricket.cricketlive.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.adapter.MatchListAdapter;
import live.cricket.cricketlive.helpers.ApiClient;
import live.cricket.cricketlive.helpers.ApiService;
import live.cricket.cricketlive.responses.MatchResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchesListAct extends AppCompatActivity
{
    RecyclerView recycler;
    LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matches_list);
        recycler=(RecyclerView)findViewById(R.id.recycler);
        llm=new LinearLayoutManager(this);
        ApiService service= ApiClient.getClient().create(ApiService.class);
        Call<MatchResponse> matches= service.matchesResponse();
        matches.enqueue(new Callback<MatchResponse>()
        {
            @Override
            public void onResponse(Call<MatchResponse> call, Response<MatchResponse> response)
            {
                try
                {
                    if (response.body().getCache2()==true)
                    {
                        MatchListAdapter adapter=new MatchListAdapter(response.body().getDatum(),MatchesListAct.this);
                        recycler.setAdapter(adapter);
                        recycler.setLayoutManager(llm);
                    }
                    else
                    {
                        Toast.makeText(MatchesListAct.this, "from else", Toast.LENGTH_SHORT).show();
                        MatchListAdapter adapter=new MatchListAdapter(response.body().getDatum(),MatchesListAct.this);
                        recycler.setAdapter(adapter);
                        recycler.setLayoutManager(llm);
                    }
                }catch (Exception e)
                {
                    Toast.makeText(MatchesListAct.this, "server down", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MatchResponse> call, Throwable t)
            {
                Toast.makeText(MatchesListAct.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
