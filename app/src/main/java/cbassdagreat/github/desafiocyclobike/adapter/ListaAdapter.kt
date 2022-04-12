package cbassdagreat.github.desafiocyclobike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import cbassdagreat.github.desafiocyclobike.R
import cbassdagreat.github.desafiocyclobike.databinding.ItemLayoutBinding
import cbassdagreat.github.desafiocyclobike.model.Ciclovia
import java.util.ArrayList

class ListaAdapter : RecyclerView.Adapter<ListaAdapter.CustomViewHolder>(){
    var lista:List<Ciclovia> = ArrayList()
    lateinit var listener: MiListener

    class CustomViewHolder (itemView: View, val listener: MiListener) : RecyclerView.ViewHolder(itemView)
    {
        private val binding = ItemLayoutBinding.bind(itemView)
        fun bindData(ciclovia: Ciclovia)
        {
            with(binding)
            {
                tvComuna.text = ciclovia.comuna
                tvNombre.text = ciclovia.nombre
                itemView.setOnClickListener{
                    listener.miOnClickListener(ciclovia)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    fun updateLista(lista:List<Ciclovia>)
    {
        this.lista = lista
        notifyDataSetChanged()
    }

    interface  MiListener{
        fun miOnClickListener(ciclovia: Ciclovia)
    }
}

