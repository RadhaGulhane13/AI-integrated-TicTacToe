package com.example.radha.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {


    int flag =0;

    int active=1;
    int [] state = {2,2,2,2,2,2,2,2,2};

    int [][] winning = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void DropIn(View view)
    {

        ImageView counter = (ImageView) view;


        if(active==1) {
            int a=Integer.parseInt(counter.getTag().toString());
            //System.out.println("in try : "+a);

            if(state[a]==2) {

                TextView player = (TextView)findViewById(R.id.textView1);
                if (flag == 0) {
                    counter.setImageResource(R.drawable.cross);
                    player.setText("Player 2");
                    state[a]=0;
                    flag = 1;
                } else {
                    counter.setImageResource(R.drawable.circle);
                    player.setText("Player 1");
                    state[a]=1;
                    flag = 0;
                }


                for(int i=0;i<9;i++) {
                    System.out.print(state[i]+" ");
                }
                int won=0;
                TextView  msg = (TextView)findViewById(R.id.textView2);

                for(int[] winning :winning){
                    if(state[winning[0]]!=2 && (state[winning[0]]==state[winning[1]]) && (state[winning[1]]==state[winning[2]]))
                    {
                        won=1;
                        if(state[winning[0]]==0)
                        {


                            player.setText("Player 1 has won !!!");
                            active=0;

                            // Toast.makeText(this,"Player 1 wins",Toast.LENGTH_SHORT).show();
                        }else
                        {
                            player.setText("Player 2 has won !!!");
                            active=0;
                            //Toast.makeText(this,"Player 2 wins",Toast.LENGTH_SHORT).show();
                        }



                    }
                }

                if(won==0 && istie())
                {  player.setText("Tie !!!");
                    active=0;

                }
            }
        }


    }


    public boolean istie()
    {
        for(int i=0;i<9;i++)
        {
            if(state[i]==2)
            {
                return false;
            }
        }
        return true;
    }


    public void Restart(View view)
    {

        active=1;
        for(int i=0;i<9;i++)
        {
            state[i]=2;
        }
        flag=0;
        TextView msg = (TextView)findViewById(R.id.textView1);
        msg.setText("");
        ImageView img1 = (ImageView)findViewById(R.id.imageView31);
        ImageView img2 = (ImageView)findViewById(R.id.imageView41);
        ImageView img3 = (ImageView)findViewById(R.id.imageView51);
        ImageView img4 = (ImageView)findViewById(R.id.imageView61);
        ImageView img5 = (ImageView)findViewById(R.id.imageView71);
        ImageView img6 = (ImageView)findViewById(R.id.imageView81);
        ImageView img7 = (ImageView)findViewById(R.id.imageView91);
        ImageView img8 = (ImageView)findViewById(R.id.imageView101);
        ImageView img9 = (ImageView)findViewById(R.id.imageView111);
        img1.setImageResource(0);
        img2.setImageResource(0);
        img3.setImageResource(0);
        img4.setImageResource(0);
        img5.setImageResource(0);
        img6.setImageResource(0);
        img7.setImageResource(0);
        img8.setImageResource(0);
        img9.setImageResource(0);

        TextView player = (TextView)findViewById(R.id.textView1);
        player.setText("Player 1");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
