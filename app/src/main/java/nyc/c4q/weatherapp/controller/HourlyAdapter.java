package nyc.c4q.weatherapp.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.weatherapp.R;
import nyc.c4q.weatherapp.model.Data;
import nyc.c4q.weatherapp.view.HourlyViewHolder;

/**
 * Created by Shant on 12/13/2017.
 */

public class HourlyAdapter extends RecyclerView.Adapter<HourlyViewHolder> {

    List<Data> hourlyData;

    public HourlyAdapter(List<Data> hourlyData) {
        this.hourlyData = hourlyData;
    }

    @Override
    public HourlyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.hourly_item_view,parent,false);
        return new HourlyViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(HourlyViewHolder holder, int position) {
        Data data = hourlyData.get(position);
        holder.onBind(data);

    }

    @Override
    public int getItemCount() {
        return hourlyData.size();
    }
}
