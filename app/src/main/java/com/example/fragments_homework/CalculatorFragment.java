package com.example.fragments_homework;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {

    public LaunchButtonsFragmentListener listener;

    TextView result;
    Double firstValues, secondValues, result_operation;
    String operation;

    Button clearButton;
    Button sevenButton;
    Button eightButton;
    Button nineButton;
    Button fourButton;
    Button fiveButton;
    Button sixButton;
    Button oneButton;
    Button twoButton;
    Button threeButton;
    Button dotButton;

    Button plusButton;
    Button minusButton;
    Button multiplyButton;
    Button divideButton;
    Button equallyButton;

    Button saveButton;

    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        result = view.findViewById(R.id.result_field);

        clearButton = view.findViewById(R.id.clear);
        sevenButton = view.findViewById(R.id.seven);
        eightButton = view.findViewById(R.id.eight);
        nineButton = view.findViewById(R.id.nine);
        fourButton = view.findViewById(R.id.four);
        fiveButton = view.findViewById(R.id.five);
        sixButton = view.findViewById(R.id.six);
        oneButton = view.findViewById(R.id.one);
        twoButton = view.findViewById(R.id.two);
        threeButton = view.findViewById(R.id.three);
        dotButton = view.findViewById(R.id.dot);

        plusButton = view.findViewById(R.id.plus);
        minusButton = view.findViewById(R.id.minus);
        multiplyButton = view.findViewById(R.id.multiply);
        divideButton = view.findViewById(R.id.divide);
        equallyButton = view.findViewById(R.id.equally);

        saveButton = view.findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(ResultHistoryFragment.GET_TEXT_KEY, result.getText().toString());
            }
        });

        //OnNumberClick
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("7");
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("8");
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("9");
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("4");
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("5");
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("6");
            }
        });

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("1");
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("2");
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("3");
            }
        });

        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    result.append(".");
                } catch (NumberFormatException NFE) {
                }
            }
        });

        //OnOperationClick
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "+");
                operation = "+";
            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "-");
                operation = "-";
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "*");
                operation = "*";
            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "/");
                operation = "/";
            }
        });
        equallyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation != null) {
                    String two = result.getText().toString().replace(firstValues + operation, "");
                    secondValues = Double.valueOf(two);
                    switch (operation) {
                        case "+":
                            plusOperation();
                            break;
                        case "-":
                            minusOperation();
                            break;
                        case "*":
                            multiplyOperation();
                            break;
                        case "/":
                            divideOperation();
                            if (firstValues > 0) {
                                try {
                                    divideOperation();
                                } catch (ArithmeticException AE) {
                                    result.setText("");
                                }
                            }
                            break;
                    }
                }
            }

        });
    }

    public void plusOperation() {
        result_operation = firstValues + secondValues;
        result.setText(result_operation.toString());
    }

    public void minusOperation() {
        result_operation = firstValues - secondValues;
        result.setText(result_operation.toString());
    }

    public void multiplyOperation() {
        result_operation = firstValues * secondValues;
        result.setText(result_operation.toString());
    }

    public void divideOperation() {
        result_operation = firstValues / secondValues;
        result.setText(result_operation.toString());
    }
}