package com.example.b02vickyrolandolangi;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import android.os.Bundle;

import java.net.CookieManager;

public class MainActivity extends AppCompatActivity {
    private TextView temperatureTextView;
    private ImageView weatherIconImageView;
    private TextView weatherDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureTextView = findViewById(R.id.temperatureTextView);
        weatherIconImageView = findViewById(R.id.weatherIconImageView);
        weatherDescriptionTextView = findViewById(R.id.weatherDescriptionTextView);

        // Panggil API untuk mendapatkan data cuaca dan tampilkan di UI
        fetchWeatherData("Manado");
    }

    private void fetchWeatherData(String cityName) {
        WeatherApiClient.getInstance().getWeather(cityName).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    WeatherResponse weatherResponse = response.body();
                    if (weatherResponse != null) {
                        double temperature = weatherResponse.getMain().getTemp();
                        String description = weatherResponse.getWeather().get(0).getDescription();
                        String iconCode = weatherResponse.getWeather().get(0).getIcon();

                        // Tampilkan data cuaca di UI
                        temperatureTextView.setText(String.format("%.1f°C", temperature - 273.15));
                        weatherDescriptionTextView.setText(description);

                        // Gunakan gambar ikon cuaca dari OpenWeather API
                        String iconUrl = "https://openweathermap.org/img/wn/" + iconCode + ".png";
                        Picasso.get().load(iconUrl).into(weatherIconImageView);
                    }
                } else {
                    // Tangani kesalahan komunikasi dengan API di sini
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                // Tangani kesalahan komunikasi dengan API di sini
            }
        });
    }
}
