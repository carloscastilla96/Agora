package com.example.carloshernando.agora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class Feed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                final ActionBar abar = getSupportActionBar();

                View viewActionBar = getLayoutInflater().inflate(R.layout.feed, null);
                ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ActionBar.LayoutParams.MATCH_PARENT,
                        Gravity.CENTER);
                TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);
                textviewTitle.setText("Agora");
                abar.setCustomView(viewActionBar, params);
                abar.setDisplayShowCustomEnabled(true);
                abar.setDisplayShowTitleEnabled(false);
                abar.setDisplayHomeAsUpEnabled(true);
                             abar.setHomeButtonEnabled(true);
            }
        });
    }

}
