package com.example.bmarshall.weatherforecastapp.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bmarshall.weatherforecastapp.R;
import com.example.bmarshall.weatherforecastapp.controller.Controller;

import java.util.List;
import java.util.Vector;

public class WeatherForecastView extends FragmentActivity {

    public Controller controller;
    private PagerAdapter mPagerAdapter;
    private TextView locationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_weather_forecast);
        locationTextView = (TextView) findViewById(R.id.locationtxt);
        controller = new Controller();
        String location = controller.getSavedLocation(this);
        String weatherData = controller.fetchWeatherData(location);
        controller.getDailyWeather(weatherData);
        controller.setIconData();
        locationTextView.setText(controller.getLocationName());
        this.initialisePaging();
    }

    public void onClickChangeLocationButton(View v) {
        controller.saveLocation("bad location", this);
        Intent intent = new Intent(WeatherForecastView.this, LocationSelectionView.class);
        startActivity(intent);
    }

    public void initialisePaging() {
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, DailyWeatherFragmentView.class.getName()));
        fragments.add(Fragment.instantiate(this, WeeklyWeatherFragmentView.class.getName()));
        this.mPagerAdapter = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        //
        ViewPager pager = (ViewPager) super.findViewById(R.id.pager);
        pager.setAdapter(this.mPagerAdapter);
    }
}
