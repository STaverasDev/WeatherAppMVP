package nyc.c4q.weatherapp.model;

/**
 * Created by Shant on 12/10/2017.
 */

public class Weather {
    double latitude;
    double longitude;
    String timezone;
    Currently currently;
    Hourly hourly;
    Daily daily;

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public Currently getCurrently() {
        return currently;
    }

    public Hourly getHourly() {
        return hourly;
    }
}
