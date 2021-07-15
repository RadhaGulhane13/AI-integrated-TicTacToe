package com.example.radha.tictactoe;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class OnePlayerAI extends AppCompatActivity {

    int flag =0;

    int active=1;
    int [] state = {0,0,0,0,0,0,0,0,0};

    int [][] winning = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};



    ImageView img0,img1,img2,img3,img4,img5,img6,img7,img8;

    TextView player;




    public void setimg(int r)
    {
        switch(r)
        {
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
    }

    int winningposiblity()
    {


        int w1=0,w2=0,a,b,c;
        for(int i=0;i<3;i++)
        {
            a = i*3+0;
            b = i*3+1;
            c = i*3+2;


            if(state[a]+state[b]+state[c]==20 || state[a]+state[b]+state[c]==10)
            {
                w1++;
            }else if(state[a]+state[b]+state[c]==200 || state[a]+state[b]+state[c]==100)
            {
                w2++;
            }
            a = i;
            b = 3+i;
            c = 6+i;
            if(state[a]+state[b]+state[c]==20 || state[a]+state[b]+state[c]==10)
            {
                w1++;
            }else if(state[a]+state[b]+state[c]==200 || state[a]+state[b]+state[c]==100)
            {
                w2++;
            }


        }

        if(state[0]+state[4]+state[8]==20 || state[0]+state[4]+state[8]==10)
        {
            w1++;

        }else if(state[0]+state[4]+state[8]==200 || state[0]+state[4]+state[8]==100)
        {
            w2++;

        }

        if(state[2]+state[4]+state[6]==20 || state[2]+state[4]+state[6]==10)
        {
            w1++;

        }else if(state[2]+state[4]+state[6]==200 || state[2]+state[4]+state[6]==100)
        {
            w2++;

        }



        return w2-w1;

    }


    int anyof(int p,int i1,int i2,int j1,int j2,int k1,int k2)
    {
        int a = i1*3+i2;
        int b = j1*3+j2;
        int c = k1*3+k2;
        if(state[a]==0 && state[b]==state[c] && state[b]==p)
        {
            state[a]=100;
            setimg(a);
            player.setText("Player 1");
            //cout<<"Computer's move : "<<i1*3+i2+1<<endl;

            return 1;
        }
        if(state[b]==0 && state[a]==state[c] && state[a]==p)
        {
            state[b]=100;
            setimg(b);
            player.setText("Player 1");
            //cout<<"Computer's move : "<<j1*3+j2+1<<endl;
            return 1;
        }
        if(state[c]==0 && state[a]==state[b] && state[b]==p)
        {
            state[c]=100;
            setimg(c);
            player.setText("Player 1");
            //cout<<"Computer's move : "<<k1*3+k2+1<<endl;
            return 1;
        }
        return 0;
    }

    int isplayerwinning(int player) {

        if (anyof(player, 0, 0, 1, 1, 2, 2) == 1 || anyof(player, 0, 2, 1, 1, 2, 0) == 1) {
            return 1;
        }

        for (int i = 0; i < 3; i++) {
            if (anyof(player, i, 0, i, 1, i, 2) == 1) {
                return 1;
            }


            if (anyof(player, 0, i, 1, i, 2, i) == 1) {
                return 1;
            }

        }

        return 0;


    }

    public void play()
    {

        if(flag==1) {
            if (isplayerwinning(100) == 1 || isplayerwinning(10) == 1) {
                flag=0;
                return;
            }


            int value=-8,a=0,b=0;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    int k= i*3+j;

                    if(state[k]==0)
                    {

                        state[k]=100;


                        int heuristic=winningposiblity();

                        if(heuristic > value)
                        {
                            value= heuristic;
                            a=i;
                            b=j;
                        }
                        state[k]=0;

                    }
                }
            }



            int c = a*3+b;
            state[c]=100;
            setimg(c);
            player.setText("Player 1");
            flag = 0;


        }


    }



    public void DropIn(View view)
    {
        if(active==1) {

                if (flag == 0) {
                    ImageView counter = (ImageView) view;
                    int a = Integer.parseInt(counter.getTag().toString());
                    if (state[a] == 0) {
                        //TextView player = (TextView)findViewById(R.id.textView);
                        counter.setImageResource(R.drawable.cross);
                        player.setText("Player 2");
                        state[a] = 10;
                        flag = 1;
                    }


                }



            if(iswin()!= 1)
            {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        play();
                        iswin();

                    }
                }, 1000);


            }

        }


    }



    public int iswin()
    {

        int won=0;
        TextView  msg = (TextView)findViewById(R.id.textView2);

        for(int[] winning :winning){
            if(state[winning[0]]!=0 && (state[winning[0]]==state[winning[1]]) && (state[winning[1]]==state[winning[2]]))
            {
                won=1;
                if(state[winning[0]]==10)
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
            won=1;
        }
        return won;
    }

    public boolean istie()
    {
        for(int i=0;i<9;i++)
        {
            if(state[i]==0)
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
            state[i]=0;
        }
        flag=0;
        TextView msg = (TextView)findViewById(R.id.textView1);
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
        setContentView(R.layout.activity_one_player_a_i);

        img0 = (ImageView)findViewById(R.id.imageView31);
        img1 = (ImageView)findViewById(R.id.imageView61);
        img2 = (ImageView)findViewById(R.id.imageView91);
        img3 = (ImageView)findViewById(R.id.imageView41);
        img4 = (ImageView)findViewById(R.id.imageView71);
        img5 = (ImageView)findViewById(R.id.imageView101);
        img6 = (ImageView)findViewById(R.id.imageView51);
        img7 = (ImageView)findViewById(R.id.imageView81);
        img8 = (ImageView)findViewById(R.id.imageView111);

        player = (TextView)findViewById(R.id.textView1);

    }
}
