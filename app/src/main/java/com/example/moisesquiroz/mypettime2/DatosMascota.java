package com.example.moisesquiroz.mypettime2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DatosMascota extends AppCompatActivity {

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_mascota);
        db = new DBHelper (this);

        Button aceptarButton = findViewById(R.id.button);
        aceptarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO agregar datos de la mascota
                volver(v);
            }
        });

        Button cancelarButton = findViewById(R.id.button2);
        cancelarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver(v);
            }
        });

        db.close();
    }

    public void volver(View view) {
        db.close();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
