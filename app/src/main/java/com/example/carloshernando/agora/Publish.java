package com.example.carloshernando.agora;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Calendar;

import items.Comment_Item;
import items.ProfessionalRequired;
import petitions.CommentPetition;
import red.Comunicacion;

public class Publish extends AppCompatActivity {

    private static int DIALOG_ID = 20;
    private static int PROFESSION_ID = 10;
    private int day_x, month_x, year_x;
    private TextView d, m, y;
    private RecyclerView recyclerViewProf;
    private PubProfessionalAdapter pubProfessionalAdapter;
    private LayoutInflater inflater;
    private ArrayList<ProfessionalRequired> newProfessionalRequired = new ArrayList<>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        recyclerViewProf = (RecyclerView) findViewById(R.id.profesionalsRecyclerPub);
        d = (TextView) findViewById(R.id.days);
        m = (TextView) findViewById(R.id.month);
        y = (TextView) findViewById(R.id.year);
        inicializarProfessionals();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        inicializarProfessionals();
        pubProfessionalAdapter = new PubProfessionalAdapter(newProfessionalRequired);
        recyclerViewProf.setLayoutManager(llm);
        recyclerViewProf.setAdapter(pubProfessionalAdapter);
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        month_x = cal.get(Calendar.MONTH);
        inflater = Publish.this.getLayoutInflater();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void inicializarProfessionals() {

        newProfessionalRequired.add(new ProfessionalRequired("Camarógrafo", "Se necesita un camarografo que requiera experiencia"));


    }

    private void onAddProfessional() {

        showDialog(PROFESSION_ID);


    }

    public void onFecha(View v) {
        showDialog(DIALOG_ID);
    }

    public Dialog onCreateDialog(int id) {

        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dateSetListener, day_x, month_x, year_x);

        return null;
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            day_x = dayOfMonth;
            month_x = month + 1;
            year_x = year;

        }
    };

    void onGaleria(View view) {


    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Publish Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
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
            //Comment_Item cp= new Comment_Item();

            //  c.enviar(cp);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

        }

    }
}
