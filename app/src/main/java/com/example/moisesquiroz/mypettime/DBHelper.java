package com.example.moisesquiroz.mypettime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyPetTimeDB.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Mascota" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR, especie VARCHAR, fechaNacimiento DATETIME);"
        );

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Comida" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, etiqueta VARCHAR, cantidad INTEGER, hora DATETIME, idMascota INTEGER, FOREIGN KEY(idMascota) REFERENCES Mascota(id));"
        );

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Medicamento" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR, hora DATETIME, idMascota INTEGER, FOREIGN KEY(idMascota) REFERENCES Mascota(id));"
        );

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Ejercicio" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, etiqueta VARCHAR, duracion INTEGER, hora DATETIME, idMascota INTEGER, FOREIGN KEY(idMascota) REFERENCES Mascota(id));"
        );

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Veterinario" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR, fecha DATETIME, idMascota INTEGER, FOREIGN KEY(idMascota) REFERENCES Mascota(id));"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // db.execSQL("DROP TABLE IF EXISTS ----");
        // onCreate(db);
    }

    public boolean addMascota (String nombre, String especie, String fechaNacimiento) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("especie", especie);
        contentValues.put("fechaNacimiento", fechaNacimiento);
        db.insert("Mascota", null, contentValues);
        return true;
    }

    public Cursor getMascota(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Mascota where id="+id+"", null );
        return res;
    }

    public boolean updateMascota (Integer id, String nombre, String especie, String fechaNacimiento) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("especie", especie);
        contentValues.put("fechaNacimiento", fechaNacimiento);
        db.update("Mascota", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteMascota (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Mascota",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllMascota() {
        ArrayList<String> array_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Mascota", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("nombre")));
            res.moveToNext();
        }
        return array_list;
    }
}