package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.codec.binary.Base32;

public class Base32Activity extends AppCompatActivity {
    Button show32;
    TextView text32;
    EditText base_id_32;
    TextView flag32;


    public void show32(View view)
{
    Base32 base32 = new Base32();
    String s = new String(base32.decode(base_id_32.getText().toString()));
     flag32.setText(s);

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base32);
        show32 = findViewById(R.id.show32);
        flag32 = findViewById(R.id.flag32);
        text32 = findViewById(R.id.text32);
        base_id_32 = findViewById(R.id.base_id_32);
    }
}