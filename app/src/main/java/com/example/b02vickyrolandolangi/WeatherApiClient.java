package com.example.b02vickyrolandolangi;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiClient {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "a96792fb6ef90130a2831330d5957e37";

    private static WeatherApiClient instance;
    private WeatherApi weatherApi;

    private WeatherApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherApi = retrofit.create(WeatherApi.class);
    }

    public static WeatherApiClient getInstance() {
        if (instance == null) {
            instance = new WeatherApiClient();
        }
        return instance;
    }

    public Call<WeatherResponse> getWeather(String cityName) {
        return weatherApi.getWeather(cityName, API_KEY);
    }
}
