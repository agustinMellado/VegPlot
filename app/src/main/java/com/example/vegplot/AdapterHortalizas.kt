package com.example.vegplot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterHortalizas(private val listaHortalizas: ArrayList<HortalizaData>) :
    RecyclerView.Adapter<AdapterHortalizas.AdapterHortalizaHolder>() {


    //declaro el click para seleccionar la informacion y mandar a otro contacto
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(
            position: Int,
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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHortalizaHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hortaliza, parent, false)

        return AdapterHortalizaHolder(view, mListener)

    }

    override fun onBindViewHolder(holder: AdapterHortalizaHolder, position: Int) {
        val hortaliza: HortalizaData = listaHortalizas[position]

        holder.nombre.text = hortaliza.nombre
       holder.descripcion.text = hortaliza.descripcion
        holder.germinacion.text = hortaliza.germinacion
        holder.profundidad.text = hortaliza.profundidad
        holder.distancia.text = hortaliza.distancia
        holder.temporada.text = hortaliza.temporada
        holder.altura.text = hortaliza.altura
        holder.cosecha.text = hortaliza.cosecha
        holder.riego.text = hortaliza.riego
        holder.siembra.text = hortaliza.siembra


    }

    // retorna la cantidad de elementos que tenemos en lista
    override fun getItemCount(): Int {
        return listaHortalizas.size
    }

    //le enviamos la vista que pasa por viewHolder
    class AdapterHortalizaHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        //  val imagen: ImageView = itemView.findViewById(R.id.imagenHor)
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
                    //imagen.setImageResource(),
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