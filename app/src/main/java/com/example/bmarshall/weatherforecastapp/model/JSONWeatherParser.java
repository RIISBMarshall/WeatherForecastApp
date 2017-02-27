package com.example.bmarshall.weatherforecastapp.model;

import com.example.bmarshall.weatherforecastapp.model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public Weather getDailyWeather(String data) throws JSONException {
        JSONObject jObj = new JSONObject(data);

        JSONObject mainObj = getObject("main", jObj);

        temp = getString("temp", mainObj);
        humidity = getString("humidity", mainObj);
        tempMin = getString("temp_min", mainObj);
        tempMax = getString("temp_max", mainObj);

        JSONObject wObj = getObject("wind", jObj);

        windSpeed = getString("speed", wObj);

        JSONObject cObj = getObject("clouds", jObj);

        clouds = getString("all", cObj);

        return new Weather(temp, humidity, tempMin, tempMax, windSpeed, clouds);
    }

    private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }
}
