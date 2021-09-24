package com.example.ultr0n;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Base64;

public class Base64Activity extends AppCompatActivity {
   // public static final String msg = "com.example.kalki.base64";
 Button show64;
 TextView text64;
 EditText base_id_64;
 TextView flag64;


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void show64(View view)
    {

        String encoded = base_id_64.getText().toString();
        // decode into String from encoded format

         byte[] actualByte = Base64.getDecoder().decode(encoded);
         String actualString = new String(actualByte);
         flag64.setText(actualString);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base64);
        Intent intent = getIntent();
        flag64 = findViewById(R.id.flag64);
        base_id_64 = findViewById(R.id.base_id_64);
        text64 = findViewById(R.id.text64);
        show64 = findViewById(R.id.show64);

    }
}