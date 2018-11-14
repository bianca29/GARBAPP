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

import com.example.biancaandrea.garbapp.entities.Usuario;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText usuario, contraseña;
    Button bLogin, bRegistro;
    TextView vistaFuente, vistaLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        bind();

        bLogin.setOnClickListener(this);
        bRegistro.setOnClickListener(this);

        configureFont();
        DB db = new DB(this, null, null, 1);
        db.showUsuarios();
    }

    private void bind() {
        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);
        bLogin = findViewById(R.id.botonLogin);
        bRegistro = findViewById(R.id.botonRegistro);
        vistaFuente = findViewById(R.id.nombre_app);
        vistaLogin = findViewById(R.id.textView3);
    }

    private void configureFont() {
        String nombre_fuente = "font/Biysk.ttf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), nombre_fuente);
        vistaLogin.setTypeface(fuente);
        vistaFuente.setTypeface(fuente);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonLogin:
                DB bd = new DB(getApplicationContext(),null,null,1);
                Usuario user = bd.getUsuario(usuario.getText().toString(), contraseña.getText().toString());
                /*String mandarUsuario = usuario.getText().toString();
                String mandarContraseña = contraseña.getText().toString();
                String mensaje = bd.buscar_reg(mandarUsuario,mandarContraseña);*/
                //Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
                if(user != null){
                    Usuario.getInstance().setData(user);
                    startActivity(new Intent(this, menu.class));
                }
                else{
                    Toast.makeText(this, "No registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.botonRegistro:
                startActivity(new Intent(this, registrar.class));
                break;
        }
    }
}

