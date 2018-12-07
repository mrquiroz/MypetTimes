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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        createListData();

    }

    public void mover(View view) {
        Intent intent = new Intent(this, DatosMascota.class);
        startActivity(intent);
    }




    private void createListData() {
        Mascota planet = new Mascota("Cachupin", 15, 10, 12);
        planetArrayList.add(planet);

        planet = new Mascota("Naruto", 7, 2, 14);
        planetArrayList.add(planet);

        planet = new Mascota("Batman", 2, 4, 68);
        planetArrayList.add(planet);

        planet = new Mascota("Silvestre", 5, 1, 23);
        planetArrayList.add(planet);

        planet = new Mascota("Gato1", 10, 9, 127);
        planetArrayList.add(planet);

        planet = new Mascota("Gato2", 14, 11, 12);
        planetArrayList.add(planet);

        planet = new Mascota("Gato1 otra vez", 5, 4, 49);
        planetArrayList.add(planet);

        planet = new Mascota("perro", 4, 12, 50);
        planetArrayList.add(planet);

        planet = new Mascota("doki", 2, 9, 52);
        planetArrayList.add(planet);

        adapter.notifyDataSetChanged();
    }
}