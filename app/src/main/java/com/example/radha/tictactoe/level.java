package com.example.radha.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class level extends AppCompatActivity {

    /* Redirects to the one player game with easy level. */
    public void easy(View view) {
        Intent intent = new Intent(this, OnePlayerEasy.class);
        startActivity(intent);
    }

    /* Redirects to the one player game with difficult level. */
    public void hard(View view) {
        Intent intent = new Intent(this, OnePlayerAI.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
    }
}
