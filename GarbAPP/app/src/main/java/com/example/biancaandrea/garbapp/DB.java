package com.example.biancaandrea.garbapp;

/**
 * Created by Bianca Andrea on 28/09/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper  {
    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "bdgarbapp", factory, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(nombre text, distrito text, email text, contraseña text)");
        //db.execSQL("create table cupones(tienda text, informacion text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS usuario");
            onCreate(db);

    }

    public String guardar(String nombre,String distrito,String usuario, String contraseña){
        String mensaje= "";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre",nombre);
        values.put("distrito",distrito);
        values.put("email",usuario);
        values.put("contraseña",contraseña);
        try{
            database.insertOrThrow("usuario",null,values);
            mensaje="ingresado correctamente";
        } catch (SQLException e){
            mensaje=" no ingresado";
        }
        return mensaje;
    }

    public String buscar_reg(String buscarUsuario,String buscarContraseña){
        String mensaje= "";
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM usuario WHERE email='"+buscarUsuario+"' AND contraseña='"+buscarContraseña+"'";
        Cursor registros= database.rawQuery(q,null);
        if(registros.moveToFirst()){
            mensaje="bienvenido    "+buscarUsuario;
        }
        else{
            mensaje="registrarse";
        }
        return mensaje;
    }

}
