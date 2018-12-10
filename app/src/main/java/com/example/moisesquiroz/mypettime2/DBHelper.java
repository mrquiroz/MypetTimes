package com.example.moisesquiroz.mypettime2;

import java.util.ArrayList;
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
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "etiqueta VARCHAR, " +
                        "cantidad INTEGER, " +
                        "hora DATETIME, " +
                        "idMascota INTEGER, " +
                        "FOREIGN KEY(idMascota) REFERENCES Mascota(id) ON DELETE CASCADE" +
                        ");"
        );

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Medicamento" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nombre VARCHAR, " +
                        "hora DATETIME, " +
                        "idMascota INTEGER, " +
                        "FOREIGN KEY(idMascota) REFERENCES Mascota(id) ON DELETE CASCADE" +
                        ");"
        );

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Ejercicio" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "etiqueta VARCHAR, " +
                        "duracion INTEGER, " +
                        "hora DATETIME, " +
                        "idMascota INTEGER, " +
                        "FOREIGN KEY(idMascota) REFERENCES Mascota(id) ON DELETE CASCADE" +
                        ");"
        );

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Veterinario" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nombre VARCHAR, " +
                        "fecha DATETIME, " +
                        "idMascota INTEGER, " +
                        "FOREIGN KEY(idMascota) REFERENCES Mascota(id) ON DELETE CASCADE" +
                        ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Comida");
        db.execSQL("DROP TABLE IF EXISTS Medicamento");
        db.execSQL("DROP TABLE IF EXISTS Ejercicio");
        db.execSQL("DROP TABLE IF EXISTS Veterinario");
        db.execSQL("DROP TABLE IF EXISTS Mascota");
        onCreate(db);
    }

// Agregar a la tabla ------------------------------------------------

    public boolean addMascota (String nombre, String especie, String fechaNacimiento) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("especie", especie);
        contentValues.put("fechaNacimiento", fechaNacimiento);
        db.insert("Mascota", null, contentValues);
        return true;
    }

    public boolean addComida (String etiqueta, int cantidad, String hora, int idMascota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("etiqueta", etiqueta);
        contentValues.put("cantidad", cantidad);
        contentValues.put("hora", hora);
        contentValues.put("idMascota", idMascota);
        db.insert("Comida", null, contentValues);
        return true;
    }

    public boolean addMedicamento (String nombre, String hora, int idMascota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("hora", hora);
        contentValues.put("idMascota", idMascota);
        db.insert("Medicamento", null, contentValues);
        return true;
    }

    public boolean addEjercicio (String etiqueta, int duracion, String hora, int idMascota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("etiqueta", etiqueta);
        contentValues.put("duracion", duracion);
        contentValues.put("hora", hora);
        contentValues.put("idMascota", idMascota);
        db.insert("Ejercicio", null, contentValues);
        return true;
    }

    public boolean addVeterinario (String nombre, String fecha, int idMascota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("fecha", fecha);
        contentValues.put("idMascota", idMascota);
        db.insert("Veterinario", null, contentValues);
        return true;
    }

// -------------------------------------------------------------------



// Obtener cursor de la tabla ----------------------------------------

    public Cursor getMascota(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Mascota where id="+id+"", null );
        return res;
    }

    public Cursor getComida(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Comida where id="+id+"", null );
        return res;
    }

    public Cursor getMedicamento(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Medicamento where id="+id+"", null );
        return res;
    }

    public Cursor getEjercicio(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Ejercicio where id="+id+"", null );
        return res;
    }

    public Cursor getVeterinario(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Veterinario where id="+id+"", null );
        return res;
    }

// -------------------------------------------------------------------



