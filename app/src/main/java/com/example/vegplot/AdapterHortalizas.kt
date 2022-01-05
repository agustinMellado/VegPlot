package com.example.vegplot

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterHortalizas(private val listaHortalizas: List<HortalizaData>) :
    RecyclerView.Adapter<AdapterHortalizas.HortalizaViewHolder>() {


    //declaro el click para seleccionar la informacion y mandar a otro contacto
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(
            position: Int,
            imagenUrl:String,
            nombre: String,
            descripcion: String,
            germinacion: String,
            profundidad: String,
            distancia: String,
            temporada: String,
            altura: String,
            cosecha: String,
            riego: String,
            siembra: String
        )
    }


    //Creacion de funcion para clickear
    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HortalizaViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hortaliza, parent, false)

        return HortalizaViewHolder(view, mListener)

    }

    override fun onBindViewHolder(holder: HortalizaViewHolder, position: Int) {
        val h: HortalizaData = listaHortalizas[position]
       /*
        //imagen tomada con el glide

        if (context != null) {
            Glide.with(context)
                .load(h.imagenUrl)
                .into(holder.imagenUrl)
        }*/
        holder.imagenUrl.text = h.imagenUrl
        holder.nombre.text = h.nombre
        holder.descripcion.text = h.descripcion
        holder.germinacion.text = h.germinacion
        holder.profundidad.text = h.profundidad
        holder.distancia.text = h.distancia
        holder.temporada.text = h.temporada
        holder.altura.text = h.altura
        holder.cosecha.text = h.cosecha
        holder.riego.text = h.riego
        holder.siembra.text = h.siembra


    }

    // retorna la cantidad de elementos que tenemos en lista
    override fun getItemCount(): Int {
        return listaHortalizas.size
    }

    //le enviamos la vista que pasa por viewHolder
    class HortalizaViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val imagenUrl: TextView= itemView.findViewById(R.id.imagenHor)
        val nombre: TextView = itemView.findViewById(R.id.nombreHor)

        val descripcion: TextView = itemView.findViewById(R.id.descripcion)
        val germinacion: TextView = itemView.findViewById(R.id.germinacion)
        val profundidad: TextView = itemView.findViewById(R.id.profundidad)
        val distancia: TextView = itemView.findViewById(R.id.distancia)
        val temporada: TextView = itemView.findViewById(R.id.temporada)
        val altura: TextView = itemView.findViewById(R.id.altura)
        val cosecha: TextView = itemView.findViewById(R.id.cosecha)
        val riego: TextView = itemView.findViewById(R.id.riego)
        val siembra: TextView = itemView.findViewById(R.id.siembra)

        //Cargamos los datos en el listener para tenerlos listos para pasar
        init {
            itemView.setOnClickListener {
                listener.onItemClick(
                    bindingAdapterPosition,
                    imagenUrl.text.toString(),
                    nombre.text.toString(),
                    descripcion.text.toString(),
                    germinacion.text.toString(),
                    profundidad.text.toString(),
                    distancia.text.toString(),
                    temporada.text.toString(),
                    altura.text.toString(),
                    cosecha.text.toString(),
                    riego.text.toString(),
                    siembra.text.toString()

                )
            }




        }
        

    }


}