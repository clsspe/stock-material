package com.example.ricardo.stockmaterial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ricardo on 08/01/2018.
 */

public class Adaptador {

    private BD dbHelper;
    private SQLiteDatabase database;
    public Adaptador(Context context) {
        dbHelper = new BD(context.getApplicationContext());
    }
    public Adaptador open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }
    public Cursor obterTodosRegistos() {
        String[] colunas = new String[3];
        colunas[0] = "_id";
        colunas[1] = "nome";
        colunas[2] = "quantidade";
        return database.query("Material", colunas, null, null, null, null, "nome");
    }


    public long insert(String nome, Integer quantidade) {
        ContentValues values = new ContentValues() ;
        values.put("nome", nome);
        values.put("quantidade", quantidade);
        return database.insert("Material", null, values);
    }

    public Cursor obterDados(Integer id){
        return database.rawQuery(
                "select _id, nome, quantidade from Material where _id=?", new String[] { id.toString() });

    }

    public int update(Integer _id, String nome, Integer quantidade) {
        String whereClause = "_id = ?";
        String[] whereArgs = new String[1];
        whereArgs[0] = new Integer(_id).toString();
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("quantidade", quantidade);
        return database.update("Material", values, whereClause, whereArgs);
    }
}
