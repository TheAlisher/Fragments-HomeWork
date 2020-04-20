package com.example.fragments_homework;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultHistoryFragment extends Fragment {

    static final String GET_TEXT_KEY = "get_text_key";

    private static int CALCULATOR_FRAGMENT_CODE = 15;

    MainAdapter adapter;
    ArrayList<String> getHistory;
    RecyclerView recyclerView;

    public LaunchButtonsFragmentListener listener;

    public ResultHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new MainAdapter();
        recyclerView = view.findViewById(R.id.vh_text_view);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CALCULATOR_FRAGMENT_CODE) {
            if (resultCode == RESULT_OK && data != null) {
                getHistory = new ArrayList<>();
                getHistory.add(0, data.getStringExtra(GET_TEXT_KEY));
                adapter.update(getHistory);
            }
        }
    }
}
