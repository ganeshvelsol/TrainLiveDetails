package live.cricket.cricketlive.trainadapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.helpers.ModelDays;
import live.cricket.cricketlive.models.Train;
import live.cricket.cricketlive.models.days;
import live.cricket.cricketlive.trainrelated.DaysDisplayPost;

/**
 * Created by Velsol 170016 on 8/13/2018.
 */

public class TrainBtwnStationsAdapter extends RecyclerView.Adapter<TrainBtwnStationsAdapter.ViewHolders>
{
    List<Train> trains;
    Context context;

    public TrainBtwnStationsAdapter(List<Train> trains, Context context )
    {
        this.trains = trains;
        this.context = context;
    }

    @Override
    public TrainBtwnStationsAdapter.ViewHolders onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.btwm_stations_adapter, parent, false);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(final TrainBtwnStationsAdapter.ViewHolders holder, final int position)
    {
        holder.train_name.setText(""+trains.get(position).getName());
        holder.from_station.setText(""+trains.get(position).getFrom_station().getName());
        holder.to_station.setText(""+trains.get(position).getTo_station().getName());
        holder.travel_time.setText(""+trains.get(position).getTravel_time());
        holder.train_number.setText(""+trains.get(position).getNumber());
        holder.arrival_time.setText(""+trains.get(position).getDest_arrival_time());
        holder.visible_days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent ss=new Intent(context,DaysDisplayPost.class);
                ss.putExtra("code1",""+trains.get(position).getDays().get(0).getCode());
                ss.putExtra("runs1",""+trains.get(position).getDays().get(0).getRuns());

                ss.putExtra("code2",""+trains.get(position).getDays().get(1).getCode());
                ss.putExtra("runs2",""+trains.get(position).getDays().get(1).getRuns());

                ss.putExtra("code3",""+trains.get(position).getDays().get(2).getCode());
                ss.putExtra("runs3",""+trains.get(position).getDays().get(2).getRuns());

                ss.putExtra("code4",""+trains.get(position).getDays().get(3).getCode());
                ss.putExtra("runs4",""+trains.get(position).getDays().get(3).getRuns());

                ss.putExtra("code5",""+trains.get(position).getDays().get(4).getCode());
                ss.putExtra("runs5",""+trains.get(position).getDays().get(4).getRuns());

                ss.putExtra("code6",""+trains.get(position).getDays().get(5).getCode());
                ss.putExtra("runs6",""+trains.get(position).getDays().get(5).getRuns());

                ss.putExtra("code7",""+trains.get(position).getDays().get(6).getCode());
                ss.putExtra("runs7",""+trains.get(position).getDays().get(6).getRuns());

                context.startActivity(ss);
            }
        });

    }
    @Override
    public int getItemCount()
    {
        return trains.size();
    }
    class ViewHolders extends RecyclerView.ViewHolder
    {
        TextView from_station,to_station,travel_time,train_number,arrival_time,train_name,visible_days;
        LinearLayout liner_layout;
        public ViewHolders(View itemView)
        {
            super(itemView);
            from_station=(TextView)itemView.findViewById(R.id.from_station);
            to_station=(TextView)itemView.findViewById(R.id.to_station);
            travel_time=(TextView)itemView.findViewById(R.id.travel_time);
            train_number=(TextView)itemView.findViewById(R.id.train_number);
            arrival_time=(TextView)itemView.findViewById(R.id.arrival_time);
            train_name=(TextView)itemView.findViewById(R.id.train_name);
            visible_days=(TextView)itemView.findViewById(R.id.visible_days);

            liner_layout=(LinearLayout)itemView.findViewById(R.id.liner_layout);
        }
    }
}
