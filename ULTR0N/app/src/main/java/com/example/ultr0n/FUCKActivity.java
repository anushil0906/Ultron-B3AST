package com.example.ultr0n;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FUCKActivity extends AppCompatActivity {

    public void BrainFuck(View view)
    {
        Intent intent = new Intent(this, BrainFuckActivity.class);
        startActivity(intent);
    }
    public void ReverseFuck(View view)
    {
        Intent intent = new Intent(this, ReverseFuckActivity.class);
        startActivity(intent);
    }
    public void BinaryFuck(View view)
    {
        Intent intent = new Intent(this, BinaryFuckActivity.class);
        startActivity(intent);
    }
    public void PiKaLang(View view)
    {
        Intent intent = new Intent(this, PikaLangActivity.class);
        startActivity(intent);
    }
    public void OOk(View view)
    {
        Intent intent = new Intent(this, OOkActivity.class);
        startActivity(intent);
    }
    public void AlpHuck(View view)
    {
        Intent intent = new Intent(this, AlpHuckActivity.class);
        startActivity(intent);
    }
    public void DeadFish(View view)
    {
        Intent intent = new Intent(this, DeadFishActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_u_c_k);
    }
}