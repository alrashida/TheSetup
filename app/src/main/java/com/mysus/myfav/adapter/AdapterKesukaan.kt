package com.mysus.myfav.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mysus.myfav.DetailActivitySetup
import com.mysus.myfav.databinding.ItemBarangkesukaanBinding
import com.mysus.myfav.model.KesukaanItem
import com.mysus.myfav.ViewHolder.KesukaanViewHolder
import com.mysus.myfav.model.Keiginanitem


class AdapterKesukaan : RecyclerView.Adapter<KesukaanViewHolder>() {
    private var listkesukaan = arrayListOf<KesukaanItem>()

    fun adddata(items: List<KesukaanItem>) {
        listkesukaan.clear()
        listkesukaan.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KesukaanViewHolder {
        val listItemKesukaanBinding = ItemBarangkesukaanBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return KesukaanViewHolder(listItemKesukaanBinding)
    }

    override fun onBindViewHolder(holder: KesukaanViewHolder, position: Int) {
        val data = listkesukaan[position]
        holder.bindView(data)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,DetailActivitySetup::class.java)
            intent.putExtra(DetailActivitySetup.DATA,data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listkesukaan.size
    }

}
