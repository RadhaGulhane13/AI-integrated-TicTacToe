package com.example.radha.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView cross, circle;
    Button btn;

    /* Redirects to the home page. */
    public void play(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Creates animation for front page. */
        cross = (ImageView) findViewById(R.id.cross);
        circle = (ImageView) findViewById(R.id.circle);
        btn = (Button) findViewById(R.id.easy);

        cross.setTranslationY(-1000f);
        circle.setTranslationY(-1000f);
        btn.setTranslationY(-1900f);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        cross.animate().translationY(40f).setDuration(500);

                        wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (this) {
                        circle.animate().translationY(40f).setDuration(500);
                        notify();
                        Thread.sleep(1000);

                        btn.animate().translationY(30f).setDuration(500);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }


}
