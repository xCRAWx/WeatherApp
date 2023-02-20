package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    //BASE URL es el host para la llamada al endpoint
    String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    //TOKEN sacado de Openweather page.
    String TOKEN = "1f06361c2706b0926610d6b3f8b1f1ae";

    //units para definir que unidad para que vengan los datos
    String UNITS = "metric";

    //LANG en que idioma queremos la info
    String LANG = "es";

    @GET("weather") //https://api.openweathermap.org/data/2.5/weather?lat=-38.5545&lon=-58.73961&appid=1f06361c2706b0926610d6b3f8b1f1ae&units=metric&lang=es
    Call<Results> getActualWeather(@Query("lat") Float latitud, @Query("lon") Float longitud, @Query("appid") String token, @Query("units") String units, @Query("lang") String lang);


}
