package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ROTALLActivity extends AppCompatActivity {
    TextView textrot;
    EditText rot_id_classic;
    Button  showrot;
    EditText flagrot;

    public void show_rot(View view) {
        String s = "";
     for(int i=1;i<=26;i++)
     {
          s += rot(rot_id_classic.getText().toString(),i)+"\n";
         Log.i("h",s);

     }
        flagrot.setText(s);

    }

    private String rot(String enc, int key)
    {
     String dec="";
     for(int i=0;i<enc.length();i++) {
         if (Character.isLowerCase(enc.charAt(i))) {
             dec = dec + (char) (((int) (enc.charAt(i)) + key - 97) % 26 + 97);
         }
         else if(Character.isUpperCase(enc.charAt(i))) {
                 dec = dec + (char) (((int) (enc.charAt(i)) + key - 65) % 26 + 65);
             }
            else
                 {
                     dec += enc.charAt(i);
                 }
     }  return dec;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_o_t_a_l_l);
        textrot = findViewById(R.id.textrot);
        rot_id_classic = findViewById(R.id.rot_id_classic);
        showrot = findViewById(R.id.showrot);
        flagrot = findViewById(R.id.flagrot);

    }
}