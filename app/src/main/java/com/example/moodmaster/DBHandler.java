package com.example.moodmaster;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "moodmasterdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "mood_values";
    private static final String ID_COL = "id";
    private static final String VALUE_COL = "value";
    private static final String DATE_COL = "date";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + VALUE_COL + " INTEGER,"
                + DATE_COL + " TEXT)";

        db.execSQL(query);
    }


// ...

    public void addValue(int value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // get current date
        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        values.put(VALUE_COL, value);
        values.put(DATE_COL, currentDate);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
