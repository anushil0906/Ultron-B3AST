package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class ReverseFuckActivity extends AppCompatActivity {
    TextView rf_text;
    EditText rf_id;
    EditText rf_flag;
    Button rf_show;

    private static Scanner ob = new Scanner(System.in);
    public void ReverseFuck_click(View view)
    {
        String s ="";
        s =interpret(rf_id.getText().toString());

        rf_flag.setText(s);




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
            if (s.charAt(i) == '<') {
                if (ptr == length - 1)//If memory is full
                    ptr = 0;//pointer is returned to zero
                else
                    ptr++;
            }

            // < moves the pointer to the left
            else if (s.charAt(i) == '>') {
                if (ptr == 0) // If the pointer reaches zero

                    // pointer is returned to rightmost memory
                    // position
                    ptr = length - 1;
                else
                    ptr--;
            }

            // + increments the value of the memory
            // cell under the pointer
            else if (s.charAt(i) == '-')
                memory[ptr]++;

                // - decrements the value of the memory cell
                // under the pointer
            else if (s.charAt(i) == '+')
                memory[ptr]--;

                // . outputs the character signified by the
                // cell at the pointer
            else if (s.charAt(i) == ',')
                x += Character.toString((char) (memory[ptr]));

                // , inputs a character and store it in the
                // cell at the pointer
                //else if (s.charAt(i) == '.')
                // memory[ptr] = (byte) (ob.next().charAt(0));

                // [ jumps past the matching ] if the cell
                // under the pointer is 0
            else if (s.charAt(i) == ']') {
                if (memory[ptr] == 0) {
                    i++;
                    if(i == 1)
                    {
                        return "not the right string";
                    }
                    while (c > 0 || s.charAt(i) != '[') {
                        if (s.charAt(i) == ']')
                            c++;
                        else if (s.charAt(i) == '[')
                            c--;
                        i++;
                    }
                }

            }

            // ] jumps back to the matching [ if the
            // cell under the pointer is nonzero
            else if (s.charAt(i) == '[') {
                if (memory[ptr] != 0) {
                    i--;
                    try {
                        while (c > 0 || s.charAt(i) != ']') {
                            if (s.charAt(i) == '[')
                                c++;
                            else if (s.charAt(i) == ']')
                                c--;
                            i--;
                        }

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
        setContentView(R.layout.activity_reverse_fuck);
      //  Log.i("here",interpret("----------]<-<---<-------<---------->>>>+[<<<<,>+++,<-----------,+++++++++++,-,>>--,<---------------,<,-----------------,+++++++++++++++++,-------------,-,++++++++++++++,>++++++++++++,<----------------,++++++++++++++++++,--------,"));
        rf_flag = findViewById(R.id.rf_flag);
        rf_id = findViewById(R.id.rf_id);
        rf_show = findViewById(R.id.rf_show);
        rf_text = findViewById(R.id.rf_text);

    }
}