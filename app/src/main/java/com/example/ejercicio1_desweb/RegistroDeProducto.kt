package com.example.ejercicio1_desweb

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.ejercicio1_desweb.utilidades.Assets
//import com.example.ejercicio1_desweb.Connection


class RegistroDeProducto : AppCompatActivity() {

    lateinit var codigo :EditText
    lateinit var nombre :EditText
    lateinit var precio :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_de_producto)
        this.codigo = findViewById<View>(R.id.editTextCodigoProducto) as EditText
        this.nombre = findViewById<View>(R.id.editTextNombreProducto) as EditText
        this.precio = findViewById<View>(R.id.editTextPrecioProducto) as EditText
    }


    fun registrarProducto(){
        try {
            var conexion = Connection(this, Assets.DB_NAME, null, Assets.DB_VERSION)
            var sqliteDataBase  = conexion.writableDatabase
            var values = ContentValues()
            values.put(Assets.CAMPO_CODIGO_PRODUCTO, this.codigo.text.toString())
            values.put(Assets.CAMPO_NOMBRE_PRODUCTO, this.nombre.text.toString())
            values.put(Assets.CAMPO_PRECIO_PRODUCTO, this.precio.text.toString())

            var result :Long = sqliteDataBase.insert(Assets.TABLA_PRODUCTO, Assets.CAMPO_CODIGO_PRODUCTO, values)

            codigo.text.clear()
            nombre.text.clear()
            precio.text.clear()

            Toast.makeText(applicationContext, "Producto ${this.nombre.text} Registrado", Toast.LENGTH_SHORT).show()


        } catch (e :Exception) {
            Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClick(view :View) {
        when(view.getId()){
            R.id.btnRegresar -> {
                onBackPressed()
            }
            R.id.btnGuardar -> {this.registrarProducto()}
        }
    }
}