package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class   RSAClassicActivity extends AppCompatActivity {

    // Instantiate the RequestQueue.
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText flagy;
    Button calculate;
   static String outer= "";



    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }
        public void click_classic(View view)
        {
            ArrayList <String> ids = new ArrayList<String>();
            ArrayList <String> values = new ArrayList<String>();
            DownloadTask task = new DownloadTask();
            DownloadTask task1 = new DownloadTask();
            String result = null;

            try {
                if(TextUtils.isEmpty(editText1.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString()) || TextUtils.isEmpty(editText3.getText().toString()))
                {
                    Toast.makeText(RSAClassicActivity.this, "Empty field not allowed!", Toast.LENGTH_SHORT).show();
                }
                else {
                     String x = editText1.getText().toString();
                     BigInteger n = new BigInteger(x);
                    BigInteger d,mes;
                    BigInteger e = new BigInteger(editText2.getText().toString());
                    BigInteger c = new BigInteger(editText3.getText().toString());
                    result = task.execute("http://factordb.com/index.php?query="+x).get();
                    Pattern p = Pattern.compile("href=\"(.*?)\"><font");
                    Matcher m = p.matcher(result);

                    while (m.find()) {
                        ids.add(m.group(1));
                    }

                    Log.i("here",ids.toString());
                    String result1 = null;
                    for(int i=1;i<ids.size();i++)
                    {
                        result1 = new DownloadTask().execute("http://factordb.com/"+ids.get(i)).get();
                        Pattern p1 = Pattern.compile("\"query\" value=\"(.*?)\">");
                        Matcher m1 = p1.matcher(result1);
                        while (m1.find()) {
                            values.add(m1.group(1));
                        }
                       // Log.i("heres",result1);


                    }
                    Log.i("data",values.toString());
                    if(values.size() > 2)
                    {
                        String s = "ITS A MULTI PRIME ATTACK";
                    }
                    BigInteger phi = new BigInteger("1");
                    for(int i=0;i<values.size();i++)
                    {
                        BigInteger factor = new BigInteger(values.get(i));
                        BigInteger new1 =  factor.subtract(new BigInteger("1"));
                        phi = phi.multiply(new1);
                    }
                    Log.i("get",phi.toString());



                    d = e.modInverse(phi);
                    mes = c.modPow(d,n);
                    String str = mes.toString();
                    Log.i("hereit",str);
                    BigInteger tohex = new BigInteger(str,10);
                    String yoo = tohex.toString(16);
                    String flag = new String(new BigInteger(yoo,16).toByteArray(),0);
                    Log.i("hereit",flag);
                    flagy.setText(flag);





                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_s_a_classic);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        calculate = findViewById(R.id.calculate);
        flagy  = findViewById(R.id.flagy);


    }
}