package br.bruno.whatsapp.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import br.bruno.whatsapp.R

class Fragmento3 : Fragment(R.layout.fragmento3) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btnLigar: Button = view.findViewById(R.id.btnLigar) as Button

        btnLigar.setOnClickListener {
            //valida permissão
            if (ContextCompat.checkSelfPermission(
                    requireContext(), android.Manifest.permission.CALL_PHONE
                )
                != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(android.Manifest.permission.CALL_PHONE), 2
                )
            } else {
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                callIntent.data = Uri.parse("tel:" + "91XXXXXXXXXX")
                requireActivity().startActivity(callIntent)


            }

        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //verifica de o request code é o mesmo que passamos na requisição
        if (requestCode == 2) {
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