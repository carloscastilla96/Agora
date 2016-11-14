package com.example.carloshernando.agora;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import items.Comment_Item;
import items.ProfessionalRequired;
import items.Publication_Item;
import petitions.CommentPetition;
import red.Comunicacion;
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

    private TextView tittle;
    private TextView description;
    private ImageView imageView;
    private TextView workdType;
    private TextView enrolledProfessionals;
    private TextView neededProfessionals;
    private TextView phone;
    private TextView addres;
    private TextView email;
    private TextView webPage;
    private TextView city;
    private Publication_Item p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication);


        professionalRequiredRV = (RecyclerView) findViewById(R.id.profesionalsRecycler);
        comments = (RecyclerView) findViewById(R.id.commentsRecycler);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        LinearLayoutManager professionalLayout = new LinearLayoutManager(this);
        //inicializarComments();
        inicializarProfessionals();
        comments.setLayoutManager(llm);
        professionalRequiredRV.setLayoutManager(professionalLayout);

        commentAdapter = new CommentAdapter(comment_items);
        comments.setAdapter(commentAdapter);
        comentario = (EditText) findViewById(R.id.commentContent);
        inicializar();

    }

    public void inicializar() {

        tittle = (TextView) findViewById(R.id.AAAAAA);
        description = (TextView) findViewById(R.id.Pdescription);
        imageView = (ImageView) findViewById(R.id.pimage);
        workdType = (TextView) findViewById(R.id.PworkType);
        enrolledProfessionals = (TextView) findViewById(R.id.PenrolledProfessionals);
        neededProfessionals = (TextView) findViewById(R.id.PneededProfessionals);
        phone = (TextView) findViewById(R.id.Pphone);
        addres = (TextView) findViewById(R.id.Padress);
        email = (TextView) findViewById(R.id.Pemail);
        webPage = (TextView) findViewById(R.id.Pwebsite);
        city = (TextView) findViewById(R.id.Pcity);


        //inicializar();

        p = (Publication_Item) getIntent().getSerializableExtra("publicacion");
        tittle = (TextView) findViewById(R.id.AAAAAA);
        tittle.setText(p.getTittle() + "asdvjbasdv");
        description.setText(p.getDescription() + "descccc");
        enrolledProfessionals.setText(p.getProfessionalsObtained().size());
        neededProfessionals.setText(p.getProfessionalsRequired().size());
        phone.setText(p.getNumber() + "tel");
        addres.setText(p.getAddress() + "direccion");
        email.setText(p.getEmail() + "email");
        webPage.setText(p.getWebAddres() + "web");
        city.setText(p.getCity());
        professionalRequireds= p.getProfessionalsRequired();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bm = BitmapFactory.decodeByteArray(p.getBytesImagen(), 0, p.getBytesImagen().length);
                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                imageView.setMinimumHeight(dm.heightPixels);
                imageView.setMinimumWidth(dm.widthPixels);
                imageView.setImageBitmap(bm);
            }
        }).start();


        professionalAdapter = new professionalAdapter(professionalRequireds);
        professionalRequiredRV.setAdapter(professionalAdapter);

        new TraerComentarios(this).execute();
        Toast.makeText(this, "wut?", Toast.LENGTH_SHORT).show();

    }

    private void inicializarProfessionals() {
       // professionalRequireds.add(new ProfessionalRequired("Camarógrafo", "Se necesita un camarografo que requiera experiencia"));
//        professionalRequireds.add(new ProfessionalRequired("Camarógrafo", "Se necesita un camarografo que requiera experiencia"));
    }

//    public void inicializarComments() {
////        comment_items.add(new Comment_Item("Carlos", "Me parece muy buena la propuesta"));
////        comment_items.add(new Comment_Item("Daniel", "Me parece muy buena la propuesta"));
////        comment_items.add(new Comment_Item("Daniel", "Me parece muy buena la propuesta"));
////        comment_items.add(new Comment_Item("Daniel", "Me parece muy buena la propuesta"));
//    }

    public void onComment(View v) {

        //codigo que se envia al servidor y este devuelve
        //codigo que actualiza
        new EnviarComentario(this).execute(comentario.getText().toString());
        comentario.setText("");
    }


    protected class EnviarComentario extends AsyncTask<String, String, String> {
        private final Comunicacion c;
        Context context;

        private EnviarComentario(Context context) {
            this.context = context;
            c = Comunicacion.getInstance();
        }

        @Override
        protected String doInBackground(String... params) {
            // creo una petición de inicio usuario
            Comment_Item com = new Comment_Item(p.getId(), DatosSesion.getUser().getName()+" "+DatosSesion.getUser().getLastName(), params[0]);
              c.enviar(com);
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            new TraerComentarios(context).execute();
        }
    }


    protected class TraerComentarios extends AsyncTask<String, String, String> {
        private final Comunicacion c;
        Context context;

        private TraerComentarios(Context context) {
            this.context = context;
            c = Comunicacion.getInstance();
        }

        @Override
        protected String doInBackground(String... params) {
            // creo una petición de inicio usuario
            CommentPetition cp= new CommentPetition(p.getId());

            c.enviar(cp);
            while (true) {
                Object res = Comunicacion.getInstance().recibir();
                if (res instanceof Comment_Item) {
                    comment_items.add((Comment_Item) res);
                } else {

                    return null;
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(context, "wut?", Toast.LENGTH_SHORT).show();

            commentAdapter = new CommentAdapter(comment_items);
            comments.setAdapter(commentAdapter);

        }
    }
}
