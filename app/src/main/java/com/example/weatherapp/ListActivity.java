package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
        private ListView listview;
        private ArrayList<String> ciudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setupListView();
    }

    void setupListView() {
        listview = (ListView) findViewById(R.id.miListView);
        ciudades = new ArrayList<String>();
        ciudades.add("Londres");
        ciudades.add("Paris");
        ciudades.add("Buenos Aires");
        ciudades.add("New York");
        ciudades.add("Miami");




        CustomAdapter adapter = new CustomAdapter(this, ciudades);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                irAdetail(ciudades.get(position));

            }
        });
    }

    private void irAdetail(String ciudad){
        Intent intentParaDetail = new Intent(this, DetailActivity.class);
        intentParaDetail.putExtra("nombreCiudad", ciudad);
        startActivity(intentParaDetail);



    }

}