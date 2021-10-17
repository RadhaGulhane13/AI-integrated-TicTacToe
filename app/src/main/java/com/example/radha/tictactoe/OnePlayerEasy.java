package com.example.radha.tictactoe;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class OnePlayerEasy extends AppCompatActivity {

    int flag = 0;
    int total_move = 0;
    int active = 1;
    int[] state = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winning = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};


    ImageView img0, img1, img2, img3, img4, img5, img6, img7, img8;

    TextView player;

    /* Adds move by computer by adding symbol on the grid. */
    public void setimg(int r) {
        switch (r) {
            case 0:
                img0.setImageResource(R.drawable.circle);
                break;
            case 1:
                img1.setImageResource(R.drawable.circle);
                break;
            case 2:
                img2.setImageResource(R.drawable.circle);
                break;
            case 3:
                img3.setImageResource(R.drawable.circle);
                break;
            case 4:
                img4.setImageResource(R.drawable.circle);
                break;
            case 5:
                img5.setImageResource(R.drawable.circle);
                break;
            case 6:
                img6.setImageResource(R.drawable.circle);
                break;
            case 7:
                img7.setImageResource(R.drawable.circle);
                break;
            case 8:
                img8.setImageResource(R.drawable.circle);
                break;
        }
        total_move++;
    }

    /* Decides computers move against user. As this is the easy level, making random moves.*/
    public void play() {

        if (flag == 1) {
            Random rand = new Random();
            int r;
            do {
                r = rand.nextInt(9);

            } while (state[r] != 2);

            state[r] = 1;

            setimg(r);

            player.setText("Player 1");
            flag = 0;
            // iswin();
        }
        flag = 0;
    }

    /*
    * It detects for winning or draw condition as well as make move by user by placing appropriate
    * symbol.
    */
    public void DropIn(View view) {
        if (active == 1) {
            if (flag == 0) {
                ImageView counter = (ImageView) view;
                int a = Integer.parseInt(counter.getTag().toString());
                if (state[a] == 2) {
                    //TextView player = (TextView)findViewById(R.id.textView);
                    counter.setImageResource(R.drawable.cross);
                    player.setText("Player 2");
                    state[a] = 0;
                    flag = 1;
                    total_move++;
                }
            }

            if (iswin() != 1) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        play();
                    }
                }, 1000);

            }
        }

    }

    /* Detects if any player has won the game. */
    public int iswin() {
        for (int i = 0; i < 9; i++) {
            System.out.print(state[i] + " ");
        }
        int won = 0;
        TextView msg = (TextView) findViewById(R.id.textView1);

        for (int[] winning : winning) {
            if (state[winning[0]] != 2 && (state[winning[0]] == state[winning[1]]) &&
                    (state[winning[1]] == state[winning[2]])) {
                won = 1;
                if (state[winning[0]] == 0) {

                    player.setText("Player 1 has won !!!");
                    active = 0;

                    // Toast.makeText(this,"Player 1 wins",Toast.LENGTH_SHORT).show();
                } else {
                    player.setText("Player 2 has won !!!");
                    active = 0;
                    //Toast.makeText(this,"Player 2 wins",Toast.LENGTH_SHORT).show();
                }


            }
        }

        if (won == 0 && istie()) {
            player.setText("Tie !!!");
            active = 0;
            won = 1;
        }
        return won;
    }

    /* Verifies if draw condition. */
    public boolean istie() {
        return total_move == 9;
//        for (int i = 0; i < 9; i++) {
//            if (state[i] == 2) {
//                return false;
//            }
//        }
//        return true;
    }

    /* Clears the grid by removing all moves on click of Restart button. */
    public void Restart(View view) {
        total_move = 0;
        active = 1;
        for (int i = 0; i < 9; i++) {
            state[i] = 2;
        }
        flag = 0;
        TextView msg = (TextView) findViewById(R.id.textView1);
        msg.setText("");

        img0.setImageResource(0);
        img1.setImageResource(0);
        img2.setImageResource(0);
        img3.setImageResource(0);
        img4.setImageResource(0);
        img5.setImageResource(0);
        img6.setImageResource(0);
        img7.setImageResource(0);
        img8.setImageResource(0);


        player.setText("Player 1");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);

        img0 = (ImageView) findViewById(R.id.imageView31);
        img1 = (ImageView) findViewById(R.id.imageView61);
        img2 = (ImageView) findViewById(R.id.imageView91);
        img3 = (ImageView) findViewById(R.id.imageView41);
        img4 = (ImageView) findViewById(R.id.imageView71);
        img5 = (ImageView) findViewById(R.id.imageView101);
        img6 = (ImageView) findViewById(R.id.imageView51);
        img7 = (ImageView) findViewById(R.id.imageView81);
        img8 = (ImageView) findViewById(R.id.imageView111);

        player = (TextView) findViewById(R.id.textView1);

    }
}
