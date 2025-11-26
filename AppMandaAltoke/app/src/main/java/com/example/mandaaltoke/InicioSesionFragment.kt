package com.example.mandaaltoke

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class InicioSesionFragment : Fragment(R.layout.fragment_inicio_sesion) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón "Crear empresa"
        val btnCrear = view.findViewById<Button>(R.id.btnCrearCuenta)

        btnCrear.setOnClickListener {
            findNavController().navigate(
                R.id.action_inicioSesionFragment_to_crearEmpresaFragment
            )
        }
    }
}
