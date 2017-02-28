package com.example.bmarshall.weatherforecastapp.model;

import com.example.bmarshall.weatherforecastapp.model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class JSONWeatherParser {
    private String locationName;
    private String temp;
    private String humidity;
    private String tempMin;
    private String tempMax;
    private String windSpeed;
    private String clouds;
    private String icon;

    public Weather getDailyWeather(String data) throws JSONException {
        JSONObject jObj = new JSONObject(data);

        JSONObject mainObj = getObject("main", jObj);

        locationName = getString("name", jObj);
        temp = convertFromKelToFar(getString("temp", mainObj));
        humidity = getString("humidity", mainObj);
        tempMin = convertFromKelToFar(getString("temp_min", mainObj));
        tempMax = convertFromKelToFar(getString("temp_max", mainObj));

        JSONObject wObj = getObject("wind", jObj);

        windSpeed = getString("speed", wObj);

        JSONObject cObj = getObject("clouds", jObj);

        clouds = getString("all", cObj);

        JSONArray jArr = jObj.getJSONArray("weather");

        JSONObject JSONWeather = jArr.getJSONObject(0);

        icon = getString("icon", JSONWeather);

        return new Weather(locationName, temp, humidity, tempMin, tempMax, windSpeed, clouds, icon);
    }

    private static JSONObject getObject(String tagName, JSONObject jObj) throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

    private String convertFromKelToFar(String kelvinTemp) {
        NumberFormat numberFormat = new DecimalFormat("##.###");
        Float kelTemp = Float.valueOf(kelvinTemp);
        double farTemp = kelTemp * (9.0 / 5) - 459.67;
        return numberFormat.format(farTemp);
    }
}
