package com.mysus.myfav.ViewHolder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mysus.myfav.adapter.AdapterBrand
import com.mysus.myfav.adapter.AdapterKesukaan
import com.mysus.myfav.databinding.ItemRecyclerBrandBinding
import com.mysus.myfav.model.Branditem

class BrandViewHolder(val brandbinding: ItemRecyclerBrandBinding) :
    RecyclerView.ViewHolder(brandbinding.root) {
    @SuppressLint("NotifyDataSetChanged")
    fun bindview(item: Branditem) {
        val adaterBrad = AdapterKesukaan()
        itemView.run {
            brandbinding.txtTitleBrand.text = item.namaBrand
            brandbinding.recyclerViewBrand.setHasFixedSize(true)
            brandbinding.recyclerViewBrand.layoutManager = LinearLayoutManager(context)
            brandbinding.recyclerViewBrand.adapter = adaterBrad
        }
        adaterBrad.adddata(item.data)
        adaterBrad.notifyDataSetChanged()
    }

}
