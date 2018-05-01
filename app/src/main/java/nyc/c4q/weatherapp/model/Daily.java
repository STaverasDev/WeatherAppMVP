package nyc.c4q.weatherapp.model;

/**
 * Created by Shant on 4/21/2018.
 */

public class Daily {
    private String icon;
    private Data data;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
