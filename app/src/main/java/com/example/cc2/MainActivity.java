package com.example.cc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    MyDataClimat db;
    ListView lst;
    ArrayList<Climat> climates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst=findViewById(R.id.lstClimate);
        db =new MyDataClimat(this);
        climates = MyDataClimat.getAllClimat(db.getReadableDatabase());
//        ArrayList<Climat> climates =new ArrayList<>();
//        climates.add(new Climat(1,22,12,"Martil","Maroc"));
//        climates.add(new Climat(2,22,12,"Tetouan","Maroc"));
//        climates.add(new Climat(3,22,12,"Casa","Maroc"));
//        climates.add(new Climat(4,22,12,"Paris","France"));
//        climates.add(new Climat(5,22,12,"London","Uk"));
//        for(Climat cl:climates)
//         MyDataClimat.AddClimat(db.getWritableDatabase(),cl);
        ArrayList<HashMap<String, Object>> list_emp = new ArrayList<>();

        for(Climat cl : climates){
            HashMap<String, Object> item = new HashMap<>();
            item.put("nom",cl.getNomVille());
            item.put("tem","Temperature : "+cl.getTemperature()+" °C");
            item.put("pou","Pour de nuages : "+cl.getPourcentage()+" %");
            list_emp.add(item);
        }

        String[] from = {"nom", "tem","pou"};
        int[] to = {R.id.idVille, R.id.idTem,R.id.idPou};

        SimpleAdapter ad = new SimpleAdapter(this,list_emp,R.layout.activity_main2,from,to);
        lst.setAdapter(ad);
    }
}