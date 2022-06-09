package com.example.cc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyDataClimat db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db =new MyDataClimat(this);
        ArrayList<Climat> climates =new ArrayList<>();
        climates.add(new Climat(1,22,12,"Martil","Maroc"));
        climates.add(new Climat(2,22,12,"Tetouan","Maroc"));
        climates.add(new Climat(3,22,12,"Casa","Maroc"));
        climates.add(new Climat(4,22,12,"Paris","France"));
        climates.add(new Climat(5,22,12,"London","Uk"));
        for(Climat cl:climates)
         MyDataClimat.AddClimat(db.getWritableDatabase(),cl);
    }
}