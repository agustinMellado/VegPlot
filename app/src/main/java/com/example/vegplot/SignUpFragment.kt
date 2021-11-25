package com.example.vegplot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.vegplot.databinding.FragmentSignUpBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import java.util.regex.Pattern

class SignUpFragment : Fragment() {
/*
    private var _binding: FragmentSignUpBinding? = null

    //creo otra variable que va a llamar a _binding
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference

    val nombreUsuario = view?.findViewById<EditText>(R.id.nombreUsuario)
    val emailUsuario = view?.findViewById<EditText>(R.id.emailUsuario)
    val passwordUsuario = view?.findViewById<EditText>(R.id.passwordUsuario)
    val repetirPasswordUsuario = view?.findViewById<EditText>(R.id.repetirPasswordUsuario)
    val btn_registro = view?.findViewById<Button>(R.id.btn_registro)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance().reference


      btn_registro?.setOnClickListener {
            verificacion()
        }

        return binding.root
    }

    private fun verificacion() {
        val nombreUsuario = nombreUsuario?.text.toString().trim()
        val emailUsuario = emailUsuario?.text.toString().trim()
        val passwordUsuario = passwordUsuario?.text.toString().trim()
        val repetirPasswordUsuario = repetirPasswordUsuario?.text.toString().trim()

        //verifico que la contraseña sea mayor igual que 8
        if (passwordUsuario.length < 8) {
            Toast.makeText(context, "La contraseña es muy corta", Toast.LENGTH_SHORT).show()
        } else {
            // verifico que la contraseña tenga al menos 1 numero
            if (!Pattern.compile("[0-9]]").matcher(passwordUsuario).find()) {
                Toast.makeText(context, "Debe tener al menos un numero", Toast.LENGTH_SHORT).show()
            } else {
                //verifico que las contraseñas sean iguales
                if (passwordUsuario == repetirPasswordUsuario) {
                    // una vez verificada la informacion de registro creo el usuario
                    registrar(nombreUsuario,emailUsuario, passwordUsuario)


                } else {
                    Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT)
                        .show()
                }

            }


        }


    }

    private fun registrar(nombre:String,email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(requireActivity()) { task: Task<AuthResult?> ->
            if (task.isSuccessful) {

                Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                val uid= Objects.requireNonNull(auth!!.currentUser)?.uid

                val user=Usuario(nombre,email)
                db.child("usuarios").child(uid.toString()).setValue(user)
            } else {
                Toast.makeText(context, "no se pudo registrar", Toast.LENGTH_SHORT).show()
            }
        }

    }

 */

}