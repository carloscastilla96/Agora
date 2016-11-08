package com.example.carloshernando.agora;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import items.Publication_Item;

/**
 * Created by carloshernando on 11/7/2016.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolderTarjeta> {

    ArrayList<Publication_Item> tarjetas = new ArrayList<>();


    public CardAdapter(ArrayList<Publication_Item> tarjetas) {

        this.tarjetas = tarjetas;
    }

    public ViewHolderTarjeta onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        ViewHolderTarjeta vht = new ViewHolderTarjeta(v);
        return vht;
    }

    @Override
    public void onBindViewHolder(ViewHolderTarjeta holder, int i) {
        holder.categorie.setText(tarjetas.get(i).getCatagorie());
        holder.subCategorie.setText(tarjetas.get(i).getSubCategorie());
        holder.title.setText(tarjetas.get(i).getTittle());
        holder.author.setText(tarjetas.get(i).getName());
        holder.description.setText(tarjetas.get(i).getDescription());
        holder.city.setText(tarjetas.get(i).getCity());
        holder.enrolledProfessionals.setText(tarjetas.get(i).getProfessionalsObtained().size());
        holder.neededProfessionals.setText(tarjetas.get(i).getProfessionalsRequired().size());
        holder.daysLeft.setText(tarjetas.get(i).getDaysLeft());
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ViewHolderTarjeta extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView image;
        TextView categorie, subCategorie, title, author, description, city, workType, neededProfessionals, enrolledProfessionals, daysLeft;

        public ViewHolderTarjeta(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            image = (ImageView) itemView.findViewById(R.id.image);
            categorie = (TextView) itemView.findViewById(R.id.categorie);
            subCategorie = (TextView) itemView.findViewById(R.id.subCategorie);
            title = (TextView) itemView.findViewById(R.id.title);
            author = (TextView) itemView.findViewById(R.id.author);
            description = (TextView) itemView.findViewById(R.id.description);
            city = (TextView) itemView.findViewById(R.id.city);
            workType = (TextView) itemView.findViewById(R.id.workType);
            neededProfessionals = (TextView) itemView.findViewById(R.id.neededProfessionals);
            enrolledProfessionals = (TextView) itemView.findViewById(R.id.enrolledProfessionals);
            daysLeft = (TextView) itemView.findViewById(R.id.daysLeft);
        }
    }
}
