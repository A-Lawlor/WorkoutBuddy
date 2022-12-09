package com.example.workoutbuddy;

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