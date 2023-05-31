package com.example.moodmaster;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class FeelingScale extends AppCompatActivity {
    // Instantiate your DBHandler
    private DBHandler dbHandler;
    private MoodDao moodDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feelingscale);  // Replace with your layout

        dbHandler = DBHandler.getInstance(getApplicationContext());
        moodDao = dbHandler.moodDao();

//        Mood mood = new Mood(42);
//
//        new InsertMoodAsyncTask().execute(mood);
//        new GetAllMoodsAsyncTask().execute();

        Button buttonMood1 = findViewById(R.id.buttonMood1);
        Button buttonMood2 = findViewById(R.id.buttonMood2);
        Button buttonMood3 = findViewById(R.id.buttonMood3);
        Button buttonMood4 = findViewById(R.id.buttonMood4);
        Button buttonMood5 = findViewById(R.id.buttonMood5);

        buttonMood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("YOUR MOOD IS BAD");
//                Mood m = new Mood(1, new Date());
//                new InsertMoodAsyncTask().execute(m);
                new GetAllMoodsAsyncTask().execute();
            }
        });

        buttonMood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("YOUR MOOD IS SEMI-BAD");
//                Mood m = new Mood(2, date);
//                new InsertMoodAsyncTask().execute(m);
                new GetAllMoodsAsyncTask().execute();
            }
        });

        buttonMood3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("YOUR MOOD IS SEMI");
//                Mood m = new Mood(3, date);
//                new InsertMoodAsyncTask().execute(m);
                new GetAllMoodsAsyncTask().execute();
            }
        });

        buttonMood4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("YOUR MOOD IS SEMI-GOOD");
//                Mood m = new Mood(4, date);
//                new InsertMoodAsyncTask().execute(m);
                new GetAllMoodsAsyncTask().execute();
            }
        });

        buttonMood5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("YOUR MOOD IS GOOD");
//                Mood m = new Mood(5, date);
//                new InsertMoodAsyncTask().execute(m);
                new GetAllMoodsAsyncTask().execute();
            }
        });

    }

    public class InsertMoodAsyncTask extends AsyncTask<Mood, Void, Void> {
        @Override
        protected Void doInBackground(Mood... moods){
            System.out.println("++++++++++++++++++++++++++" + moods[0].getMood());
            moodDao.insert(moods[0]);
            return null;
        }
    }

    public class GetAllMoodsAsyncTask extends AsyncTask<Void, Void, List<Mood>>{
        @Override
        protected List<Mood> doInBackground(Void... voids){
            return moodDao.getAllMoods();
        }

        @Override
        protected void onPostExecute(List<Mood> moods){
            super.onPostExecute(moods);

            for(Mood m : moods){
                System.out.println("-----------------------------------MOOD: " + m.getMood() + " " + m.getDate());
            }
        }
    }
}
