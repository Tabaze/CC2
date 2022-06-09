package com.example.cc2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDataClimat extends SQLiteOpenHelper {
    public static String dbName="Climat.db";
    public static String Table="Climat";
    public static String col1="id";
    public static String col2="ville";
    public static String col3="pays";
    public static String col4="temperature";
    public static String col5="PourcNuage";

    public MyDataClimat(Context context) {
        super(context, dbName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + Table + " (" + col1 + " integer primary key autoincrement," + col2 + " text," + col3 + " text," + col4 + " integer," + col5 + " integer)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE " + Table;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public static long AddClimat(SQLiteDatabase sql, Climat cl){
        ContentValues c = new ContentValues();
        c.put(col2,cl.getNomVille());
        c.put(col3,cl.getPays());
        c.put(col4,cl.getTemperature());
        c.put(col5,cl.getPourcentage());
        return sql.insert(Table,null,c);
    }
    public static long UpdateClimat(SQLiteDatabase sql, Climat cl){
        ContentValues c = new ContentValues();
        c.put(col2,cl.getNomVille());
        c.put(col3,cl.getPays());
        c.put(col4,cl.getTemperature());
        c.put(col5,cl.getPourcentage());
        return sql.update(Table,c,"id = " + cl.getId(),null);
    }
    public static long DeleteClimat(SQLiteDatabase sql, int id){
        return sql.delete(Table,"id = " + id,null);
    }
    public static ArrayList<Climat> getAllClimat(SQLiteDatabase sql){
        ArrayList<Climat> prds = new ArrayList<>();

        Cursor cur = sql.rawQuery("SELECT * FROM "+Table,null);

        while(cur.moveToNext()){
            Climat cl = new Climat();
            cl.setId(cur.getInt(0));
            cl.setNomVille(cur.getString(1));
            cl.setPays(cur.getString(2));
            cl.setTemperature(cur.getInt(3));
            cl.setPourcentage(cur.getInt(4));
            prds.add(cl);
        }
        return prds;
    }
    public static Climat getAOneProduit(SQLiteDatabase sql, int id){
        Climat cl = null;
        Cursor cur = sql.rawQuery("SELECT * FROM "+Table + " WHERE id="+id ,null);
        if(cur.moveToNext()){
            cl.setId(cur.getInt(0));
            cl.setNomVille(cur.getString(1));
            cl.setPays(cur.getString(2));
            cl.setTemperature(cur.getInt(3));
            cl.setPourcentage(cur.getInt(4));
        }
        return cl;
    }
}
