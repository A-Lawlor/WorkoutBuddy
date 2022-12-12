package com.example.workoutbuddy;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workoutbuddy.databinding.FragmentMenuBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuFragment extends Fragment {
    private FragmentMenuBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        ExerciseDatabase db = ExerciseDatabase.getDbInstance(this.getActivity().getApplicationContext());


        //If no settings exist generate a default settings
        if(db.exerciseDao().getAllSettings().size() == 0) {
            Settings defaultSettings = new Settings();
            defaultSettings.color = Color.parseColor("0F89CF");
            defaultSettings.name = "Welcome to WorkoutBuddy";
            defaultSettings.fadedColor = Color.parseColor("#800F89CF");
            db.exerciseDao().insertSettings(defaultSettings);
        }

        Settings[] settingsDB = db.exerciseDao().getAllSettings().toArray(new Settings[0]);

        binding.constraintView.setBackgroundColor(settingsDB[0].color);
        binding.startButton.setTextColor(settingsDB[0].color);
        binding.customizeButton.setTextColor(settingsDB[0].color);
        binding.addExerciseButton.setTextColor(settingsDB[0].color);
        binding.menuWelcomeText.setText(settingsDB[0].name);

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NavDirections action = MenuFragmentDirections.actionMenuFragmentToWorkoutFragment();
                NavDirections action = MenuFragmentDirections.actionMenuFragmentToWorkoutFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.customizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = MenuFragmentDirections.actionMenuFragmentToViewExercisesFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = MenuFragmentDirections.actionMenuFragmentToExercisesFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
        return view;
    }
}