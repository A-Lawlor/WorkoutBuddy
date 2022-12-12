package com.example.workoutbuddy;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.example.workoutbuddy.databinding.FragmentExercisesBinding;

public class ExercisesFragment extends Fragment {
    private FragmentExercisesBinding binding;
    String muscleGroup = "";
    String exerciseName = "";
    int reps = 0;
    int sets = 0;
    int numOfExercises = 0;
    Boolean muscleGroupSet = false;
    Boolean exerciseNameSet = false;
    Boolean repsSet = false;
    Boolean setsSet = false;

    //Things to do make sure the same exercise cannot be added twice;
    //Make a popup to the user that said's the same exercise cannot be added
    //Add a display the number of exercises currently in the workout


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExercisesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ExerciseDatabase db = ExerciseDatabase.getDbInstance(this.getActivity().getApplicationContext());
        Settings[] settingsDB = db.exerciseDao().getAllSettings().toArray(new Settings[0]);
        //Get incrementer amount for progress bar

        //Change colors
        binding.addExerciseButton.setBackgroundColor(settingsDB[0].color);
        binding.mainMenuButton.setBackgroundColor(settingsDB[0].color);

        int max = binding.progressBar.getMax();
        int increment = max/4;

        class Utility{
            public void changeMuscleGroup(String muscle){
                muscleGroup = muscle;
            }
            public void changeExerciseName(String exercise){
                exerciseName = exercise;
            }
            public void changeRepsText(int repsArg){
                reps = repsArg;
            }
            public void changeSetsText(int setsArg){
                sets = setsArg;
            }
            public void muscleGroupProgressBar(){
                if(!muscleGroupSet){
                    binding.progressBar.incrementProgressBy(increment);
                    muscleGroupSet = true;
                }
            }
            public void exerciseNameProgressBar() {
                if (!exerciseNameSet) {
                    binding.progressBar.incrementProgressBy(increment);
                    exerciseNameSet = true;
                }
            }
            public void repsProgressBar() {
                if (!repsSet) {
                    binding.progressBar.incrementProgressBy(increment);
                    repsSet = true;
                }
            }
            public void setsProgressBar() {
                if (!setsSet) {
                    binding.progressBar.incrementProgressBy(increment);
                    setsSet = true;
                }
            }
        }

        Utility utility = new Utility();

        binding.exerciseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!binding.exerciseSpinner.getSelectedItem().toString().equals("Select Muscle Group")) {
                    utility.muscleGroupProgressBar();
                    utility.changeMuscleGroup(binding.exerciseSpinner.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });




        binding.textExercise.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (!String.valueOf(editable).equals("")) {
                    utility.changeExerciseName(String.valueOf(editable));
                    utility.exerciseNameProgressBar();
                }
                else {
                    int decrement = binding.progressBar.getProgress() - increment;
                    binding.progressBar.setProgress(decrement);
                    exerciseNameSet = false;
                }
            }
        });

        binding.textReps.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(!String.valueOf(editable).equals("")){
                    utility.changeRepsText(Integer.parseInt(editable.toString()));
                    utility.repsProgressBar();
                }
                else{
                    int decrement = binding.progressBar.getProgress() - increment;
                    binding.progressBar.setProgress(decrement);
                    repsSet = false;
                }

            }
        });

        binding.textSets.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(!String.valueOf(editable).equals("")) {
                    utility.changeSetsText(Integer.parseInt(editable.toString()));
                    utility.setsProgressBar();
                }
                 else{
                    int decrement = binding.progressBar.getProgress() - increment;
                    binding.progressBar.setProgress(decrement);
                    setsSet = false;
                }
            }
        });

        binding.addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exercise[] exerciseDB = db.exerciseDao().getAllExercise().toArray(new Exercise[0]);

                //If there is less than 10 total user created exercises
                if(exerciseDB.length < 10){
                    Exercise exercise = new Exercise(numOfExercises, muscleGroup, exerciseName, reps, sets);
                    db.exerciseDao().insertExercise(exercise);
                    numOfExercises++;
                }
            }
        });

        binding.mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NavDirections action = ExercisesFragmentDirections.actionExercisesFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}