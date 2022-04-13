package br.bruno.whatsapp.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import br.bruno.whatsapp.R


class Fragmento2 : Fragment(R.layout.fragmento2) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCamera: Button = view.findViewById(R.id.btnCamera) as Button

        btnCamera.setOnClickListener {
            //valida permissão
            if (ContextCompat.checkSelfPermission(
                    requireContext(), android.Manifest.permission.CAMERA
                )
                != PackageManager.PERMISSION_GRANTED
            ) {

                //solicita permissão ao usuario
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(android.Manifest.permission.CAMERA), 1
                )
            } else {
                //inicia a tela de ligação com um telefone
                var abrirCam = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(abrirCam)
            }

        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //verifica de o request code é o mesmo que passamos na requisição
        if (requestCode == 1) {
            //verifica se o item dentro da array de permissões é permissão garantida
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(requireContext(), "Permissão garantida", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "Permissão Negada", Toast.LENGTH_LONG).show()
            }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}


