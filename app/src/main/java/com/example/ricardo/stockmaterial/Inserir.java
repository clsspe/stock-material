package com.example.ricardo.stockmaterial;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inserir extends Activity {

    protected Adaptador a;
    protected Cursor c;

    protected AutoCompleteTextView etNome;
    protected EditText etQnt;
    protected Button btnInserir;


    @Override
    protected void onStart() {
        super.onStart();

        a = new Adaptador(this).open();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);

        etNome = (AutoCompleteTextView) findViewById(R.id.etNome);
        etQnt = (EditText) findViewById(R.id.etQnt);

        a = new Adaptador(this).open();

        btnInserir = (Button) findViewById(R.id.btnInserir);

        new AsyncGenerator(btnInserir, "zonaporto.com", "xml.xml", 443, etNome, getApplicationContext()).execute(0);



        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etNome.getText().toString().equals("") || etQnt.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Formulário incompleto!", Toast.LENGTH_SHORT).show();
                else {
                    a.insert(etNome.getText().toString(), Integer.parseInt(etQnt.getText().toString()));
                    etNome.setText("");
                    etQnt.setText("");
                    Toast.makeText(getApplicationContext(), "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    executarOutraActivity(MainActivity.class);
                }
            }
        });


    }
    private void executarOutraActivity(Class<?> subActividade) {
        Intent x = new Intent(this, subActividade);
        startActivity(x);
    }
}
