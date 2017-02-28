package com.example.bmarshall.weatherforecastapp.model;

import com.example.bmarshall.weatherforecastapp.BuildConfig;

import junit.framework.Assert;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by bmarshall on 2/27/17.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class JSONWeatherParserTest {
    private String weatherData;

    @Before
    public void setUp(){
        weatherData = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39}," +
                " \"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\"," +
                "\"sunrise\":1427723751,\"sunset\":1427768967}, \"weather\":[{\"id\":800,\"main\"" +
                ":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}], " +
                "\"base\":\"stations\", \"main\":{\"temp\":285.68,\"humidity\":74," +
                "\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48}, " +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001}, \"clouds\":{\"all\":0}, " +
                "\"dt\":1427700245, \"id\":0, \"name\":\"Mountain View\", \"cod\":200}";
    }

    @Test
    public void getDailyWeather() throws JSONException {
        JSONWeatherParser jsonWeatherParser = new JSONWeatherParser();
        Weather weather = jsonWeatherParser.getDailyWeather(weatherData);

        Assert.assertEquals("temp should be set to 285.68", "285.68", weather.getTemp());
        Assert.assertEquals("humidity should be set to 74", "74", weather.getHumidity());
        Assert.assertEquals("tempMin should be set to 284.82", "284.82", weather.getTempMin());
        Assert.assertEquals("tempMax should be set to 286.48", "286.48", weather.getTempMax());
        Assert.assertEquals("windSpeed should be set to 0.96", "0.96", weather.getWindSpeed());
        Assert.assertEquals("clouds should be set to 0", "0", weather.getClouds());
    }
}
