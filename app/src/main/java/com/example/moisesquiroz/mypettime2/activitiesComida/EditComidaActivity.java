package com.example.moisesquiroz.mypettime2.activitiesComida;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.moisesquiroz.mypettime2.DBHelper;
import com.example.moisesquiroz.mypettime2.R;

public class EditComidaActivity extends AppCompatActivity {

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_comida);
        db = new DBHelper(this);

        // Se obtiene el id de la comida, de la actividad anterior
        final int idComida = getIntent().getIntExtra("idComida", 0);
        Cursor refComida = db.getComida(idComida);
        refComida.moveToFirst();
        final int idMascota = refComida.getInt(refComida.getColumnIndex("idMascota"));
        refComida.close();

        Button aceptarButton = findViewById(R.id.aceptar_edit_comida);
        aceptarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se obtienen los datos de la mascota
                EditText editEtiqueta = (EditText)findViewById(R.id.etiqueta_input);
                EditText editCantidad = (EditText)findViewById(R.id.cantidad_input);
                EditText editHora = (EditText)findViewById(R.id.hora_input);

                // TODO comprobar que la hora este en formato correcto

                // Se modifica la comida en la BD
                db.updateComida(
                        idComida,
                        editEtiqueta.getText().toString(),
                        Integer.parseInt(editCantidad.getText().toString()),
                        editHora.getText().toString(),
                        idMascota
                );

                volver(v, idMascota);
            }
        });

        Button cancelarButton = findViewById(R.id.cancelar_edit_comida);
        cancelarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver(v, idMascota);
            }
        });

        Button eliminarButton = findViewById(R.id.eliminar_comida);
        eliminarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteComida(idComida);
                volver(v, idMascota);
            }
        });
    }

    public void volver(View view, int idMascota){
        db.close();
        Intent intent = new Intent(this, ComidaActivity.class);
        intent.putExtra("idMascota", idMascota);
        startActivity(intent);
    }
}
