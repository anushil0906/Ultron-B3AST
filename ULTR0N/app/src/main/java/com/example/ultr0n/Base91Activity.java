package com.example.ultr0n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class Base91Activity extends AppCompatActivity {
    TextView text91;
    EditText base_id_91;
    Button show91;
    EditText flag91;
    public void show91(View view)
    {
       String s = new String( Base91.decode(base_id_91.getText().toString().getBytes()));
       flag91.setText(s);

    }
    public static class Base91 {

        public static final byte[] ENCODING_TABLE;
        private static final byte[] DECODING_TABLE;
        private static final int BASE;
        private static final float AVERAGE_ENCODING_RATIO = 1.2297f;

        static {
            String ts = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&()*+,./:;<=>?@[]^_`{|}~\"";
            ENCODING_TABLE = ts.getBytes();
            BASE = ENCODING_TABLE.length;

            DECODING_TABLE = new byte[256];
            for ( int i = 0; i < 256; ++i )
                DECODING_TABLE[i] = -1;

            for ( int i = 0; i < BASE; ++i )
                DECODING_TABLE[ENCODING_TABLE[i]] = (byte) i;
        }

        public static byte[] encode(byte[] data) {

            int estimatedSize = (int) Math.ceil(data.length * AVERAGE_ENCODING_RATIO);
            ByteArrayOutputStream output = new ByteArrayOutputStream(estimatedSize);

            int ebq = 0;
            int en = 0;
            for ( int i = 0; i < data.length; ++i ) {
                ebq |= (data[i] & 255) << en;
                en += 8;
                if ( en > 13 ) {
                    int ev = ebq & 8191;

                    if ( ev > 88 ) {
                        ebq >>= 13;
                        en -= 13;
                    } else {
                        ev = ebq & 16383;
                        ebq >>= 14;
                        en -= 14;
                    }
                    output.write(ENCODING_TABLE[ev % BASE]);
                    output.write(ENCODING_TABLE[ev / BASE]);
                }
            }

            if ( en > 0 ) {
                output.write(ENCODING_TABLE[ebq % BASE]);
                if ( en > 7 || ebq > 90 ) {
                    output.write(ENCODING_TABLE[ebq / BASE]);
                }
            }

            return output.toByteArray();
        }

        public static byte[] decode(byte[] data) {

            // if (data.length == 0)
            // return new byte[] {};

            int dbq = 0;
            int dn = 0;
            int dv = -1;

            int estimatedSize = Math.round(data.length / AVERAGE_ENCODING_RATIO);
            ByteArrayOutputStream output = new ByteArrayOutputStream(estimatedSize);

            for ( int i = 0; i < data.length; ++i ) {
                if ( DECODING_TABLE[data[i]] == -1 )
                    continue;
                if ( dv == -1 )
                    dv = DECODING_TABLE[data[i]];
                else {
                    dv += DECODING_TABLE[data[i]] * BASE;
                    dbq |= dv << dn;
                    dn += (dv & 8191) > 88 ? 13 : 14;
                    do {
                        output.write((byte) dbq);
                        dbq >>= 8;
                        dn -= 8;
                    } while ( dn > 7 );
                    dv = -1;
                }
            }

            if ( dv != -1 ) {
                output.write((byte) (dbq | dv << dn));
            }

            return output.toByteArray();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base91);
        text91 = findViewById(R.id.text91);
        base_id_91 = findViewById(R.id.base_id_91);
        show91 = findViewById(R.id.show91);
        flag91 = findViewById(R.id.flag91);
    }
}