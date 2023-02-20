package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Results {
    //Modelo
    @SerializedName("name")
    public String name;

    @SerializedName("weather")
    public ArrayList<Weather> weather = null;
    @SerializedName("main")
    public Main main = null;

    @SerializedName("visibility")
    public Integer visibility;

    public class Main {
        @SerializedName("temp")
        public Float temp;
        @SerializedName("temp_min")
        public Float temperaturaMinima;
        @SerializedName("temp_max")
        public Float temperaturaMaxima;
    }

    public class Weather {
        @SerializedName("description")
        public String description;
        @SerializedName("icon")
        public String icon;
    }

    public Results(String name, ArrayList<Weather> weather, Main main, Integer visibility) {
        this.name = name;
        this.weather = weather;
        this.main = main;
        this.visibility = visibility;
    }
}
