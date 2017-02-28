package com.example.bmarshall.weatherforecastapp.view;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmarshall.weatherforecastapp.R;
import com.example.bmarshall.weatherforecastapp.controller.Controller;

import java.io.IOException;

public class LocationSelectionView extends AppCompatActivity {
    private String zipCode;
    public Controller controller;
    private EditText zipCodeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_location_selection);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        controller = new Controller();
        next();
        zipCodeEditText = (EditText) findViewById(R.id.zipcode_edittext);
    }

    public void onClickGoButton(View v) throws IllegalAccessException, IOException, InstantiationException {
        zipCode = String.valueOf(zipCodeEditText.getText());
        if (controller.checkValid(zipCode)) {
            controller.saveLocation(zipCode, this);
            Intent intent = new Intent(LocationSelectionView.this, WeatherForecastView.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Invalid ZipCode",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void next() {
        if (controller.checkValid(controller.getSavedLocation(this))) {
            Intent intent = new Intent(LocationSelectionView.this, WeatherForecastView.class);
            startActivity(intent);
        }
    }
}
