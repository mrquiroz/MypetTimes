package com.example.moisesquiroz.mypettime2.activitiesComida;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moisesquiroz.mypettime2.R;
import com.example.moisesquiroz.mypettime2.clasesEntidades.Comida;

import java.util.ArrayList;
import java.util.Locale;

public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ComidaHolder> {

    public class ComidaHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtDistance, txtGravity, txtDiameter;
        public
        ComidaHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtDistance = itemView.findViewById(R.id.txtDistance);
            txtGravity = itemView.findViewById(R.id.txtGravity);
            txtDiameter = itemView.findViewById(R.id.txtDiameter);
        }
        public void setDetails(final Comida comida) {
            txtName.setText(comida.getEtiqueta());
            txtDistance.setText(String.format(Locale.US, "Cantidad : %d grs", comida.getCantidad()));
            txtGravity.setText(String.format(Locale.US, "Hora : %s ", comida.getHora()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editComida(view, comida.getId());
                }
            });

        }

    }

    private Context context;
    private ArrayList<Comida> comidas;
    public ComidaAdapter(Context context, ArrayList<Comida> comidas) {
        this.context = context;
        this.comidas = comidas;
    }
    @Override
    public int getItemCount() {
        return comidas.size();
    }
    @Override
    public ComidaHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_row,parent, false);
        return new ComidaHolder(view);
    }

    @Override
    public void onBindViewHolder(ComidaHolder holder, int position) {
        Comida comida = comidas.get(position);
        holder.setDetails(comida);
    }

    public void editComida(View view, int id) {
        Intent intent = new Intent(this.context, EditComidaActivity.class);
        intent.putExtra("idComida", id);
        context.startActivity(intent);
    }
}
