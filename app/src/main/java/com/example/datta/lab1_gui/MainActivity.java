package com.example.datta.lab1_gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hey write a code to wish me on a messageView here..!
        Toast.makeText(this,"Hey Good Morning!",Toast.LENGTH_SHORT).show();

    }
}
