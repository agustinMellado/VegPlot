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
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.findNavController
import com.example.vegplot.databinding.FragmentSignUpBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import java.util.*
import java.util.regex.Pattern

class SignUpFragment : Fragment() {

    private lateinit var nombreUsuario: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPass: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        nombreUsuario = view.findViewById(R.id.nombreUsuario)
        email = view.findViewById(R.id.emailUsuario)
        password = view.findViewById(R.id.passwordUsuario)
        confirmPass = view.findViewById(R.id.confirmPassword)

        auth = Firebase.auth
        //colocar el navegation cuando lo cree en el nav_graph xdxdxd

        view.findViewById<Button>(R.id.btn_registro).setOnClickListener {
            verificacion()

        }




        return view
    }


    private fun verificacion() {


        //verifico que los campos de registro no se encuentren vacios
        when {
            TextUtils.isEmpty(nombreUsuario.text.toString().trim()) -> {
                nombreUsuario.setError("porfavor ingrese su nombre")
            }
            TextUtils.isEmpty(email.text.toString().trim()) -> {
                email.setError("porfavor ingrese su email")
            }
            TextUtils.isEmpty(password.text.toString().trim()) -> {
                password.setError("porfavor ingrese su contraseña")
            }
            TextUtils.isEmpty(confirmPass.text.toString().trim()) -> {
                confirmPass.setError("porfavor ingrese su confirmacion de contraseña")
            }


            email.text.toString().isNotEmpty() && password.text.toString()
                .isNotEmpty() && confirmPass.text.toString().isNotEmpty() -> {


                if (password.text.toString().length >= 8) {

                    if (password.text.toString() == confirmPass.text.toString()) {
                        registro()
                        Toast.makeText(context, "registro exitoso", Toast.LENGTH_SHORT).show()
                    } else {
                        confirmPass.setError("las contraseñas no coinciden")
                    }
                } else {
                    password.setError("Porfavor coloque una contraseña mayor a 8 caracteres")
                }

            }

        }


    }

    private fun registro() {
        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    view?.findNavController()?.navigate(R.id.action_signUpFragment_to_loginFragment)
                    Toast.makeText(context, "registro exitoso", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()

                }
            }
    }


}