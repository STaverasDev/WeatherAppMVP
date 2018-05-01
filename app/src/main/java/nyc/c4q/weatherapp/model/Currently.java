package nyc.c4q.weatherapp.model;

/**
 * Created by Shant on 12/13/2017.
 */

public class Currently {
    long time;
    String summary;
    String icon;
    int nearestStormDistance;
    double precipIntensity;
    double precipProbability;
    String precipType;
    double temperature;
    double windSpeed;
    double cloudCover;

    public long getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public int getNearestStormDistance() {
        return nearestStormDistance;
    }

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getCloudCover() {
        return cloudCover;
    }
}
