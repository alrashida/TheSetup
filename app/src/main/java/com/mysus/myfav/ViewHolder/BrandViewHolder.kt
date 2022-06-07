package com.mysus.myfav.ViewHolder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mysus.myfav.adapter.AdapterKesukaan
import com.mysus.myfav.databinding.FragmentBrandBinding
import com.mysus.myfav.databinding.ItemRecyclerBrandBinding
import com.mysus.myfav.model.Branditem

class BrandViewHolder(val brandbinding: ItemRecyclerBrandBinding) :
    RecyclerView.ViewHolder(brandbinding.root) {
    fun bindview(item: Branditem) {
        var adaterKesukaan = AdapterKesukaan()
        itemView.run {
            brandbinding.txtTitleBrand.text = item.namaBrand
            brandbinding.recyclerViewBrand.setHasFixedSize(true)
            brandbinding.recyclerViewBrand.layoutManager = LinearLayoutManager(context)
            brandbinding.recyclerViewBrand.adapter = adaterKesukaan
        }
        adaterKesukaan.adddata(item.data)
        adaterKesukaan.notifyDataSetChanged()
    }

}
