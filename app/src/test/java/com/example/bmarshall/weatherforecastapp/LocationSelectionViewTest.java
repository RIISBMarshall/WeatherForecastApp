package com.example.bmarshall.weatherforecastapp;

import android.widget.Button;
import android.widget.EditText;

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
public class LocationSelectionViewTest {
    private Button goButton;
    private LocationSelectionView locationSelectionView;
    private EditText zipCodeEditText;

    @Before
    public void setUp(){
        locationSelectionView = Robolectric.buildActivity(LocationSelectionView.class).create().get();
        goButton = (Button) locationSelectionView.findViewById(R.id.go_btn);
        zipCodeEditText = (EditText) locationSelectionView.findViewById(R.id.zipcode_edittext);
    }

    @Test
    public void onClickGoButtonTest() throws IllegalAccessException, IOException, InstantiationException {
        zipCodeEditText.setText("48310");
        goButton.callOnClick();
        Assert.assertEquals("Saved Location should be equal to valid location entered",
                zipCodeEditText.getText(), locationSelectionView.controller.getSavedLocation(locationSelectionView));

        zipCodeEditText.setText("483105");
        goButton.callOnClick();
        Assert.assertNotSame("Saved Location should not equal invalid location entered",
                zipCodeEditText.getText(), locationSelectionView.controller.getSavedLocation(locationSelectionView));
    }
}
