package com.example.moisesquiroz.mypettime2.activitiesComida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.moisesquiroz.mypettime2.DBHelper;
import com.example.moisesquiroz.mypettime2.R;

public class AddComidaActivity extends AppCompatActivity {

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comida);
        db = new DBHelper(this);

        // Se obtiene el id de la mascota de la actividad anterior
        final int idMascota = getIntent().getIntExtra("idMascota", 0);

        Button aceptarButton = findViewById(R.id.aceptar_add_comida);
        aceptarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se obtienen los datos de la mascota
                EditText editEtiqueta = (EditText)findViewById(R.id.etiqueta_input);
                EditText editCantidad = (EditText)findViewById(R.id.cantidad_input);
                EditText editHora = (EditText)findViewById(R.id.hora_input);

                // TODO comprobar que la fecha este en formato correcto

                // Se agrega la nueva comida en la BD
                db.addComida(
                        editEtiqueta.getText().toString(),
                        Integer.parseInt(editCantidad.getText().toString()),
                        editHora.getText().toString(),
                        idMascota
                );

                volver(v, idMascota);
            }
        });

        Button cancelarButton = findViewById(R.id.cancelar_add_comida);
        cancelarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver(v, idMascota);
            }
        });
    }

    public void volver(View view, int id){
        db.close();
        Intent intent = new Intent(this, ComidaActivity.class);
        intent.putExtra("idMascota", id);
        startActivity(intent);
    }
}
