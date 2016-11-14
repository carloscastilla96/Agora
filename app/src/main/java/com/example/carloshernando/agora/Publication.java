package com.example.carloshernando.agora;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

import items.Comment_Item;
import items.ProfessionalRequired;
import items.Publication_Item;
import red.User;


public class Publication extends AppCompatActivity {

    private RecyclerView comments;
    private RecyclerView professionalRequiredRV;
    private CommentAdapter commentAdapter;
    private professionalAdapter professionalAdapter;
    private ArrayList<Comment_Item> comment_items = new ArrayList<>();
    private ArrayList<ProfessionalRequired> professionalRequireds = new ArrayList<>();
    private EditText comentario;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication);
        professionalRequiredRV = (RecyclerView) findViewById(R.id.profesionalsRecycler);
        comments = (RecyclerView) findViewById(R.id.commentsRecycler);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        LinearLayoutManager professionalLayout = new LinearLayoutManager(this);
        inicializarComments();
        inicializarProfessionals();
        comments.setLayoutManager(llm);
        professionalRequiredRV.setLayoutManager(professionalLayout);
        professionalAdapter = new professionalAdapter(professionalRequireds);
        professionalRequiredRV.setAdapter(professionalAdapter);
        commentAdapter = new CommentAdapter(comment_items);
        comments.setAdapter(commentAdapter);
        comentario = (EditText) findViewById(R.id.commentContent);
    }

    private void inicializarProfessionals() {

        professionalRequireds.add(new ProfessionalRequired("Camarógrafo", "Se necesita un camarografo que requiera experiencia"));

        professionalRequireds.add(new ProfessionalRequired("Camarógrafo", "Se necesita un camarografo que requiera experiencia"));
    }

    public void inicializarComments() {
        comment_items.add(new Comment_Item("Carlos", "Me parece muy buena la propuesta"));
        comment_items.add(new Comment_Item("Daniel", "Me parece muy buena la propuesta"));
        comment_items.add(new Comment_Item("Daniel", "Me parece muy buena la propuesta"));
        comment_items.add(new Comment_Item("Daniel", "Me parece muy buena la propuesta"));
    }

    public void onComment(View v) {

        //codigo que se envia al servidor y este devuelve
        //codigo que actualiza
        comentario.clearComposingText();
    }


}
