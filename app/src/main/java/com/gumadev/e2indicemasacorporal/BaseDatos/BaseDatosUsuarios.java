package com.gumadev.e2indicemasacorporal.BaseDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gumadev.e2indicemasacorporal.Objetos.Usuario;

/**
 * Created by sergu on 01/02/2017.
 */


public class BaseDatosUsuarios extends SQLiteOpenHelper {

    private static final String SQL_CREA_TABLA_USUARIOS = "CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, pass TEXT)";

    public BaseDatosUsuarios(Context context, String nombre, SQLiteDatabase.CursorFactory factor, int version) {
        super(context, nombre, factor, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREA_TABLA_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertarUusario(Usuario usuario){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //Log.d(getClass().getCanonicalName(),"INSERT INTO usuarios (nombre, pass)VALUES('"+usuario.getNombre()+"', '"+usuario.getPass()+"')");
        sqLiteDatabase.execSQL("INSERT INTO usuarios (nombre, pass)VALUES('"+usuario.getNombre()+"', '"+usuario.getPass()+"')");
        sqLiteDatabase.close();
    }

    public boolean existeUsuario(Usuario usuario){
        boolean existe = false;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String consulta = "SELECT id FROM usuarios WHERE ((nombre = '"+usuario.getNombre()+"') AND (pass = '"+usuario.getPass()+"'))";
        Cursor cursor = sqLiteDatabase.rawQuery(consulta, null);

        if( (cursor != null) && ( cursor.getCount() > 0 )){
            existe = true;
            //Log.d(getClass().getCanonicalName(),"Existe");
            //el usuario existe
        }

        return existe;
    }
}
