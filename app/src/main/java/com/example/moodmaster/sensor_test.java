package com.example.moodmaster;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

// Inside your activity or fragment
public class sensor_test extends AppCompatActivity {
    private SensorHelper sensorHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_test);

        // Create an instance of SensorHelper
        sensorHelper = new SensorHelper(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Start listening for light sensor changes
        sensorHelper.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Stop listening for light sensor changes
        sensorHelper.stop();
    }

    private void processLightValues() {
        List<Float> lightValues = sensorHelper.getLightValues();
        // Perform operations with the lightValues list
        // Example: Log the values
        for (float value : lightValues) {
            Log.d("Light Value", String.valueOf(value));
        }
    }
}
