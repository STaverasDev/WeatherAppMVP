package nyc.c4q.weatherapp.model;

import com.raizlabs.android.dbflow.annotation.Table;

import nyc.c4q.weatherapp.data.local.LocalDatabase;

/**
 * Created by Shant on 12/10/2017.
 */

@Table(database = LocalDatabase.class, allFields = true)
public class Data {

    private String time;
    private String summary;
    private String icon;
    private double precipIntensity;
    private double precipProbability;
    private String precipType;
    private double temperature;
    private double temperatureLow;
    private double temperatureHigh;
    private double apparentTemperature;
    private double humidity;
    private double pressure;
    private double windSpeed;
    private double cloudCover;
    private double visibility;

    public String getPrecipType() {
        return precipType;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public double getVisibility() {
        return visibility;
    }

    public String getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }
}
