package com.example.moisesquiroz.mypettime2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditMascota extends AppCompatActivity {

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mascota);
        db = new DBHelper(this);

        // Se obtiene el id de la mascota de la actividad anterior
        final int idMascota = getIntent().getIntExtra("idMascota", 0);
        Cursor refMascota = db.getMascota(idMascota);
        refMascota.moveToFirst();
        String nombreMascota = refMascota.getString(refMascota.getColumnIndex("nombre"));
        refMascota.close();

        // Muestra el nombre de la mascota actual
        final TextView nMascotaTxtView = (TextView) findViewById(R.id.display_mascota);
        nMascotaTxtView.setText("Editar Datos - " + nombreMascota);

        Button aceptarButton = findViewById(R.id.button_aceptar);
        aceptarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se obtienen los datos de la mascota
                EditText editNombre = (EditText)findViewById(R.id.nombre_mascota_input);
                EditText editEspecie = (EditText)findViewById(R.id.especie_input);
                EditText editFechaN = (EditText)findViewById(R.id.fecha_nacimiento_input);

                // TODO comprobar que la fecha este en formato correcto

                // Se agrega la nueva mascota en la BD
                db.updateMascota(
                        idMascota,
                        editNombre.getText().toString(),
                        editEspecie.getText().toString(),
                        editFechaN.getText().toString()
                );

                volver(v, idMascota);
            }
        });

        Button cancelarButton = findViewById(R.id.button_cancelar);
        cancelarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver(v, idMascota);
            }
        });
    }

    public void volver(View view, int id) {
        db.close();
        Intent intent = new Intent(this, CuidadoMascota.class);
        intent.putExtra("idMascota", id);
        startActivity(intent);
    }
}
