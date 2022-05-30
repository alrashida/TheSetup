package com.mysus.myfav.ViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mysus.myfav.databinding.ItemBarangkeinginanBinding
import com.mysus.myfav.model.Keiginanitem

class KeinginanViewHolder(val keinginanBinding: ItemBarangkeinginanBinding) :
    RecyclerView.ViewHolder(keinginanBinding.root) {
    fun bindview(item: Keiginanitem) {
        itemView.run {
            keinginanBinding.txtJudulgallery.text = item.name
            Glide.with(this).load(item.imgurl).into(keinginanBinding.imgkeingin)

        }
    }
}
