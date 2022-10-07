package com.example.ejercicio1_desweb

import android.content.ContentValues
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CursorAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.ejercicio1_desweb.modelos.Productos
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
            var productosAdapter :ProductosAdapter
            var listaProducto: ArrayList<Productos> = ArrayList()
            var lst :List<Productos>

            //Guardar en cursor los datos de la tabla
            var result = sqliteDataBase.rawQuery("SELECT * FROM ${Assets.TABLA_PRODUCTO}", null)


            //Recorrer datos del cursor
            if(result.moveToFirst()) {
                do {
                    listaProducto.add(Productos(
                        result.getInt(result.getColumnIndex(Assets.CAMPO_CODIGO_PRODUCTO).toInt()),
                        result.getString(result.getColumnIndex(Assets.CAMPO_NOMBRE_PRODUCTO).toInt()),
                        result.getDouble(result.getColumnIndex(Assets.CAMPO_PRECIO_PRODUCTO).toInt())
                    ))

                } while (result.moveToNext())
            } else {
                Toast.makeText(applicationContext, "Lista Vacía", Toast.LENGTH_SHORT).show()
            }

            productosAdapter = ProductosAdapter(applicationContext,R.layout.productos_adapter, listaProducto)
            listViewProductos.adapter = productosAdapter
            Toast.makeText(applicationContext, "Lista mostrada", Toast.LENGTH_SHORT).show()

        } catch (e :Exception) {
            Toast.makeText(applicationContext, "Error al mostrar la lista", Toast.LENGTH_SHORT).show()
        }
    }


    fun onClick(view : View) {
        //var intent : Intent? = null
        when(view.getId()){
            R.id.btnRegresar -> {
                //intent = Intent(this, MainActivity::class.java)
                onBackPressed()
            }
        }
        //if(intent!=null) { startActivity(intent) }
    }
}