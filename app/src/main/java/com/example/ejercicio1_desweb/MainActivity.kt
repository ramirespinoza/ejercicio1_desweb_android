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
        //btnRegistro.setOnClickListener {}
    }



    fun onClick(view :View) {
        var intent : Intent

        when(view.getId()){
            R.id.btnRegister -> {
                intent = Intent(this, RegistroDeProducto::class.java)
                startActivity(intent)

            }

        }
    }
}