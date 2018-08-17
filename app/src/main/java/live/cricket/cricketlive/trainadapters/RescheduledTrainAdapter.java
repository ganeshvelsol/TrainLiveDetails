package live.cricket.cricketlive.trainadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.models.Train;

/**
 * Created by Velsol 170016 on 8/17/2018.
 */

public class RescheduledTrainAdapter extends RecyclerView.Adapter<RescheduledTrainAdapter.ViewHolderss>
{
    List<Train> trains;
    Context context;

    public RescheduledTrainAdapter(List<Train> trains, Context context)
    {
        this.trains = trains;
        this.context = context;
    }

    @Override
    public RescheduledTrainAdapter.ViewHolderss onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rescheduled_trains_dapot, parent, false);
        return new ViewHolderss(view);
    }
    @Override
    public void onBindViewHolder(RescheduledTrainAdapter.ViewHolderss holder, int position)
    {
        holder.train_name_resch.setText(""+trains.get(position).getName());
        holder.train_number_resch.setText(""+trains.get(position).getNumber());
        holder.train_date_resch.setText(""+trains.get(position).getRescheduled_date());
        holder.train_time_resch.setText(""+trains.get(position).getRescheduled_time());
    }
    @Override
    public int getItemCount()
    {
        return trains.size();
    }
    class ViewHolderss extends RecyclerView.ViewHolder
    {
        TextView train_name_resch,train_number_resch,train_date_resch,train_time_resch;
        LinearLayout llm;
        public ViewHolderss(View itemView)
        {
            super(itemView);
            train_name_resch=(TextView)itemView.findViewById(R.id.train_name_resch);
            train_number_resch=(TextView)itemView.findViewById(R.id.train_number_resch);
            train_date_resch=(TextView)itemView.findViewById(R.id.train_date_resch);
            train_time_resch=(TextView)itemView.findViewById(R.id.train_time_resch);
        }
    }
}
