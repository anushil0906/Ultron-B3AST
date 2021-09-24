package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

public class RSACRTActivity extends AppCompatActivity {

EditText editText12;
EditText editText13;
EditText editText14;
EditText editText15;
EditText editText16;
EditText flagy;
Button calculate3;
public void click_CRT(View view)
{
    if (TextUtils.isEmpty(editText12.getText().toString()) || TextUtils.isEmpty(editText13.getText().toString()) || TextUtils.isEmpty(editText14.getText().toString()) || TextUtils.isEmpty(editText15.getText().toString()) || TextUtils.isEmpty(editText16.getText().toString()))
    {
        Toast.makeText(RSACRTActivity.this, "Empty field not allowed!", Toast.LENGTH_SHORT).show();
    }
    else
    {
        Log.i("here",calc_CRT());
        flagy.setText(calc_CRT());

    }
}
public String calc_CRT()
{
    BigInteger p = new BigInteger(editText12.getText().toString());
    BigInteger q = new BigInteger(editText13.getText().toString());
    BigInteger dp = new BigInteger(editText14.getText().toString());
    BigInteger dq = new BigInteger(editText15.getText().toString());
    BigInteger c = new BigInteger(editText16.getText().toString());

    /*
    BigInteger p = new BigInteger("13933456593176243154100377873430882621391758852656558429724762973347360236943843561115853953109364536196109721883268507535475066907044098569465386296597743");
    BigInteger q = new BigInteger("15198474901634168188325068803080245719929911711407562675823034258010488604003982742159010817649976771484173949147756365239891343259425337749854069871273763");
    BigInteger dp = new BigInteger("10169576291048744120030378521334130877372575619400406464442859732399651284965479823750811638854185900836535026290910663113961810650660236370395359445734425");
    BigInteger dq = new BigInteger("10169576291048744120030378521334130877372575619400406464442859732399651284965479823750811638854185900836535026290910663113961810650660236370395359445734425");
    BigInteger c = new BigInteger("42601238135749247354464266278794915846396919141313024662374579479712190675096500801203662531952565488623964806890491567595603873371264777262418933107257283084704170577649264745811855833366655322107229755242767948773320530979935167331115009578064779877494691384747024161661024803331738931358534779829183671004");
    */
    BigInteger Qinv = multiinv(q,p);


    if(Qinv.equals(new BigInteger("-1")))
    {
        return "modular inverse does not exist";
    }
        BigInteger m1 = c.modPow(dp, p);
        BigInteger m2 = c.modPow(dq, q);

        BigInteger h = (Qinv.multiply(m1.subtract(m2))).mod(p);
        BigInteger m = m2.add(h.multiply(q));
        String str = m.toString();
        //Log.i("hereit",str);
        BigInteger tohex = new BigInteger(str, 10);
        String yoo = tohex.toString(16);
        String flag = new String(new BigInteger(yoo, 16).toByteArray(), 0);
        return flag;



}
public BigInteger multiinv(BigInteger a,BigInteger b)
{
   MultipleValues1 m = egcd(a,b);
    if(m.g.equals(new BigInteger("1"))) {
        return m.y.mod(b);
    }
    return new BigInteger("-1");
}
    static class MultipleValues1 {
        BigInteger g, x, y;
        MultipleValues1(BigInteger a, BigInteger b, BigInteger c) {
            g = a;
            y = b;
            x = c;
        }
    }

    public static MultipleValues1 egcd(BigInteger a, BigInteger b) {
        if (a.equals(new BigInteger("0"))) {
            return new MultipleValues1(b, new BigInteger("0"), new BigInteger("1"));
        } else {
           MultipleValues1 m = egcd(b.mod(a), a);
            return new MultipleValues1(m.g, m.x .subtract(b.divide(a)).multiply(m.y), m.y);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_s_a_c_r_t);
        Intent intent = getIntent();
        editText12  = findViewById(R.id.editText12);
        editText13  = findViewById(R.id.editText13);
        editText14  = findViewById(R.id.editText14);
        editText15  = findViewById(R.id.editText15);
        editText16  = findViewById(R.id.editText16);
        calculate3  = findViewById(R.id.calculate3);
        flagy  = findViewById(R.id.flagy);



    }
}