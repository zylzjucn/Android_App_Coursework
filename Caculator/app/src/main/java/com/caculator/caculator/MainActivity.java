package com.caculator.caculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnAdd, btnSub, btnMul, btnDev;
    private TextView result;
    private EditText firstnumber, secondnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDev = (Button)findViewById(R.id.btnDev);
        firstnumber = (EditText)findViewById(R.id.first);
        secondnumber = (EditText)findViewById(R.id.second);
        result = (TextView)findViewById(R.id.result);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDev.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String num1 = firstnumber.getText().toString();
        String num2 = secondnumber.getText().toString();
        switch (view.getId()) {
            case R.id.btnAdd:
                int addition = Integer.parseInt(num1) + Integer.parseInt(num2);
                result.setText(String.valueOf(addition));
                break;
            case R.id.btnSub:
                int substraction = Integer.parseInt(num1) - Integer.parseInt(num2);
                result.setText(String.valueOf(substraction));
                break;
            case R.id.btnMul:
                int multiply = Integer.parseInt(num1) * Integer.parseInt(num2);
                result.setText(String.valueOf(multiply));
                break;
            case R.id.btnDev:
                try {
                    int devision = Integer.parseInt(num1) / Integer.parseInt(num2);
                    result.setText(String.valueOf(devision));
                }catch(Exception e) {
                    result.setText("Can not Devide!");
                }
                break;
        }
    }
}
