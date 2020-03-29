package com.example.gameadit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContextWrapper;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvleft,tvscore;
    Button start;
    ImageView b1,b2,b3;
    Random r;
    int score=0, fps=1000, left=5, tempifleft=0;
    int which=0;
    int whichsave=0;
    AnimationDrawable an;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = new Random();
        tvleft = (TextView) findViewById(R.id.left);
        tvscore = (TextView)findViewById(R.id.score);
        start = (Button) findViewById(R.id.button);
        b1 = (ImageView)findViewById(R.id.a1);
        b2 = (ImageView)findViewById(R.id.a2);
        b3 = (ImageView)findViewById(R.id.a3);
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left=5;
                tvleft.setText("Left: "+left);
                score=0;
                tvscore.setText("Score: "+ score);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        theGameActions();
                    }
                }, 1000);
                start.setEnabled(false);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempifleft=1;
                b1.setImageResource(R.drawable.adit);
                score=score+1;
                tvscore.setText("Score: "+ score);
                b1.setEnabled(false);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempifleft=1;
                b1.setImageResource(R.drawable.adit);
                score=score+1;
                tvscore.setText("Score: "+ score);
                b2.setEnabled(false);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempifleft=1;
                b1.setImageResource(R.drawable.adit);
                score=score+1;
                tvscore.setText("Score: "+ score);
                b3.setEnabled(false);

            }
        });
    }
    private void theGameActions(){
        if(score<10)
        {
            fps=1000;
        }
        else if(score>=10&&score<15)
        {
            fps=950;
        }
        else if(score>=15&&score<20)
        {
            fps=900;
        }
        else if(score>=20&&score<25)
        {
            fps=850;
        }
        else if(score>=25&&score<30)
        {
            fps=800;
        }
        else if(score>=30&&score<35)
        {
            fps=750;
        }
        else if(score>=35&&score<40)
        {
            fps=700;
        }
        else if(score>=40&&score<45)
        {
            fps=650;
        }
        else if(score>=45&&score<50)
        {
            fps=600;
        }
        else if(score>=50&&score<55)
        {
            fps=550;
        }
        else if(score>=55&&score<60)
        {
            fps=500;
        }
        else if(score>=60&&score<65)
        {
            fps=450;
        }
        else if(score>=65&&score<70)
        {
            fps=400;
        }
        else if(score>=70)
        {
            fps=350;
        }
        an = (AnimationDrawable) ContextCompat.getDrawable(this,R.drawable.anime);
        do{
            which = r.nextInt(3)+1;
        }while(whichsave==which);
        whichsave=which;
        if (which==1)
        {
            b1.setImageDrawable(an);
            b1.setVisibility(View.VISIBLE);
            b1.setEnabled(true);
        }

        else if (which==2)
        {
            b2.setImageDrawable(an);
            b2.setVisibility(View.VISIBLE);
            b2.setEnabled(true);
        }

       else if (which==3)
        {
            b3.setImageDrawable(an);
            b3.setVisibility(View.VISIBLE);
            b3.setEnabled(true);
        }
       an.start();
       Handler handler =new Handler();
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               b1.setVisibility(View.INVISIBLE);
               b2.setVisibility(View.INVISIBLE);
               b3.setVisibility(View.INVISIBLE);
               b1.setEnabled(false);
               b2.setEnabled(false);
               b3.setEnabled(false);
               if(tempifleft==0)
               {
                   left=left-1;
                   tvleft.setText("Left: "+left);
               }
               else if(tempifleft==1)
                   tempifleft=0;
               if(left==0)
               {
                   Toast.makeText(MainActivity.this,"Game Over",Toast.LENGTH_SHORT).show();
               }
               else if(left>0)
               {
                   theGameActions();
               }
           }
       },fps);
    }
}
