package com.example.cc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity3 extends AppCompatActivity {
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        sp=findViewById(R.id.spPays);
        String[] pays = getResources().getStringArray(R.array.pays);
        ArrayAdapter ad = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,pays);
        sp.setAdapter(ad);
    }
}