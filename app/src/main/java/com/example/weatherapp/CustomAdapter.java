package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<String> ciudades;

    public CustomAdapter(Context context, ArrayList<String> names) {
        this.context = context;
        this.ciudades = names;
    }

    @Override
    public int getCount() {
        return ciudades.size();
    }

    @Override
    public Object getItem(int position) {
        return this.ciudades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        //inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.list_item_ciudad, null);

        //valor actual segun la posicion
        String currentName = ciudades.get(position);

        //Referenciamos el elemento a modificar y lo rellenamos
        TextView textView = (TextView) v.findViewById(R.id.textView_item);
        textView.setText(currentName);

        //Devolvemos la vista inflada
        return v;
    }
}

