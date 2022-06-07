package com.mysus.myfav.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mysus.myfav.ViewHolder.BrandViewHolder
import com.mysus.myfav.adapter.AdapterBrand
import com.mysus.myfav.adapter.AdapterKesukaan
import com.mysus.myfav.databinding.FragmentBarangkesukaanBinding
import com.mysus.myfav.databinding.FragmentBrandBinding
import com.mysus.myfav.model.Branditem
import com.mysus.myfav.network.RetrofitInterface
import com.mysus.myfav.network.RetrofitService
import kotlinx.coroutines.launch


class BrandFragment : Fragment() {

    private lateinit var binding: FragmentBrandBinding
    private lateinit var adapterBrandBinding: AdapterBrand
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBrandBinding.inflate(inflater, container, false)
        adapterBrandBinding = AdapterBrand()
        binding.rvBrand.adapter = adapterBrandBinding
        binding.rvBrand.setHasFixedSize(true)
        binding.rvBrand.layoutManager = LinearLayoutManager(context)
        return binding.root

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val mintadataBrand = retrofitService.getbrand()

            if (mintadataBrand.isSuccessful) {
                val databrand = mintadataBrand.body()as List<Branditem>
                adapterBrandBinding.addata(databrand)
                adapterBrandBinding.notifyDataSetChanged()

            }

        }

    }

}


