package com.example.biancaandrea.garbapp;

/**
 * Created by Bianca Andrea on 28/09/2018.
 */

import android.content.Intent;
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

import com.example.biancaandrea.garbapp.entities.Usuario;

public class registrar extends AppCompatActivity implements View.OnClickListener {

    EditText email,contraseña,nombre,distrito;
    Button guardar;
    TextView vistaRegistro;
    Spinner opciones;
    private static final String TAG = "REGISTER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        bind();

        setupAdapter();

        guardar.setOnClickListener(this);
        configureFont();
    }

    private void configureFont() {
        String nombre_fuente = "font/Biysk.ttf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), nombre_fuente);
        vistaRegistro.setTypeface(fuente);
    }

    private void setupAdapter() {
        final ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.Distrito,android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
    }

    private void bind() {
        opciones = findViewById(R.id.spinner01);
        vistaRegistro = findViewById(R.id.registro_app) ;
        email = findViewById(R.id.email);
        contraseña = findViewById(R.id.contraseña);
        nombre = findViewById(R.id.nombre);
        guardar = findViewById(R.id.BotonListoRegistro);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BotonListoRegistro:
                DB bd = new DB(getApplicationContext(), null, null, 1);
                Usuario usuario = new Usuario(
                        nombre.getText().toString(),
                        opciones.getSelectedItem().toString(),
                        email.getText().toString(),
                        contraseña.getText().toString()
                );
                Log.e(TAG, opciones.getSelectedItem().toString());
                String mensaje = bd.guardarUsuario(usuario);
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, Login.class));
                break;
        }
    }
}