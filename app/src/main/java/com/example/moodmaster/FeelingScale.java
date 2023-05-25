package com.example.moodmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FeelingScale extends AppCompatActivity {

    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feelingscale);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(FeelingScale.this);
    }
}