package com.example.bmarshall.weatherforecastapp.model;

import com.example.bmarshall.weatherforecastapp.model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class JSONWeatherParser {
    private String locationName;
    private String temp;
    private String humidity;
    private String tempMin;
    private String tempMax;
    private String windSpeed;
    private String clouds;
    private String icon;

    public Weather getDailyWeather(String data) {
        try {
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
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new Weather(locationName, temp, humidity, tempMin, tempMax, windSpeed, clouds, icon);
    }

    public ArrayList getWeeksWeather(String data) {
        ArrayList<Weather> weeksWeather = new ArrayList<>(5);

        JSONObject jObj = null;
        try {
            jObj = new JSONObject(data);


            JSONArray list = jObj.getJSONArray("list");


            for (int i = 0; i < 5; i++) {

                JSONObject item = list.getJSONObject(i);

                JSONObject temp = item.getJSONObject("temp");

                tempMax = convertFromKelToFar(temp.getString("max"));

                tempMin = convertFromKelToFar(temp.getString("min"));

                JSONArray weatherList = item.getJSONArray("weather");

                JSONObject weatherItem = weatherList.getJSONObject(0);

                icon = weatherItem.getString("icon");

                windSpeed = item.getString("speed");

                humidity = item.getString("humidity");

                weeksWeather.add(i, new Weather(tempMax, tempMin, windSpeed, humidity, icon));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return weeksWeather;
    }

    private static JSONObject getObject(String tagName, JSONObject jObj) throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

    private String convertFromKelToFar(String kelvinTemp) {
        NumberFormat numberFormat = new DecimalFormat("##.##");
        Float kelTemp = Float.valueOf(kelvinTemp);
        double farTemp = kelTemp * (9.0 / 5) - 459.67;
        return numberFormat.format(farTemp);
    }
}
