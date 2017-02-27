package com.example.bmarshall.weatherforecastapp.model;

import com.example.bmarshall.weatherforecastapp.model.Weather;

/**
 * Created by bmarshall on 2/27/17.
 */

public class JSONWeatherParser {
    private String temp;
    private String humidity;
    private String tempMin;
    private String tempMax;
    private String windSpeed;
    private String clouds;

    public Weather getDailyWeather(String data) {
        temp = "50";
        humidity = "2.0";
        tempMin = "25";
        tempMax = "55";
        windSpeed = "100 miles per hour";
        clouds = "partly sunny";
        return new Weather(temp, humidity, tempMin, tempMax, windSpeed, clouds);
    }
}
