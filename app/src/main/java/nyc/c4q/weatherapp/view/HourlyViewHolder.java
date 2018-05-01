package nyc.c4q.weatherapp.view;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.c4q.weatherapp.R;
import nyc.c4q.weatherapp.model.Data;

/**
 * Created by Shant on 12/13/2017.
 */

public class HourlyViewHolder extends RecyclerView.ViewHolder {

    TextView timeTextView;
    TextView tempTextView;
    ConstraintLayout layout;

    public HourlyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
        timeTextView = (TextView) itemView.findViewById(R.id.time);
        tempTextView = (TextView) itemView.findViewById(R.id.hourly_temp);
        layout = (ConstraintLayout) itemView.findViewById(R.id.hourly_layout);

    }

    public void onBind(Data data) {

        String timeValue = data.getTime();
        long timeLong = Long.parseLong(timeValue);
        String finalTime = UnixToTime(timeLong);
        timeTextView.setText(finalTime);
        String tempValue = (String) Double.toString(Math.round(data.getApparentTemperature()));
        tempTextView.setText(tempValue);

    }

    public String UnixToTime(long unix) {
        //Convert UNIX date format to UTC-4 format, 12 hour timeTextView
        Date date = new Date(unix * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC-4"));
        String formattedTime = sdf.format(date);
        return formattedTime;
    }

    public String getIconImage(String s) {
        //Return image url based on String value of iconImageView field in data model
        String imgUrl;
        switch (s) {
            case "fog":
                imgUrl = "https://cdn4.iconfinder.com/data/icons/wthr/32/659098-cloud-fog-512.png";
                break;
            case "clear-day":
                imgUrl = "https://cdn1.iconfinder.com/data/icons/weather-elements/512/Weather_SunAbstract.png";
                break;
            case "clear-night":
                imgUrl = "https://d30y9cdsu7xlg0.cloudfront.net/png/141494-200.png";
                break;
            case "partly-cloudy-day":
                imgUrl = "http://icons.iconarchive.com/icons/icons8/android/512/Weather-Partly-Cloudy-Day-icon.png";
                break;
            case "partly-cloudy-night":
                imgUrl = "http://icons.iconarchive.com/icons/icons8/android/512/Weather-Partly-Cloudy-Night-icon.png";
                break;
            case "cloudy":
                imgUrl = "http://icon-park.com/imagefiles/simple_weather_icons2_cloudy.png";
                break;
            case "rain":
                imgUrl = "https://cdn3.iconfinder.com/data/icons/weather-16/256/Rainy_Day-512.png";
                break;
            case "sleet":
                imgUrl = "http://moziru.com/images/snow-clipart-rain-and-snow-18.png";
                break;
            case "snow":
                imgUrl = "http://icons.iconarchive.com/icons/icons8/windows-8/512/Weather-Snow-iconImageView.png";
                break;
            case "wind":
                imgUrl = "https://cdn3.iconfinder.com/data/icons/simple-weather-iconImageView/64/Wind-512.png";
                break;
            default:
                imgUrl = "https://cdn1.iconfinder.com/data/icons/weather-elements/512/Weather_SunAbstract.png";

        }
        return imgUrl;

    }
}
