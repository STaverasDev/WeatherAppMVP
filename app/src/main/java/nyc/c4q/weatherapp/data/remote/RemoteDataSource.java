package nyc.c4q.weatherapp.data.remote;

import java.util.List;

import nyc.c4q.weatherapp.Token.Token;
import nyc.c4q.weatherapp.data.DarkSkyAPI;
import nyc.c4q.weatherapp.data.DataSource;
import nyc.c4q.weatherapp.model.Data;
import nyc.c4q.weatherapp.model.Weather;
import nyc.c4q.weatherapp.util.threading.MainUiThread;
import nyc.c4q.weatherapp.util.threading.ThreadExecutor;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Shant on 4/19/2018.
 */

public class RemoteDataSource extends DataSource {

    public static final String API_TOKEN = Token.getToken();
    public static final String BASE_API_URL = "https://api.darksky.net/";
    public static final String FORECAST_ENDPOINT = "/forecast/";
    public static final String QUERY_PARAM_COORD = "cord";
    public static final String QUERY_PARAM_EXCLUDE = "exclude";

    private static RemoteDataSource remoteDataSource;

    private DarkSkyAPI apiService;

    private RemoteDataSource(MainUiThread mainUiThread,
                             ThreadExecutor threadExecuter, DarkSkyAPI apiService) {
        super(mainUiThread, threadExecuter);
        this.apiService = apiService;
    }

    public static synchronized RemoteDataSource getInstance(MainUiThread mainUiThread,
                                                            ThreadExecutor threadExecutor,
                                                            DarkSkyAPI apiService) {
        if (remoteDataSource == null) {
            remoteDataSource = new RemoteDataSource(mainUiThread, threadExecutor, apiService);

        }
        return remoteDataSource;
    }

    @Override
    public void getWeather(final GetWeather weather) {
        String excludeString = "minutely,daily,alerts";
        String coords = "42.3601,-71.0589";

        retrofit2.Call<Weather> call = apiService.getWeather(coords,API_TOKEN,excludeString);

        call.enqueue(new retrofit2.Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if(response.isSuccessful()){
                    Weather weatherResponse = response.body();
                    weather.onSuccess(weatherResponse.getHourly().getData());
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                t.printStackTrace();


            }
        });

    }
}
