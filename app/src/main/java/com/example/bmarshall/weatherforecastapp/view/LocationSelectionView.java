package com.example.bmarshall.weatherforecastapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.bmarshall.weatherforecastapp.R;
import com.example.bmarshall.weatherforecastapp.controller.Controller;

public class LocationSelectionView extends AppCompatActivity {
    private String zipCode;
    public Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_location_selection);
        controller = new Controller();
    }

    public void onClickGoButton(View v){
        if(controller.checkValid(zipCode)){
            controller.saveLocation(zipCode);
        } else{
            //Error Message
        }
    }
}
