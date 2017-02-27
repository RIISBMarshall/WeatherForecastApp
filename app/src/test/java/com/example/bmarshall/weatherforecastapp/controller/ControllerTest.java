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

/**
 * Created by bmarshall on 2/24/17.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class ControllerTest {
    private Controller controller;
    private LocationSelectionView locationSelectionView;

    @Before
    public void setUp(){
        controller = new Controller();
        locationSelectionView = Robolectric.buildActivity(LocationSelectionView.class).create().get();
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
    public void getDailyWeather() {
        String weatherData = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39}," +
                " \"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\"," +
                "\"sunrise\":1427723751,\"sunset\":1427768967}, \"weather\":[{\"id\":800,\"main\"" +
                ":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}], " +
                "\"base\":\"stations\", \"main\":{\"temp\":285.68,\"humidity\":74," +
                "\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48}, " +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001}, \"clouds\":{\"all\":0}, " +
                "\"dt\":1427700245, \"id\":0, \"name\":\"Mountain View\", \"cod\":200}";

        controller.getDailyWeather(weatherData);
        Assert.assertEquals("temp should be set to 285.68", "285.68", controller.getTemp());
        Assert.assertEquals("humidity should be set to 74", "74", controller.getHumidity());
        Assert.assertEquals("tempMin should be set to 284.82", "284.82", controller.getTempMin());
        Assert.assertEquals("tempMax should be set to 286.48", "286.48", controller.getTempMax());
        Assert.assertEquals("windSpeed should be set to 0.96", "0.96", controller.getWindSpeed());
        Assert.assertEquals("clouds should be set to 0", "0", controller.getClouds());
    }

    @Test
    public void fetchWeatherData(){
        //Cant test API calls
    }

    @Test
    public void getTemp() {
        String weatherData = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39}," +
                " \"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\"," +
                "\"sunrise\":1427723751,\"sunset\":1427768967}, \"weather\":[{\"id\":800,\"main\"" +
                ":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}], " +
                "\"base\":\"stations\", \"main\":{\"temp\":285.68,\"humidity\":74," +
                "\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48}, " +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001}, \"clouds\":{\"all\":0}, " +
                "\"dt\":1427700245, \"id\":0, \"name\":\"Mountain View\", \"cod\":200}";

        controller.getDailyWeather(weatherData);
        Assert.assertEquals("temp should be set to 285.68", "285.68", controller.getTemp());
    }

    @Test
    public void getHumidity() {
        String weatherData = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39}," +
                " \"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\"," +
                "\"sunrise\":1427723751,\"sunset\":1427768967}, \"weather\":[{\"id\":800,\"main\"" +
                ":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}], " +
                "\"base\":\"stations\", \"main\":{\"temp\":285.68,\"humidity\":74," +
                "\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48}, " +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001}, \"clouds\":{\"all\":0}, " +
                "\"dt\":1427700245, \"id\":0, \"name\":\"Mountain View\", \"cod\":200}";

        controller.getDailyWeather(weatherData);

        Assert.assertEquals("humidity should be set to 74", "74", controller.getHumidity());
    }

    @Test
    public void getTempMin() {
        String weatherData = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39}," +
                " \"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\"," +
                "\"sunrise\":1427723751,\"sunset\":1427768967}, \"weather\":[{\"id\":800,\"main\"" +
                ":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}], " +
                "\"base\":\"stations\", \"main\":{\"temp\":285.68,\"humidity\":74," +
                "\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48}, " +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001}, \"clouds\":{\"all\":0}, " +
                "\"dt\":1427700245, \"id\":0, \"name\":\"Mountain View\", \"cod\":200}";

        controller.getDailyWeather(weatherData);

        Assert.assertEquals("tempMin should be set to 284.82", "284.82", controller.getTempMin());
    }

    @Test
    public void getTempMax() {
        String weatherData = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39}," +
                " \"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\"," +
                "\"sunrise\":1427723751,\"sunset\":1427768967}, \"weather\":[{\"id\":800,\"main\"" +
                ":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}], " +
                "\"base\":\"stations\", \"main\":{\"temp\":285.68,\"humidity\":74," +
                "\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48}, " +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001}, \"clouds\":{\"all\":0}, " +
                "\"dt\":1427700245, \"id\":0, \"name\":\"Mountain View\", \"cod\":200}";

        controller.getDailyWeather(weatherData);

        Assert.assertEquals("tempMax should be set to 286.48", "286.48", controller.getTempMax());
    }

    @Test
    public void getWindSpeed() {
        String weatherData = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39}," +
                " \"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\"," +
                "\"sunrise\":1427723751,\"sunset\":1427768967}, \"weather\":[{\"id\":800,\"main\"" +
                ":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}], " +
                "\"base\":\"stations\", \"main\":{\"temp\":285.68,\"humidity\":74," +
                "\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48}, " +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001}, \"clouds\":{\"all\":0}, " +
                "\"dt\":1427700245, \"id\":0, \"name\":\"Mountain View\", \"cod\":200}";

        controller.getDailyWeather(weatherData);

        Assert.assertEquals("windSpeed should be set to 0.96", "0.96", controller.getWindSpeed());
    }

    @Test
    public void getClouds() {
        String weatherData = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39}," +
                " \"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\"," +
                "\"sunrise\":1427723751,\"sunset\":1427768967}, \"weather\":[{\"id\":800,\"main\"" +
                ":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}], " +
                "\"base\":\"stations\", \"main\":{\"temp\":285.68,\"humidity\":74," +
                "\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48}, " +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001}, \"clouds\":{\"all\":0}, " +
                "\"dt\":1427700245, \"id\":0, \"name\":\"Mountain View\", \"cod\":200}";

        controller.getDailyWeather(weatherData);

        Assert.assertEquals("clouds should be set to 0", "0", controller.getClouds());
    }
}
