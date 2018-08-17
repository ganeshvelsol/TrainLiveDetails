package live.cricket.cricketlive.trainadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.models.Route;
import live.cricket.cricketlive.models.Train;

/**
 * Created by Velsol 170016 on 8/10/2018.
 */

public class TrainRouteAdapter extends RecyclerView.Adapter<TrainRouteAdapter.ViewHolders>
{
    List<Route> route;
    Context context;
    Train train;

    public TrainRouteAdapter(List<Route> route, Context context) {
        this.route = route;
        this.context = context;
    }

    @Override
    public TrainRouteAdapter.ViewHolders onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_train_routes, parent, false);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(TrainRouteAdapter.ViewHolders holder, int position)
    {

        holder.sch_arrival.setText(""+route.get(position).getScharr());
        holder.stn_name.setText(""+route.get(position).getStation().getName());
        holder.sch_dep.setText(""+route.get(position).getSchdep());
        holder.dist.setText(""+route.get(position).getDistance());
        holder.st_no.setText(""+route.get(position).getNo());
        holder.halts.setText(""+route.get(position).getHalt());

    }

    @Override
    public int getItemCount()
    {
        return route.size();
    }
    class ViewHolders extends RecyclerView.ViewHolder
    {
        TextView sch_arrival,stn_name,sch_dep,dist,st_no,halts;
        public ViewHolders(View itemView)
        {
            super(itemView);
            sch_arrival=(TextView)itemView.findViewById(R.id.sch_arrival);
            stn_name=(TextView)itemView.findViewById(R.id.stn_name);
            sch_dep=(TextView)itemView.findViewById(R.id.sch_dep);
            dist=(TextView)itemView.findViewById(R.id.dist);
            st_no=(TextView)itemView.findViewById(R.id.st_no);
            halts=(TextView)itemView.findViewById(R.id.halts);
        }
    }
}
