package com.mysus.myfav.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mysus.myfav.ViewHolder.BrandViewHolder
import com.mysus.myfav.databinding.ItemRecyclerBrandBinding
import com.mysus.myfav.model.Branditem

class AdapterBrand : RecyclerView.Adapter<BrandViewHolder>() {
    private var listbrand = arrayListOf<Branditem>()

    fun addata(items: List<Branditem>){
        listbrand.clear()
        listbrand.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val listItemBrandbinding = ItemRecyclerBrandBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BrandViewHolder(listItemBrandbinding)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val data = listbrand[position]
        holder.bindview(data)

    }

    override fun getItemCount(): Int {
        return listbrand.size
    }

}