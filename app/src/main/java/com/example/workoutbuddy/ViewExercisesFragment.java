package com.example.workoutbuddy;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.workoutbuddy.databinding.FragmentViewExercisesBinding;
import com.example.workoutbuddy.databinding.FragmentWorkoutBinding;

public class ViewExercisesFragment extends Fragment {
    private FragmentViewExercisesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context context = this.getActivity().getApplicationContext();
        ExerciseDatabase db = ExerciseDatabase.getDbInstance(this.getActivity().getApplicationContext());
        db.exerciseDao().deleteAllWorkout();




        // Inflate the layout for this fragment
        binding = FragmentViewExercisesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        //Gets all ex


        //Class to call after clear because there is no way to refresh onCreateView in this version of android
        class Utility{
            Exercise[] exerciseDB;

            public void setExerciseDB(){
                exerciseDB = db.exerciseDao().getAllExercise().toArray(new Exercise[0]);
            }

            public void setBindings(){
                binding.viewExercise0.setVisibility(View.GONE);
                binding.viewExercise1.setVisibility(View.GONE);
                binding.viewExercise2.setVisibility(View.GONE);
                binding.viewExercise3.setVisibility(View.GONE);
                binding.viewExercise4.setVisibility(View.GONE);
                binding.viewExercise5.setVisibility(View.GONE);
                binding.viewExercise6.setVisibility(View.GONE);
                binding.viewExercise7.setVisibility(View.GONE);
                binding.viewExercise8.setVisibility(View.GONE);
                binding.viewExercise9.setVisibility(View.GONE);

                for(int i = 0; i < exerciseDB.length; i++) {
                    System.out.println(exerciseDB.length);
                    switch (i) {
                        case 0:
                            binding.viewExercise0.setVisibility(View.VISIBLE);
                            binding.viewExerciseTextType0.setText("[" + exerciseDB[i].getMuscleGroup() + "]");
                            binding.viewExerciseText0.setText(exerciseDB[i].getExerciseName() + "\n" + "Reps: " + exerciseDB[i].getReps() + " Sets: " + exerciseDB[i].getSets());
                            break;
                        case 1:
                            binding.viewExercise1.setVisibility(View.VISIBLE);
                            binding.viewExerciseTextType1.setText("[" + exerciseDB[i].getMuscleGroup() + "]");
                            binding.viewExerciseText1.setText(exerciseDB[i].exerciseName + "\n" + "Reps: " + exerciseDB[i].reps + " Sets: " + exerciseDB[i].sets);
                            break;
                        case 2:
                            binding.viewExercise2.setVisibility(View.VISIBLE);
                            binding.viewExerciseTextType2.setText("[" + exerciseDB[i].getMuscleGroup() + "]");
                            binding.viewExerciseText2.setText(exerciseDB[i].exerciseName + "\n" + "Reps: " + exerciseDB[i].reps + " Sets: " + exerciseDB[i].sets);
                            break;
                        case 3:
                            binding.viewExercise3.setVisibility(View.VISIBLE);
                            binding.viewExerciseTextType3.setText("[" + exerciseDB[i].getMuscleGroup() + "]");
                            binding.viewExerciseText3.setText(exerciseDB[i].exerciseName + "\n" + "Reps: " + exerciseDB[i].reps + " Sets: " + exerciseDB[i].sets);
                            break;
                        case 4:
                            binding.viewExercise4.setVisibility(View.VISIBLE);
                            binding.viewExerciseTextType4.setText("[" + exerciseDB[i].getMuscleGroup() + "]");
                            binding.viewExerciseText4.setText(exerciseDB[i].exerciseName + "\n" + "Reps: " + exerciseDB[i].reps + " Sets: " + exerciseDB[i].sets);
                            break;
                        case 5:
                            binding.viewExercise5.setVisibility(View.VISIBLE);
                            binding.viewExerciseTextType5.setText("[" + exerciseDB[i].getMuscleGroup() + "]");
                            binding.viewExerciseText5.setText(exerciseDB[i].exerciseName + "\n" + "Reps: " + exerciseDB[i].reps + " Sets: " + exerciseDB[i].sets);
                            break;
                        case 6:
                            binding.viewExercise6.setVisibility(View.VISIBLE);
                            binding.viewExerciseTextType6.setText("[" + exerciseDB[i].getMuscleGroup() + "]");
                            binding.viewExerciseText6.setText(exerciseDB[i].exerciseName + "\n" + "Reps: " + exerciseDB[i].reps + " Sets: " + exerciseDB[i].sets);
                            break;
                        case 7:
                            binding.viewExercise7.setVisibility(View.VISIBLE);
                            binding.viewExerciseTextType7.setText("[" + exerciseDB[i].getMuscleGroup() + "]");
                            binding.viewExerciseText7.setText(exerciseDB[i].exerciseName + "\n" + "Reps: " + exerciseDB[i].reps + " Sets: " + exerciseDB[i].sets);
                            break;
                        case 8:
                            binding.viewExercise8.setVisibility(View.VISIBLE);
                            binding.viewExerciseTextType8.setText("[" + exerciseDB[i].getMuscleGroup() + "]");
                            binding.viewExerciseText8.setText(exerciseDB[i].exerciseName + "\n" + "Reps: " + exerciseDB[i].reps + " Sets: " + exerciseDB[i].sets);
                            break;
                        case 9:
                            binding.viewExercise9.setVisibility(View.VISIBLE);
                            binding.viewExerciseTextType9.setText("[" + exerciseDB[i].getMuscleGroup() + "]");
                            binding.viewExerciseText9.setText(exerciseDB[i].exerciseName + "\n" + "Reps: " + exerciseDB[i].reps + " Sets: " + exerciseDB[i].sets);
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        Utility utility = new Utility();
        utility.setExerciseDB();
        utility.setBindings();
            //*******Add checks to not let you add over 10 exercises
            binding.viewCheckBox0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.viewCheckBox0.isChecked()) {
                        Workout workout = new Workout(utility.exerciseDB[0].muscleGroup, utility.exerciseDB[0].exerciseName, utility.exerciseDB[0].reps, utility.exerciseDB[0].sets);
                        db.exerciseDao().insertWorkout(workout);
                    }
                }
            });
            binding.viewCheckBox1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.viewCheckBox1.isChecked()) {
                        Workout workout = new Workout(utility.exerciseDB[1].muscleGroup, utility.exerciseDB[1].exerciseName, utility.exerciseDB[1].reps, utility.exerciseDB[1].sets);
                        db.exerciseDao().insertWorkout(workout);
                    }
                }
            });

            binding.viewCheckBox2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.viewCheckBox2.isChecked()) {
                        Workout workout = new Workout(utility.exerciseDB[2].muscleGroup, utility.exerciseDB[2].exerciseName, utility.exerciseDB[2].reps, utility.exerciseDB[2].sets);
                        db.exerciseDao().insertWorkout(workout);
                    }
                }
            });

            binding.viewCheckBox3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.viewCheckBox3.isChecked()) {
                        Workout workout = new Workout(utility.exerciseDB[3].muscleGroup, utility.exerciseDB[3].exerciseName, utility.exerciseDB[3].reps, utility.exerciseDB[3].sets);
                        db.exerciseDao().insertWorkout(workout);
                    }
                }
            });

            binding.viewCheckBox4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.viewCheckBox4.isChecked()) {
                        Workout workout = new Workout(utility.exerciseDB[4].muscleGroup, utility.exerciseDB[4].exerciseName, utility.exerciseDB[4].reps, utility.exerciseDB[4].sets);
                        db.exerciseDao().insertWorkout(workout);
                    }
                }
            });

            binding.viewCheckBox5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.viewCheckBox5.isChecked()) {
                        Workout workout = new Workout(utility.exerciseDB[5].muscleGroup, utility.exerciseDB[5].exerciseName, utility.exerciseDB[5].reps, utility.exerciseDB[5].sets);
                        db.exerciseDao().insertWorkout(workout);
                    }
                }
            });

            binding.viewCheckBox6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.viewCheckBox6.isChecked()) {
                        Workout workout = new Workout(utility.exerciseDB[6].muscleGroup, utility.exerciseDB[6].exerciseName, utility.exerciseDB[6].reps, utility.exerciseDB[6].sets);
                        db.exerciseDao().insertWorkout(workout);
                    }
                }
            });

            binding.viewCheckBox7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.viewCheckBox7.isChecked()) {
                        Workout workout = new Workout(utility.exerciseDB[7].muscleGroup, utility.exerciseDB[7].exerciseName, utility.exerciseDB[7].reps, utility.exerciseDB[7].sets);
                        db.exerciseDao().insertWorkout(workout);
                    }
                }
            });

            binding.viewCheckBox8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.viewCheckBox8.isChecked()) {
                        Workout workout = new Workout(utility.exerciseDB[8].muscleGroup, utility.exerciseDB[8].exerciseName, utility.exerciseDB[8].reps, utility.exerciseDB[8].sets);
                        db.exerciseDao().insertWorkout(workout);
                    }
                }
            });

            binding.viewCheckBox9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.viewCheckBox9.isChecked()) {
                        Workout workout = new Workout(utility.exerciseDB[9].muscleGroup, utility.exerciseDB[9].exerciseName, utility.exerciseDB[9].reps, utility.exerciseDB[9].sets);
                        db.exerciseDao().insertWorkout(workout);
                    }
                }
            });


            binding.buttonStartWorkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavDirections action = ViewExercisesFragmentDirections.actionViewExercisesFragmentToWorkoutFragment();
                    Navigation.findNavController(view).navigate(action);
                }
            });

            binding.buttonAddExercise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavDirections action = ViewExercisesFragmentDirections.actionViewExercisesFragmentToExercisesFragment();
                    Navigation.findNavController(view).navigate(action);
                }
            });

            binding.buttonClearExercises.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.exerciseDao().deleteAllExercise();
                    db.exerciseDao().deleteAllWorkout();
                    utility.setExerciseDB();
                    utility.setBindings();

                }
            });
        return view;
    }
}