package com.example.radha.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {


    public void player1(View view)
    {

        Intent intent = new Intent(this,level.class);
        startActivity(intent);
    }

    public void player2(View view)
    {

        Intent intent = new Intent(this, TwoPlayer.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
