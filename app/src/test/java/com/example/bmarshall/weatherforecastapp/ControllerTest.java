package com.example.bmarshall.weatherforecastapp;

import com.example.bmarshall.weatherforecastapp.controller.Controller;
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
}
