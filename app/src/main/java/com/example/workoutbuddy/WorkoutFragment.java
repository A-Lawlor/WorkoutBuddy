package com.example.workoutbuddy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.workoutbuddy.databinding.FragmentMenuBinding;
import com.example.workoutbuddy.databinding.FragmentWorkoutBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.yashovardhan99.timeit.Stopwatch;
import com.yashovardhan99.timeit.Timer;

import org.w3c.dom.Text;

public class WorkoutFragment extends Fragment {
    private FragmentWorkoutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWorkoutBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ExerciseDatabase db = ExerciseDatabase.getDbInstance(this.getActivity().getApplicationContext());
        Settings[] settingsDB = db.exerciseDao().getAllSettings().toArray(new Settings[0]);

        binding.buttonFinishedWorkout.setBackgroundColor(settingsDB[0].color);

        //Max value for each progress bar
        int max = binding.workoutBar0.getMax();



        int appMainColor = settingsDB[0].color;
        int appMainColorTrans = settingsDB[0].fadedColor;


        //Gets all workouts added from viewExercisesFragment
        Workout[] workoutDB = db.exerciseDao().getAllWorkout().toArray(new Workout[0]);
        Stopwatch stopwatch = new Stopwatch();
        //New timer object and setting text field to timer

        stopwatch.setTextView(binding.timer);
        stopwatch.start();

        System.out.println(workoutDB.length);
        for(int i = 0; i < workoutDB.length; i++) {
            switch (i) {
                case 0: binding.exercise0.setVisibility(View.VISIBLE);
                        binding.workoutBarLayout0.setVisibility(View.VISIBLE);
                        binding.setButton0.setBackgroundColor(appMainColor);
                        binding.exerciseTextType0.setText("[" + workoutDB[i].muscleGroup + "]");
                        binding.exerciseText0.setText(workoutDB[i].exerciseName + "\n" + "Reps: " + workoutDB[i].reps + " Sets: " + workoutDB[i].sets);

                        break;
                case 1: binding.exercise1.setVisibility(View.VISIBLE);
                        binding.workoutBarLayout1.setVisibility(View.VISIBLE);
                        binding.setButton1.setBackgroundColor(appMainColor);
                        binding.exerciseTextType1.setText("[" + workoutDB[i].muscleGroup + "]");
                        binding.exerciseText1.setText(workoutDB[i].exerciseName + "\n" + "Reps: " + workoutDB[i].reps + " Sets: " + workoutDB[i].sets);
                        break;
                case 2: binding.exercise2.setVisibility(View.VISIBLE);
                        binding.workoutBarLayout2.setVisibility(View.VISIBLE);
                        binding.setButton2.setBackgroundColor(appMainColor);
                        binding.exerciseTextType2.setText("[" + workoutDB[i].muscleGroup + "]");
                        binding.exerciseText2.setText(workoutDB[i].exerciseName + "\n" + "Reps: " + workoutDB[i].reps + " Sets: " + workoutDB[i].sets);
                        break;
                case 3: binding.exercise3.setVisibility(View.VISIBLE);
                        binding.workoutBarLayout3.setVisibility(View.VISIBLE);
                        binding.setButton3.setBackgroundColor(appMainColor);
                        binding.exerciseTextType3.setText("[" + workoutDB[i].muscleGroup + "]");
                        binding.exerciseText3.setText(workoutDB[i].exerciseName + "\n" + "Reps: " + workoutDB[i].reps + " Sets: " + workoutDB[i].sets);
                        break;
                case 4: binding.exercise4.setVisibility(View.VISIBLE);
                        binding.workoutBarLayout4.setVisibility(View.VISIBLE);
                        binding.setButton4.setBackgroundColor(appMainColor);
                        binding.exerciseTextType4.setText("[" + workoutDB[i].muscleGroup + "]");
                        binding.exerciseText4.setText(workoutDB[i].exerciseName + "\n" + "Reps: " + workoutDB[i].reps + " Sets: " + workoutDB[i].sets);
                        break;
                case 5: binding.exercise5.setVisibility(View.VISIBLE);
                        binding.workoutBarLayout5.setVisibility(View.VISIBLE);
                        binding.setButton5.setBackgroundColor(appMainColor);
                        binding.exerciseTextType5.setText("[" + workoutDB[i].muscleGroup + "]");
                        binding.exerciseText5.setText(workoutDB[i].exerciseName + "\n" + "Reps: " + workoutDB[i].reps + " Sets: " + workoutDB[i].sets);
                        break;
                case 6: binding.exercise6.setVisibility(View.VISIBLE);
                        binding.workoutBarLayout6.setVisibility(View.VISIBLE);
                        binding.setButton6.setBackgroundColor(appMainColor);
                        binding.exerciseTextType6.setText("[" + workoutDB[i].muscleGroup + "]");
                        binding.exerciseText6.setText(workoutDB[i].exerciseName + "\n" + "Reps: " + workoutDB[i].reps + " Sets: " + workoutDB[i].sets);
                        break;
                case 7: binding.exercise7.setVisibility(View.VISIBLE);
                        binding.workoutBarLayout7.setVisibility(View.VISIBLE);
                        binding.setButton7.setBackgroundColor(appMainColor);
                        binding.exerciseTextType7.setText("[" + workoutDB[i].muscleGroup + "]");
                        binding.exerciseText7.setText(workoutDB[i].exerciseName + "\n" + "Reps: " + workoutDB[i].reps + " Sets: " + workoutDB[i].sets);
                        break;
                case 8: binding.exercise8.setVisibility(View.VISIBLE);
                        binding.workoutBarLayout8.setVisibility(View.VISIBLE);
                        binding.setButton8.setBackgroundColor(appMainColor);
                        binding.exerciseTextType8.setText("[" + workoutDB[i].muscleGroup + "]");
                        binding.exerciseText8.setText(workoutDB[i].exerciseName + "\n" + "Reps: " + workoutDB[i].reps + " Sets: " + workoutDB[i].sets);
                        break;
                case 9: binding.exercise9.setVisibility(View.VISIBLE);
                        binding.workoutBarLayout9.setVisibility(View.VISIBLE);
                        binding.setButton9.setBackgroundColor(appMainColor);
                        binding.exerciseTextType9.setText("[" + workoutDB[i].muscleGroup + "]");
                        binding.exerciseText9.setText("[" + workoutDB[i].muscleGroup + "] " + workoutDB[i].exerciseName + "\n" + "Reps: " + workoutDB[i].reps + " Sets: " + workoutDB[i].sets);
                        break;
                default:
                        break;
            }
        }

