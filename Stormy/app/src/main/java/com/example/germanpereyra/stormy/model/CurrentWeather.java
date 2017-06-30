package com.example.germanpereyra.stormy.model;

import com.example.germanpereyra.stormy.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by germanpereyra on 6/28/17.
 */

public class CurrentWeather {
    private String icon;
    private long time;
    private double temperature;
    private double humedity;
    private double precipitationChance;
    private String summary;
    private String timeZone;
    private int resourceIconId;

    public int getResourceIconId() {
        if (resourceIconId == 0) {

            resourceIconId = R.drawable.clear_day;
            String mIcon = this.icon;

            if (mIcon.equals("clear-day")) {
                resourceIconId = R.drawable.clear_day;
            }
            else if (mIcon.equals("clear-night")) {
                resourceIconId = R.drawable.clear_night;
            }
            else if (mIcon.equals("rain")) {
                resourceIconId = R.drawable.rain;
            }
            else if (mIcon.equals("snow")) {
                resourceIconId = R.drawable.snow;
            }
            else if (mIcon.equals("sleet")) {
                resourceIconId = R.drawable.sleet;
            }
            else if (mIcon.equals("wind")) {
                resourceIconId = R.drawable.wind;
            }
            else if (mIcon.equals("fog")) {
                resourceIconId = R.drawable.fog;
            }
            else if (mIcon.equals("cloudy")) {
                resourceIconId = R.drawable.cloudy;
            }
            else if (mIcon.equals("partly-cloudy-day")) {
                resourceIconId = R.drawable.partly_cloudy;
            }
            else if (mIcon.equals("partly-cloudy-night")) {
                resourceIconId = R.drawable.cloudy_night;
            }

        }
        return resourceIconId;
    }

    public void setResourceIconId(int resourceIconId) {
        this.resourceIconId = resourceIconId;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumedity() {
        return humedity;
    }

    public void setHumedity(double humedity) {
        this.humedity = humedity;
    }

    public double getPrecipitationChance() {
        return precipitationChance;
    }

    public String getFormattedDate() {
        SimpleDateFormat formater = new SimpleDateFormat("dd MM a");
        formater.setTimeZone(TimeZone.getTimeZone(timeZone));
        return formater.format(new Date(time));
    }

    public void setPrecipitationChance(double precipitationChance) {
        this.precipitationChance = precipitationChance;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
