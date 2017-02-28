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
        String locationName = "Sterling Heights";
        String temp = "50";
        String humidity = "2.0";
        String tempMin = "25";
        String tempMax = "55";
        String windSpeed = "100 miles per hour";
        String clouds = "partly sunny";
        String icon = "50d";
        weather = new Weather(locationName, temp, humidity, tempMin, tempMax, windSpeed, clouds, icon);
    }

    @Test
    public void getTempTest() {
        Assert.assertEquals("50", weather.getTemp());
    }

    @Test
    public void getHumidityTest() {
        Assert.assertEquals("2.0", weather.getHumidity());
    }

    @Test
    public void getTempMinTest() {
        Assert.assertEquals("25", weather.getTempMin());
    }

    @Test
    public void getTempMaxTest() {
        Assert.assertEquals("55", weather.getTempMax());
    }

    @Test
    public void getWindSpeedTest() {
        Assert.assertEquals("100 miles per hour", weather.getWindSpeed());
    }

    @Test
    public void getCloudsTest() {
        Assert.assertEquals("50", weather.getTemp());
    }

    @Test
    public void getIconTest(){
        Assert.assertEquals("50d", weather.getIcon());
    }

    @Test
    public void setIconDataTest(){
        String hexCode = "e04fd020ea3a6910a2d808002b30309d";
        int len = hexCode.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexCode.charAt(i), 16) << 4)
                    + Character.digit(hexCode.charAt(i+1), 16));
        }
        weather.setIconData(data);
        Assert.assertEquals(data, weather.getIconData());
    }

    @Test
    public void getIconDataTest(){
        String hexCode = "e04fd020ea3a6910a2d808002b30309d";
        int len = hexCode.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexCode.charAt(i), 16) << 4)
                    + Character.digit(hexCode.charAt(i+1), 16));
        }
        weather.setIconData(data);
        Assert.assertEquals(data, weather.getIconData());
    }

    @Test
    public void getLocationNameTest(){
        Assert.assertEquals("Sterling Heights", weather.getLocationName());
    }
}
