package br.bruno.whatsapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.bruno.whatsapp.R
import br.bruno.whatsapp.data.Pessoa

class RecycleAdapter(val context: Context?, val listaDePessoa: List<Pessoa>) :
    RecyclerView.Adapter<RecycleAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var layoutInflater = LayoutInflater.from(context).inflate(
            R.layout.recycler_item,
            parent, false)
        return viewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.imageView.setImageResource(listaDePessoa[position].foto)
        holder.textView.text = listaDePessoa[position].nome
        holder.textMsgView.text = listaDePessoa[position].msg
    }

    override fun getItemCount(): Int {
        return listaDePessoa.size
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView.findViewById<ImageView>(R.id.fotoPessoa)
        var textView = itemView.findViewById<TextView>(R.id.txtNome)
        var textMsgView = itemView.findViewById<TextView>(R.id.txtMsg)

    }
}