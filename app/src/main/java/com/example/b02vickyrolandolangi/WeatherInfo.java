package com.example.b02vickyrolandolangi;

import com.google.gson.annotations.SerializedName;

public class WeatherInfo {
    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String icon;

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
