package com.example.carloshernando.agora;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import items.Comment_Item;


class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolderComment> {

    //el RecyclerView.Viewholer, permite hacer la conexion entre los elementos del xml y el adaptor a través de la instacia View
    public class ViewHolderComment extends RecyclerView.ViewHolder {

        TextView usuario, texto;


        public ViewHolderComment(View itemView) {
            super(itemView);
            usuario = (TextView) itemView.findViewById(R.id.name);
            texto = (TextView) itemView.findViewById(R.id.comment);
        }
    }

    private ArrayList<Comment_Item> comentarios = new ArrayList<>();


    public CommentAdapter(ArrayList<Comment_Item> comentarios) {
        this.comentarios = comentarios;
    }


    //Genera una instacia de view la cual infla el xml, pasandole al viewholder el layout
    @Override
    public ViewHolderComment onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment, parent, false);
        ViewHolderComment vhc = new ViewHolderComment(v);
        return vhc;
    }

    //Como su nombre lo dice, hac el binding con elementos del ViewHolder respectivo con los elementos y hace el setting especifico con los elementos del Layout
    @Override
    public void onBindViewHolder(ViewHolderComment holder, int i) {
        holder.texto.setText(comentarios.get(i).getContent());
        holder.usuario.setText(comentarios.get(i).getNameUser());
    }


    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return comentarios.size();
    }


}
