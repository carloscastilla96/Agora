package com.example.carloshernando.agora;

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

import java.util.ArrayList;

import items.Publication_Item;


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
        recyclerView.setAdapter(cardAdapter);
    }

    private void inicializar() {
        tarjetas.add(new Publication_Item(0, "carlos", "castilla", "Mascara de los secretos", "arte", "documental", "lorem ipsumo dolom sit amen"));
    }

}
