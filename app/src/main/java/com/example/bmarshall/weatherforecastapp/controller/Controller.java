package com.example.bmarshall.weatherforecastapp.controller;

import android.content.Context;

import com.example.bmarshall.weatherforecastapp.model.APIHelper;
import com.example.bmarshall.weatherforecastapp.model.JSONWeatherParser;
import com.example.bmarshall.weatherforecastapp.model.PreferenceHelper;
import com.example.bmarshall.weatherforecastapp.model.Weather;

import org.json.JSONException;

public class Controller {
    private Weather weather;

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
        try {
            weather = jSONWeatherParser.getDailyWeather(weatherData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String fetchWeatherData(String location){
        APIHelper apiHelper = new APIHelper();
        return apiHelper.fetchWeatherData(location);
    }

    public void setIconData(){
        APIHelper apiHelper = new APIHelper();
        weather.setIconData(apiHelper.getImage(weather.getIcon()));
    }

    public String getTemp() {
        return weather.getTemp();
    }

    public String getHumidity() {
        return weather.getHumidity();
    }

    public String getTempMin() {
        return weather.getTempMin();
    }

    public String getTempMax() {
        return weather.getTempMax();
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
}
