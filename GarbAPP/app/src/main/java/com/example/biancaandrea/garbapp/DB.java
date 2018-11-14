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
import android.nfc.Tag;
import android.util.Log;

import com.example.biancaandrea.garbapp.entities.Usuario;

public class DB extends SQLiteOpenHelper  {
    private static final String TAG = "DB";
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

    public String guardarUsuario(Usuario usuario){
        String mensaje = "";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", usuario.getNombre());
        values.put("distrito", usuario.getDistrito());
        values.put("email", usuario.getEmail());
        values.put("contraseña", usuario.getContraseña());
        try{
            database.insertOrThrow("usuario",null,values);
            mensaje = "ingresado correctamente";
            Log.e(TAG, "getUsuario");
            Log.e(TAG, usuario.toString());
        } catch (SQLException e){
            mensaje = " no ingresado";
        }
        return mensaje;
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

    public Usuario getUsuario(String usu, String pass){
        Usuario usuario = null;
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT nombre, distrito, email FROM usuario WHERE email='"+usu+"' AND contraseña='"+pass+"'";
        Cursor registros= database.rawQuery(q,null);
        if(registros.moveToFirst()){
            usuario = new Usuario(
                    registros.getString(0),
                    registros.getString(1),
                    registros.getString(2),
                    ""
            );
            Log.e(TAG, "getUsuario");
            Log.e(TAG, usuario.toString());
        }
        return usuario;
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
    public void showUsuarios(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT nombre FROM usuario";
        Cursor usuarios = database.rawQuery(query, null);
        if(usuarios.moveToFirst()){
            do{
                String nombre = usuarios.getString(0);
                Log.e(TAG, nombre);
            }while (usuarios.moveToNext());
        }
    }
}
