package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BASEActivity extends AppCompatActivity {

public void Base_64(View view)
{
    Intent intent = new Intent(this, Base64Activity.class);
    startActivity(intent);
}
    public void Base_32(View view)
    {
        Intent intent = new Intent(this, Base32Activity.class);
        startActivity(intent);
    }
 public void Base_58(View view)
 {
     Intent intent = new Intent(this, Base58Activity.class);
     startActivity(intent);
 }
 public void Base_62(View view)
 {
     Intent intent = new Intent(this, Base62Activity.class);
     startActivity(intent);

 }
    public void Base_85(View view)
    {
        Intent intent = new Intent(this, Base85Activity.class);
        startActivity(intent);

    }
    public void Base_91(View view)
    {
        Intent intent = new Intent(this, Base91Activity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_a_s_e);
        Intent intent = getIntent();
    }
}