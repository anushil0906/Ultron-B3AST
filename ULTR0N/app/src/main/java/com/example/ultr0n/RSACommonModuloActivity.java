package com.example.ultr0n;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class RSACommonModuloActivity extends AppCompatActivity {
    EditText editText7;
    EditText editText8;
    EditText editText9;
    EditText editText10;
    EditText editText11;
    EditText flagy;
  //  static BigInteger x = new BigInteger("1");
   // static  BigInteger y = new BigInteger("1");

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void click_modulo(View view)
    {
        if (TextUtils.isEmpty(editText7.getText().toString()) || TextUtils.isEmpty(editText8.getText().toString()) || TextUtils.isEmpty(editText9.getText().toString()) || TextUtils.isEmpty(editText10.getText().toString()) || TextUtils.isEmpty(editText11.getText().toString()))
        {
            Toast.makeText(RSACommonModuloActivity.this, "Empty field not allowed!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String str = calc();
            Log.i("here",str);
            byte[] b1 = new BigInteger(str).toByteArray();
            String s = new String(b1, StandardCharsets.US_ASCII);
         //   BigInteger tohex = new BigInteger(str,10);
           // String yoo = tohex.toString(16);
            //String flag = new String(new BigInteger(yoo,16).toByteArray(),0);
            Log.i("here",s);
            flagy.setText(s);


        }

    }
    public BigInteger iroot(long k, BigInteger n)
    {
        long k1 = k -1;
        BigInteger s = n.add(new BigInteger("1"));
        BigInteger u = n;
        int comparevalue = u.compareTo(s);
        while (comparevalue==-1)
        {
            s=u;
            u = (u.multiply(new BigInteger(Integer.toString((int)k1))).add(n.divide(u.pow((int)k1)))).divide(new BigInteger(Integer.toString((int)k)));
            comparevalue = u.compareTo(s);
        }
        return s;

    }

    public String calc()
    {
        BigInteger n = new BigInteger(editText7.getText().toString());
      //  BigInteger e1 = new BigInteger(editText8.getText().toString());
      //  BigInteger e2 = new BigInteger(editText9.getText().toString());
        BigInteger c1 = new BigInteger(editText10.getText().toString());
        BigInteger c2 = new BigInteger(editText11.getText().toString());
        long e1 = Long.parseLong(editText8.getText().toString());
        long e2 = Long.parseLong(editText9.getText().toString());


         MultipleValues m1 = egcd(e1,e2);
         Log.i("g", Long.toString(m1.g));
         BigInteger x = new BigInteger(Long.toString(m1.y));
         Log.i("check",x.toString());

        BigInteger y = new BigInteger(Long.toString(m1.x));
        Log.i("check",y.toString());
        int compare1 = x.compareTo(new BigInteger("0"));
        int compare2 = y.compareTo(new BigInteger("0"));
        if (compare1 == -1) {
            c1 = neg_pow_x(c1, n,x);
        }
        else
        {
            c1 = c1.modPow(x,n);
        }
        if (compare2 == -1) {
            c2 = neg_pow_y(c2, n,y);
        }
        else
        {
            c2 = c2.modPow(y,n);
        }
        BigInteger ct = (c1.multiply(c2)).mod(n);
        BigInteger nroot = iroot(m1.g,ct);
        return nroot.toString();

        }

    static class MultipleValues {
        long g, x, y;
        MultipleValues(long a, long b, long c) {
            g = a;
            y = b;
            x = c;
        }
    }

    public static MultipleValues egcd(long a, long b) {
        if (a == 0) {
            return new MultipleValues(b, 0, 1);
        } else {
            MultipleValues m = egcd(b % a, a);
            return new MultipleValues(m.g, m.x - (b /a) * m.y, m.y);
        }
    }

    /*
    public BigInteger egcd(BigInteger a , BigInteger b)
    {
        if (a.equals("0"))
        {
            x = new BigInteger("0");
            y = new BigInteger("1");

        }
        BigInteger g;
        BigInteger x1 = new BigInteger("1");
        BigInteger y1 = new BigInteger("1");
        // To store results of recursive call
        g = egcd(b.mod(a), a);

        // Update x and y using results of recursive
        // call
        x = y1.subtract(b.divide(a)) .multiply(x1);
        y = x1;
        return g;



    }
    */
    public BigInteger neg_pow_x(BigInteger c,BigInteger n,BigInteger x) {

           assert c.gcd(n).equals(new BigInteger("1"));
           BigInteger res = c.modInverse(n);
           res = res.modPow(x.multiply(new BigInteger("-1")),n);
           return res;

    }
    public BigInteger neg_pow_y(BigInteger c,BigInteger n,BigInteger y) {

        assert c.gcd(n).equals(new BigInteger("1"));
        BigInteger res = c.modInverse(n);
        res = res.modPow(y.multiply(new BigInteger("-1")),n);
        return res;

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_s_a_common_modulo);
        Intent intent = getIntent();

        editText7 = findViewById(R.id.editText7);
        editText8 = findViewById(R.id.editText8);
        editText9 = findViewById(R.id.editText9);
        editText10 = findViewById(R.id.editText10);
        editText11 = findViewById(R.id.editText11);
        flagy  = findViewById(R.id.flagy);


/*

        String str = "null";
        str = calc();
        Log.i("here",str);
        byte[] b1 = new BigInteger(str).toByteArray();
        String s = new String(b1, StandardCharsets.US_ASCII);
        //   BigInteger tohex = new BigInteger(str,10);
         //String yoo = tohex.toString(16);
         //String flag = new String(new BigInteger(yoo,16).toByteArray(),0);
        Log.i("here",s);

*/



    }
}