package nyc.c4q.weatherapp.ui;

import java.util.List;

import nyc.c4q.weatherapp.model.Data;

/**
 * Created by Shant on 4/26/2018.
 */

public interface IDailyWeatherContract {

    interface View {

        void showDailyWeather(List<Data> weather);

    }

    interface Presenter {

        void goToHourly();

    }
}
