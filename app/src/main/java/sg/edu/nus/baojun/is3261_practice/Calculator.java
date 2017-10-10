package sg.edu.nus.baojun.is3261_practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    private TextView textResult;
    private String currentResult;
    private String currentOperator;
    private boolean isAppend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textResult = (TextView) findViewById(R.id.text_result);
        textResult.setText("0");
        isAppend = false;
    }

    public void onClick_AllClear(View view) {
        currentResult = "";
        currentOperator = "";
        textResult.setText("0");
        isAppend = false;
    }

    public void onClick_Clear(View view) {
        textResult.setText("0");
        isAppend = false;
    }

    public void onClick_Operator(View view) {
        String operator = ((Button) view).getText().toString();
        currentResult = textResult.getText().toString();

        switch (operator) {
            case "+": {
                currentOperator = "+";
                isAppend = false;
                break;
            }

            case "-": {
                currentOperator = "-";
                isAppend = false;
                break;
            }

            case "x": {
                currentOperator = "x";
                isAppend = false;
                break;
            }

            case "/": {
                currentOperator = "/";
                isAppend = false;
                break;
            }

            default: {
                break;
            }
        }
    }

    public void onClick_Equals(View view) {
        if(isAppend && !currentOperator.isEmpty()) {
            int number1 = Integer.parseInt(currentResult);
            int number2 = Integer.parseInt(textResult.getText().toString());

            Log.d("HELLO", "" + number1 + " " + number2);
            int result = 0;

            switch (currentOperator) {
                case "+": {
                    result = number1 + number2;
                    break;
                }

                case "-": {
                    result = number1 - number2;
                    break;
                }

                case "x": {
                    result = number1 * number2;
                    break;
                }

                case "/": {
                    result = number1 / number2;
                    break;
                }
            }

            textResult.setText(String.valueOf(result));
            currentOperator = "";
            currentResult = "";
            isAppend = false;
        }
    }

    public void onClick_Digits(View view) {
        String digit = ((Button) view).getText().toString();
        int number;

        if (isAppend) {
            number = Integer.valueOf(textResult.getText().toString());
            textResult.setText(number + digit);
        } else {
            number = Integer.valueOf(digit);
            textResult.setText(String.valueOf(number));
            isAppend = true;
        }
    }
}
