package com.example.ejercicio1_desweb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun onClick(view :View) {
        var intent : Intent? = null



        when(view.getId()){
            R.id.btnRegistrar ->
                intent = Intent(this, RegistroDeProducto::class.java)
            R.id.btnListar ->
                intent = Intent(this, ListadoDeProductos::class.java)
            R.id.btnListarRV ->
                intent = Intent(this, ListadoDeProductosRV::class.java)
        }

        if(intent!=null) {
            startActivity(intent)
        }
    }
}