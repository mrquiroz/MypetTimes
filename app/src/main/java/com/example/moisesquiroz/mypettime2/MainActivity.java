package com.example.moisesquiroz.mypettime2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MascotaAdapter adapter;
    private ArrayList<Mascota> planetArrayList;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper (this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        planetArrayList = new ArrayList<>();
        adapter = new MascotaAdapter(this, planetArrayList);
        recyclerView.addItemDecoration(new LineDividerItemDecoration(this, R.drawable.line_divider));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.floating_action_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mover(v);
            }
        });



        if(db.checkEmpty())
        {
            createListData();
        }

        db.getAllMascota(planetArrayList);
        adapter.notifyDataSetChanged();
    }

    public void mover(View view) {
        db.close();
        Intent intent = new Intent(this, DatosMascota.class);
        startActivity(intent);
    }


    private void createListData() {
        // Inicializa con valores de prueba
        db.addMascota("Firulais", "Perro", "01/10/2015");
        db.addMascota("Huesos", "Perro", "10/11/2010");
        db.addMascota("Misifus", "Gato", "25/04/2013");
        db.addMascota("Richard Parker", "Tigre", "12/06/2011");
        db.addMascota("Jaws", "Tiburon Blanco", "14/03/2009");
    }
}