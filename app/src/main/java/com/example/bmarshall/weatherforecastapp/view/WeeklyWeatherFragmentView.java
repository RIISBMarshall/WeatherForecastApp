package com.example.bmarshall.weatherforecastapp.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.bmarshall.weatherforecastapp.R;

public class WeeklyWeatherFragmentView extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        return (LinearLayout) inflater.inflate(R.layout.view_weekly_weather_fragment, container, false);
    }
}