        //Start of dealing with adding sets and modifying progress bar
        binding.setButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.workoutBar0.incrementProgressBy(max/workoutDB[0].sets);
                //Catch if progress is not completely divisible by #sets
                if(binding.workoutBar0.getProgress() >= 98){
                    binding.workoutBar0.incrementProgressBy(5);
                    binding.exercise0.setBackgroundColor(appMainColorTrans);
                }
            }
        });

        binding.setButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.workoutBar1.incrementProgressBy(max/workoutDB[1].sets);
                //Catch if progress is not completely divisible by #sets
                if(binding.workoutBar1.getProgress() >= 98){
                    binding.workoutBar1.incrementProgressBy(5);
                    binding.exercise1.setBackgroundColor(appMainColorTrans);
                }
            }
        });

        binding.setButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.workoutBar2.incrementProgressBy(max/workoutDB[2].sets);
                //Catch if progress is not completely divisible by #sets
                if(binding.workoutBar2.getProgress() >= 98){
                    binding.workoutBar2.incrementProgressBy(5);
                    binding.exercise2.setBackgroundColor(appMainColorTrans);
                }
            }
        });

        binding.setButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.workoutBar3.incrementProgressBy(max/workoutDB[3].sets);
                //Catch if progress is not completely divisible by #sets
                if(binding.workoutBar3.getProgress() >= 98){
                    binding.workoutBar3.incrementProgressBy(5);
                    binding.exercise3.setBackgroundColor(appMainColorTrans);
                }
            }
        });

        binding.setButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.workoutBar4.incrementProgressBy(max/workoutDB[4].sets);
                //Catch if progress is not completely divisible by #sets
                if(binding.workoutBar4.getProgress() >= 98){
                    binding.workoutBar4.incrementProgressBy(5);
                    binding.exercise4.setBackgroundColor(appMainColorTrans);
                }
            }
        });

        binding.setButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.workoutBar5.incrementProgressBy(max/workoutDB[5].sets);
                //Catch if progress is not completely divisible by #sets
                if(binding.workoutBar5.getProgress() >= 98){
                    binding.workoutBar5.incrementProgressBy(5);
                    binding.exercise5.setBackgroundColor(appMainColorTrans);
                }
            }
        });

        binding.setButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.workoutBar6.incrementProgressBy(max/workoutDB[6].sets);
                //Catch if progress is not completely divisible by #sets
                if(binding.workoutBar6.getProgress() >= 98){
                    binding.workoutBar6.incrementProgressBy(5);
                    binding.exercise6.setBackgroundColor(appMainColorTrans);
                }
            }
        });

        binding.setButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.workoutBar7.incrementProgressBy(max/workoutDB[7].sets);
                //Catch if progress is not completely divisible by #sets
                if(binding.workoutBar7.getProgress() >= 98){
                    binding.workoutBar7.incrementProgressBy(5);
                    binding.exercise7.setBackgroundColor(appMainColorTrans);
                }
            }
        });

        binding.setButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.workoutBar8.incrementProgressBy(max/workoutDB[8].sets);
                //Catch if progress is not completely divisible by #sets
                if(binding.workoutBar8.getProgress() >= 98){
                    binding.workoutBar8.incrementProgressBy(5);
                    binding.exercise8.setBackgroundColor(appMainColorTrans);
                }
            }
        });

        binding.setButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.workoutBar9.incrementProgressBy(max/workoutDB[9].sets);
                //Catch if progress is not completely divisible by #sets
                if(binding.workoutBar9.getProgress() >= 98){
                    binding.workoutBar9.incrementProgressBy(5);
                    binding.exercise9.setBackgroundColor(appMainColorTrans);
                }
            }
        });

        binding.buttonFinishedWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int completedExer0 = 0, completedExer1 = 0, completedExer2 = 0, completedExer3 = 0, completedExer4 = 0, completedExer5 = 0, completedExer6 = 0, completedExer7 = 0, completedExer8 = 0, completedExer9 = 0;

                if(binding.exercise0.getVisibility() == View.VISIBLE){
                    completedExer0 = 1;
                    if(binding.workoutBar0.getProgress() == max){
                        completedExer0 = 2;
                    }
                }
                if(binding.exercise1.getVisibility() == View.VISIBLE){
                    completedExer1 = 1;
                    if(binding.workoutBar1.getProgress() == max){
                        completedExer1 = 2;
                    }
                }
                if(binding.exercise2.getVisibility() == View.VISIBLE){
                    completedExer2 = 1;
                    if(binding.workoutBar2.getProgress() == max){
                        completedExer2 = 2;
                    }
                }
                if(binding.exercise3.getVisibility() == View.VISIBLE){
                    completedExer3 = 1;
                    if(binding.workoutBar3.getProgress() == max){
                        completedExer3 = 2;
                    }
                }
                if(binding.exercise4.getVisibility() == View.VISIBLE){
                    completedExer4 = 1;
                    if(binding.workoutBar4.getProgress() == max){
                        completedExer4 = 2;
                    }
                }
                if(binding.exercise5.getVisibility() == View.VISIBLE){
                    completedExer5 = 1;
                    if(binding.workoutBar5.getProgress() == max){
                        completedExer5 = 2;
                    }
                }
                if(binding.exercise6.getVisibility() == View.VISIBLE){
                    completedExer6 = 1;
                    if(binding.workoutBar6.getProgress() == max){
                        completedExer6 = 2;
                    }
                }
                if(binding.exercise7.getVisibility() == View.VISIBLE){
                    completedExer7 = 1;
                    if(binding.workoutBar7.getProgress() == max){
                        completedExer7 = 2;
                    }
                }
                if(binding.exercise8.getVisibility() == View.VISIBLE){
                    completedExer8 = 1;
                    if(binding.workoutBar8.getProgress() == max){
                        completedExer8 = 2;
                    }
                }
                if(binding.exercise9.getVisibility() == View.VISIBLE){
                    completedExer9 = 1;
                    if(binding.workoutBar9.getProgress() == max){
                        completedExer9 = 2;
                    }
                }

                //Checking no progress bars are still active and will sent activity to result screen.
                if(completedExer0 != 1 && completedExer1 != 1 && completedExer2 != 1 && completedExer3 != 1 && completedExer4 != 1 && completedExer5 != 1 && completedExer6 != 1 && completedExer7 != 1 && completedExer8 != 1 && completedExer9 != 1){
                    stopwatch.pause();
                    NavDirections action = WorkoutFragmentDirections.actionWorkoutFragmentToResultsFragment(stopwatch.getElapsedTime());
                    Navigation.findNavController(view).navigate(action);
                }
                else{
                    Snackbar shesASnack = Snackbar.make(requireActivity().getWindow().getDecorView().getRootView(), "Please Complete All Exercises", Snackbar.LENGTH_LONG);
                    shesASnack.getView().setTranslationY(-120);
                    shesASnack.getView().setBackgroundColor(appMainColor);
                    shesASnack.setTextColor(Color.WHITE);
                    shesASnack.show();
                }
            }
        });

        return view;
    }




}