// Actualizar dato en la tabla ---------------------------------------

    public boolean updateMascota (Integer id, String nombre, String especie, String fechaNacimiento) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("especie", especie);
        contentValues.put("fechaNacimiento", fechaNacimiento);
        db.update("Mascota", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public boolean updateComida (Integer id, String etiqueta, int cantidad, String hora, int idMascota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("etiqueta", etiqueta);
        contentValues.put("cantidad", cantidad);
        contentValues.put("hora", hora);
        contentValues.put("idMascota", idMascota);
        db.update("Comida", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public boolean updateMedicamento (Integer id, String nombre, String hora, int idMascota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("hora", hora);
        contentValues.put("idMascota", idMascota);
        db.update("Medicamento", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public boolean updateEjercicio (Integer id, String etiqueta, int duracion, String hora, int idMascota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("etiqueta", etiqueta);
        contentValues.put("duracion", duracion);
        contentValues.put("hora", hora);
        contentValues.put("idMascota", idMascota);
        db.update("Ejercicio", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public boolean updateVeterinario (Integer id, String nombre, String fecha, int idMascota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("fecha", fecha);
        contentValues.put("idMascota", idMascota);
        db.update("Veterinario", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

// ----------------------------------------------------------------



// Eliminar dato en la tabla --------------------------------------

    public int deleteMascota (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Mascota",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public int deleteComida (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Comida",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public int deleteMedicamento (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Medicamento",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public int deleteEjercicio (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Ejercicio",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public int deleteVeterinario (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Veterinario",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

// ----------------------------------------------------------------



// Obtener arraylist de la tabla ----------------------------------

    public void getAllMascota(ArrayList<Mascota> array_list) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Mascota", null );
        res.moveToFirst();

        Mascota planet;

        while(res.isAfterLast() == false){
            planet = new Mascota(
                    res.getString(res.getColumnIndex("nombre")),
                    res.getString(res.getColumnIndex("especie")),
                    res.getString(res.getColumnIndex("fechaNacimiento")),
                    res.getInt(res.getColumnIndex("id"))
            );

            array_list.add(planet);
            res.moveToNext();
        }
        res.close();
    }

    public void getComidaWithMascota(int idMascota, ArrayList<Comida> array_list) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Comida where idMascota="+idMascota+"", null ); // TODO Revisar esto
        res.moveToFirst();

        Comida nuevaComida;

        while(res.isAfterLast() == false){
            nuevaComida = new Comida(
                    res.getString(res.getColumnIndex("etiqueta")),
                    res.getString(res.getColumnIndex("hora")),
                    res.getInt(res.getColumnIndex("cantidad")),
                    res.getInt(res.getColumnIndex("id")),
                    res.getInt(res.getColumnIndex("idMascota"))
            );

            array_list.add(nuevaComida);
            res.moveToNext();
        }
        res.close();
    }

    public void getMedicamentoWithMascota(int idMascota, ArrayList<Medicamento> array_list) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Medicamento where idMascota="+idMascota+"", null );  // TODO Revisar esto
        res.moveToFirst();

        Medicamento nuevoMedicamento;

        while(res.isAfterLast() == false){
            nuevoMedicamento = new Medicamento(
                    res.getString(res.getColumnIndex("nombre")),
                    res.getString(res.getColumnIndex("hora")),
                    res.getInt(res.getColumnIndex("id")),
                    res.getInt(res.getColumnIndex("idMascota"))
            );

            array_list.add(nuevoMedicamento);
            res.moveToNext();
        }
        res.close();
    }

    public void getEjercicioWithMascota(int idMascota, ArrayList<Ejercicio> array_list) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Ejercicio where idMascota="+idMascota+"", null );  // TODO Revisar esto
        res.moveToFirst();

        Ejercicio nuevoEjercicio;

        while(res.isAfterLast() == false){
            nuevoEjercicio = new Ejercicio(
                    res.getString(res.getColumnIndex("etiqueta")),
                    res.getString(res.getColumnIndex("hora")),
                    res.getInt(res.getColumnIndex("duracion")),
                    res.getInt(res.getColumnIndex("id")),
                    res.getInt(res.getColumnIndex("idMascota"))
            );

            array_list.add(nuevoEjercicio);
            res.moveToNext();
        }
        res.close();
    }

    public void getVeterinarioWithMascota(int idMascota, ArrayList<Veterinario> array_list) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Veterinario where idMascota="+idMascota+"", null );  // TODO Revisar esto
        res.moveToFirst();

        Veterinario nuevoVeterinario;

        while(res.isAfterLast() == false){
            nuevoVeterinario = new Veterinario(
                    res.getString(res.getColumnIndex("nombre")),
                    res.getString(res.getColumnIndex("fecha")),
                    res.getInt(res.getColumnIndex("id")),
                    res.getInt(res.getColumnIndex("idMascota"))
            );

            array_list.add(nuevoVeterinario);
            res.moveToNext();
        }
        res.close();
    }

    public boolean checkEmpty(){
        SQLiteDatabase db = this.getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, "mascota") == 0;
    }
}