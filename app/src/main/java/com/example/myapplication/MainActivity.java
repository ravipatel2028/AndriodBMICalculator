package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText heightEditText, weightEditText;
    private AppCompatButton calcButton;
    private TextView resultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
                clear();
            }
        });
    }

    public void calc(){
        if(!(heightEditText.getText().equals("") && weightEditText.getText().equals(""))){
            int height=Integer.parseInt(heightEditText.getText().toString());
            int weight=Integer.parseInt(weightEditText.getText().toString());
            float valH=height/100.0f;
            float valW=weight;
            float bmi=valW/(valH*valH);
            resultsTextView.setText("Your BMI is : " +bmi);

            Toast.makeText(this, "Your BMI is : " +bmi, Toast.LENGTH_SHORT).show();
        }

    }
    public void clear(){
        heightEditText.setText("");
        weightEditText.setText("");
        resultsTextView.setText("RESULT PENDING ..");
    }

    public void init(){
        heightEditText=findViewById(R.id.height_editview);
        weightEditText=findViewById(R.id.weight_editview);
        calcButton=findViewById(R.id.calculate_btn);
        resultsTextView=findViewById(R.id.results_textview);
    }
}