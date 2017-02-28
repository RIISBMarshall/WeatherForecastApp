package com.example.bmarshall.weatherforecastapp.model;

/**
 * Created by bmarshall on 2/27/17.
 */

public class Weather {

    private String locationName;
    private String temp;
    private String humidity;
    private String tempMin;
    private String tempMax;
    private String windSpeed;
    private String clouds;
    private String icon;
    private byte[] iconData;

    public Weather(String locationName, String temp, String humidity, String tempMin, String tempMax, String windSpeed,
                   String clouds, String icon) {
        this.locationName = locationName;
        this.temp = temp;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
        this.icon = icon;
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

    public String getIcon() {
        return icon;
    }

    public void setIconData(byte[] iconData) {
        this.iconData = iconData;
    }

    public byte[] getIconData() {
        return iconData;
    }

    public String getLocationName() {
        return locationName;
    }
}
