package com.example.fastmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class overactivity extends AppCompatActivity {
    TextView txvmyScrore;
    Button btn_Try, btn_Home;
    String myCore,mybest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overactivity);
        txvmyScrore = findViewById(R.id.txvmyscore);
        btn_Home = findViewById(R.id.btnhome);
        btn_Try = findViewById(R.id.btntryagain);
        // lay diem
        Intent getScrore = this.getIntent();
        myCore = getScrore.getStringExtra("d");
        mybest = getScrore.getStringExtra("dcao");
        //hien diem
        txvmyScrore.setText(myCore);
        btn_Try.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(overactivity.this,playactivity.class);
                startActivity(intent);
                overactivity.this.finish();
            }
        });
        btn_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(overactivity.this,MainActivity.class);
                intent.putExtra("dh",mybest);
                startActivity(intent);
                overactivity.this.finish();
            }
        });
    }
}
