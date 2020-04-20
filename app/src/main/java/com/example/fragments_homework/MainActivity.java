package com.example.fragments_homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LaunchButtonsFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupLaunchButtonsFragment();
        setupResultHistoryFragment();
    }

    private void setupLaunchButtonsFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        LaunchButtonsFragment launchButtonsFragment = (LaunchButtonsFragment) fragmentManager.findFragmentById(R.id.fragment_launch_buttons);
        launchButtonsFragment.listener = this;
    }

    private void setupResultHistoryFragment() {
        ResultHistoryFragment resultHistoryFragment = new ResultHistoryFragment();
        showFragment(resultHistoryFragment);
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();
    }

    @Override
    public void onCalculatorButtonClick() {
        CalculatorFragment calculatorFragment = new CalculatorFragment();
        calculatorFragment.listener = this;
        showFragment(calculatorFragment);
    }

    @Override
    public void onShowHistoryClick() {
        ResultHistoryFragment resultHistoryFragment = new ResultHistoryFragment();
        resultHistoryFragment.listener = this;
        showFragment(resultHistoryFragment);
    }

}
