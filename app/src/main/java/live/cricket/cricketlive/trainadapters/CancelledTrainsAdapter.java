package live.cricket.cricketlive.trainadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.models.Train;

/**
 * Created by Velsol 170016 on 8/16/2018.
 */

public class CancelledTrainsAdapter extends RecyclerView.Adapter<CancelledTrainsAdapter.ViewHolderss>
{
    List<Train> trains;
    Context context;

    public CancelledTrainsAdapter(List<Train> trains, Context context) {
        this.trains = trains;
        this.context = context;
    }

    @Override
    public CancelledTrainsAdapter.ViewHolderss onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cancel_train_adapter, parent, false);
        return new ViewHolderss(view);
    }

    @Override
    public void onBindViewHolder(CancelledTrainsAdapter.ViewHolderss holder, int position)
    {
        holder.cancelled_name.setText(""+trains.get(position).getName());
        holder.cancelled_number.setText(""+trains.get(position).getNumber());
        holder.cancelled_type.setText(""+trains.get(position).getType());
        holder.cancelled_source_name.setText(""+trains.get(position).getSource().getName());
        holder.cancelled_destin_name.setText(""+trains.get(position).getDest().getName());

    }

    @Override
    public int getItemCount() {
        return trains.size();
    }



    class ViewHolderss extends RecyclerView.ViewHolder
    {
        TextView cancelled_name,cancelled_number,cancelled_type,cancelled_source_name,cancelled_destin_name;
        public ViewHolderss(View itemView)
        {
            super(itemView);
            cancelled_name=(TextView)itemView.findViewById(R.id.cancelled_name);
            cancelled_number=(TextView)itemView.findViewById(R.id.cancelled_number);
            cancelled_type=(TextView)itemView.findViewById(R.id.cancelled_type);
            cancelled_source_name=(TextView)itemView.findViewById(R.id.cancelled_source_name);
            cancelled_destin_name=(TextView)itemView.findViewById(R.id.cancelled_destin_name);
        }
    }
}
