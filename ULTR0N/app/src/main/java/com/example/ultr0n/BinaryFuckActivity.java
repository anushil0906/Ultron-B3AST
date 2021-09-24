package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class BinaryFuckActivity extends AppCompatActivity {
    TextView bin_f_text;
    EditText bin_f_id;
    EditText bin_f_flag;
    Button  bin_f_show;

    private static Scanner ob = new Scanner(System.in);
    public void BinaryFuck_click(View view)
    {

        //Log.i("test2",flag);
        //bin_f_flag.setText(Binary_to_Brain(interpret()));

        String s = Binary_to_Brain(bin_f_id.getText().toString());
        if(!s.equals("not a binaryfuck")) {
            String flag = interpret(s);
            bin_f_flag.setText(flag);
        }
        else
        {
            bin_f_flag.setText("not a binaryfuck");
        }




    }
    private static String Binary_to_Brain(String s)
    {
        String brain="";
        if(s.length()%3==0) {
            for (int i = 0; i < s.length(); i += 3) {
                String x = "";
                for (int j = i; j < i + 3; j++) {

                    x += Character.toString(s.charAt(j));
                }
                if (x.equals("000")) {
                    brain += "+";
                } else if (x.equals("001")) {
                    brain += "-";
                } else if (x.equals("010")) {
                    brain += ">";
                } else if (x.equals("011")) {
                    brain += "<";
                } else if (x.equals("110")) {
                    brain += "[";
                } else if (x.equals("111")) {
                    brain += "]";
                } else if (x.equals("100")) {
                    brain += ".";
                }
                //if(x.equals("101")){brain+=",";}

            }
        }
        else
        {
            brain = "not a binaryfuck";
        }
      //  String decoded = interpret(brain);
        return brain;
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

            if (s.charAt(i) == '>') {
                if (ptr == length - 1)//If memory is full
                    ptr = 0;//pointer is returned to zero
                else
                    ptr++;
            }

            // < moves the pointer to the left
            else if (s.charAt(i) == '<') {
                if (ptr == 0) // If the pointer reaches zero

                    // pointer is returned to rightmost memory
                    // position
                    ptr = length - 1;
                else
                    ptr--;
            }

            // + increments the value of the memory
            // cell under the pointer
            else if (s.charAt(i) == '+')
                memory[ptr]++;

                // - decrements the value of the memory cell
                // under the pointer
            else if (s.charAt(i) == '-')
                memory[ptr]--;

                // . outputs the character signified by the
                // cell at the pointer
            else if (s.charAt(i) == '.')
                x += Character.toString((char) (memory[ptr]));

                // , inputs a character and store it in the
                // cell at the pointer
                //else if (s.charAt(i) == ',')
                // memory[ptr] = (byte) (ob.next().charAt(0));

                // [ jumps past the matching ] if the cell
                // under the pointer is 0
            else if (s.charAt(i) == '[') {
                if (memory[ptr] == 0) {
                    i++;
                    if(i == 1)
                    {
                        return "not the right string";
                    }
                    while (c > 0 || s.charAt(i) != ']') {
                        if (s.charAt(i) == '[')
                            c++;
                        else if (s.charAt(i) == ']')
                            c--;
                        i++;
                    }
                }

            }

            // ] jumps back to the matching [ if the
            // cell under the pointer is nonzero
            else if (s.charAt(i) == ']') {

                if (memory[ptr] != 0) {
                    i--;

                    try {
                        //  Log.i("here",Integer.toString(i));
                        while (c > 0 || s.charAt(i) != '[') {


                            if (s.charAt(i) == ']')
                                c++;
                            else if (s.charAt(i) == '[')
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
        setContentView(R.layout.activity_binary_fuck);
        //Log.i("here",Binary_to_Brain("000000000000000000000000000000110010000010000000000010000000000000000000000010000000000000000000000000000000011011011011001111010010010010000000000000100001001001100000000000000000000000000000000000000000100001001001001001001001001001001001001001100011011000000100010010000000000000100000000000000000000000000000000100011011100010010000000000000000000100001001001001001001001001001001100000000000000000000100001001001100011011100010010001001001001001001001001001001001001100000000000000000000100001001001001001001001001001001001100000000000000000000100011011100010010000000000000000000000000000000000000000100001001001001001001001001001001001001001001001001001001001100000000000000000000000000000000100001001001001001001100011011100010010000000000000100000000000000000000000000000000000100"));
        bin_f_flag = findViewById(R.id.bin_f_flag);
        bin_f_id = findViewById(R.id.bin_f_id);
        bin_f_show = findViewById(R.id.bin_f_show);
        bin_f_text = findViewById(R.id.bin_f_text);

    }
}