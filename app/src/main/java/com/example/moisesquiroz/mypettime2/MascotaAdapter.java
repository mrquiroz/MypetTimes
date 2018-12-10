package com.example.moisesquiroz.mypettime2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaHolder>{


    public class MascotaHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtDistance, txtGravity, txtDiameter;
        public
        MascotaHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtDistance = itemView.findViewById(R.id.txtDistance);
            txtGravity = itemView.findViewById(R.id.txtGravity);
            txtDiameter = itemView.findViewById(R.id.txtDiameter);
        }
        public void setDetails(final Mascota mascota) {
            txtName.setText(mascota.getPlanetName());
            txtDistance.setText(String.format(Locale.US, "Especie : %s", mascota.getEspecie()));
            txtGravity.setText(String.format(Locale.US, "Fecha de Nacimiento : %s ", mascota.getFechaNacimiento()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                // Mensaje de prueba:
                    Toast mostrarNombre = Toast.makeText(context.getApplicationContext(), mascota.getPlanetName(), Toast.LENGTH_LONG);
                    mostrarNombre.show();
                }
            });

        }

    }
    private Context context;
    private ArrayList<Mascota> planets;
    public MascotaAdapter(Context context, ArrayList<Mascota> mascotas) {
            this.context = context;
            this.planets = mascotas;
        }
    @Override
    public int getItemCount() {
        return planets.size();
    }
    @Override
    public MascotaHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_row,parent, false);
        return new MascotaHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaHolder holder, int position) {
        Mascota mascota = planets.get(position);
        holder.setDetails(mascota);
    }

}

