package com.example.ricardo.stockmaterial;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    protected Button btnInserir;
    protected ListView Lista;
    protected Adaptador a;
    protected Cursor cursor;


    @Override
    protected void onStart() {
        super.onStart();

        a = new Adaptador(this).open();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInserir = (Button) findViewById(R.id.btnInserir);

        btnInserir.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                executarOutraActivity(Inserir.class);
            }
        });

        Lista = (ListView) findViewById(R.id.Lista);

        a = new Adaptador(this).open();

        cursor = a.obterTodosRegistos();

        List<String> arr = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                arr.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, arr);

        Lista.setAdapter(adapter);

        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                cursor.moveToPosition(position);
                int i = cursor.getInt(0);

                executarOutraActivity(Editar.class, i);



            }

        });

    }

    private void executarOutraActivity(Class<?> subActividade) {
        Intent x = new Intent(this, subActividade);
        startActivity(x);
    }

    private void executarOutraActivity(Class<?> subActividade, Integer id) {
        Intent x = new Intent(this, subActividade);
        x.putExtra("_id", id);
        startActivity(x);
    }
}
