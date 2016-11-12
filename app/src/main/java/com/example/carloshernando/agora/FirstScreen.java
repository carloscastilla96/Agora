package com.example.carloshernando.agora;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FirstScreen extends AppCompatActivity {


    LinearLayout buttons;
    LinearLayout principal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FirstScreen.this);
        buttons = (LinearLayout) findViewById(R.id.buttons);
        principal = (LinearLayout) findViewById(R.id.principal);
        buttons.bringToFront();
        principal.bringToFront();
    }


    public void onInicioSesion(View v) {

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);


    }

    public void onRegistro(View v) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

}
