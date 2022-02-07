package com.example.vegplot
//Creo un modelo de dato para añadir informacion sobre los datos de las hortalizas
data class HortalizaData(
    var imagenUrl:String?=null,
    var altura: String? = null,
    var nombre: String? = null,
    var descripcion: String? = null,
    var germinacion: String? = null,
    var profundidad: String? = null,
    var distancia: String? = null,
    var temporada: String? = null,
    var cosecha: String? = null,
    var riego: String? = null,
    var siembra: String? = null
)
