package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

public class RSACubeRootActivity extends AppCompatActivity {
    EditText editText4;
    EditText editText5;
    EditText editText6;
    Button calculate1;
    EditText flagy;
    public void click_cube_root(View view)
    {

        if (TextUtils.isEmpty(editText4.getText().toString()) || TextUtils.isEmpty(editText5.getText().toString()) || TextUtils.isEmpty(editText6.getText().toString()))
        {
            Toast.makeText(RSACubeRootActivity.this, "Empty field not allowed!", Toast.LENGTH_SHORT).show();
        }
        else {
            BigInteger check = new BigInteger(editText5.getText().toString());

            if (!check.equals(new BigInteger("3"))) {

                Toast.makeText(RSACubeRootActivity.this, "Value of e should be 3 in Cube Root RSA", Toast.LENGTH_SHORT).show();

            } else {
                BigInteger cc = new BigInteger(calc(editText6.getText().toString()));
                BigInteger nc = new BigInteger(calc(editText4.getText().toString()));
                int compare = nc.compareTo(cc);
                if (compare == 1) {
                    String str = cc.toString();
                    Log.i("here", str);
                    BigInteger tohex = new BigInteger(str, 10);
                    String yoo = tohex.toString(16);
                    String flag = new String(new BigInteger(yoo, 16).toByteArray(), 0);
                    Log.i("flag", flag);
                    flagy.setText(flag);
                } else {
                    Toast.makeText(RSACubeRootActivity.this, "Cube Root Of C is Not Less Than Cube Root Of N", Toast.LENGTH_SHORT).show();


                }


            }
        }

    }


    public String calc(String s)
    {
        String result="";
        try {
              BigInteger e = new BigInteger(editText5.getText().toString());
                BigInteger three = new BigInteger("3");
                if(e.equals(three))
                {
                    BigInteger c = new BigInteger("0");
                    BigInteger c1 = new BigInteger("2");
                    while(!c.equals(c1))
                    {
                        BigInteger x = new BigInteger(s);
                        c =c1;
                        BigInteger c3 = c.pow(3);
                        BigInteger d = (c3.multiply(new BigInteger("2"))).add(x);
                        c1 = ((c.multiply(c3.add(x.multiply(new BigInteger("2")))).add(d.divide(new BigInteger("2")))).divide(d));
                    }
                    result = c.toString();
                }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_s_a_cube_root);
        Intent intent = getIntent();
        editText4  = findViewById(R.id.editText4);
        editText5  = findViewById(R.id.editText5);
        editText6  = findViewById(R.id.editText6);
        calculate1 = findViewById(R.id.calculate1);
        flagy = findViewById(R.id.flagy);




    }
}