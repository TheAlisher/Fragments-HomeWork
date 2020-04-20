package com.example.fragments_homework;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class LaunchButtonsFragment extends Fragment {

    Button showCalculatorButton;
    Button showResultHistoryButton;

    LaunchButtonsFragmentListener listener;

    public LaunchButtonsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_launch_buttons, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showCalculatorButton = view.findViewById(R.id.show_calculator);
        showResultHistoryButton = view.findViewById(R.id.show_result_history);

        showCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("anim", "showCalculator clicked");
                listener.onCalculatorButtonClick();
            }
        });

        showResultHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onShowHistoryClick();
            }
        });
    }
}
