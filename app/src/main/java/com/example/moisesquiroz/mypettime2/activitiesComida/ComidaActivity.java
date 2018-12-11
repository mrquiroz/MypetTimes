package com.example.moisesquiroz.mypettime2.activitiesComida;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.moisesquiroz.mypettime2.DBHelper;
import com.example.moisesquiroz.mypettime2.LineDividerItemDecoration;
import com.example.moisesquiroz.mypettime2.R;
import com.example.moisesquiroz.mypettime2.clasesEntidades.Comida;

import java.util.ArrayList;

public class ComidaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ComidaAdapter adapter;
    private ArrayList<Comida> comidaArrayList;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);
        db = new DBHelper (this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        comidaArrayList = new ArrayList<>();
        adapter = new ComidaAdapter(this, comidaArrayList);
        recyclerView.addItemDecoration(new LineDividerItemDecoration(this, R.drawable.line_divider));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        // Obtener idMascota de la actividad anterior
        final int idMascota = getIntent().getIntExtra("idMascota", 0);

        FloatingActionButton fab = findViewById(R.id.floating_action_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComida(v, idMascota);
            }
        });

        // Cargar lista de comidas
        db.getComidaWithMascota(idMascota, comidaArrayList);
        adapter.notifyDataSetChanged();
    }

    public void addComida(View view, int id){
        db.close();
        Intent intent = new Intent(this, AddComidaActivity.class);
        intent.putExtra("idMascota", id);
        startActivity(intent);
    }
}
