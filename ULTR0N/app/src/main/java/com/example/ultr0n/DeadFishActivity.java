package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class DeadFishActivity extends AppCompatActivity {
    TextView dead_text;
    EditText dead_id;
    EditText dead_flag;
    Button dead_show;
    private static Scanner ob = new Scanner(System.in);
    public void DeadFish_click(View view)
    {
        String s ="";
        s =interpret(dead_id.getText().toString());

        dead_flag.setText(s);




    }

    private static String interpret(String s) {

        int ptr = 0; // Data pinter

        // Max memory limit. It is the highest number which
        // can be represented by an unsigned 16-bit binary
        // number. Many computer programming environments
        // beside brainfuck may have predefined
        // constant values representing 65535.
        int length = 65535;

        // Array of byte type simulating memory of max
        // 65535 bits from 0 to 65534.
        byte memory[] = new byte[length];
        int c = 0;
        String x="";

        // Parsing through each character of the code
        for (int i = 0; i < s.length(); i++) {
            // BrainFuck is a tiny language with only
            // eight instructions. In this loop we check
            // and execute all those eight instructions


            // > moves the pointer to the right



            // + increments the value of the memory
            // cell under the pointer
             if (s.charAt(i) == 'i')
                memory[ptr]++;

                // - decrements the value of the memory cell
                // under the pointer
            else if (s.charAt(i) == 'd')
                memory[ptr]--;

                // . outputs the character signified by the
                // cell at the pointer
            else if (s.charAt(i) == 'o')
                x += Character.toString((char) (memory[ptr]));


            else if (s.charAt(i) == 's')
                memory[ptr] = (byte)(memory[ptr]*memory[ptr]);

                // [ jumps past the matching ] if the cell
                // under the pointer is 0


        }
        return x;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead_fish);
        dead_show = findViewById(R.id.dead_show);
        dead_flag = findViewById(R.id.dead_flag);
        dead_id = findViewById(R.id.dead_id);
        dead_text = findViewById(R.id.dead_text);

    }
}