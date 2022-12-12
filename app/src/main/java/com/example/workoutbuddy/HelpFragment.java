package com.example.workoutbuddy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workoutbuddy.databinding.FragmentHelpBinding;
import com.example.workoutbuddy.databinding.FragmentSettingsBinding;


public class HelpFragment extends Fragment {
    private FragmentHelpBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HelpFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HelpFragment newInstance(String param1, String param2) {
        HelpFragment fragment = new HelpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHelpBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ExerciseDatabase db = ExerciseDatabase.getDbInstance(this.getActivity().getApplicationContext());
        Settings[] settingsDB = db.exerciseDao().getAllSettings().toArray(new Settings[0]);

        //Setting text color of title
        binding.textViewHelpAbout.setTextColor(settingsDB[0].color);

        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}