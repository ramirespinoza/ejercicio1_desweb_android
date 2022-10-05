package com.example.ejercicio1_desweb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.ejercicio1_desweb.utilidades.Assets

class Connection :SQLiteOpenHelper {
    constructor(
        context: Context?,
        name: String?,
        factory: SQLiteDatabase.CursorFactory?,
        version: Int
    ) : super(context, name, factory, version)

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        // TODO("Not yet implemented")
        sqLiteDatabase.execSQL(Assets.CREAR_TABLA_PRODUCTO)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // TODO("Not yet implemented")
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PRODUCTO")
        this.onCreate(sqLiteDatabase)
    }


}