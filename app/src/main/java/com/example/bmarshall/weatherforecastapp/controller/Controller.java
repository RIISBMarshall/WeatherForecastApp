package com.example.bmarshall.weatherforecastapp.controller;

import com.example.bmarshall.weatherforecastapp.model.PreferenceHelper;

/**
 * Created by bmarshall on 2/24/17.
 */

public class Controller {
    private PreferenceHelper preferenceHelper;

    public boolean checkValid(String enteredLocation){
        return preferenceHelper.checkValid(enteredLocation);
    }

    public void saveLocation(String zipCode){
        preferenceHelper.saveLocation(zipCode);
    }

    public String getSavedLocation(){
        return preferenceHelper.getSavedLocation();
    }
}
