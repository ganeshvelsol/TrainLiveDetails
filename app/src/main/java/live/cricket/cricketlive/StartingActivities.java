package live.cricket.cricketlive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import live.cricket.cricketlive.trainrelated.CancelledTrains;
import live.cricket.cricketlive.trainrelated.LiveTrainStatus;
import live.cricket.cricketlive.trainrelated.RescheduledTrains;
import live.cricket.cricketlive.trainrelated.TrainArrivalTime;
import live.cricket.cricketlive.trainrelated.TrainBWNStations;
import live.cricket.cricketlive.trainrelated.TrainRoute;

public class StartingActivities extends AppCompatActivity
{
    CardView trainroute,live_train_status,train_btw_stations,train_arrival_time_gap,
            train_cancelled,train_rescheduled;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_activities);

        trainroute=(CardView)findViewById(R.id.trainroute);
        live_train_status=(CardView)findViewById(R.id.live_train_status);
        train_btw_stations=(CardView)findViewById(R.id.train_btw_stations);
        train_arrival_time_gap=(CardView)findViewById(R.id.train_arrival_time_gap);
        train_cancelled=(CardView)findViewById(R.id.train_cancelled);
        train_rescheduled=(CardView)findViewById(R.id.train_rescheduled);
        trainroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartingActivities.this, TrainRoute.class));
            }
        });
        train_btw_stations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartingActivities.this, TrainBWNStations.class));
            }
        });
        live_train_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartingActivities.this, LiveTrainStatus.class));
            }
        });
        train_arrival_time_gap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(StartingActivities.this,TrainArrivalTime.class));
            }
        });
        train_cancelled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(StartingActivities.this, CancelledTrains.class));
            }
        });
        train_rescheduled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartingActivities.this,RescheduledTrains.class));
            }
        });

    }
}
