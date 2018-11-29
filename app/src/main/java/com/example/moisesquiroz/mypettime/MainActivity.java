package com.example.moisesquiroz.mypettime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    class Mascota {
        String name;
        String age;

        Mascota(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }

    private List<Mascota> mascotas;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Emma Wilson", "23 years old"));
        mascotas.add(new Mascota("Lavery Maiss", "25 years old"));
        mascotas.add(new Mascota("Lillie Watts", "35 years old"));
    }
    public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

        public static class PersonViewHolder extends RecyclerView.ViewHolder {
            CardView cv;
            TextView personName;
            TextView personAge;
            ImageView personPhoto;

            PersonViewHolder(View itemView) {
                super(itemView);
                cv = (CardView)itemView.findViewById(R.id.cv);
                personName = (TextView)itemView.findViewById(R.id.person_name);
                personAge = (TextView)itemView.findViewById(R.id.person_age);
            }
        }

    }
}
