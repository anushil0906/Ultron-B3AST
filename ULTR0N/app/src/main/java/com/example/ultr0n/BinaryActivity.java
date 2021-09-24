package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BinaryActivity extends AppCompatActivity {

TextView bin_text;
EditText bin_id;
EditText bin_flag;
Button bin_show;
public void bin(View view)
{
    //bin_flag.setText(bin_2_text(bin_id.getText().toString()));
}
    public String bin_2_text(String s)
    {

        String str="";
        //String x = "";
        if(s.contains(" "))
        {
            s = s.replaceAll("\\s","");
        }
       // System.out.println(x);
        for(int i=0;i<(s.length());i+=8)
        {
            String c = "";

            for(int j=i;j<i+8;j++) {

                c+=s.charAt(j);
            }
            int charCode = Integer.parseInt(c, 2);
            // System.out.println(charCode);
            str += new Character((char)charCode).toString();
            //str+=c;
        }

        return str;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);
        //Log.i("here",bin_2_text("101010101010100101010101010"));
       // bin_flag = findViewById(R.id.bin_flag);
        bin_id = findViewById(R.id.bin_id);
        bin_show = findViewById(R.id.bin_show);
        bin_text = findViewById(R.id.bin_text);
    }


}