package com.example.carloshernando.agora;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import items.ProfessionalRequired;

/**
 * Created by carloshernando on 11/14/2016.
 */
public class PubProfessionalAdapter extends RecyclerView.Adapter<PubProfessionalAdapter.PubProfessionalViewHolder> {

    private ArrayList<ProfessionalRequired> newProfessionals = new ArrayList<>();


    public PubProfessionalAdapter(ArrayList<ProfessionalRequired> newProfessionals) {

        this.newProfessionals = newProfessionals;
    }

    @Override
    public PubProfessionalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.newprofessional, parent, false);
        PubProfessionalViewHolder ppvh = new PubProfessionalViewHolder(v);
        return ppvh;
    }

    @Override
    public void onBindViewHolder(PubProfessionalViewHolder holder, int i) {
        holder.nombre.setText(newProfessionals.get(i).getCareer());
        holder.descripcion.setText(newProfessionals.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return newProfessionals.size();
    }

    public class PubProfessionalViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, descripcion;


        public PubProfessionalViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.professionalType);
            descripcion = (TextView) itemView.findViewById(R.id.professionalDescription);


        }
    }
}
