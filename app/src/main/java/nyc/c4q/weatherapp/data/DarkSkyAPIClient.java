package nyc.c4q.weatherapp.data;

import android.util.Log;

import nyc.c4q.weatherapp.Token.Token;
import nyc.c4q.weatherapp.model.Hourly;
import nyc.c4q.weatherapp.model.Weather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shant on 12/13/2017.
 */

public class DarkSkyAPIClient implements Callback<Weather> {

    final static String TAG ="WEATHER CHECK";
    final static String token = new Token().getToken();
    final static String BASE_URL = "https://api.darksky.net";

    Weather weather;
    Hourly hourly;

    public void start(String location,String excludeString){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DarkSkyAPI darkSkyAPI = retrofit.create(DarkSkyAPI.class);
        Call<Weather> call = darkSkyAPI.getWeather(location,token,excludeString);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Weather> call, Response<Weather> response) {
        if(response.isSuccessful()){
            weather = response.body();
            hourly = (Hourly) weather.getHourly();
            Log.d(TAG,weather.getTimezone());
        }
    }

    @Override
    public void onFailure(Call<Weather> call, Throwable t) {
        t.printStackTrace();
    }

    public Weather getWeather() {
        return weather;
    }
}
