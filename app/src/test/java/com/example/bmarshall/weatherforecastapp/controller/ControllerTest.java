package com.example.bmarshall.weatherforecastapp.controller;

import com.example.bmarshall.weatherforecastapp.BuildConfig;
import com.example.bmarshall.weatherforecastapp.controller.Controller;
import com.example.bmarshall.weatherforecastapp.model.APIHelper;
import com.example.bmarshall.weatherforecastapp.model.JSONWeatherParser;
import com.example.bmarshall.weatherforecastapp.model.Weather;
import com.example.bmarshall.weatherforecastapp.view.LocationSelectionView;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by bmarshall on 2/24/17.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class ControllerTest {
    private Controller controller;
    private LocationSelectionView locationSelectionView;
    private String weatherData;
    private String weeklyWeatherData;
    private String badWeather;

    @Before
    public void setUp(){
        controller = new Controller();
        locationSelectionView = Robolectric.buildActivity(LocationSelectionView.class).create().get();
        weatherData = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39}," +
                " \"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\"," +
                "\"sunrise\":1427723751,\"sunset\":1427768967}, \"weather\":[{\"id\":800,\"main\"" +
                ":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}], " +
                "\"base\":\"stations\", \"main\":{\"temp\":285.68,\"humidity\":74," +
                "\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48}, " +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001}, \"clouds\":{\"all\":0}, " +
                "\"dt\":1427700245, \"id\":0, \"name\":\"Mountain View\", \"cod\":200}";

        badWeather = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39}," +
                " \"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\"," +
                "\"sunrise\":1427723751,\"sunset\":1427768967}, \"weather\":[{\"id\":800,\"main\"" +
                ":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}], " +
                "\"base\":\"stations\", \"main\":{\"temp\":258.15,\"humidity\":74," +
                "\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48}, " +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001}, \"clouds\":{\"all\":0}, " +
                "\"dt\":1427700245, \"id\":0, \"name\":\"Mountain View\", \"cod\":200}";

        weeklyWeatherData = "{\"city\":{\"id\":5011148,\"name\":\"Sterling Heights\",\"coord\"" +
                ":{\"lon\":-83.0302,\"lat\":42.5803},\"country\":\"US\",\"population\":129699}," +
                "\"cod\":\"200\",\"message\":0.0894006,\"cnt\":7,\"list\":[{\"dt\":1488301200," +
                "\"temp\":{\"day\":282.15,\"min\":282.15,\"max\":285.5,\"night\":285.5,\"eve\"" +
                ":283.24,\"morn\":282.15},\"pressure\":1004.36,\"humidity\":75,\"weather\":[{" +
                "\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"" +
                "}],\"speed\":4.61,\"deg\":165,\"clouds\":92,\"rain\":2.66},{\"dt\":148838760" +
                "0,\"temp\":{\"day\":282.86,\"min\":268.68,\"max\":283.42,\"night\":268.68,\"" +
                "eve\":277.6,\"morn\":283.07},\"pressure\":988,\"humidity\":84,\"weather\":[{" +
                "\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}" +
                "],\"speed\":6.01,\"deg\":242,\"clouds\":76,\"rain\":0.99,\"snow\":0.09},{\"" +
                "dt\":1488474000,\"temp\":{\"day\":270.67,\"min\":266.35,\"max\":271.73,\"night" +
                "\":267.66,\"eve\":268.94,\"morn\":266.91},\"pressure\":1009.91,\"humidity\":92," +
                "\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon" +
                "\":\"13d\"}],\"speed\":4.43,\"deg\":314,\"clouds\":56,\"snow\":0.32},{\"dt" +
                "\":1488560400,\"temp\":{\"day\":272.26,\"min\":265.53,\"max\":272.26,\"night" +
                "\":268.65,\"eve\":271.59,\"morn\":265.53},\"pressure\":1016.72,\"humidity\":0," +
                "\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\"," +
                "\"icon\":\"13d\"}],\"speed\":6.76,\"deg\":292,\"clouds\":45,\"snow\":0.75},{" +
                "\"dt\":1488646800,\"temp\":{\"day\":275.49,\"min\":266.05,\"max\":275.49,\"night" +
                "\":271.56,\"eve\":274.35,\"morn\":266.05},\"pressure\":1016.97,\"humidity\":0," +
                "\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\"," +
                "\"icon\":\"01d\"}],\"speed\":4.09,\"deg\":133,\"clouds\":42,\"snow\":0.02},{" +
                "\"dt\":1488733200,\"temp\":{\"day\":283.3,\"min\":272.51,\"max\":283.3,\"night" +
                "\":279.1,\"eve\":281.42,\"morn\":272.51},\"pressure\":1008.92,\"humidity\":0," +
                "\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\"," +
                "\"icon\":\"01d\"}],\"speed\":4.15,\"deg\":189,\"clouds\":21},{\"dt\":1488819600," +
                "\"temp\":{\"day\":282.41,\"min\":273,\"max\":282.41,\"night\":273,\"eve\":279.68," +
                "\"morn\":280.23},\"pressure\":996.88,\"humidity\":0,\"weather\":[{\"id\":800,\"main" +
                "\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":5.58," +
                "\"deg\":231,\"clouds\":87,\"rain\":2.11,\"snow\":0.02}]}";
    }

    @Test
    public void checkValidTest(){
        String validEntry = "48310";
        Assert.assertEquals("valid entry should return true", true, controller.checkValid(validEntry));
        String invalidEntry = "4831";
        Assert.assertEquals("invalid entry should return false", false, controller.checkValid(invalidEntry));
    }

    @Test
    public void saveLocationTest() throws IllegalAccessException, IOException, InstantiationException {
        String location = "48310";
        controller.saveLocation(location, locationSelectionView);
        Assert.assertEquals("saveLocation should save the location we enter", location, controller.getSavedLocation(locationSelectionView));
    }

    @Test
    public void getSavedLocationTest() throws IllegalAccessException, IOException, InstantiationException {
        String location = "48310";
        controller.saveLocation(location, locationSelectionView);
        Assert.assertEquals("getSavedLocation should return the location we save", location, controller.getSavedLocation(locationSelectionView));
    }

    @Test
    public void getDailyWeatherTest() {
        controller.getDailyWeather(weatherData);
        Assert.assertEquals("temp should be set to 54.55", "54.55", controller.getTemp());
        Assert.assertEquals("humidity should be set to 74", "74", controller.getHumidity());
        Assert.assertEquals("tempMin should be set to 53.01", "53.01", controller.getTempMin());
        Assert.assertEquals("tempMax should be set to 55.99", "55.99", controller.getTempMax());
        Assert.assertEquals("windSpeed should be set to 0.96", "0.96", controller.getWindSpeed());
        Assert.assertEquals("clouds should be set to 0", "0", controller.getClouds());
    }

    @Test
    public void fetchWeatherDataTest(){
        //Cant test API calls
    }

    @Test
    public void getTempTest() {
        controller.getDailyWeather(weatherData);
        Assert.assertEquals("temp should be set to 54.55", "54.55", controller.getTemp());
    }

    @Test
    public void getHumidityTest() {
        controller.getDailyWeather(weatherData);

        Assert.assertEquals("humidity should be set to 74", "74", controller.getHumidity());
    }

    @Test
    public void getTempMinTest() {
        controller.getDailyWeather(weatherData);

        Assert.assertEquals("tempMin should be set to 53.01", "53.01", controller.getTempMin());
    }

    @Test
    public void getTempMaxTest() {
        controller.getDailyWeather(weatherData);

        Assert.assertEquals("tempMax should be set to 55.99", "55.99", controller.getTempMax());
    }

    @Test
    public void getWindSpeedTest() {
        controller.getDailyWeather(weatherData);

        Assert.assertEquals("windSpeed should be set to 0.96", "0.96", controller.getWindSpeed());
    }

    @Test
    public void getCloudsTest() {
        controller.getDailyWeather(weatherData);

        Assert.assertEquals("clouds should be set to 0", "0", controller.getClouds());
    }

    @Test
    public void getLocationNameTest(){
        controller.getDailyWeather(weatherData);

        Assert.assertEquals("Mountain View", controller.getLocationName());
    }

    @Test
    public void getWeekdayMaxTempTest(){
        controller.getWeeksWeather(weeklyWeatherData);
        Assert.assertEquals("54.23", controller.getWeekdayMaxTemp(0));
    }

    @Test
    public void getWeekdayMinTempTest(){
        controller.getWeeksWeather(weeklyWeatherData);
        Assert.assertEquals("48.2", controller.getWeekdayMinTemp(0));
    }

    @Test
    public void getWeekdayHumidityTest(){
        controller.getWeeksWeather(weeklyWeatherData);
        Assert.assertEquals("75", controller.getWeekdayHumidity(0));
    }

    @Test
    public void getWeekdayWindSpeedTest(){
        controller.getWeeksWeather(weeklyWeatherData);
        Assert.assertEquals("4.61", controller.getWeekdayWindSpeed(0));
    }

    @Test
    public void getWeeksWeatherTest() {
        controller.getWeeksWeather(weeklyWeatherData);
        ArrayList<Weather> weeksWeatherArray = controller.getWeeksWeatherArray();
        Assert.assertEquals("4.61", weeksWeatherArray.get(0).getWindSpeed());
    }

    @Test
    public void weatherIsBadTest(){
        controller.getDailyWeather(weatherData);
        Assert.assertEquals(false, controller.weatherIsBad());

        controller.getDailyWeather(badWeather);
        Assert.assertEquals(true, controller.weatherIsBad());
    }
}
