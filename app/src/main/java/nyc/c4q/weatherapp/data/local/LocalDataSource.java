package nyc.c4q.weatherapp.data.local;

import android.database.sqlite.SQLiteDatabase;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

import java.util.List;

import nyc.c4q.weatherapp.data.DataSource;
import nyc.c4q.weatherapp.model.Data;
import nyc.c4q.weatherapp.model.Weather;
import nyc.c4q.weatherapp.util.threading.MainUiThread;
import nyc.c4q.weatherapp.util.threading.ThreadExecutor;

/**
 * Created by Shant on 4/29/2018.
 */

public class LocalDataSource extends DataSource {

    private static LocalDataSource localDataSource;
    private DatabaseDefinition databaseDefinition;

    private LocalDataSource(MainUiThread mainUiThread, ThreadExecutor threadExecutor,
                            DatabaseDefinition databaseDefinition) {
        super(mainUiThread, threadExecutor);
        this.databaseDefinition = databaseDefinition;
    }

    public static synchronized LocalDataSource getInstance(MainUiThread mainUiThread,
                                                           ThreadExecutor threadExecutor,
                                                           DatabaseDefinition databaseDefinition) {
        if (localDataSource == null) {
            localDataSource = new LocalDataSource(mainUiThread, threadExecutor, databaseDefinition);
        }
        return localDataSource;
    }

    @Override
    public void getWeather(final GetWeather weather) {
        threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                final List<Data> data = SQLite.select().
                        from(Data.class).
                        queryList();


                mainUiThread.post(new Runnable() {
                    @Override
                    public void run() {
                        weather.onSuccess(data);

                    }
                });
            }
        });
    }

    public void storeWeather(final List<Data> data) {
        Transaction transaction = databaseDefinition.beginTransactionAsync(
                new ITransaction() {
                    @Override
                    public void execute(DatabaseWrapper databaseWrapper) {
                        for (Data d : data) {
                            d.save();
                        }
                    }
                }).build();
        transaction.execute();

    }
}
