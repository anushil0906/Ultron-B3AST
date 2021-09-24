package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class HexActivity extends AppCompatActivity {
    public String hex_2_text(String s)
    {
        s = s.toUpperCase();
        if(s.contains("0X"))
        {
            s=s.replaceAll("0X","");
        }
        if(s.contains("0x"))
        {
            s=s.replaceAll("0x","");
        }
        if(s.contains(" "))
        {
            s = s.replaceAll("\\s","");
        }
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Check if the character
            // is invalid

            if ((ch < '0' || ch > '9')
                    && (ch < 'A' || ch > 'F')) {

                //System.out.println("No");
                return "not a hex";
            }
        }

        StringBuilder output = new StringBuilder(" ");

        for (int i = 0; i < s.length(); i += 2) {

            String str = s.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }

//        System.out.println( output.toString());


        return output.toString();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex);
        Log.i("here",hex_2_text(",4pf,4pf4fp4kfp34kf34pofk34fpk34fp3kfp34kf34pfkpfk"));
    }
}