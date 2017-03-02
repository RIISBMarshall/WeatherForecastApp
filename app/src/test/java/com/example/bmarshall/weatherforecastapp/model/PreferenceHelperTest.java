package com.example.bmarshall.weatherforecastapp.model;

import com.example.bmarshall.weatherforecastapp.BuildConfig;
import com.example.bmarshall.weatherforecastapp.view.LocationSelectionView;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class PreferenceHelperTest {
    private PreferenceHelper preferenceHelper;
    private LocationSelectionView locationSelectionView;

    @Before
    public void setUp() {
        preferenceHelper = new PreferenceHelper();
        locationSelectionView = Robolectric.buildActivity(LocationSelectionView.class).create().get();
    }

    @Test
    public void checkValidTest() {
        String validEntry = "48310";
        Assert.assertEquals("valid entry should return true", true, preferenceHelper.checkValid(validEntry));
        String invalidEntry = "4831";
        Assert.assertEquals("invalid entry should return false", false, preferenceHelper.checkValid(invalidEntry));
    }

    @Test
    public void saveLocationTest() {
        String location = "48310";
        preferenceHelper.saveLocation(location, locationSelectionView);
        Assert.assertEquals("saveLocation should save the location we enter", location, preferenceHelper.getSavedLocation(locationSelectionView));
    }

    @Test
    public void getSavedLocationTest() {
        String location = "48310";
        preferenceHelper.saveLocation(location, locationSelectionView);
        Assert.assertEquals("getSavedLocation should return the location we save", location, preferenceHelper.getSavedLocation(locationSelectionView));
    }
}
