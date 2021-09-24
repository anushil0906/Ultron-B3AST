package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RSAActivity extends AppCompatActivity {
    Button rsa1;
    Button rsa2;
    Button rsa3;
    Button rsa4;
    Button rsa5;
    Button rsa6;
    public void classic_attack(View view)
    {
        Intent intent = new Intent(this,RSAClassicActivity.class);
        startActivity(intent);
    }
    public void cube_root_attack(View view)
    {
        Intent intent = new Intent(this,RSACubeRootActivity.class);
        startActivity(intent);
    }
    public void common_modulo_attack(View view)
    {
        Intent intent = new Intent(this,RSACommonModuloActivity.class);
        startActivity(intent);
    }
    public void chinese_remainder_attack(View view)
    {
        Intent intent = new Intent(this,RSACRTActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_s_a);
        Intent intent = getIntent();
        rsa1 = findViewById(R.id.rsa1);
        rsa2 = findViewById(R.id.rsa2);
        rsa3 = findViewById(R.id.rsa3);
        rsa4 = findViewById(R.id.rsa4);
        rsa5 = findViewById(R.id.rsa5);
        rsa6 = findViewById(R.id.rsa6);
    }
}