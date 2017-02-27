package com.example.bmarshall.weatherforecastapp.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferenceHelper {
    private static final String PREFS_NAME = "AOP_PREFS";
    private static final String PREFS_KEY = "AOP_PREFS_String";

    public PreferenceHelper() {
    }

    public void saveLocation(String zipCode, Context context) {
        SharedPreferences settings;
        Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.putString(PREFS_KEY, zipCode);
        editor.apply();
    }

    public String getSavedLocation(Context context) {
        SharedPreferences settings;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getString(PREFS_KEY, null);
    }

    public boolean checkValid(String enteredLocation) {
        if ((enteredLocation != null) && (enteredLocation.length() == 5) && enteredLocation.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }
}
