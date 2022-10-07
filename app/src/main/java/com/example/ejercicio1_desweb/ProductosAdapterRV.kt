package com.example.ejercicio1_desweb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio1_desweb.modelos.Productos

class ProductosAdapterRV() :
        RecyclerView.Adapter<ProductosAdapterRV.ViewHolder>() {

    private lateinit var productos: ArrayList<Productos>
    private lateinit var context: Context

    constructor(productos: ArrayList<Productos>, context: Context) : this() {
        this.productos = productos
        this.context = context

    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lblCodigoProducto: TextView
        val lblNombreProducto: TextView
        val lblPrecioProducto: TextView
        private lateinit var context: Context
        fun setContext(context: Context) {this.context = context}

        init {
            // Define click listener for the ViewHolder's View.
            lblCodigoProducto = view.findViewById(R.id.lblCodProducto)
            lblNombreProducto = view.findViewById(R.id.lblNombreProducto)
            lblPrecioProducto = view.findViewById(R.id.lblPrecioProducto)
            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(this.context, lblNombreProducto.text, Toast.LENGTH_SHORT).show() })
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.productos_adapter, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //Se envía el contexto para el onclicklistener
        viewHolder.setContext(this.context)

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.lblCodigoProducto.text = productos[position].id.toString()
        viewHolder.lblNombreProducto.text = productos[position].nombre
        viewHolder.lblPrecioProducto.text = productos[position].precio.toString()



    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = productos.size
}