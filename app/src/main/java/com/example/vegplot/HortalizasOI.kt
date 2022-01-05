package com.example.vegplot

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*

class HortalizasOI : Fragment() {

    //Declaracion de variables
    private lateinit var db: FirebaseFirestore
    private lateinit var recyclerView: RecyclerView
    private lateinit var listaDeHortalizas: ArrayList<HortalizaData>
    private lateinit var adapter: AdapterHortalizas


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_hortalizas_o_i, container, false)


        //instanciamos recycler y le asigno el manager
        recyclerView = view.findViewById(R.id.recyclerViewHortalizas)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        //inicializo el arreglo y se lo paso al adaptador
        listaDeHortalizas = arrayListOf()

        adapter = AdapterHortalizas(listaDeHortalizas)
        recyclerView.adapter = adapter


        //utilizo el itemClick del adaptador
        adapter.setOnItemClickListener(object : AdapterHortalizas.OnItemClickListener {
            override fun onItemClick(
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

            ) {
                val bundle = Bundle()
                bundle.putString("imagenUrl",imagenUrl)
                bundle.putString("nombre", nombre)
                bundle.putString("descripcion", descripcion)
                bundle.putString("germinacion", germinacion)
                bundle.putString("profundidad", profundidad)
                bundle.putString("distancia", distancia)
                bundle.putString("temporada", temporada)
                bundle.putString("altura", altura)
                bundle.putString("cosecha", cosecha)
                bundle.putString("riego", riego)
                bundle.putString("siembra", siembra)


                //mando la informacion que almacene en la bundle al fragmento de detalles hortaliza
                view.findNavController().navigate(R.id.action_hortalizasOI_to_detallesHortaliza,bundle)

            }
        })
        //Busco los datos en la bd
        leerData()


        return view
    }

    private fun leerData() {
        //Le asigno a la variable la instancia de la base de datos
        db = FirebaseFirestore.getInstance()
        //voy a la coleccion dentro de firebase y con el listener captamos los movimiento dentro de esta
        db.collection("hortalizasOI").addSnapshotListener(object : EventListener<QuerySnapshot> {

            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ) {
                if (error != null) {
                    //mostramos que se produjo un error
                    Log.e("error", error.message.toString())
                    return
                }
                // si no hay error mostramos por pantalla la lista
                for (dc: DocumentChange in value?.documentChanges!!) {
                    if (dc.type == DocumentChange.Type.ADDED) {
                        listaDeHortalizas.add(dc.document.toObject(HortalizaData::class.java)) //lo agregamos usando la clase que creamos para los contacts
                    }
                }
                adapter.notifyDataSetChanged() // notificamos al adaptador para que cree las tarjetas
            }
        })
    }

}