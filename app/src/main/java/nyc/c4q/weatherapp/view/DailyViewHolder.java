package nyc.c4q.weatherapp.view;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.weatherapp.R;
import nyc.c4q.weatherapp.model.Currently;
import nyc.c4q.weatherapp.model.Data;

/**
 * Created by Shant on 4/21/2018.
 */

public class DailyViewHolder extends RecyclerView.ViewHolder{

    TextView date;
    TextView day;
    TextView low;
    TextView avg;
    TextView high;
    ConstraintLayout layout;

    public DailyViewHolder(View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.daily_date);
        day = itemView.findViewById(R.id.daily_day);
        low = itemView.findViewById(R.id.daily_low);
        avg = itemView.findViewById(R.id.daily_avg);
        high = itemView.findViewById(R.id.daily_high);
        layout = itemView.findViewById(R.id.daily_layout);
    }

    public void onBind(Data data){

    }
}
