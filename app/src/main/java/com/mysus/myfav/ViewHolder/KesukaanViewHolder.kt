package com.mysus.myfav.ViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mysus.myfav.databinding.ItemBarangkesukaanBinding
import com.mysus.myfav.model.KesukaanItem

class KesukaanViewHolder(val KesukaanBinding: ItemBarangkesukaanBinding):
 RecyclerView.ViewHolder(KesukaanBinding.root){
     fun bindView(item: KesukaanItem){
   itemView.run {
       KesukaanBinding.txtJudulkesukaan.text = item.name

       Glide.with(this).load(item.imgurl).into(KesukaanBinding.imgkesukaan)
   }
     }

}
