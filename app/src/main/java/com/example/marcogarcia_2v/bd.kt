package com.example.marcogarcia_2v

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Clase DatabaseHelper
class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE = "bbddJuegos"
        private const val TABLA_VIDEOJUEGOS = "VideoJuegos"
        private const val KEY_ID = ""
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_VALORACION = "valoracon"
        private const val COLUMN_AÑO = "año"
        private const val COLUMN_EMPRESA = "empresa"

    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLA_VIDEOJUEGOS (" +
                "$KEY_ID INTEGER PRIMARY KEY, " +
                "$COLUMN_NOMBRE TEXT, " +
                "$COLUMN_VALORACION FLOAT,"+
                "$COLUMN_AÑO INTEGER,"+
                "$COLUMN_EMPRESA TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_VIDEOJUEGOS")
        onCreate(db)
    }

    fun escribir(videojuego: videojuego):Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOMBRE, videojuego.getNombre())
            put(COLUMN_VALORACION, videojuego.getValoracion())
            put(COLUMN_AÑO, videojuego.getAño())
            put(COLUMN_EMPRESA, videojuego.getEmpresa())

        }
        val id= db.insert(TABLA_VIDEOJUEGOS, null, values)
        db.close()
        return id
    }


    @SuppressLint("Range")
    fun lectura(): ArrayList<videojuego> {
        val videojuegos = ArrayList<videojuego>()
        val selectQuery = "SELECT * FROM $TABLA_VIDEOJUEGOS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val valoracion = cursor.getFloat(cursor.getColumnIndex(COLUMN_VALORACION))
                val año = cursor.getInt(cursor.getColumnIndex(COLUMN_AÑO))
                val empresa = cursor.getString(cursor.getColumnIndex(COLUMN_EMPRESA))
                var videojuego: videojuego = videojuego(nombre,valoracion.toString().toFloat())
                videojuego.setAño(año)
                videojuego.setEmpresa(empresa)

                videojuegos.add(videojuego)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return videojuegos
    }

}