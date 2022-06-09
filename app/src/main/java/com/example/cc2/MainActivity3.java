package com.example.cc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    MyDataClimat db;
    Spinner sp;
    Button eff,en;
    String[] pays;
    EditText ville,tem,pou;
    String pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db =new MyDataClimat(this);
        sp=findViewById(R.id.spPays);
        pays = getResources().getStringArray(R.array.pays);
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
        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ville.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity3.this, "Ennter un ville", Toast.LENGTH_SHORT).show();
                    ville.requestFocus();
                    return;
                }
                if(pou.getText().toString().isEmpty() || tem.getText().toString().isEmpty()){
                    return;
                }
                int po= Integer.parseInt(pou.getText().toString());
                if(po<0 || po>100){
                    Toast.makeText(MainActivity3.this, "Le pourcentage entre 0 et 100", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(MyDataClimat.getOneClimat(db.getReadableDatabase(),ville.getText().toString())!=null){
                    Toast.makeText(MainActivity3.this, "La ville deja exist", Toast.LENGTH_SHORT).show();
                    return;
                }
                Climat cl=new Climat();
                cl.setNomVille(ville.getText().toString());
                cl.setPays(pays[sp.getSelectedItemPosition()]);
                cl.setTemperature(Integer.parseInt(tem.getText().toString()));
                cl.setPourcentage(Integer.parseInt(pou.getText().toString()));
                MyDataClimat.AddClimat(db.getWritableDatabase(),cl);
            }
        });
    }
}