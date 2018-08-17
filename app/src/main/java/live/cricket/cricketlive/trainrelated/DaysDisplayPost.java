package live.cricket.cricketlive.trainrelated;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import live.cricket.cricketlive.R;
import live.cricket.cricketlive.helpers.ModelDays;

public class DaysDisplayPost extends AppCompatActivity
{
    String code1,code2,code3,code4,code5,code6,code7;
    String runs1,runs2,runs3,runs4,runs5,runs6,runs7;

    TextView table_day7,table_col7,table_day6,table_col6,table_day5,table_col5,table_day4,table_col4,
            table_day3,table_col3, table_day2,table_col2, table_day1,table_col1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.days_display_post);
        Bundle b=getIntent().getExtras();
        code1=b.getString("code1");
        code2=b.getString("code2");
        code3=b.getString("code3");
        code4=b.getString("code4");
        code5=b.getString("code5");
        code6=b.getString("code6");
        code7=b.getString("code7");

        runs1=b.getString("runs1");
        runs2=b.getString("runs2");
        runs3=b.getString("runs3");
        runs4=b.getString("runs4");
        runs5=b.getString("runs5");
        runs6=b.getString("runs6");
        runs7=b.getString("runs7");

        table_day7=findViewById(R.id.table_day7);
        table_day6=findViewById(R.id.table_day6);
        table_day5=findViewById(R.id.table_day5);
        table_day4=findViewById(R.id.table_day4);
        table_day3=findViewById(R.id.table_day3);
        table_day2=findViewById(R.id.table_day2);
        table_day1=findViewById(R.id.table_day1);

        table_col7=findViewById(R.id.table_col7);
        table_col6=findViewById(R.id.table_col6);
        table_col5=findViewById(R.id.table_col5);
        table_col4=findViewById(R.id.table_col4);
        table_col3=findViewById(R.id.table_col3);
        table_col2=findViewById(R.id.table_col2);
        table_col1=findViewById(R.id.table_col1);

        table_day7.setText(""+code7);
        table_day6.setText(""+code6);
        table_day5.setText(""+code5);
        table_day4.setText(""+code4);
        table_day3.setText(""+code3);
        table_day2.setText(""+code2);
        table_day1.setText(""+code1);

        table_col1.setText(""+runs1);
        table_col2.setText(""+runs2);
        table_col3.setText(""+runs3);
        table_col4.setText(""+runs4);
        table_col5.setText(""+runs5);
        table_col6.setText(""+runs6);
        table_col7.setText(""+runs7);
    }
}
