package com.example.workoutbuddy;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "workout_table")
public class Workout {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "muscle_group")
    public String muscleGroup;
    @ColumnInfo(name = "exercise_name")
    public String exerciseName;
    @ColumnInfo(name = "reps")
    public int reps;
    @ColumnInfo(name = "sets")
    public int sets;

    public Workout(String muscleGroup, String exerciseName, int reps, int sets){
        this.muscleGroup = muscleGroup;
        this.exerciseName = exerciseName;
        this.reps = reps;
        this.sets = sets;
    }

}
