package nyc.c4q.weatherapp.data;

import android.support.annotation.MainThread;

import java.util.List;

import nyc.c4q.weatherapp.model.Data;
import nyc.c4q.weatherapp.model.Weather;
import nyc.c4q.weatherapp.util.threading.MainUiThread;
import nyc.c4q.weatherapp.util.threading.ThreadExecutor;

/**
 * Created by Shant on 4/17/2018.
 */

public abstract class DataSource {

    protected MainUiThread mainUiThread;
    protected ThreadExecutor threadExecutor;

    public DataSource(MainUiThread mainUiThread, ThreadExecutor threadExecutor){
        this.mainUiThread = mainUiThread;
        this.threadExecutor = threadExecutor;
    }

    public interface GetWeather {
        void onSuccess(List<Data> hourlyData);

        void onFailure(Throwable throwable);

        void onNetworkFailure();

    }

    public abstract void getWeather(GetWeather weather);





}
