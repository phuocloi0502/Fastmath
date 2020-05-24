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


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playactivity);

        btndung = findViewById(R.id.btn_dung);
        btnsai = findViewById(R.id.btn_sai);
        txvTime = findViewById(R.id.txvtime);
        txvScroePlay = findViewById(R.id.txvscoreplay);
        txvBestScrore = findViewById(R.id.txvbestscoreplay);
        txvBestScrore.setText(String.valueOf(laydiem()));
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
                    txvScroePlay.setText("SCORE: " + score);
                    cauhoi(lv);


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
                    txvScroePlay.setText("SCORE: " + score);
                    cauhoi(lv);


                } else {
                    Toast.makeText(playactivity.this, "Sai", Toast.LENGTH_SHORT).show();
                    t.cancel();
                    gameover(playactivity.this, score,bestscoreCurrent);
                }
            }
        });


    }

    public int kiemtrabestscore(int score, int bestscore) {
        if (score > bestscore)
            return score;
        else return bestscore;
    }

    public void luudiem( int score,int bestscore) {
        //tạo đối tượng getSharedPreferences
        SharedPreferences pre = getSharedPreferences("diem", MODE_PRIVATE);
        //tạo đối tượng Editor để lưu thay đổi
        SharedPreferences.Editor editor = pre.edit();

        editor.putInt("diemcuatoi",kiemtrabestscore(score,bestscore));
        //chấp nhận lưu xuống file
        editor.commit();
    }

    public int laydiem() {
        SharedPreferences pre = getSharedPreferences
                ("diem", MODE_PRIVATE);
        //lấy giá trị checked ra, nếu không thấy thì giá trị mặc định là false
        int diemlayra = pre.getInt("diemcuatoi", 0);
        return diemlayra;
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
        luudiem(score,bestscore);
        Intent intent = new Intent(playactivity.this, overactivity.class);

        //   intent.putExtra("diem", score);
        intent.putExtra("d", String.valueOf(score));
        // playactivity.this.startActivityForResult(intent,123);
        activity.finish();
        startActivity(intent);


    }
}
