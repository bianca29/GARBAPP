package com.example.biancaandrea.garbapp;

/**
 * Created by Bianca Andrea on 28/09/2018.
 */

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class registrar extends AppCompatActivity  {

    EditText email,contraseña,nombre,distrito;
    Button guardar;
    TextView vistaRegistro;
    Spinner opciones;
    private static final String TAG = "REGISTER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        opciones = (Spinner) findViewById(R.id.spinner01);
        vistaRegistro = (TextView) findViewById(R.id.registro_app) ;
        email = (EditText) findViewById(R.id.email);
        contraseña = (EditText) findViewById(R.id.contraseña);
        nombre = (EditText) findViewById(R.id.nombre);
        guardar = (Button) findViewById(R.id.BotonListoRegistro);
        final ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.Distrito,android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB bd = new DB(getApplicationContext(), null, null, 1);
                String email1 = email.getText().toString();
                String contraseña1 = contraseña.getText().toString();
                String nombre1 = nombre.getText().toString();
                String distrito1 = opciones.getSelectedItem().toString();
                Log.e(TAG, opciones.getSelectedItem().toString());
                String mensaje = bd.guardar(nombre1,distrito1, email1, contraseña1);
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });
        String nombre_fuente = "font/Biysk.ttf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), nombre_fuente);
        vistaRegistro.setTypeface(fuente);


    }

}