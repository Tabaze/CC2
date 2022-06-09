package com.example.cc2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

    }
}
