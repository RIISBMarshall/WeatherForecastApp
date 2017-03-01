package com.example.bmarshall.weatherforecastapp.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bmarshall.weatherforecastapp.R;
import com.example.bmarshall.weatherforecastapp.controller.Controller;

public class WeeklyWeatherFragmentView extends Fragment {
    private Controller controller;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        View view = inflater.inflate(R.layout.view_weekly_weather_fragment, container, false);
        WeatherForecastView weatherForecastView = (WeatherForecastView) getActivity();
        controller = weatherForecastView.controller;

        ListView weatherListView = (ListView) view.findViewById(R.id.weather_listview);
        WeeklyWeatherAdapter weeklyWeatherAdapter = new WeeklyWeatherAdapter(weatherForecastView, controller.getWeeksWeatherArray());
        weatherListView.setAdapter(weeklyWeatherAdapter);
        return view;
    }
}
