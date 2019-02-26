package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerview.Adaptador.AdaptadorPersona;
import com.example.recyclerview.Modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rcv);

        List<Persona> lp = new ArrayList<Persona>();

        lp.add(new Persona(1,"Daniel","Rodriguez",20));
        lp.add(new Persona(2,"Daniel","Rodriguez",20));
        lp.add(new Persona(3,"Daniel","Rodriguez",20));
        lp.add(new Persona(4,"Daniel","Rodriguez",20));

        AdaptadorPersona adp = new AdaptadorPersona(lp);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setAdapter(adp);

        // Como agregarle elementos, como animarlo, o agregarle CARDS y como asignarle eventos


    }
}
