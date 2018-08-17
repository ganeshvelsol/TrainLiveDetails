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
import android.widget.RelativeLayout;
import android.widget.Toast;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.helpers.ApiClient;
import live.cricket.cricketlive.helpers.ApiService;
import live.cricket.cricketlive.helpers.MyApplication;
import live.cricket.cricketlive.models.Train;
import live.cricket.cricketlive.responses.TrainRouteResponse;
import live.cricket.cricketlive.trainadapters.TrainRouteAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainRoute extends AppCompatActivity
{
    RecyclerView relative_train_route;
    EditText train_number;
    LinearLayoutManager llm;
    LinearLayout data_loading_screen_layout;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_route);
        relative_train_route=findViewById(R.id.relative_train_route);
        train_number=(EditText)findViewById(R.id.train_number);
        llm=new LinearLayoutManager(this);
        data_loading_screen_layout=(LinearLayout)findViewById(R.id.data_loading_screen_layout);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //read data from the edittexts
                respondToIt();
            }
        });
    }
    public void respondToIt()
    {

        String tno=train_number.getText().toString().trim();
        if (tno.isEmpty())
        {
            train_number.setError("enter number");
            train_number.requestFocus();
        }
        else
            {
                if (MyApplication.isNetworkAvailable(this)) {
                    data_loading_screen_layout.setVisibility(View.VISIBLE);
                    ApiService service = ApiClient.getClient().create(ApiService.class);
                    Call<TrainRouteResponse> routes = service.trainRoute("route/train/" + tno + "/apikey/msj3v9dlw4/");
                    routes.enqueue(new Callback<TrainRouteResponse>() {
                        @Override
                        public void onResponse(Call<TrainRouteResponse> call, Response<TrainRouteResponse> response) {
                            data_loading_screen_layout.setVisibility(View.GONE);
                            if (response.body().getResponse_code() == 200) {
                                TrainRouteAdapter ta = new TrainRouteAdapter(response.body().getRoute(), TrainRoute.this);
                                relative_train_route.setAdapter(ta);
                                relative_train_route.setLayoutManager(llm);
                            } else {
                                Snackbar sp = Snackbar.make(TrainRoute.this.findViewById(android.R.id.content), "no data found", Snackbar.LENGTH_LONG);
                                sp.show();
                            }
                        }

                        @Override
                        public void onFailure(Call<TrainRouteResponse> call, Throwable t)
                        {
                            data_loading_screen_layout.setVisibility(View.GONE);
                            Snackbar ss = Snackbar.make(TrainRoute.this.findViewById(android.R.id.content), "something went went wrong", Snackbar.LENGTH_LONG);
                            ss.show();
                        }
                    });
                }else
                {
                    data_loading_screen_layout.setVisibility(View.GONE);
                    Snackbar snackbar = Snackbar
                            .make(TrainRoute.this.findViewById(android.R.id.content), "No internet connection! Turn on ", Snackbar.LENGTH_LONG)
                            .setAction("YES", new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view)
                                        {
                                            TrainRoute.this.startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                                        }
                                    }
                            );
                    snackbar.show();
                }
        }
    }
}
