package com.example.ricardo.stockmaterial;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Editar extends Activity {

    protected AutoCompleteTextView etNome;
    protected EditText etQuantidade;
    protected Button btnEditar;
    protected Adaptador a;
    protected Cursor cursor;
    protected Intent oIntent;
    protected Integer _id;

    @Override
    protected void onStart() {
        super.onStart();

        a = new Adaptador(this).open();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        oIntent = getIntent();
        _id = oIntent.getExtras().getInt("_id");

        etNome = (AutoCompleteTextView) findViewById(R.id.etNome);
        etQuantidade = (EditText) findViewById(R.id.etQuantidade);
        a = new Adaptador(this).open();
        cursor = a.obterDados(_id);


        if(cursor.moveToFirst()){
            etNome.setText(cursor.getString(1));
            etQuantidade.setText(cursor.getString(2));
        }

        btnEditar = (Button)findViewById(R.id.btnEditar);

        new AsyncGenerator(btnEditar, "zonaporto.com", "xml.xml", 443, etNome, getApplicationContext()).execute(0);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etNome.getText().toString().equals("") || etQuantidade.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Formulário incompleto!", Toast.LENGTH_SHORT).show();
                else {
                    a.update(_id, etNome.getText().toString(), Integer.parseInt(etQuantidade.getText().toString()));
                    etNome.setText("");
                    etQuantidade.setText("");
                    Toast.makeText(getApplicationContext(), "Editado com sucesso!", Toast.LENGTH_SHORT).show();
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
