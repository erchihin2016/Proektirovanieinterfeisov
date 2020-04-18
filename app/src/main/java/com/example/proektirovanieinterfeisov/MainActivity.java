package com.example.proektirovanieinterfeisov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText upEdittext;
    private EditText lowEdittext;
    private EditText pulseEdittext;
    private CheckBox tachoCheckbox;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"save button clicked");
                String upStr = upEdittext.getText().toString();
                String lowStr = lowEdittext.getText().toString();
                String pulseStr = pulseEdittext.getText().toString();
                boolean haveTacho = tachoCheckbox.isChecked();

                try {
                    int up = Integer.parseInt(upStr);
                    int low = Integer.parseInt(lowStr);
                    int pulse = Integer.parseInt(pulseStr);

                    String result ="верхнее давление"+up+"нижнее давление"+low+"пульс"+pulse+"имеет тахикардию"+haveTacho;
                    Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                }catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, R.string.incorrectvalue, Toast.LENGTH_SHORT).show();

                }finally {
                    upEdittext.getText().clear();
                    lowEdittext.getText().clear();
                    pulseEdittext.getText().clear();
                }
            }
        });
    }

    private void init() {
        upEdittext = findViewById(R.id.upEdittext);
        lowEdittext = findViewById(R.id.lowEdittext);
        pulseEdittext = findViewById(R.id.pulseEdittext);
        tachoCheckbox = findViewById(R.id.tachoCheckbox);
        saveButton = findViewById(R.id.saveButton);
        Log.d(TAG,"All views initialized");

    }
}
