package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     private Button btnac,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Sensor");
        btnac.findViewById(R.id.btnac);
        btn2.findViewById(R.id.btngyro);
        btn3.findViewById(R.id.btnpro);
        btn4.findViewById(R.id.btnlight);
        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AccelerometerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GyroscopeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
