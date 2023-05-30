package com.example.moodmaster;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Mood.class}, version = 1)
public abstract class DBHandler extends RoomDatabase {

    private static DBHandler moodDBInstance;

    public abstract MoodDao moodDao();

    public static DBHandler getInstance(Context context){
        if(DBHandler.moodDBInstance == null){
            synchronized(DBHandler.class){
                if(DBHandler.moodDBInstance == null){
                    DBHandler.moodDBInstance = Room.databaseBuilder(context, DBHandler.class, "mood_db").build();
                }
            }
        }
        return(DBHandler.moodDBInstance);
    }


}
