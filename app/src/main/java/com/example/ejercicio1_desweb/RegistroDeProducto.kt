package com.example.ejercicio1_desweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast


class RegistroDeProducto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_de_producto)
        //this.codigo = findViewById<View>(R.id.textView2)
    }

/*
    fun registrarProducto(){
        try {
            var conexion = Connection(this, Assets.DB_NAME, null, Assets)
            var sqliteDataBase  = conexion.writableDatabase
            var values = ConetentValues

        } catch (e :Exception) {
            Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show();
        }
    }

 */
}