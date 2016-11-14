package com.example.carloshernando.agora;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import petitions.UserPetition;
import red.Comunicacion;
import red.NewUser;

public class Register extends AppCompatActivity {


    EditText name, lastName, username, password, cPassword, email;
    Button registrarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText) findViewById(R.id.name);
        lastName = (EditText) findViewById(R.id.apellido);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        cPassword = (EditText) findViewById(R.id.confirmPassword);
        email = (EditText) findViewById(R.id.email);
        registrarme = (Button) findViewById(R.id.iniciarSesion);
        registrarme.bringToFront();

    }

    public void onInicioSesion(View v) {
        String nm = name.getText().toString();
        String lastnm = lastName.getText().toString();
        String usernm = username.getText().toString();
        String pswd = password.getText().toString();
        String xpswd = cPassword.getText().toString();
        String eml = email.getText().toString();

        if (pswd.equals(xpswd)) {
            new Task(this).execute(nm, lastnm, usernm, pswd, eml);
        } else {

            Toast.makeText(this, "las contraseñas no son iguale pibe", Toast.LENGTH_SHORT).show();
        }
    }

    public class Task extends AsyncTask<String, String, Object> {
        Context c;

        public Task(Context c) {
            this.c = c;
        }

        protected Object doInBackground(String... params) {
            Comunicacion c = Comunicacion.getInstance();
            c.getInstance().enviar(new NewUser(params[0], params[1], params[2], params[3], params[4]));

            return c.recibir();
        }


        @Override
        protected void onPostExecute(Object o) {
            if (o != null) {
                String r = (String) o;
                Toast.makeText(c, r, Toast.LENGTH_SHORT).show();

                startActivity(new Intent(c, FirstScreen.class));
            } else {
                Toast.makeText(c, "algun problema en la conexión, creo", Toast.LENGTH_SHORT).show();
            }


        }
    }

}
