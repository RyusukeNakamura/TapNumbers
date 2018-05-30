package com.lifeistech.android.tapnumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int[] hairetsu;
    int seikai;
    String mondai = "";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        start();

    }

    public void start() {
        hairetsu = new int[4];
        Random rand = new Random();
        hairetsu[0] = rand.nextInt(4) + 1;
        hairetsu[1] = rand.nextInt(4) + 1;
        hairetsu[2] = rand.nextInt(4) + 1;
        hairetsu[3] = rand.nextInt(4) + 1;

        for (int i = 0; i < hairetsu.length; i++) {
            mondai += Integer.toString(hairetsu[i]);
        }
        textView.setText(mondai);
        seikai = 0;
    }

    public void number1(View v) {
        number(1);
    }

    public void number2(View v) {
        number(2);

    }

    public void number3(View v) {
       number(3);
    }

    public void number4(View v) {
       number(4);
    }

    public void number(int i) {
        if (hairetsu[seikai] == i) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai++;
            if (seikai == 4) {
                start();
            }
        }else{
            Toast.makeText(this,"数字が違います",Toast.LENGTH_LONG).show();
        }
    }
}
