package com.example.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText txtbox;
    private String txt;
    private RadioGroup rgBtn;
    private RadioButton rBtn;
    private String temp;
    private Float tempValue;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.convert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtbox = (EditText) findViewById(R.id.temperature);
                txt = txtbox.getText().toString();
                tempValue = Float.valueOf(txt);
                rgBtn = (RadioGroup) findViewById(R.id.radioGroup);
                int selectedId = rgBtn.getCheckedRadioButtonId();
                rBtn = (RadioButton) findViewById(selectedId);
                temp = rBtn.getText().toString();
//                System.out.println(rBtn.getText());
                if (temp.equals("Fahrenheit")) {
                    fahrenheit(tempValue);
                } else {
                    celcius(tempValue);
                }
            }
        });
    }

    public void celcius(float temp) {
        displayTemp((((temp - 32) * 5) / 9), "celcius");
    }

    public void fahrenheit(float temp) {
        displayTemp(((temp * (9 / 5)) + 32), "fahrenheit");
    }

    public void displayTemp(float tempValue, String temp) {
        txtView = (TextView) findViewById(R.id.display);
        txtView.setText("The value is " + tempValue + " " + temp);
    }
}