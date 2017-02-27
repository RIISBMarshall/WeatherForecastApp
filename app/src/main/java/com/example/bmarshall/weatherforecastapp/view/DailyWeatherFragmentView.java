package com.example.bmarshall.weatherforecastapp.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bmarshall.weatherforecastapp.R;
import com.example.bmarshall.weatherforecastapp.controller.Controller;

public class DailyWeatherFragmentView extends Fragment {

    private TextView temp;
    private TextView humidity;
    private TextView tempMin;
    private TextView tempMax;
    private TextView windSpeed;
    private TextView clouds;
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

        temp = (TextView) view.findViewById(R.id.temp);
        humidity = (TextView) view.findViewById(R.id.humidity);
        tempMin = (TextView) view.findViewById(R.id.temp_min);
        tempMax = (TextView) view.findViewById(R.id.temp_max);
        windSpeed = (TextView) view.findViewById(R.id.wind_speed);
        clouds = (TextView) view.findViewById(R.id.clouds);

        temp.setText(controller.getTemp());
        humidity.setText(controller.getHumidity());
        tempMin.setText(controller.getTempMin());
        tempMax.setText(controller.getTempMax());
        windSpeed.setText(controller.getWindSpeed());
        clouds.setText(controller.getClouds());

        return view;
    }
}
