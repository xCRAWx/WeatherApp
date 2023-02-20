package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    TextView nameOfCity, tempActual,tempMax, tempMin, description;
    ImageView imageIcon;
    float latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Obtener la latitud y longitud de la activity anterior
        Intent myIntent = getIntent(); //obtiene el item creado anteriormente
        latitud = myIntent.getFloatExtra("lat", 0.0F);
        longitud = myIntent.getFloatExtra("lon", 0.0F);

        //String ciudadElegida = myIntent.getStringExtra("nombreCiudad");
        //TextView nombreCiudad = findViewById(R.id.tvCiudad);
        //nombreCiudad.setText(ciudadElegida);

        //Obtener las textViews
        nameOfCity = findViewById(R.id.nameOfCity);
        tempActual = findViewById(R.id.tempActual);
        tempMax = findViewById(R.id.tempMax);
        tempMin = findViewById(R.id.tempMin);
        description = findViewById(R.id.description);
        //imageIcon = findViewById(R.id.imageIcon);

        getActualWeather();
    }

    private void getActualWeather(){
        //llamar a la API

        Call<Results> call = RetrofitClient.getInstance().getMyApi().getActualWeather(latitud, longitud, API.TOKEN, API.UNITS, API.LANG);
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                if (response.isSuccessful()){
                    Results results = response.body();
                    nameOfCity.setText(results.name);
                    tempActual.setText(String.valueOf(results.main.temp.shortValue()));
                    tempMax.setText(String.valueOf(results.main.temperaturaMaxima.shortValue()));
                    tempMin.setText(String.valueOf(results.main.temperaturaMinima.shortValue()));
                    Results.Weather weather = results.weather.get(0);
                    description.setText(weather.description);
                    String imageIconBaseURL = "https://openweathermap.org/img/wn/10d@2x.png";
                    String finalURL = "2x.png";
                    String urlFinal = imageIconBaseURL + weather.icon + finalURL;

                    new DownloadImageTask(imageIcon).execute(urlFinal);

                } else {
                    Toast.makeText(DetailActivity.this, "Error al intentar pedir los datos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

            }
        });

    }
}