package com.route.basicsc40;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class CalculatorActivity extends AppCompatActivity {
    TextView resultTv;
    String lhs = "";
    String savedOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultTv = findViewById(R.id.resultTv);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        if (resultTv.getText().toString().contains(".") && button.getText().toString().equals(".")) {
            return;
        }
        resultTv.append(button.getText());
    }

    public void onOperatorClick(View view) {
        Button clickedOperator = (Button) view;
        if (savedOperator.isEmpty()) {
            lhs = resultTv.getText().toString();
        } else {
            if (resultTv.getText().toString().isEmpty()) return;
            lhs = calculate(lhs, savedOperator, resultTv.getText().toString());
        }
        savedOperator = clickedOperator.getText().toString();
        resultTv.setText("");
        Log.e("onOperatorClick", "lhs = " + lhs + ", savedOperator = " + savedOperator);
    }

    public String calculate(String lhs, String operator, String rhs) {
        double n1 = Double.parseDouble(lhs);
        double n2 = Double.parseDouble(rhs);
        if (Objects.equals(operator, "+")) {
            return (n1 + n2) + "";
        } else if (Objects.equals(operator, "-")) {
            return (n1 - n2) + "";
        } else if (Objects.equals(operator, "*")) {
            return (n1 * n2) + "";
        } else {
            return (n1 / n2) + "";
        }
    }

    public void onEqualClick(View view) {
        resultTv.setText(
                calculate(lhs, savedOperator, resultTv.getText().toString())
        );
        lhs = "";
        savedOperator = "";
    }
}