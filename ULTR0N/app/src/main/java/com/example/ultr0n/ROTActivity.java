package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ROTActivity extends AppCompatActivity {
    public void R0t(View view)
    {
        Intent intent = new Intent(this,ROTALLActivity.class);
        startActivity(intent);
    }
    public void R0t47(View view)
    {
        Intent intent = new Intent(this,ROT47Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_o_t);
    }
}