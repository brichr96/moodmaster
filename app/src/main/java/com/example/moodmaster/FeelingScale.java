package com.example.moodmaster;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FeelingScale extends AppCompatActivity {
    // Instantiate your DBHandler
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feelingscale);  // Replace with your layout

        dbHandler = new DBHandler(this);

        Button vH = findViewById(R.id.veryHappy);
        Button qH = findViewById(R.id.quiteHappy);
        Button nhnu = findViewById(R.id.nhnu);
        Button qU = findViewById(R.id.quiteUnhappy);
        Button vU = findViewById(R.id.veryUnhappy);


        vH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.addValue(1);
            }
        });

        qH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.addValue(2);
            }
        });
        nhnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.addValue(2);
            }
        });
        qU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.addValue(2);
            }
        });
        vU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.addValue(2);
            }
        });


        // ... set up listeners for the rest of your buttons
    }
}
