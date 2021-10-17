package com.example.radha.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/* provides single and double player option to user. */
public class Home extends AppCompatActivity {

    /* Redirects to the level page. */
    public void player1(View view)
    {
        Intent intent = new Intent(this,level.class);
        startActivity(intent);
    }

    /* Redirects to the game page for two player. */
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
