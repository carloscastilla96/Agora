package com.example.carloshernando.agora;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import items.ProfessionalRequired;

/**
 * Created by carloshernando on 11/8/2016.
 */
public class professionalAdapter extends RecyclerView.Adapter<professionalAdapter.ViewHolderProfessional> {
    private ArrayList<ProfessionalRequired> professionalRequireds = new ArrayList<>();

    public professionalAdapter(ArrayList<ProfessionalRequired> professionalRequireds) {
        this.professionalRequireds = professionalRequireds;
    }

    public class ViewHolderProfessional extends RecyclerView.ViewHolder {

        TextView nombre, descripcion;


        public ViewHolderProfessional(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.professionalType);
            descripcion = (TextView) itemView.findViewById(R.id.professionalDescription);


        }
    }

    @Override
    public ViewHolderProfessional onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.professional, parent, false);
        ViewHolderProfessional vhp = new ViewHolderProfessional(v);
        return vhp;
    }

    @Override
    public void onBindViewHolder(ViewHolderProfessional holder, int i) {
        holder.nombre.setText(professionalRequireds.get(i).getCareer());
        holder.descripcion.setText(professionalRequireds.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return professionalRequireds.size();
    }

}
