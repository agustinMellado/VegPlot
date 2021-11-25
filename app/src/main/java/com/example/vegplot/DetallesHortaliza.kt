package com.example.vegplot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class DetallesHortaliza : Fragment() {

    private lateinit var nombre:TextView
    private lateinit var descripcion: TextView
    private lateinit var  germinacion:TextView
    private lateinit var  profundidad: TextView
    private lateinit var  distancia: TextView
    private lateinit var  temporada: TextView
    private lateinit var  altura: TextView
    private lateinit var  cosecha: TextView
    private lateinit var  riego: TextView
    private lateinit var  siembra: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view:View=inflater.inflate(R.layout.fragment_detalles_hortaliza, container, false)
        //inicializo los elementos del fragmento detalles
        nombre= view.findViewById(R.id.nombreDetalle)
        descripcion= view.findViewById(R.id.descripcion)
        germinacion= view.findViewById(R.id.germinacion)
        profundidad= view.findViewById(R.id.profundidad)
        distancia= view.findViewById(R.id.distancia)
        temporada= view.findViewById(R.id.temporada)
        altura=view.findViewById(R.id.altura)
        cosecha=view.findViewById(R.id.cosecha)
        riego=view.findViewById(R.id.riego)
        siembra=view.findViewById(R.id.siembra)

        //les paso los datos a la vista
        nombre.text="${arguments?.getString("nombre")}"
       descripcion.text="${arguments?.getString("descripcion")}"
        germinacion.text="${arguments?.getString("germinacion")}"
        profundidad.text="${arguments?.getString("profundidad")}"
        distancia.text="${arguments?.getString("distancia")}"
        temporada.text="${arguments?.getString("temporada")}"
        altura.text="${arguments?.getString("altura")}"
        cosecha.text="${arguments?.getString("cosecha")}"
        riego.text="${arguments?.getString("riego")}"
        siembra.text="${arguments?.getString("siembra")}"

        return view
    }

}