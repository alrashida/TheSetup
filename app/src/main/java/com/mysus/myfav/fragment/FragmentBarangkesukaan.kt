package com.mysus.myfav.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mysus.myfav.DetailActivityComp
import com.mysus.myfav.adapter.AdapterKesukaan
import com.mysus.myfav.databinding.FragmentBarangkesukaanBinding
import com.mysus.myfav.model.KesukaanItem
import com.mysus.myfav.network.RetrofitInterface
import com.mysus.myfav.network.RetrofitService
import kotlinx.coroutines.launch


class FragmentBarangkesukaan : Fragment() {

    private lateinit var binding: FragmentBarangkesukaanBinding
    private lateinit var adapterkesukaan: AdapterKesukaan
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //utk menyambungkan recyclerView nya
        binding = FragmentBarangkesukaanBinding.inflate(inflater,container,false)
        adapterkesukaan = AdapterKesukaan()
        binding.rvkesukaan.adapter = adapterkesukaan
        binding.rvkesukaan.setHasFixedSize(true)
        binding.rvkesukaan.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val mintadataksesukaan = retrofitService.getkesukaan()

            if (mintadataksesukaan.isSuccessful){
                val datakesukaan = mintadataksesukaan.body()as List<KesukaanItem>
                adapterkesukaan.adddata(datakesukaan)
                adapterkesukaan.notifyDataSetChanged()
            }
        }
    }

}