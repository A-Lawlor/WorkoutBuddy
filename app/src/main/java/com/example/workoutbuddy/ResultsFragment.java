package com.example.workoutbuddy;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workoutbuddy.databinding.FragmentResultsBinding;
import com.example.workoutbuddy.databinding.FragmentWorkoutBinding;
import com.yashovardhan99.timeit.Stopwatch;
import com.yashovardhan99.timeit.Timer;


public class ResultsFragment extends Fragment {
    private FragmentResultsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

         class Utility{
            public String convertSecondsToHMmSs(long milliseconds) {
                long ms = (milliseconds / 1000);
                long s = (milliseconds / 1000) % 60;
                long m = (milliseconds / (1000 * 60)) % 24;
                long h = (milliseconds / (1000 * 60 * 60)) % 24;
                return String.format("%d:%02d:%02d:%02d", h,m,s,ms);
            }
        };

        Utility utility = new Utility();



        ExerciseDatabase db = ExerciseDatabase.getDbInstance(this.getActivity().getApplicationContext());
        Settings[] settingsDB = db.exerciseDao().getAllSettings().toArray(new Settings[0]);

        binding.resultsConstraint.setBackgroundColor(settingsDB[0].color);
        binding.mainMenuReusltsButton.setTextColor(settingsDB[0].color);

        db.exerciseDao().deleteAllWorkout();
        Long stopwatchMS = ResultsFragmentArgs.fromBundle(requireArguments()).getStopwatchMS();
        binding.timerResult.setText("Time: " + utility.convertSecondsToHMmSs(stopwatchMS));


        binding.mainMenuReusltsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = ResultsFragmentDirections.actionResultsFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}