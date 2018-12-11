package com.example.moisesquiroz.mypettime2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CuidadoMascota extends AppCompatActivity {

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuidado_mascota);
        db = new DBHelper(this);

        // Recibe los datos de la actividad anterior
        final int idMascota = getIntent().getIntExtra("idMascota", 0);
        Cursor refMascota = db.getMascota(idMascota);
        refMascota.moveToFirst();
        String nombreMascota = refMascota.getString(refMascota.getColumnIndex("nombre"));
        refMascota.close();

        // Muestra el nombre de la mascota actual
        final TextView nMascotaTxtView = (TextView) findViewById(R.id.display_nombre_mascota);
        nMascotaTxtView.setText(nombreMascota);

        // Editar Mascota
        Button editarMButton = findViewById(R.id.editar_mascota);
        editarMButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irEditar(v, idMascota);
            }
        });

        // Eliminar Mascota
        Button eliminarButton = findViewById(R.id.eliminar_mascota);
        eliminarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteMascota(idMascota);
                volverMain(v);
            }
        });
    }

    public void irEditar(View view, int id){
        db.close();
        Intent intent = new Intent(this, EditMascota.class);
        intent.putExtra("idMascota", id);
        startActivity(intent);
    }

    public void volverMain(View view){
        db.close();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
