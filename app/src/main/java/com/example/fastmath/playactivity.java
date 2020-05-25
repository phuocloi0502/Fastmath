package com.example.fastmath;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class playactivity extends AppCompatActivity {
    int soa, sob, kq;
    public boolean kt;
    Button btndung, btnsai;
    TextView txvPhepTinh, txvTime, txvScroePlay, txvBestScrore;
    int lv = 0;
    CountDownTimer t;
    int score = 0;
    int bestscoreCurrent=0;
    Question mQuestion;
    SharedPreferences luudiemso;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playactivity);
        btndung = findViewById(R.id.btn_dung);
        btnsai = findViewById(R.id.btn_sai);
        txvTime = findViewById(R.id.txvtime);
        txvScroePlay = findViewById(R.id.txvscoreplay);
        txvBestScrore = findViewById(R.id.txvbestscoreplay);
        luudiemso=getSharedPreferences("Diemsogame",MODE_PRIVATE);
        bestscoreCurrent=luudiemso.getInt("diemcuatoi",0);
        txvBestScrore.setText("BEST: "+String.valueOf(bestscoreCurrent));
        txvPhepTinh = findViewById(R.id.txvpheptinh);
        cauhoi(lv);
        btndung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestion.isSt() == true) {
                    lv++;
                    Toast.makeText(playactivity.this, "Dung", Toast.LENGTH_SHORT).show();
                    t.cancel();
                    score++;
                    if(bestscoreCurrent<score){
                        luudiem();
                    }
                    txvScroePlay.setText("SCORE: " + score);
                    //delay 1s
                    new CountDownTimer(1000, 100) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }
                        @Override
                        public void onFinish() {
                            cauhoi(lv);
                        }
                    }.start();
                } else {
                    Toast.makeText(playactivity.this, "Sai", Toast.LENGTH_SHORT).show();
                    t.cancel();
                    gameover(playactivity.this, score,bestscoreCurrent);
                }
            }
        });

        btnsai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestion.isSt() == false) {
                    lv++;
                    Toast.makeText(playactivity.this, "Dung", Toast.LENGTH_SHORT).show();
                    t.cancel();
                    score++;
                    if(bestscoreCurrent<score){
                        luudiem();
                    }
                    txvScroePlay.setText("SCORE: " + score);
                    //delay 1s
                    new CountDownTimer(1000, 100) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }
                        @Override
                        public void onFinish() {
                            cauhoi(lv);
                        }
                    }.start();


                } else {
                    Toast.makeText(playactivity.this, "Sai", Toast.LENGTH_SHORT).show();
                    t.cancel();
                    gameover(playactivity.this, score,bestscoreCurrent);
                }
            }
        });


    }
    public void luudiem() {
        SharedPreferences.Editor editor = luudiemso.edit();
        editor.putInt("diemcuatoi",score);
        editor.commit();
    }
    public void cauhoi(int lv) {
        txvPhepTinh = findViewById(R.id.txvpheptinh);
        Random stt = new Random();
        final boolean st = stt.nextBoolean();
        if (lv <= 10) {
            mQuestion = new Question(10, 10, st);
            txvPhepTinh.setText(mQuestion.createQuestion());
            settime();
        }
        if (lv > 10 && lv <= 20) {
            mQuestion = new Question(50, 50, st);
            txvPhepTinh.setText(mQuestion.createQuestion());
            settime();
        }
        if (lv > 20) {
            mQuestion = new Question(100, 100, st);
            txvPhepTinh.setText(mQuestion.createQuestion());
            settime();
        }


    }

    public void settime() {
        t = new CountDownTimer(6000 + 1, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                txvTime.setText("" + millisUntilFinished / 1000);
                if ((millisUntilFinished / 1000 < 1)) {
                    txvTime.setText("Het gio");


                }
            }

            @Override
            public void onFinish() {
                gameover(playactivity.this, score,bestscoreCurrent);
                //playactivity.this.finish();
            }
        };
        t.start();
    }


    public void gameover(Activity activity, int score,int bestscore) {
        t.cancel();
        // gui qua overlayout
        Intent intent = new Intent(playactivity.this, overactivity.class);
        intent.putExtra("d", String.valueOf(score));
        intent.putExtra("dcao", String.valueOf(bestscore));
        // gui qua mainlayout
//        Intent intenthome=new Intent(playactivity.this,MainActivity.class);
//        intenthome.putExtra("diemhome",String.valueOf(bestscore));
        activity.finish();
        startActivity(intent);
    }
}
