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
import live.cricket.cricketlive.adapter.MatchListAdapter;
import live.cricket.cricketlive.models.Route;

/**
 * Created by Velsol 170016 on 8/10/2018.
 */

public class LiveTrainRouteAdapter extends RecyclerView.Adapter<LiveTrainRouteAdapter.ViewHolders>
{
    List<Route> route;
    Context context;

    public LiveTrainRouteAdapter(List<Route> route, Context context) {
        this.route = route;
        this.context = context;
    }

    @Override
    public LiveTrainRouteAdapter.ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.live_station, parent, false);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(LiveTrainRouteAdapter.ViewHolders holder, int position)
    {

           holder.has_departured.setText(""+route.get(position).getHas_departed());
           holder.sch_arr_date.setText(""+route.get(position).getScharr_date());
           holder.sch_dep.setText(""+route.get(position).getSchdep());
           holder.station_name.setText(""+route.get(position).getStation().getName());
           holder.status.setText(""+route.get(position).getStatus());
           holder.distance.setText(""+route.get(position).getDistance());
           holder.delay_min.setText(""+route.get(position).getLatemin()+"minutes");
           holder.act_arr_date.setText(""+route.get(position).getActarr_date());
           holder.has_arrived.setText(""+route.get(position).getHas_arrived());
           holder.act_arrival.setText(""+route.get(position).getActarr());

   }

    @Override
    public int getItemCount() {
        return route.size();
    }
    class ViewHolders extends RecyclerView.ViewHolder
    {
        TextView has_departured,sch_arr_date,sch_dep,station_name,status,distance,delay_min,act_arr_date,
        has_arrived,act_arrival;
        public ViewHolders(View itemView)
        {
            super(itemView);
            has_departured=(TextView)itemView.findViewById(R.id.has_departured);
            sch_arr_date=(TextView)itemView.findViewById(R.id.sch_arr_date);
            sch_dep=(TextView)itemView.findViewById(R.id.sch_dep);
            station_name=(TextView)itemView.findViewById(R.id.station_name);
            status=(TextView)itemView.findViewById(R.id.status);
            distance=(TextView)itemView.findViewById(R.id.distance);
            delay_min=(TextView)itemView.findViewById(R.id.delay_min);
            act_arr_date=(TextView)itemView.findViewById(R.id.act_arr_date);
            has_arrived=(TextView)itemView.findViewById(R.id.has_arrived);
            act_arrival=(TextView)itemView.findViewById(R.id.act_arrival);

        }
    }
}
