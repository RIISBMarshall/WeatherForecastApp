package com.example.bmarshall.weatherforecastapp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bmarshall.weatherforecastapp.R;
import com.example.bmarshall.weatherforecastapp.model.Weather;

import java.util.ArrayList;

class WeeklyWeatherAdapter extends ArrayAdapter<Weather> {
    private final Context context;

    WeeklyWeatherAdapter(Context context, ArrayList<Weather> weeksWeather) {
        super(context, 0, weeksWeather);
        this.context = context;
    }

    @NonNull
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

        maxTemp.setText(context.getString(R.string.high) + " " + weather.getTempMax());
        minTemp.setText(context.getString(R.string.low) + " " + weather.getTempMin());
        humid.setText(context.getString(R.string.humidity) + " " + weather.getHumidity());
        speedWind.setText(context.getString(R.string.windspeed) + " " + weather.getWindSpeed());
        return convertView;
    }
}
