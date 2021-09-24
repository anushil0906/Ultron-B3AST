package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class PikaLangActivity extends AppCompatActivity {
    TextView pi_ka_text;
    EditText pi_ka_id;
    EditText pi_ka_flag;
    Button pi_ka_show;


    private static Scanner ob = new Scanner(System.in);
    public void PiKaLang_click(View view)
    {

        //Log.i("test2",flag);
        //bin_f_flag.setText(Binary_to_Brain(interpret()));
        String x = pi_ka_id.getText().toString();

        String s =PiKa_to_Brain(x);
        String flag = interpret(s);
        pi_ka_flag.setText(flag);


    }
    private static String PiKa_to_Brain(String s)
    {


        String brain="";
         String str[] = s.split(" ");
         for(int i=0;i<str.length;i++)
         {

             if(str[i].equals("pi")){brain+="+";}
             else if(str[i].equals("ka")){brain+="-";}
             else if(str[i].equals("pipi")){brain+=">";}
             else if(str[i].equals("pichu")){brain+="<";}
             else if(str[i].equals("pika")){brain+="[";}
             else if(str[i].equals("chu")){brain+="]";}
             else if(str[i].equals("pikachu")){brain+=".";}
             // else if(str[i].equals("pikapi")){brain+=",";}


         }
       // String decode = interpret(brain);

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
        setContentView(R.layout.activity_pika_lang);
        //String s =PiKa_to_Brain("pi pi pi pi pi pi pi pi pi pi pika pipi pi pipi pi pi pi pipi pi pi pi pi pi pi pi pipi pi pi pi pi pi pi pi pi pi pi pichu pichu pichu pichu ka chu pipi pipi pipi pipi pikachu ka pikachu pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pikachu ka ka ka ka ka ka ka ka ka ka ka ka ka ka pikachu pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pikachu ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka pikachu ka ka ka pikachu pi pi pi pi pi pi pi pi pi pi pi pi pi pikachu ka ka ka ka ka ka ka ka ka ka ka ka ka pikachu ka ka ka ka ka ka pikachu pi pi pi pi pi pi pi pi pi pi pikachu pi pi pi pi pi pi pi pi pi pi pikachu ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka pikachu pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pikachu ka ka ka ka ka ka ka ka ka ka pikachu pi pi pi pi pi pi pikachu ka ka ka pikachu ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka ka pikachu pi pi pi pi pi pi pi pikachu pi pi pi pi pi pi pikachu ka ka ka ka ka ka ka ka ka ka ka pikachu pi pi pi pi pi pi pikachu ka ka ka ka ka ka ka ka pikachu pi pi pi pi pi pi pikachu pi pi pi pi pi pi pi pi pi pikachu ka ka ka ka pikachu pi pi pi pi pi pikachu pi pi pi pi pi pi pi pi pi pi pikachu pichu pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pi pikachu pi pi pi pi pi pi pi pi pi pi pikachu pipi ka ka ka ka ka pikachu pichu ka ka ka ka ka ka ka ka ka ka pikachu pipi ka ka ka ka pikachu ka ka ka ka ka ka ka pikachu pi pi pikachu pichu pi pi pikachu ka ka pikachu pipi pi pi pi pi pi pikachu ka ka ka ka ka ka ka pikachu pi pi pikachu pichu pi pi pikachu ka ka pikachu pipi pi pi pi pi pi pikachu ka ka ka ka ka ka ka pikachu pi pi pikachu pichu pi pi pikachu pi pi pikachu pipi ka ka ka pikachu pi pi pi pi pi pi pi pi pi pi pi pi pi pikachu pichu ka ka ka ka pikachu pichu pi pi pi pi pi pikachu pipi pikachu pi pi pi pi pi pikachu ka pikachu pipi ka pikachu pichu pi pi pi pikachu ka ka ka ka ka ka ka pikachu pipi ka ka pikachu ka ka ka pikachu pichu pi pi pi pi pikachu pipi ka ka ka ka pikachu pi pi pi pi pi pi pi pi pikachu pi pi pi pi pi pi pi pi pi pi pikachu ");
         // Log.i("here_it",s);
       //    PiKaLang_click();
       // PiKa_to_Brain("scsc");

          pi_ka_id = findViewById(R.id.pi_ka_id);
          pi_ka_show = findViewById(R.id.bin_f_show);
          pi_ka_text = findViewById(R.id.pi_ka_text);
          pi_ka_flag = findViewById(R.id.pi_ka_flag);
    }
}