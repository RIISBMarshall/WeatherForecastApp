package com.example.bmarshall.weatherforecastapp.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bmarshall.weatherforecastapp.R;
import com.example.bmarshall.weatherforecastapp.controller.Controller;

public class WeeklyWeatherFragmentView extends Fragment {
    private Controller controller;
    private TextView weatherOne;
    private TextView weatherTwo;
    private TextView weatherThree;
    private TextView weatherFour;
    private TextView weatherFive;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        View view = inflater.inflate(R.layout.view_weekly_weather_fragment, container, false);
        WeatherForecastView weatherForecastView = (WeatherForecastView) getActivity();
        controller = weatherForecastView.controller;
        weatherOne = (TextView) view.findViewById(R.id.weatherone);
        weatherTwo = (TextView) view.findViewById(R.id.weathertwo);
        weatherThree = (TextView) view.findViewById(R.id.weatherthree);
        weatherFour = (TextView) view.findViewById(R.id.weatherfour);
        weatherFive = (TextView) view.findViewById(R.id.weatherfive);

        weatherOne.setText(controller.getWeekdayMaxTemp(1));
        //image, maxtemp, lowtemp, windspeed, humidity

        return view;
    }
}
