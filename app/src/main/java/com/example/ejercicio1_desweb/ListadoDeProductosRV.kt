package com.example.ejercicio1_desweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.ejercicio1_desweb.modelos.Productos
import com.example.ejercicio1_desweb.utilidades.Assets

class ListadoDeProductosRV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_de_productos_rv)
        try {
            var conexion = Connection(this, Assets.DB_NAME, null, Assets.DB_VERSION)
            var sqliteDataBase  = conexion.readableDatabase

            var rvProductos : RecyclerView = findViewById(R.id.rvProductos) as RecyclerView
            var productosAdapter :ProductosAdapterRV
            var listaProducto: ArrayList<Productos> = ArrayList()
            var lst :List<Productos>

            //Guardar en cursor los datos de la tabla
            var result = sqliteDataBase.rawQuery("SELECT * FROM ${Assets.TABLA_PRODUCTO}", null)


            //Recorrer datos del cursor
            if(result.moveToFirst()) {
                do {
                    listaProducto.add(
                        Productos(
                        result.getInt(result.getColumnIndex(Assets.CAMPO_CODIGO_PRODUCTO).toInt()),
                        result.getString(result.getColumnIndex(Assets.CAMPO_NOMBRE_PRODUCTO).toInt()),
                        result.getDouble(result.getColumnIndex(Assets.CAMPO_PRECIO_PRODUCTO).toInt())
                    )
                    )

                } while (result.moveToNext())
            } else {
                Toast.makeText(applicationContext, "Lista Vacía", Toast.LENGTH_SHORT).show()
            }

            productosAdapter = ProductosAdapterRV(listaProducto, this)

            rvProductos.setHasFixedSize(true)
            rvProductos.layoutManager = LinearLayoutManager(this)
            rvProductos.adapter = productosAdapter

        } catch (e :Exception) {
            Toast.makeText(applicationContext, "Error al mostrar la lista", Toast.LENGTH_SHORT).show()
        }
    }


    fun onClick(view : View) {
        when(view.getId()){
            R.id.btnRegresar -> {
                onBackPressed()
            }
        }
    }
}