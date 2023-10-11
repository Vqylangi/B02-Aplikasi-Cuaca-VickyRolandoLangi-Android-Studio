package com.example.b02vickyrolandolangi;

import com.google.gson.annotations.SerializedName;

public class WeatherMain {
    @SerializedName("temp")
    private double temp;

    public double getTemp() {
        return temp;
    }
}
