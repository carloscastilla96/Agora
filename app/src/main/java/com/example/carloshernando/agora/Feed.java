package com.example.carloshernando.agora;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.CardView;
import android.widget.Toast;

import java.util.ArrayList;

import items.Publication_Item;
import petitions.PublicationPetition;
import petitions.UserPetition;
import red.Comunicacion;
import red.User;


public class Feed extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private CardView cardView;
    ArrayList<Publication_Item> tarjetas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);
        recyclerView = (RecyclerView) findViewById(R.id.cardRecycle);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        cardAdapter = new CardAdapter(tarjetas);
        inicializar();
        recyclerView.setAdapter(cardAdapter);

        traerPublicaciones();

    }

    public void traerPublicaciones() {

         new Task(this, tarjetas).execute();
    }

    private void inicializar() {
        tarjetas.add(new Publication_Item(0, "carlos", "castilla", "Mascara de los secretos", "arte", "documental", "lorem ipsumo dolom sit amen"));
        tarjetas.add(new Publication_Item(1, "carlos", "castilla", "Mascara de los secretos", "arte", "documental", "lorem ipsumo dolom sit amen"));
    }


    protected class Task extends AsyncTask<String, String, ArrayList<Publication_Item>> {

        private final ArrayList<Publication_Item> tarjetas;
        Context context;

        private Task(Context context, ArrayList<Publication_Item> tarjetas) {
            this.context = context;
            this.tarjetas = tarjetas;
        }

        @Override
        protected ArrayList<Publication_Item> doInBackground(String... params) {

            // creo una petición de inicio usuario
            PublicationPetition uP = new PublicationPetition("");
            Comunicacion.getInstance().enviar(uP);

            while (true) {

                Object res = Comunicacion.getInstance().recibir();

                if (res instanceof Publication_Item) {
                    tarjetas.add((Publication_Item) res);
                    System.err.println("as.dkvjbabsjvakjsbdvkajsbd.vabjsdv");

                } else {
                    return tarjetas;


                }
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Publication_Item> s) {
            s.add(new Publication_Item(0, "carlos", "castilla", "Mascara de los secretos", "arte", "documental", "lorem ipsumo dolom sit amen"));
            cardAdapter = new CardAdapter(s);
            recyclerView.setAdapter(cardAdapter);
        }
    }
}
