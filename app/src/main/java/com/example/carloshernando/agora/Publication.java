package com.example.carloshernando.agora;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;


public class Publication extends Activity {
    ActionBar bar = getActionBar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication);
        bar.setTitle("Agora");
    }

}
