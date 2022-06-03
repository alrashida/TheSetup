package com.mysus.myfav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.mysus.myfav.databinding.ActivityDetailSetupBinding
import com.mysus.myfav.model.KesukaanItem

class DetailActivitySetup : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSetupBinding

    companion object {
        const val DATA = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSetupBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val data = intent.getParcelableExtra<KesukaanItem>(DATA)

        Glide.with(this).load(data?.imgurl).into(binding.imageView3)
        binding.txtTitle.text = data?.name
        binding.txtDesc.text = data?.Desc


    }
}