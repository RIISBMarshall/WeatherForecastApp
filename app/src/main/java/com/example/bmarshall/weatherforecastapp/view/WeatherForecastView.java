package com.example.bmarshall.weatherforecastapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.bmarshall.weatherforecastapp.R;
import com.example.bmarshall.weatherforecastapp.controller.Controller;

import java.io.IOException;

public class WeatherForecastView extends AppCompatActivity {

    public Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast_view);
        controller = new Controller();
    }

    public void onClickChangeLocationButton(View v) throws IllegalAccessException, IOException, InstantiationException {
        controller.saveLocation("bad location", this);
        Intent intent = new Intent(WeatherForecastView.this, LocationSelectionView.class);
        startActivity(intent);
    }
}
