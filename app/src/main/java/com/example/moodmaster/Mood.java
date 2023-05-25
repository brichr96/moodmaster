package com.example.moodmaster;

public class Mood {
    private int value;
    private String date;

    public Mood(int value, String date) {
        this.value = value;
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }
}
