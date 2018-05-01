package nyc.c4q.weatherapp.model;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by Shant on 12/13/2017.
 */

public class Hourly {
    String summary;
    String icon;
    ArrayList<Data> data;

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public ArrayList<Data> getData() {
        return data;
    }
}
