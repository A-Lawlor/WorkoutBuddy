package com.example.workoutbuddy;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Exercise.class, Workout.class}, version = 1)
public abstract class ExerciseDatabase extends RoomDatabase {

    public abstract ExerciseDao exerciseDao();

    private static ExerciseDatabase INSTANCE;

    public static ExerciseDatabase getDbInstance(Context context) {

        //Create database if it does not exist
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ExerciseDatabase.class, "exercise_database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
