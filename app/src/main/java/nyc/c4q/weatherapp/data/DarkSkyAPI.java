package nyc.c4q.weatherapp.data;

import nyc.c4q.weatherapp.Token.Token;
import nyc.c4q.weatherapp.model.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Shant on 12/10/2017.
 */

public interface DarkSkyAPI {


    //Modify call by specifying location in lat,long string and excluded fields separated by comma
    @GET("/forecast/{token}/{cord}/")
    Call<Weather> getWeather(@Path("cord") String coordinates,@Path("token") String token, @Query("exclude") String excludeString);




}
