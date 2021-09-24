package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ROT47Activity extends AppCompatActivity {
    Button solverot47;
    EditText rot_id_47;
    EditText flagrot47;
    TextView rot47;
    public void show_rot47(View view)
    {
        flagrot47.setText(rot47(rot_id_47.getText().toString()));


    }
    public String rot47( String enc) {
        String decode = "";

        for(int i=0;i<enc.length();i++) {
            int encoded = (int)enc.charAt(i);
            if (encoded >= 33 && encoded <=126) {
                decode+=((char)(33 + ((encoded + 14) % 94)));
            }
            else {
                decode+=(enc.charAt(i));
            }
        }
        return decode;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_o_t47);
        //Log.i("here",rot47("5r@56 #@E\\cf"));
        solverot47 = findViewById(R.id.solverot47);
        rot_id_47 = findViewById(R.id.rot_id_47);
        flagrot47 = findViewById(R.id.flagrot47);
        rot47 = findViewById(R.id.rot47);
    }
}