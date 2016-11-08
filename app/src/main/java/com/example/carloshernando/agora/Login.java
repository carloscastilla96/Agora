package com.example.carloshernando.agora;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import petitions.UserPetition;
import red.Comunicacion;
import red.User;

public class Login extends AppCompatActivity {


    EditText username;
    EditText tpassword;
    private Comunicacion c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username= (EditText) findViewById(R.id.user);
        tpassword= (EditText) findViewById(R.id.password);
        new StartC().execute();
    }


    public void onInicioSesion(View v) {

        String user = username.getText().toString();
        String password = tpassword.getText().toString();

        if (!(password.equals("User") && user.equals("Password"))) {
            new Task(this).execute(user, password);
            Toast.makeText(this, "enviando peticion", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "por favor ingrese los datos", Toast.LENGTH_SHORT).show();
        }

    }


    protected class Task extends AsyncTask<String, String, Object> {

        Context context;
        private Task(Context context) {
            this.context = context;
        }

        @Override
        protected Object doInBackground(String... params) {

            // creo una petición de inicio usuario
            UserPetition uP = new UserPetition(params[0], params[1]);

            c.enviar(uP);

            while (true) {
               Object res = c.recibir();
                return res;
            }

        }

        @Override
        protected void onPostExecute(Object s) {
            super.onPostExecute(s);
            if(s != null ){
                if(s instanceof User){
                    User user= (User)s;

                    startActivity(new Intent(context, FirstScreen.class));

                }else{
                   String r = (String)s;
                    Toast.makeText(context, r, Toast.LENGTH_SHORT).show();
                }

            }

        }

    }


    protected class StartC extends AsyncTask<String, String, String> {
        protected String doInBackground(String... params) {
            c = Comunicacion.getInstance();
            System.out.println("Se ha inicializado la conexion hija de puta");
            return null;
        }
    }
}
