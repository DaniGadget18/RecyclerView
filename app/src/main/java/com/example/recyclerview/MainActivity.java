package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.recyclerview.Adaptador.AdaptadorPersona;
import com.example.recyclerview.Modelo.Persona;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rcv);
        findViewById(R.id.Cargar).setOnClickListener(this);
    }

    public void onClick(View view) {

        JsonArrayRequest jr = new JsonArrayRequest(Request.Method.GET, "http://nuevo.rnrsiilge-org.mx/lista", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson g = new Gson();

                Type tp = new TypeToken<List<Persona>>(){}.getType();

                Log.d("Lista",response.toString());
                List<Persona> lp = g.fromJson(response.toString(),tp);

                AdaptadorPersona ap = new AdaptadorPersona(lp);

                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rv.setAdapter( new AdaptadorPersona(lp));


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleyS.getInstance(this).getRq().add(jr);

    }
}
