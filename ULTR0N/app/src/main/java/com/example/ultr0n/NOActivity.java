package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NOActivity extends AppCompatActivity {

    public void bin_to_text(View view)
    {
        Intent intent = new Intent(this,BinaryActivity.class);
        startActivity(intent);
    }
    public void hex_to_text(View view)
    {
        Intent intent = new Intent(this,HexActivity.class);
        startActivity(intent);
    }
    public void oct_to_text(View view)
    {
        Intent intent = new Intent(this,OctalActivity.class);
        startActivity(intent);
    }
    public void dec_to_text(View view)
    {
        Intent intent = new Intent(this,DecimalActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_o);

    }
}