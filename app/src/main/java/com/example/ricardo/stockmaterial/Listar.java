package com.example.ricardo.stockmaterial;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Listar extends Activity {

    protected Adaptador a;
    protected Cursor c;
    protected Intent oIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        oIntent = getIntent();
        Integer id = oIntent.getExtras().getInt("id");
        a = new Adaptador(this).open();
        c = a.obterDados(id);
        c.moveToFirst();

    }
}
