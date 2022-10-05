package com.example.ejercicio1_desweb

import android.content.ContentValues
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CursorAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.ejercicio1_desweb.utilidades.Assets
import kotlin.reflect.typeOf

class ListadoDeProductos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_de_productos)

        try {
            var conexion = Connection(this, Assets.DB_NAME, null, Assets.DB_VERSION)
            var sqliteDataBase  = conexion.readableDatabase

            var listViewProductos :ListView = findViewById(R.id.listViewProductos) as ListView
            var listaProductos :ArrayList<String> = ArrayList()
            var arrayAdapter :ArrayAdapter<*>

            //Guardar en cursor los datos de la tabla
            var result = sqliteDataBase.rawQuery("SELECT * FROM ${Assets.TABLA_PRODUCTO}", null)


            //Recorrer datos del cursor
            result.moveToFirst()
            do {
                listaProductos.add("Cod.${result.getString(0)} | Nombre.${result.getString(1)} | Precio.${result.getString(2)}")
            } while(result.moveToNext())


            arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, listaProductos)
            listViewProductos.adapter = arrayAdapter
            Toast.makeText(applicationContext, "Producto Registrado", Toast.LENGTH_SHORT).show()

        } catch (e :Exception) {
            Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
        }
    }
}