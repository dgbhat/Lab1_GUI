package com.example.datta.lab1_gui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int ch=1,ch2=36;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hey write a code to wish me on a messageView here..!
        Toast.makeText(this,"Hey Yoo Wassupp!!!",Toast.LENGTH_SHORT).show();
        final TextView textView = (TextView)findViewById(R.id.textView);
        Button button_color = (Button)findViewById(R.id.button_color);
        Button button_fontsize = (Button)findViewById(R.id.button_fontsize);
        Button button_nextScreen = (Button)findViewById(R.id.button_nextScreen);

        button_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (ch) {
                    case 1: textView.setTextColor(Color.RED);break;
                    case 2: textView.setTextColor(Color.GREEN);break;
                    case 3: textView.setTextColor(Color.BLUE);break;
                }
                ch++;
                if(ch==4) ch=1;
            }
        });

        button_fontsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (ch2){
                    case 36:textView.setTextSize(ch2-2);break;
                    case 34:textView.setTextSize(ch2-2);break;
                }
                ch2=ch2-2;
                if(ch2==32) ch2=36;
            }
            });

        button_nextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
    }
}
