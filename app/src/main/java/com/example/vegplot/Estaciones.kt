package com.example.vegplot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class Estaciones : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       val view: View = inflater.inflate(R.layout.fragment_estaciones, container, false)
        //boton para ir al fragmento otonio invierno
        view.findViewById<Button>(R.id.btn_oi).setOnClickListener{
            view.findNavController().navigate(R.id.action_estaciones_to_hortalizasOI)
        }
        view.findViewById<Button>(R.id.btn_pv).setOnClickListener{
            view.findNavController().navigate(R.id.action_estaciones_to_hortalizasPV)
        }
        return view
    }


}