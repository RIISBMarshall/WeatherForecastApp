package com.example.bmarshall.weatherforecastapp.model;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bmarshall on 2/27/17.
 */

public class APIHelper {

    public String fetchWeatherData(String location, String dayOrWeek) {
        final String DAY_URL = "http://api.openweathermap.org/data/2.5/weather?zip=";
        final String WEEK_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?zip=";
        final String API = "ab91657c8c50ed23f0e6041b14b7d71f";

        HttpURLConnection con = null;
        InputStream is = null;

        String baseURL;

        if(dayOrWeek.equals("day")){
            baseURL = DAY_URL;
        } else{
            baseURL = WEEK_URL;
        }

        try {
            con = (HttpURLConnection) (new URL(baseURL + location + "&appid=" + API)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null)
                buffer.append(line + "\r\n");

            is.close();
            con.disconnect();
            return buffer.toString();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable t) {
            }
            try {
                con.disconnect();
            } catch (Throwable t) {
            }
        }
        return null;
    }

    public byte[] getImage(String code) {
        HttpURLConnection con = null;
        InputStream is = null;
        final String IMG_URL = "http://openweathermap.org/img/w/";
        try {
            con = (HttpURLConnection) (new URL(IMG_URL + code + ".png")).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            //con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while (is.read(buffer) != -1)
                baos.write(buffer);

            return baos.toByteArray();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable t) {
            }
            try {
                con.disconnect();
            } catch (Throwable t) {
            }
        }
        return null;
    }
}
