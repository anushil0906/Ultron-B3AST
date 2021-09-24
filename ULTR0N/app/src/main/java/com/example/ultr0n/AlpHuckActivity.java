package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class AlpHuckActivity extends AppCompatActivity {

TextView alp_text;
EditText alp_id;
EditText alp_flag;
Button alp_show;

    private static Scanner ob = new Scanner(System.in);
    public void AlpHuck_click(View view)
    {
        String s ="";
        s =interpret(alp_id.getText().toString());

        alp_flag.setText(s);




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

            if (s.charAt(i) == 'a') {
                if (ptr == length - 1)//If memory is full
                    ptr = 0;//pointer is returned to zero
                else
                    ptr++;
            }

            // < moves the pointer to the left
            else if (s.charAt(i) == 'c') {
                if (ptr == 0) // If the pointer reaches zero

                    // pointer is returned to rightmost memory
                    // position
                    ptr = length - 1;
                else
                    ptr--;
            }

            // + increments the value of the memory
            // cell under the pointer
            else if (s.charAt(i) == 'e')
                memory[ptr]++;

                // - decrements the value of the memory cell
                // under the pointer
            else if (s.charAt(i) == 'i')
                memory[ptr]--;

                // . outputs the character signified by the
                // cell at the pointer
            else if (s.charAt(i) == 'j')
                x += Character.toString((char) (memory[ptr]));

                // , inputs a character and store it in the
                // cell at the pointer
                //else if (s.charAt(i) == 'o')
                // memory[ptr] = (byte) (ob.next().charAt(0));

                // [ jumps past the matching ] if the cell
                // under the pointer is 0
            else if (s.charAt(i) == 'p') {
                if (memory[ptr] == 0) {
                    i++;
                    if(i == 1)
                    {
                        return "not the right string";
                    }
                    while (c > 0 || s.charAt(i) != 's') {
                        if (s.charAt(i) == 'p')
                            c++;
                        else if (s.charAt(i) == 's')
                            c--;
                        i++;
                    }
                }

            }

            // ] jumps back to the matching [ if the
            // cell under the pointer is nonzero
            else if (s.charAt(i) == 's') {

                if (memory[ptr] != 0) {
                    i--;

                    try {
                        //  Log.i("here",Integer.toString(i));
                        while (c > 0 || s.charAt(i) != 'p') {


                            if (s.charAt(i) == 's')
                                c++;
                            else if (s.charAt(i) == 'p')
                                c--;
                            i--;
                        }
                        i--;
                    }catch(StringIndexOutOfBoundsException e)
                    {
                        return "not the right string";
                    }

                }
            }
        }
        return x;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alp_huck);
        alp_flag = findViewById(R.id.alp_flag);
        alp_id = findViewById(R.id.alp_id);
        alp_show = findViewById(R.id.alp_show);
        alp_text = findViewById(R.id.alp_text);

    }
}