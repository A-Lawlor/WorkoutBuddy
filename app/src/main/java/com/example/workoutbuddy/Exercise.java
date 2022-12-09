package com.example.workoutbuddy;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "exercise_table")
public class Exercise {
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

    public Exercise(int id, String muscleGroup, String exerciseName, int reps, int sets){
        this.id = id;
        this.muscleGroup = muscleGroup;
        this.exerciseName = exerciseName;
        this.reps = reps;
        this.sets = sets;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setMuscleGroup(String muscleGroup){
        this.muscleGroup = muscleGroup;
    }

    public String getMuscleGroup(){
        return this.muscleGroup;
    }

    public void setExerciseName(String exerciseName){
        this.exerciseName = exerciseName;
    }

    public String getExerciseName(){
        return this.exerciseName;
    }

    public void setReps(int reps){
        this.reps = reps;
    }

    public int getReps(){
        return this.reps;
    }

    public void getSets(int sets){
        this.sets = sets;
    }

    public int getSets(){
        return this.sets;
    }

}
