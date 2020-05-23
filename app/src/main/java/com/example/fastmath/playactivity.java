package com.example.fastmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class playactivity extends AppCompatActivity {
int soa,sob,kq;
boolean kt;
Button btndung,btnsai;
TextView txvPhepTinh,txvTime;
    int dem=6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playactivity);
        cauhoi();

        btndung=findViewById(R.id.btn_dung);
        btnsai=findViewById(R.id.btn_sai);
        txvTime=findViewById(R.id.txvtime);

        btndung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kt){

                    Toast.makeText(playactivity.this,"Dung",Toast.LENGTH_LONG).show();
                    cauhoi();

                }  else {
                    Toast.makeText(playactivity.this,"Sai",Toast.LENGTH_LONG).show();
                    gameover();
                }
            }
        });

        btnsai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kt==false){

                    Toast.makeText(playactivity.this,"Dung",Toast.LENGTH_LONG).show();
                    cauhoi();

                }  else {
                    Toast.makeText(playactivity.this,"Sai",Toast.LENGTH_LONG).show();
                    gameover();
                }
            }
        });



    }
    public void cauhoi(){
        Random r=new Random();
        soa=r.nextInt(10);
        sob=r.nextInt(10);
        kt=r.nextBoolean(); // 1 or 0
        txvPhepTinh=findViewById(R.id.txvpheptinh);

        if(kt){
            kq=soa+sob;
            txvPhepTinh.setText(""+soa+" + "+sob+" = "+kq);//
        } else{
            kq=soa+r.nextInt(3)+sob;
            txvPhepTinh.setText(""+soa+" + "+sob+" = "+kq);
        }

        CountDownTimer t=new CountDownTimer(6000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                txvTime.setText(""+millisUntilFinished/1000);
                if((millisUntilFinished/1000<1)){
                    txvTime.setText("Het gio");
                  //  gameover();
                }
            }

            @Override
            public void onFinish() {
            gameover();
            }
        }.start();
    }
    public void gameover(){
        Intent intent=new Intent(playactivity.this,overactivity.class);
        startActivity(intent);

    }
}
