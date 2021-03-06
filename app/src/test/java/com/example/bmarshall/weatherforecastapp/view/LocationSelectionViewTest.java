package com.example.bmarshall.weatherforecastapp.view;

import android.widget.Button;
import android.widget.EditText;

import com.example.bmarshall.weatherforecastapp.BuildConfig;
import com.example.bmarshall.weatherforecastapp.R;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class LocationSelectionViewTest {
    private Button goButton;
    private LocationSelectionView locationSelectionView;
    private EditText zipCodeEditText;

    @Before
    public void setUp() {
        locationSelectionView = Robolectric.buildActivity(LocationSelectionView.class).create().get();
        goButton = (Button) locationSelectionView.findViewById(R.id.go_btn);
        zipCodeEditText = (EditText) locationSelectionView.findViewById(R.id.zipcode_edittext);
    }

    @Test
    public void onClickGoButtonTest() {
        zipCodeEditText.setText(locationSelectionView.getString(R.string.goodzip));
        goButton.callOnClick();
        Assert.assertEquals("Saved Location should be equal to valid location entered",
                zipCodeEditText.getText(), locationSelectionView.controller.getSavedLocation(locationSelectionView));

        zipCodeEditText.setText(locationSelectionView.getString(R.string.badzip));
        goButton.callOnClick();
        Assert.assertNotSame("Saved Location should not equal invalid location entered",
                zipCodeEditText.getText(), locationSelectionView.controller.getSavedLocation(locationSelectionView));
    }
}
