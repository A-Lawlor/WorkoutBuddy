package com.example.workoutbuddy;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Dao;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

@Dao
public interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertExercise(Exercise exercise);

    @Delete
    void deleteExercise(Exercise exercise);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertWorkout(Workout workout);

    @Delete
    void deleteWorkout(Workout workout);


//    @Ignore
//    @Query("SELECT exercise_name FROM exercise_table WHERE exercise_name = :exercise")
//    List<Exercise> exerciseInTable(String exercise);


    @Query("SELECT * FROM exercise_table")
    List<Exercise> getAllExercise();

    @Query("DELETE FROM exercise_table")
    void deleteAllExercise();

    @Query("SELECT * FROM workout_table")
    List<Workout> getAllWorkout();

    @Query("DELETE FROM workout_table")
    void deleteAllWorkout();

}
