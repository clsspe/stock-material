package com.example.ricardo.stockmaterial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ricardo on 08/01/2018.
 */

public class BD extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BaseDados.db";
    private static final int VERSION = 2;
    public BD(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "CREATE TABLE Material(_id integer primary key autoincrement, nome varchar(50), quantidade integer)";
        db.execSQL(s);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Material");
        onCreate(db);
    }

}