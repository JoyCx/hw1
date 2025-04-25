package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
    TextView t;
    EditText tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        t = findViewById(R.id.textView2);
        tb = findViewById(R.id.editTextNumber2);
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource
                        (this,
                                R.array.array,
                                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                double temp = Calc(getInput(), position);
                if(getInput() != -1){
                    ChangeTxt(temp);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                double temp = Calc(getInput(), 0);
                if(getInput() != -1){
                    ChangeTxt(temp);
                }
            }
        });
    }

    private double Calc(double num, int index){
        switch (index){
            case 0: // Centimeters to Meters
                return num / 100.0;
            case 1: // Meters to Kilometers
                return num / 1000.0;
            case 2: // Celsius to Fahrenheit
                return (num * (9.0 / 5.0)) + 32;
            case 3: // Grams to Kilograms
                return num / 1000.0;
            default:
                return num;
        }
    }



    private void ChangeTxt(double num){
        String s = "" + num;
        t.setText(s);
    }

    private double getInput(){
        try{
            return Double.parseDouble(tb.getText().toString());
        }
        catch (Exception e){
            return -1;
        }
    }
}