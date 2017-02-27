package com.example.bmarshall.weatherforecastapp.controller;

import android.content.Context;

import com.example.bmarshall.weatherforecastapp.model.PreferenceHelper;

import java.io.IOException;

/**
 * Created by bmarshall on 2/24/17.
 */

public class Controller {

    public boolean checkValid(String enteredLocation) {
        PreferenceHelper preferenceHelper = new PreferenceHelper();
        return preferenceHelper.checkValid(enteredLocation);
    }

    public void saveLocation(String zipCode, Context context) throws IllegalAccessException, IOException, InstantiationException {
        PreferenceHelper preferenceHelper = new PreferenceHelper();
        preferenceHelper.saveLocation(zipCode, context);
    }

    public String getSavedLocation(Context context) throws IllegalAccessException, IOException, InstantiationException {
        PreferenceHelper preferenceHelper = new PreferenceHelper();
        return preferenceHelper.getSavedLocation(context);
    }
}
