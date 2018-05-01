package nyc.c4q.weatherapp.data.local;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Shant on 4/29/2018.
 */

@Database(name = LocalDatabase.NAME, version = LocalDatabase.VERSION)
public class LocalDatabase {
    public static final String  NAME = "WeatherDB";
    public static final int VERSION = 2;

}
