package nyc.c4q.weatherapp.ui;

import nyc.c4q.weatherapp.data.DataRepository;
import nyc.c4q.weatherapp.util.threading.MainUiThread;
import nyc.c4q.weatherapp.util.threading.ThreadExecutor;

/**
 * Created by Shant on 4/26/2018.
 */

public class DailyWeatherPresenter implements IDailyWeatherContract.Presenter {

    private DataRepository dataRepository;
    private ThreadExecutor threadExecutor;
    private MainUiThread mainUiThread;

    public DailyWeatherPresenter(IDailyWeatherContract.View view,
                                 DataRepository dataRepository, ThreadExecutor threadExecutor,
                                 MainUiThread mainUiThread){
        this.dataRepository = dataRepository;
        this.threadExecutor = threadExecutor;
        this.mainUiThread = mainUiThread;
    }

    @Override
    public void goToHourly() {

    }
}
