package nyc.c4q.weatherapp.data;

import android.content.Context;

import nyc.c4q.weatherapp.Token.Token;
import nyc.c4q.weatherapp.model.Data;
import nyc.c4q.weatherapp.model.Weather;
import nyc.c4q.weatherapp.util.threading.NetworkHelper;

/**
 * Created by Shant on 4/17/2018.
 */

public class DataRepository {

    private DataSource localDataSource;
    private DataSource remoteDataSource;
    private NetworkHelper networkHelper;

    private static DataRepository dataRepository;

    public DataRepository(DataSource remoteDataSource,
                          DataSource localDataSource,
                          NetworkHelper networkHelper) {
        this.remoteDataSource = remoteDataSource;
        this.networkHelper = networkHelper;
        this.localDataSource = localDataSource;
    }

    public static synchronized DataRepository getInstance(DataSource remoteDataSource,DataSource localDataSource,
                                                          NetworkHelper networkHelper) {
        if (dataRepository == null) {
            dataRepository = new DataRepository(remoteDataSource,localDataSource, networkHelper);
        }
        return dataRepository;
    }

    public void getWeather(Context context, final DataSource.GetWeather callback) {
        if (networkHelper.isNetworkAvailable(context)) {
            remoteDataSource.getWeather(new DataSource.GetWeather() {
                @Override
                public void onSuccess(Weather weather) {
                    callback.onSuccess(weather);

                }

                @Override
                public void onFailure(Throwable throwable) {
                    callback.onFailure(throwable);

                }

                @Override
                public void onNetworkFailure() {
                    callback.onNetworkFailure();

                }
            });
        }

    }

    public void destroyInstance() {
        dataRepository = null;
    }

}
