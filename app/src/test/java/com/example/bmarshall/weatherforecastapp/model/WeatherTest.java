package com.example.bmarshall.weatherforecastapp.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by bmarshall on 2/27/17.
 */

public class WeatherTest {
    private Weather weather;

    @Before
    public void setUp(){
        String temp = "50";
        String humidity = "2.0";
        String tempMin = "25";
        String tempMax = "55";
        String windSpeed = "100 miles per hour";
        String clouds = "partly sunny";
        weather = new Weather(temp, humidity, tempMin, tempMax, windSpeed, clouds);
    }

    @Test
    public void getTemp() {
        Assert.assertEquals("50", weather.getTemp());
    }

    @Test
    public void getHumidity() {
        Assert.assertEquals("2.0", weather.getHumidity());
    }

    @Test
    public void getTempMin() {
        Assert.assertEquals("25", weather.getTempMin());
    }

    @Test
    public void getTempMax() {
        Assert.assertEquals("55", weather.getTempMax());
    }

    @Test
    public void getWindSpeed() {
        Assert.assertEquals("100 miles per hour", weather.getWindSpeed());
    }

    @Test
    public void getClouds() {
        Assert.assertEquals("50", weather.getTemp());
    }
}
