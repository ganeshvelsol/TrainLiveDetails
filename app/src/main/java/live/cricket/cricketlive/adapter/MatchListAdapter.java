package live.cricket.cricketlive.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.activities.MatchesListAct;
import live.cricket.cricketlive.activities.RespectiveData;
import live.cricket.cricketlive.models.Datum;

/**
 * Created by Velsol 170016 on 7/20/2018.
 */

public class MatchListAdapter extends RecyclerView.Adapter<MatchListAdapter.ViewHolder>
{
    List<Datum> Datum;
    Context context;

    public MatchListAdapter(List<Datum> datum, Context context) {
        Datum = datum;
        this.context = context;
    }

    @Override
    public MatchListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MatchListAdapter.ViewHolder holder, final int position)
    {
       // holder.id.setText(""+Datum.get(position).getUnique_id());
        holder.text1.setText(""+Datum.get(position).getTitle());
        holder.text2.setText(""+Datum.get(position).getDescription());
        holder.linears.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                Intent ss=new Intent(context,RespectiveData.class);
                ss.putExtra("userId",Datum.get(position).getUnique_id());
                context.startActivity(ss);
            }
        });
    }
    @Override
    public int getItemCount() {
        return Datum.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView id,text1,text2;
        LinearLayout linears;
        public ViewHolder(View itemView)
        {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.id);
            text1=(TextView)itemView.findViewById(R.id.text1);
            text2=(TextView)itemView.findViewById(R.id.text2);
            linears=(LinearLayout)itemView.findViewById(R.id.linears);
        }
    }
}
