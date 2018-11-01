package com.example.biancaandrea.garbapp;

/**
 * Created by Bianca Andrea on 28/09/2018.
 */

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText usuario, contraseña;
    Button bLogin, bRegistro;
    TextView vistaFuente, vistaLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        usuario = (EditText) findViewById(R.id.usuario);
        contraseña = (EditText) findViewById(R.id.contraseña);
        bLogin = (Button) findViewById(R.id.botonLogin);
        bRegistro = (Button) findViewById(R.id.botonRegistro);
        vistaFuente = (TextView) findViewById(R.id.nombre_app);
        vistaLogin = (TextView) findViewById(R.id.textView3);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB bd = new DB(getApplicationContext(),null,null,1);
                String mandarUsuario = usuario.getText().toString();
                String mandarContraseña = contraseña.getText().toString();
                String mensaje = bd.buscar_reg(mandarUsuario,mandarContraseña);
                Toast.makeText(getApplicationContext(), mensaje,Toast.LENGTH_LONG).show();
                Login.this.startActivity(new Intent(Login.this, menu.class));
            }
        });

        bRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login.this.startActivity(new Intent(Login.this, registrar.class));
            }
        });

        String nombre_fuente = "font/Biysk.ttf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), nombre_fuente);
        vistaLogin.setTypeface(fuente);
        vistaFuente.setTypeface(fuente);
    }
    public String guardar_nombre(){
        String nombre = usuario.getText().toString();
        return nombre;
    }
}

