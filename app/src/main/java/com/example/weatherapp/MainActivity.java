package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irAListCiudades(View view){
       Intent miIntent = new Intent(this, ListActivity.class);
       startActivity(miIntent);
    }
    public void irADetalle(View view){
        //Iniciar nueva activity y pasarle como parametro la latitud y longitud de una ciudad
        Intent myIntent = new Intent(this, DetailActivity.class);
        //A la latitud y longitud se le agrega la "f" al final para indicar que es un float
        myIntent.putExtra("lat", "-38.5545f");
        myIntent.putExtra("lon", "-58.73961f");
        startActivity(myIntent);
    }
}
