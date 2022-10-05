package com.example.ejercicio1_desweb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.AdapterListUpdateCallback
import com.example.ejercicio1_desweb.modelos.Productos

class ProductosAdapter(
                        private val mContext :Context,
                        private val productosList :List<Productos>
                        ) : ArrayAdapter<Productos>(mContext,0, productosList) {
/*
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            /*
            val adapterLayout = LayoutInflater.from(mContext)
                .inflate(R.layout.category_list_adapter, parent,false)

            val gameTypeItem = gameList[position]

            adapterLayout.textViewName.text = gameTypeItem.name
            adapterLayout.textViewPrice.text = "Q${gameTypeItem.price}"
            Picasso.get().load(gameTypeItem.image).into(adapterLayout.imageViewImage)

            return adapterLayout
           */
        }

 */


}