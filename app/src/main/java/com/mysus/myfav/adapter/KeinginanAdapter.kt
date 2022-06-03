package com.mysus.myfav.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mysus.myfav.DetailActivityComp
import com.mysus.myfav.databinding.ItemBarangkeinginanBinding
import com.mysus.myfav.model.Keiginanitem
import com.mysus.myfav.ViewHolder.KeinginanViewHolder

class KeinginanAdapter : RecyclerView.Adapter<KeinginanViewHolder>() {
    private var listitemkeinginan = arrayListOf<Keiginanitem>()


    fun adddata(items: List<Keiginanitem>) {
        listitemkeinginan.clear()
        listitemkeinginan.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeinginanViewHolder {
//        with viewbinding
        val listItemBarangkeinginanBinding =
            ItemBarangkeinginanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KeinginanViewHolder(listItemBarangkeinginanBinding)
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_keinginan,parent,false)
//        return KeinginanViewHolder(view)
    }

    override fun onBindViewHolder(holder: KeinginanViewHolder, position: Int) {
        val data = listitemkeinginan[position]
        holder.bindview(data)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivityComp::class.java)
            intent.putExtra(DetailActivityComp.DATA, data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listitemkeinginan.size
    }

}