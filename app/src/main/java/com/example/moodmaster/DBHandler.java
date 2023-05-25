package com.example.moodmaster;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "moodmasterdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "mood_values";
    private static final String ID = "id";
    private static final String Mood_Value = "value";

    private static final String Date = "date";



    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Mood_Value + " INTEGER,"
                + Date + " TEXT)";

        db.execSQL(query);
    }


// ...

    public void addValue(int value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // get current date
        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        values.put(Mood_Value, value);
        values.put(Date, currentDate);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Mood> getAllMoods() {
        ArrayList<Mood> moodList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " ORDER BY " + Date + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
// Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                int moodColIndex = cursor.getColumnIndex(Mood_Value);
                int dateColIndex = cursor.getColumnIndex(Date);

                if (moodColIndex != -1 && dateColIndex != -1) {
                    int moodValue = cursor.getInt(moodColIndex);
                    String moodDate = cursor.getString(dateColIndex);
                    Mood mood = new Mood(moodValue, moodDate);
                    moodList.add(mood);
                }
            } while (cursor.moveToNext());
        }


        // Return mood list
        return moodList;
    }

}
