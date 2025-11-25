package com.example.mandaaltoke

import android.widget.EditText
import android.widget.Button
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth


class InicioSesionFragment : Fragment(R.layout.fragment_inicio_sesion) {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailField = view.findViewById<EditText>(R.id.txtEmail)
        val passField = view.findViewById<EditText>(R.id.txtPassword)
        val btnLogin = view.findViewById<Button>(R.id.btnIniciarSesion)
        val btnIrRegistro = view.findViewById<Button>(R.id.btnCrearCuenta)

        btnLogin.setOnClickListener {
            val email = emailField.text.toString().trim()
            val pass = passField.text.toString().trim()

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(context, "Complete los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, pass)
                .addOnSuccessListener {
                    Toast.makeText(context, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                    // Navegar a Home
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_LONG).show()
                }
        }

        btnIrRegistro.setOnClickListener {
            // Navegar a crear empresa
        }
    }

}