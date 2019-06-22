package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class LightActivity extends AppCompatActivity {
    private SensorManager sensorManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        setTitle("Light Sensor");
        sensorLight();

    }

    private void sensorLight() {
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        SensorEventListener sel=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.sensor.getType()==Sensor.TYPE_LIGHT){
                    Toast.makeText(LightActivity.this,"On Change: "+sensorEvent.values[0],Toast.LENGTH_SHORT).show();
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
