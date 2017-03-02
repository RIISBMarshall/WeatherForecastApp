package com.example.bmarshall.weatherforecastapp.controller;

import android.content.Context;

import com.example.bmarshall.weatherforecastapp.model.APIHelper;
import com.example.bmarshall.weatherforecastapp.model.JSONWeatherParser;
import com.example.bmarshall.weatherforecastapp.model.PreferenceHelper;
import com.example.bmarshall.weatherforecastapp.model.Weather;

import java.util.ArrayList;

public class Controller {
    private Weather weather;
    private ArrayList<Weather> weeksWeather;

    public Controller() {

    }

    public boolean checkValid(String enteredLocation) {
        PreferenceHelper preferenceHelper = new PreferenceHelper();
        return preferenceHelper.checkValid(enteredLocation);
    }

    public void saveLocation(String zipCode, Context context) {
        PreferenceHelper preferenceHelper = new PreferenceHelper();
        preferenceHelper.saveLocation(zipCode, context);
    }

    public String getSavedLocation(Context context) {
        PreferenceHelper preferenceHelper = new PreferenceHelper();
        return preferenceHelper.getSavedLocation(context);
    }

    public void getDailyWeather(String weatherData) {
        JSONWeatherParser jSONWeatherParser = new JSONWeatherParser();
        weather = jSONWeatherParser.getDailyWeather(weatherData);

    }

    public void getWeeksWeather(String weatherData) {
        JSONWeatherParser jSONWeatherParser = new JSONWeatherParser();
        weeksWeather = jSONWeatherParser.getWeeksWeather(weatherData);
    }

    public String fetchDailyWeatherData(String location) {
        APIHelper apiHelper = new APIHelper();
        return apiHelper.fetchWeatherData(location, "day");
    }

    public String fetchWeeklyWeatherData(String location) {
        APIHelper apiHelper = new APIHelper();
        return apiHelper.fetchWeatherData(location, "week");
    }

    public void setIconData() {
        APIHelper apiHelper = new APIHelper();
        weather.setIconData(apiHelper.getImage(weather.getIcon()));
    }

    public void setWeeksWeatherIconData() {
        APIHelper apiHelper = new APIHelper();
        for (int i = 0; i < 5; i++) {
            weeksWeather.get(i).setIconData(apiHelper.getImage(weeksWeather.get(i).getIcon()));
        }
    }

    public String getTemp() {
        return weather.getTemp();
    }

    public String getHumidity() {
        return weather.getHumidity();
    }

    public String getWindSpeed() {
        return weather.getWindSpeed();
    }

    public String getClouds() {
        return weather.getClouds();
    }

    public byte[] getIconData() {
        return weather.getIconData();
    }

    public String getLocationName() {
        return weather.getLocationName();
    }

    public ArrayList<Weather> getWeeksWeatherArray() {
        return weeksWeather;
    }

    public boolean weatherIsBad() {
        return Double.valueOf(weather.getTemp()) < 10;
    }
}