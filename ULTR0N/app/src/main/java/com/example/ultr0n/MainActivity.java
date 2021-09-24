package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView header;
    Button GO;
    ImageButton RSA;
    ImageButton BASES;
    ImageButton ROT;
    ImageButton XOR;
    ImageButton NUMBER_SYSTEM;
    ImageButton SUBSTITUTION;
    public void go(View view)
    {
        GO.setVisibility(View.INVISIBLE);
        header.setVisibility(View.VISIBLE);
        RSA.setVisibility(View.VISIBLE);
        BASES.setVisibility(View.VISIBLE);
        ROT.setVisibility(View.VISIBLE);
        XOR.setVisibility(View.VISIBLE);
        NUMBER_SYSTEM.setVisibility(View.VISIBLE);
        SUBSTITUTION.setVisibility(View.VISIBLE);
    }
    public void type_of_rsa(View view)
    {
        Intent intent = new Intent(this,RSAActivity.class);
        startActivity(intent);
    }
    public void type_of_bases(View view)
    {
        Intent intent = new Intent(this,BASEActivity.class);
        startActivity(intent);
    }
    public void type_of_rot(View view)
    {
        Intent intent = new Intent(this,ROTActivity.class);
        startActivity(intent);
    }
    public void type_of_xor(View view)
    {
        Intent intent = new Intent(this,XORActivity.class);
        startActivity(intent);
    }
    public void type_of_fuck(View view)
    {
        Intent intent = new Intent(this, FUCKActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header = findViewById(R.id.textView);
        //GO = findViewById(R.id.GO);
        RSA = findViewById(R.id.RSA);
        BASES = findViewById(R.id.BASES);
        ROT = findViewById(R.id.ROT);
        XOR = findViewById(R.id.XOR);
        NUMBER_SYSTEM = findViewById(R.id.NUMBER_SYSTEM);
        SUBSTITUTION = findViewById(R.id.SUBSTITUTION);
    }
}