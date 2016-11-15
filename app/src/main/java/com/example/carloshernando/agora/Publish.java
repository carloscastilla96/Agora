package com.example.carloshernando.agora;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

import items.ProfessionalRequired;

public class Publish extends AppCompatActivity {

    private static int DIALOG_ID = 20;
    private static int PROFESSION_ID = 10;
    private int day_x, month_x, year_x;
    private TextView d, m, y;
    private RecyclerView recyclerViewProf;
    private PubProfessionalAdapter pubProfessionalAdapter;
    private LayoutInflater inflater;
    private ArrayList<ProfessionalRequired> newProfessionalRequired = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        recyclerViewProf = (RecyclerView) findViewById(R.id.profesionalsRecyclerPub);
        d = (TextView) findViewById(R.id.days);
        m = (TextView) findViewById(R.id.month);
        y = (TextView) findViewById(R.id.year);
        inicializarProfessionals();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        pubProfessionalAdapter = new PubProfessionalAdapter(newProfessionalRequired);
        recyclerViewProf.setLayoutManager(llm);
        recyclerViewProf.setAdapter(pubProfessionalAdapter);
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        month_x = cal.get(Calendar.MONTH);
        inflater = Publish.this.getLayoutInflater();

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

}
