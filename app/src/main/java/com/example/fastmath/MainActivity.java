package com.example.fastmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnPlay, btnAbout;
    TextView txvScore;
    SharedPreferences pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   pr=getSharedPreferences("luudiemhome",MODE_PRIVATE);
        Intent laydiem=this.getIntent();
        String  score=laydiem.getStringExtra("diemhome");
        txvScore=findViewById(R.id.txvscore);
        txvScore.setText(score);

        btnPlay=findViewById(R.id.btnplay);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,playactivity.class);
                startActivity(intent);
            }
        });
//        SharedPreferences.Editor editor=pr.edit();
//        editor.putString("diem",score);
//        editor.commit();
    }
}
