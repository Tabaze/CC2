package com.example.cc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity3 extends AppCompatActivity {
    Spinner sp;
    Button eff,en;
    EditText ville,tem,pou;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        sp=findViewById(R.id.spPays);
        String[] pays = getResources().getStringArray(R.array.pays);
        ArrayAdapter ad = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,pays);
        sp.setAdapter(ad);
        en=findViewById(R.id.btnSave);
        eff=findViewById(R.id.btnEffa);
        ville=findViewById(R.id.txtVille);
        tem=findViewById(R.id.txtTem);
        pou=findViewById(R.id.txtPou);
        eff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ville.getText().clear();
                tem.getText().clear();
                pou.getText().clear();
                ville.requestFocus();
            }
        });
    }
}