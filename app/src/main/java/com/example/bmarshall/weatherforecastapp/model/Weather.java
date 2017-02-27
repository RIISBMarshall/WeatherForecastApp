package com.example.bmarshall.weatherforecastapp.model;

/**
 * Created by bmarshall on 2/27/17.
 */

public class Weather {

    private String temp;
    private String humidity;
    private String tempMin;
    private String tempMax;
    private String windSpeed;
    private String clouds;

    public Weather(String temp, String humidity, String tempMin, String tempMax, String windSpeed,
                   String clouds) {
        this.temp = temp;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.windSpeed = windSpeed;
        this.clouds = clouds;

    }

    public String getTemp() {
        return temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTempMin() {
        return tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getClouds() {
        return clouds;
    }
}
