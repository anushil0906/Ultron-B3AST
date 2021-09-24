package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class XORActivity extends AppCompatActivity {
    TextView textxor;
    EditText xor_id;
    EditText keyxor;
    Button solvexor;
    EditText flagxor;
    public void solve_xor(View view)
    {
        if (TextUtils.isEmpty(xor_id.getText().toString()) || TextUtils.isEmpty(keyxor.getText().toString()))
        {
            Toast.makeText(XORActivity.this, "Empty field not allowed!", Toast.LENGTH_SHORT).show();
        }
        else {
            String output = "";
            int q = xor_id.getText().toString().length();
            int l = keyxor.getText().toString().length();
            for (int i = 0; i < q; i++) {
                char c = xor_id.getText().toString().charAt(i);
                char a = keyxor.getText().toString().charAt(i % (l));
                output += (char) (((int) (c)) ^ (int) (a));
            }
            flagxor.setText(output);
            flagxor.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_o_r);
        textxor = findViewById(R.id.textxor);
        xor_id = findViewById(R.id.xor_id);
        keyxor = findViewById(R.id.keyxor);
        solvexor = findViewById(R.id.solvexor);
        flagxor = findViewById(R.id.flagxor);
    }
}