package com.example.bmarshall.weatherforecastapp;

import com.example.bmarshall.weatherforecastapp.controller.Controller;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by bmarshall on 2/24/17.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class ControllerTest {
    private Controller controller;

    @Before
    public void setUp(){
        controller = new Controller();
    }

    @Test
    public void checkValidTest(){
        String validEntry = "48310";
        Assert.assertEquals("valid entry should return true", true, controller.checkValid(validEntry));
        String invalidEntry = "4831";
        Assert.assertEquals("invalid entry should return false", false, controller.checkValid(invalidEntry));
    }

    @Test
    public void saveLocationTest(){
        String location = "48310";
        controller.saveLocation(location);
        Assert.assertEquals("saveLocation should save the location we enter", location, controller.getSavedLocation());
    }

    @Test
    public void getSavedLocationTest(){
        String location = "48310";
        controller.saveLocation(location);
        Assert.assertEquals("getSavedLocation should return the location we save", location, controller.getSavedLocation());
    }
}
