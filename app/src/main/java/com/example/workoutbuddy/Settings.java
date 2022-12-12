package com.example.workoutbuddy;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "settings_table")
public class Settings {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "Name")
    public String name;
    @ColumnInfo(name = "Color")
    public int color;
    @ColumnInfo(name = "FadedColor")
    public int fadedColor;
};