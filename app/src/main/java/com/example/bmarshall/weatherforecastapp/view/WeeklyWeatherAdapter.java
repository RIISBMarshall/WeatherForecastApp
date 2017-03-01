package com.example.bmarshall.weatherforecastapp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bmarshall.weatherforecastapp.R;
import com.example.bmarshall.weatherforecastapp.model.Weather;

import java.util.ArrayList;

/**
 * Created by bmarshall on 3/1/17.
 */

public class WeeklyWeatherAdapter extends ArrayAdapter<Weather> {

    public WeeklyWeatherAdapter(Context context, ArrayList<Weather> weeksWeather) {
        super(context, 0, weeksWeather);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Weather weather = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.weather, parent, false);
        }
        ImageView iconView = (ImageView) convertView.findViewById(R.id.icon_view);
        TextView maxTemp = (TextView) convertView.findViewById(R.id.max_temp);
        TextView minTemp = (TextView) convertView.findViewById(R.id.min_temp);
        TextView humid = (TextView) convertView.findViewById(R.id.humid);
        TextView speedWind = (TextView) convertView.findViewById(R.id.speed_wind);

        byte[] iconData = weather.getIconData();

        iconView.getLayoutParams().width = 250;
        iconView.getLayoutParams().height = 250;

        if (iconData != null && iconData.length > 0) {
            Bitmap img = BitmapFactory.decodeByteArray(iconData, 0, iconData.length);
            iconView.setImageBitmap(img);
        }

        maxTemp.setText("high: " + weather.getTempMax());
        minTemp.setText("low: " + weather.getTempMin());
        humid.setText("humidity: " + weather.getHumidity());
        speedWind.setText("windspeed: " + weather.getWindSpeed());
        return convertView;
    }

    /*<ImageView
        android:id="@+id/icon_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <TextView
        android:id="@+id/max_temp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <TextView
        android:id="@+id/min_temp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <TextView
        android:id="@+id/humid"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <TextView
        android:id="@+id/speed_wind"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />*/
}
