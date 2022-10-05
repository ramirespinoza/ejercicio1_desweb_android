package com.example.ejercicio1_desweb.utilidades

class Assets {

    companion object{
        @JvmStatic val DB_VERSION = 1
        @JvmStatic val DB_NAME = "DB_INVENTARIO"

        @JvmStatic val TABLA_PRODUCTO = "PRODUCTO"
        @JvmStatic val CAMPO_CODIGO_PRODUCTO = "COD_PRODUCTO"
        @JvmStatic val CAMPO_NOMBRE_PRODUCTO = "NOMBRE"
        @JvmStatic val CAMPO_PRECIO_PRODUCTO = "PRECIO"

        @JvmStatic val CREAR_TABLA_PRODUCTO = "CREATE TABLE $TABLA_PRODUCTO (" +
                                                    "$CAMPO_CODIGO_PRODUCTO TEXT primary key, " +
                                                    "$CAMPO_NOMBRE_PRODUCTO TEXT, " +
                                                    "$CAMPO_PRECIO_PRODUCTO REAL" +
                                                    ") "


    }
}