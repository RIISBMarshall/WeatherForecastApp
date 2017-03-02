package com.example.bmarshall.weatherforecastapp.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bmarshall.weatherforecastapp.R;
import com.example.bmarshall.weatherforecastapp.controller.Controller;

public class DailyWeatherFragmentView extends Fragment {

    private TextView temp;
    private TextView humidity;
    private TextView windSpeed;
    private TextView clouds;
    private ImageView imgView;
    private Controller controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        View view = inflater.inflate(R.layout.view_daily_weather_fragment, container, false);
        WeatherForecastView weatherForecastView = (WeatherForecastView) getActivity();
        controller = weatherForecastView.controller;

        imgView = (ImageView) view.findViewById(R.id.imgview);
        temp = (TextView) view.findViewById(R.id.temp);
        humidity = (TextView) view.findViewById(R.id.humidity);
        windSpeed = (TextView) view.findViewById(R.id.wind_speed);
        clouds = (TextView) view.findViewById(R.id.clouds);

        imgView.getLayoutParams().width = 400;
        imgView.getLayoutParams().height = 400;

        showCurrentWeather();

        return view;
    }

    private void showCurrentWeather() {
        byte[] iconData = controller.getIconData();

        if (iconData != null && iconData.length > 0) {
            Bitmap img = BitmapFactory.decodeByteArray(iconData, 0, iconData.length);
            imgView.setImageBitmap(img);
        }

        temp.setText(getString(R.string.temperature) + " " + controller.getTemp());
        humidity.setText(getString(R.string.humidity) + " " + controller.getHumidity());
        windSpeed.setText(getString(R.string.windspeed) + " " + controller.getWindSpeed());
        clouds.setText(getString(R.string.clouds) + " " + controller.getClouds() + "%");
    }
}
