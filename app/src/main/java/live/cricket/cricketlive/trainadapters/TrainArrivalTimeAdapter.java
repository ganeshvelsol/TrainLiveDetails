package live.cricket.cricketlive.trainadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.models.Train;

/**
 * Created by Velsol 170016 on 8/16/2018.
 */

public class TrainArrivalTimeAdapter extends RecyclerView.Adapter<TrainArrivalTimeAdapter.ViewHolders>
{
    List<Train> trains;
    Context context;

    public TrainArrivalTimeAdapter(List<Train> trains, Context context) {
        this.trains = trains;
        this.context = context;
    }

    @Override
    public TrainArrivalTimeAdapter.ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.train_arrv_timings, parent, false);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(TrainArrivalTimeAdapter.ViewHolders holder, int position)
    {
        holder.train_number.setText(""+trains.get(position).getNumber());
        holder.sch_arrival.setText(""+trains.get(position).getScharr());
        holder.acctl_arrival.setText(""+trains.get(position).getActarr());
        holder.sch_departure.setText(""+trains.get(position).getSchdep());
        holder.train_name.setText(""+trains.get(position).getName());
        holder.actl_departure.setText(""+trains.get(position).getActdep());
        holder.delay_arrival.setText(""+trains.get(position).getDelayarr());
        holder.delay_departure.setText(""+trains.get(position).getDelaydep());

    }

    @Override
    public int getItemCount() {
        return trains.size();
    }
    class ViewHolders extends RecyclerView.ViewHolder
    {
        TextView train_number,sch_arrival,acctl_arrival,sch_departure,train_name,actl_departure,delay_arrival,delay_departure;
        public ViewHolders(View itemView)
        {
            super(itemView);
            train_number=(TextView)itemView.findViewById(R.id.train_number);
            sch_arrival=(TextView)itemView.findViewById(R.id.sch_arrival);
            acctl_arrival=(TextView)itemView.findViewById(R.id.acctl_arrival);
            sch_departure=(TextView)itemView.findViewById(R.id.sch_departure);
            train_name=(TextView)itemView.findViewById(R.id.train_name);
            actl_departure=(TextView)itemView.findViewById(R.id.actl_departure);
            delay_arrival=(TextView)itemView.findViewById(R.id.delay_arrival);
            delay_departure=(TextView)itemView.findViewById(R.id.delay_departure);
        }
    }
}
