package com.example.vegplot

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import java.util.regex.Pattern

class LoginFragment : Fragment() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btn_login: Button
    private lateinit var btn_registrar: Button


    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        email = view.findViewById(R.id.log_email)
        password = view.findViewById(R.id.log_password)
        btn_login= view.findViewById(R.id.btn_inicioSesion)
        btn_registrar= view.findViewById(R.id.btn_registro)

       btn_login.setOnClickListener {
            verificacion()       }
        btn_registrar.setOnClickListener {
            view.findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }





        return view
    }

    private fun ingresar() {
  /*  btn_login.isEnabled=false
        btn_login.alpha=0.5f

   */


        auth= FirebaseAuth.getInstance()

        auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener(requireActivity()) { task : Task<AuthResult>->
                if (task.isSuccessful){
                    Toast.makeText(context,"Bienvenido",Toast.LENGTH_SHORT).show()
                    view?.findNavController()?.navigate(R.id.action_loginFragment_to_estaciones)
                }else{


                    Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
                }

            }


    }
    private fun verificacion() {
        //verifico que los campos de registro no se encuentren vacios
        when {

            TextUtils.isEmpty(email.text.toString().trim()) -> {
                email.setError("porfavor ingrese su email")
            }
            TextUtils.isEmpty(password.text.toString().trim()) -> {
                password.setError("porfavor ingrese su contraseña")
            }


            email.text.toString().isNotEmpty() && password.text.toString()
                .isNotEmpty() -> {
                ingresar()
            }
        }
    }


}