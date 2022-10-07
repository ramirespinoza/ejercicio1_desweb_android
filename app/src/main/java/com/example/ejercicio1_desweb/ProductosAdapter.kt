package com.example.ejercicio1_desweb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.AdapterListUpdateCallback
import com.example.ejercicio1_desweb.modelos.Productos

class ProductosAdapter: BaseAdapter {

    private var context : Context
    private var layout : Int
    private var productosList : List<Productos>

    constructor(context: Context, layout: Int, productosList: List<Productos>) : super() {
        this.context = context
        this.layout = layout
        this.productosList = productosList
    }


    override fun getCount(): Int {
        //TODO("Not yet implemented")
        return this.productosList.size
    }

    override fun getItem(position: Int): Any {
        //TODO("Not yet implemented")
        return this.productosList.get(position)
    }

    override fun getItemId(id: Int): Long {
        //TODO("Not yet implemented")
        return id.toLong()
    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        //TODO("Not yet implemented")
        var vwProducto : View? = convertView;

        //Inflamos la vista con nuestro propio layout
        var layoutInflater :LayoutInflater = LayoutInflater.from(this.context);
        vwProducto = layoutInflater.inflate(this.layout, null);

        // Valor actual según la posición
        var producto : Productos = productosList[position]

        // Referenciamos el elemento a modificar y lo rellenamos

        var lblCodProducto = vwProducto.findViewById(R.id.lblCodProducto) as TextView
        var lblNombreProducto = vwProducto.findViewById(R.id.lblNombreProducto) as TextView
        var lblPrecioProducto = vwProducto.findViewById(R.id.lblPrecioProducto) as TextView


        lblCodProducto.text = producto.id.toString()
        lblNombreProducto.text = producto.nombre
        lblPrecioProducto.text = producto.precio.toString()
        //Devolvemos la vista inflada
        return vwProducto;
    }
}