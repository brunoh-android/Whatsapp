package br.bruno.whatsapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import br.bruno.whatsapp.R
import br.bruno.whatsapp.adapters.RecycleAdapter
import br.bruno.whatsapp.data.PessoaBuilder

class Fragmento1 : Fragment (R.layout.fragmento1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var pessoaBiulder = PessoaBuilder()
        pessoaBiulder.add("Maria", R.drawable.imag1,"Eiiii")
        pessoaBiulder.add("Pedro", R.drawable.imag4,"Ta em ksa?")
        pessoaBiulder.add("Caio", R.drawable.img3,"Vai me pagar não???")

        var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = RecycleAdapter(this.context,pessoaBiulder.listaDePessoas)
    }
}