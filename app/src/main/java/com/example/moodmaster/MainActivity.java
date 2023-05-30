package com.example.moodmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        final TextView moodMasterTextView = findViewById(R.id.textView);
        final Handler handler = new Handler();

        // Set up scale and fade in animation for Moodmaster text
        Animation scaleAnimation = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        moodMasterTextView.startAnimation(scaleAnimation);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, FeelingScale.class);
                startActivity(intent);
            }
        }, 5000);  // 15000 milliseconds = 15 seconds
    }
}
