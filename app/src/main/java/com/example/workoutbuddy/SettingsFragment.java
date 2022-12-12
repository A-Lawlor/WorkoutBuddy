package com.example.workoutbuddy;

import android.graphics.Color;
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
import com.example.workoutbuddy.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {
    private FragmentSettingsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        ExerciseDatabase db = ExerciseDatabase.getDbInstance(this.getActivity().getApplicationContext());
        Settings userSettings = new Settings();
        Settings[] settingsDB = db.exerciseDao().getAllSettings().toArray(new Settings[0]);

        userSettings.name = "Welcome to WorkoutBuddy";
        binding.settingsSubmit.setBackgroundColor(settingsDB[0].color);

        binding.settingColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: userSettings.color = Color.parseColor("#0F89CF");
                            userSettings.fadedColor = Color.parseColor("#800F89CF");
                            break;
                    case 1: userSettings.color = Color.parseColor("#d11717");
                            userSettings.fadedColor = Color.parseColor("#80d11717");
                            break;
                    case 2: userSettings.color = Color.parseColor("#e30e7c");
                            userSettings.fadedColor = Color.parseColor("#80e30e7c");
                            break;
                    case 3: userSettings.color = Color.parseColor("#10e325");
                            userSettings.fadedColor = Color.parseColor("#8010e325");
                            break;
                    case 4: userSettings.color = Color.parseColor("#e2ed0c");
                            userSettings.fadedColor = Color.parseColor("#80e2ed0c");
                            break;
                    case 5: userSettings.color = Color.parseColor("#ed9a0c");
                            userSettings.fadedColor = Color.parseColor("#80ed9a0c");
                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                userSettings.color = Color.parseColor("#64eb34");
                userSettings.fadedColor = Color.parseColor("#8064eb34");
            }
        });


        binding.settingName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                userSettings.name = "Welcome " + editable;
                System.out.println(userSettings.name);
            }
        });

        binding.settingsSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(userSettings.name);
                db.exerciseDao().deleteAllSettings();
                db.exerciseDao().insertSettings(userSettings);
                NavDirections action = SettingsFragmentDirections.actionSettingsFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        return view;
    }



}