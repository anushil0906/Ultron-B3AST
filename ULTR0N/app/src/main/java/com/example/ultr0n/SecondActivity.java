package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.view.View.VISIBLE;

public class SecondActivity extends AppCompatActivity {
 TextView textChanger;

    TextView texty;
    Button bases_button;
    Button rot_button;
    Button fuck_button;
    Button xor_button;
    Button dna_button;
    Button vigenere_button;
    Button morse_button;
    Button bacon_button;
    Button no_button;
    Button rsa_button;
    Button memes;


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
    public void type_of_number(View view)
    {
        Intent intent = new Intent(this,NOActivity.class);
        startActivity(intent);
    }
    public void type_of_morse(View view)
    {
        Intent intent = new Intent(this,MORSEActivity.class);
        startActivity(intent);
    }
    public void meme(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        texty = findViewById(R.id.texty);
        texty.setText(" L0ADING....................");
        rsa_button = findViewById(R.id.rsa_button);
        no_button = findViewById(R.id.no_button);
        fuck_button = findViewById(R.id.fuck_button);
        dna_button = findViewById(R.id.dna_button);
        morse_button = findViewById(R.id.morse_button);
        bacon_button = findViewById(R.id.bacon_button);
        vigenere_button = findViewById(R.id.vigenere_button);
        xor_button = findViewById(R.id.xor_button);
        rot_button = findViewById(R.id.rot_button);
        bases_button = findViewById(R.id.bases_button);
        memes = findViewById(R.id.memes);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                texty.setText("L0ADING..................");
               //textChanger.setText("..........**********RSA************..........");
                rsa_button.setVisibility(VISIBLE);
            }
        }, 500);
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                texty.setText("L0ADING................");
                bases_button.setVisibility(VISIBLE);
            }
        }, 1000);

    Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
        @Override
        public void run() {
            texty.setText("L0ADING..............");
            rot_button.setVisibility(VISIBLE);
        }
    }, 1500);

        Handler handler3 = new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                texty.setText("L0ADING............");
                fuck_button.setVisibility(VISIBLE);
            }
        }, 2000);
        Handler handler4 = new Handler();
        handler4.postDelayed(new Runnable() {
            @Override
            public void run() {
                texty.setText("L0ADING..........");
                xor_button.setVisibility(VISIBLE);
            }
        }, 2500);
        Handler handler5 = new Handler();
        handler5.postDelayed(new Runnable() {
            @Override
            public void run() {
                texty.setText("L0ADING........");
                no_button.setVisibility(VISIBLE);
            }
        }, 3000);
        Handler handler6 = new Handler();
        handler6.postDelayed(new Runnable() {
            @Override
            public void run() {
                texty.setText("L0ADING......");
                dna_button.setVisibility(VISIBLE);
            }
        }, 3500);
        Handler handler7 = new Handler();
        handler7.postDelayed(new Runnable() {
            @Override
            public void run() {
                texty.setText("L0ADING....");
                morse_button.setVisibility(VISIBLE);
            }
        }, 4000);
        Handler handler8 = new Handler();
        handler8.postDelayed(new Runnable() {
            @Override
            public void run() {
                texty.setText("L0ADING..");
                vigenere_button.setVisibility(VISIBLE);
            }
        }, 4500);
        Handler handler9 = new Handler();
        handler9.postDelayed(new Runnable() {
            @Override
            public void run() {
                texty.setText("Game_0n");
                bacon_button.setVisibility(VISIBLE);
            }
        }, 5000);
        Handler handler10 = new Handler();
        handler10.postDelayed(new Runnable() {
            @Override
            public void run() {
               // texty.setText("Game_0n");
                memes.setVisibility(VISIBLE);
            }
        }, 5500);


}

}



