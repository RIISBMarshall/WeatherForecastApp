package com.example.bmarshall.weatherforecastapp.view;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bmarshall.weatherforecastapp.R;
import com.example.bmarshall.weatherforecastapp.controller.Controller;

import java.util.List;
import java.util.Vector;

public class WeatherForecastView extends FragmentActivity {

    public Controller controller;
    private PagerAdapter mPagerAdapter;
    private TextView locationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_weather_forecast);
        locationTextView = (TextView) findViewById(R.id.locationtxt);
        controller = new Controller();
        String location = controller.getSavedLocation(this);

        String weatherData = controller.fetchDailyWeatherData(location);
        controller.getDailyWeather(weatherData);
        controller.setIconData();
        locationTextView.setText(controller.getLocationName());

        weatherData = controller.fetchWeeklyWeatherData(location);
        controller.getWeeksWeather(weatherData);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        controller.setWeeksWeatherIconData();

        System.out.println("before");
        if(controller.weatherIsBad()){
            System.out.println("after");
            String longText = "Warning: Bad weather in your selected area!";
            Intent intent = new Intent(this, WeatherForecastView.class);
            PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
            Notification n  = new Notification.Builder(this)
                    .setContentTitle("BAD WEATHER WARNING!!")
                    .setContentText("Subject")
                    .setSmallIcon(R.drawable.icon)
                    .setContentIntent(pIntent)
                    .setAutoCancel(true)
                    .setStyle(new Notification.BigTextStyle().bigText(longText))
                    .addAction(R.drawable.icon, "More", pIntent).build();
            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(0, n);
        }

        this.initialisePaging();
    }

    public void onClickChangeLocationButton(View v) {
        controller.saveLocation("bad location", this);
        Intent intent = new Intent(WeatherForecastView.this, LocationSelectionView.class);
        startActivity(intent);
    }

    public void initialisePaging() {
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, DailyWeatherFragmentView.class.getName()));
        fragments.add(Fragment.instantiate(this, WeeklyWeatherFragmentView.class.getName()));
        this.mPagerAdapter = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        //
        ViewPager pager = (ViewPager) super.findViewById(R.id.pager);
        pager.setAdapter(this.mPagerAdapter);
    }
}
