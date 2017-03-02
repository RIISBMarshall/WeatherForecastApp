package com.example.bmarshall.weatherforecastapp.model;

public class Weather {

    private String locationName;
    private String temp;
    private final String humidity;
    private String tempMin;
    private String tempMax;
    private final String windSpeed;
    private String clouds;
    private final String icon;
    private byte[] iconData;

    public Weather(String locationName, String temp, String humidity, String windSpeed,
                   String clouds, String icon) {
        this.locationName = locationName;
        this.temp = temp;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
        this.icon = icon;
    }

    public Weather(String tempMax, String tempMin, String windSpeed, String humidity, String icon) {
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
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
