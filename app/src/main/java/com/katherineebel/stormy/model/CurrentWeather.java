package com.katherineebel.stormy.model;


import com.katherineebel.stormy.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by kathyebel on 4/13/17.
 */

public class CurrentWeather {
    private String mIcon;
    private long mTime;
    private double mTemperature;
    private double mHumidity;
    private double mPrecipChance;
    private String mSummary;
    private String mTimeZone;

    public CurrentWeather(String icon, long time, double temperature, double humidity, double precipChance, String summary, String timeZone) {
        this.mIcon = icon;
        this.mTime = time;
        this.mTemperature = temperature;
        this.mHumidity = humidity;
        this.mPrecipChance = precipChance;
        this.mTimeZone = timeZone;
        this.mSummary = summary;
    }

    public String getIcon() {
        return mIcon;
    }

    public int getIconId() {
        switch (mIcon) {
            case "clear-day":
                return R.drawable.clear_day;
            case "clear-night":
                return R.drawable.clear_night;
            case "rain":
                return R.drawable.rain;
            case "snow":
                return R.drawable.snow;
            case "sleet":
                return R.drawable.sleet;
            case "wind":
                return R.drawable.wind;
            case "fog":
                return R.drawable.fog;
            case "cloudy":
                return R.drawable.cloudy;
            case "partly-cloudy-day":
                return R.drawable.partly_cloudy;
            case "partly-cloudy-night":
                return R.drawable.cloudy_night;
            default:
                return R.drawable.clear_day;
        }
    }
    public void setIcon(String icon) {
        this.mIcon = icon;
    }

    public String getFormattedtime() {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(getTimeZone()));
        Date dateTime = new Date(getTime() * 1000);
        return formatter.format(dateTime);
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        this.mTime = time;
    }

    public int getTemperature() {
        return (int) Math.round(mTemperature);
    }

    public void setTemperature(double temperature) {
        this.mTemperature = temperature;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        this.mHumidity = humidity;
    }

    public int getPrecipChance() {
        return (int) Math.round(mPrecipChance * 100);
    }

    public void setPrecipChance(double precipChance) {
        this.mPrecipChance = precipChance;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setmSummary(String summary) {
        this.mSummary = summary;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }
}
