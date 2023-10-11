package com.example.b02vickyrolandolangi;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {
    @SerializedName("main")
    private WeatherMain main;

    @SerializedName("weather")
    private List<WeatherInfo> weather;

    public WeatherMain getMain() {
        return main;
    }

    public List<WeatherInfo> getWeather() {
        return weather;
    }
}
