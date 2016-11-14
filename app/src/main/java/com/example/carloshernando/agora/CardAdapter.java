package com.example.carloshernando.agora;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import items.Publication_Item;

/**
 * Created by carloshernando on 11/7/2016.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolderTarjeta> {

    private final Context context;
    ArrayList<Publication_Item> tarjetas = new ArrayList<>();


    public CardAdapter(ArrayList<Publication_Item> tarjetas, Context context) {
        this.tarjetas = tarjetas;
        this.context = context;
    }

    public ViewHolderTarjeta onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        ViewHolderTarjeta vht = new ViewHolderTarjeta(v);
        return vht;
    }

    @Override
    public void onBindViewHolder(ViewHolderTarjeta holder, int i) {
        final Publication_Item item = tarjetas.get(i);
        ViewHolderTarjeta h = holder;
        holder.categorie.setText(tarjetas.get(i).getCatagorie());
        holder.subCategorie.setText(tarjetas.get(i).getSubCategorie());
        holder.title.setText(tarjetas.get(i).getTittle());
        holder.author.setText(tarjetas.get(i).getName() + " " + tarjetas.get(i).getLastName());
        holder.description.setText(tarjetas.get(i).getDescription());
        holder.city.setText(tarjetas.get(i).getCity());
//        holder.enrolledProfessionals.setText(0);
//        holder.neededProfessionals.setText(0);
        // holder.daysLeft.setText(tarjetas.get(i).getDaysLeft());

        Bitmap bm = BitmapFactory.decodeByteArray(tarjetas.get(i).getBytesImagen(), 0, tarjetas.get(i).getBytesImagen().length);
        DisplayMetrics dm = new DisplayMetrics();
        //  cgetWindowManager().getDefaultDisplay().getMetrics(dm);
        h.image.setMinimumHeight(dm.heightPixels);
        h.image.setMinimumWidth(dm.widthPixels);
        h.image.setImageBitmap(bm);
        holder.currentItem = tarjetas.get(i);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Publication.class);
                i.putExtra("publicacion", item);
                context.startActivity(i);
            }
        });

    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return tarjetas.size();
    }


    public static class ViewHolderTarjeta extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView image;
        TextView categorie, subCategorie, title, author, description, city, workType, neededProfessionals, enrolledProfessionals, daysLeft;
        public Publication_Item currentItem;


        public ViewHolderTarjeta(final View itemView) {
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
            //ededProfessionals = (TextView) itemView.findViewById(R.id.neededProfessionals);
            //nrolledProfessionals = (TextView) itemView.findViewById(R.id.enrolledProfessionals);
            daysLeft = (TextView) itemView.findViewById(R.id.daysLeft);


        }


    }


}
