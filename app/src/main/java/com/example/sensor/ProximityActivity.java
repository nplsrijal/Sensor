package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProximityActivity extends AppCompatActivity {
    private TextView tvPro;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);
        setTitle("Proximity Sensor");

        tvPro=findViewById(R.id.tvPro);
        sensorProxi();
    }
    private void sensorProxi() {
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        SensorEventListener sel=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[0] <= 4){
                    tvPro.setText("Object is Near");
                }else{
                    tvPro.setText("Object is Far");
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
