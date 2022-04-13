package br.bruno.whatsapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    var listaDeFragmentos = mutableListOf<Fragment>()
    var listaDeTitulo = mutableListOf<String>()

    fun add(fragmento: Fragment, titulo :String) {
        listaDeFragmentos.add(fragmento)
        listaDeTitulo.add(titulo)
    }

    override fun getCount(): Int {
        return listaDeFragmentos.size
    }

    override fun getItem(position: Int): Fragment {
        return listaDeFragmentos.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listaDeTitulo[position]
    }

}