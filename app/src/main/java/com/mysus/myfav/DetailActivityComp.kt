package com.mysus.myfav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.mysus.myfav.databinding.ActivityDetailCompBinding
import com.mysus.myfav.model.Keiginanitem

class DetailActivityComp : AppCompatActivity() {
    private  lateinit var binding: ActivityDetailCompBinding

    companion object{
        const val DATA = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCompBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val data = intent.getParcelableExtra<Keiginanitem>(DATA)

        Glide.with(this).load(data?.imgurl).into(binding.imageView3)
        binding.txtTitle.text = data?.name
        binding.txtDesc.text = data?.Desc


    }
}