package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class GyroscopeActivity extends AppCompatActivity {
    private TextView tvGyro;
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        setTitle("Gyroscrope Sensor");

        tvGyro=findViewById(R.id.tvGyro);
        sensorGyro();
    }

    private void sensorGyro() {
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        SensorEventListener sel=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[2] > 0.5f) { // anticlockwise
                    tvGyro.setText("Left");
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                } else if(sensorEvent.values[2] < -0.5f) { // clockwise
                    tvGyro.setText("right");
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        if(sensor != null){
            sensorManager.registerListener(sel,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(this, "No Sensor Found", Toast.LENGTH_SHORT).show();
        }
    }
}
