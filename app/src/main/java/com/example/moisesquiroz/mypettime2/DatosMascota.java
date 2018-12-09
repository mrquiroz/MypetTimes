package com.example.moisesquiroz.mypettime2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                // Se obtienen los datos de la mascota
                EditText editNombre = (EditText)findViewById(R.id.nombre_mascota_input);
                EditText editEspecie = (EditText)findViewById(R.id.especie_input);
                EditText editFechaN = (EditText)findViewById(R.id.fecha_nacimiento_input);

                // TODO comprobar que la fecha este en formato correcto

                // Se agrega la nueva mascota en la BD
                db.addMascota(
                        editNombre.getText().toString(),
                        editEspecie.getText().toString(),
                        editFechaN.getText().toString()
                );

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

    }

    public void volver(View view) {
        db.close();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
