package nyc.c4q.weatherapp;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import nyc.c4q.weatherapp.controller.DailyAdapter;
import nyc.c4q.weatherapp.data.DarkSkyAPIClient;
import nyc.c4q.weatherapp.controller.HourlyAdapter;
import nyc.c4q.weatherapp.model.Data;
import nyc.c4q.weatherapp.model.Hourly;
import nyc.c4q.weatherapp.model.Weather;
import nyc.c4q.weatherapp.ui.IDailyWeatherContract;

public class MainActivity extends AppCompatActivity implements IDailyWeatherContract.View{
    final static String TAG = "DATA CHECK: ";
    final static String excludeString = "minutely,alerts";
    Weather weather;
    Hourly hourly;
    String coords = "42.3601,-71.0589";

    HourlyAdapter hourlyAdapter;
    DarkSkyAPIClient client;
    private List<Data> dataList;
    private IDailyWeatherContract.Presenter presenter;
    private DailyAdapter dailyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApiCall();

    }

    public void getApiCall(){
        client = new DarkSkyAPIClient();
        client.start(coords,excludeString);
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        Log.d(TAG,"STARTING TO SET VARIABLES");
                        setVariables();
                    }
                }, 2000
        );
    }

    public void setVariables(){
        weather = client.getWeather();
        hourly = weather.getHourly();
        dataList = hourly.getData();
        Log.d(TAG,dataList.size()+"");
        for(Data d:dataList){
            Log.d(TAG,"icon: "+d.getIcon());
        }

        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            public void run() {
                setRecView();
            }
        });
    }

    public void setRecView(){
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.hourly_rec_view);
        hourlyAdapter = new HourlyAdapter(dataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(hourlyAdapter);

    }

    @Override
    public void showDailyWeather(List<Data> weather) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
