package com.mysus.myfav.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mysus.myfav.adapter.KeinginanAdapter
import com.mysus.myfav.databinding.FragmentFragmentkeinginanBinding
import com.mysus.myfav.model.Keiginanitem
import com.mysus.myfav.network.RetrofitInterface
import com.mysus.myfav.network.RetrofitService
import kotlinx.coroutines.launch


class Fragmentkeinginan : Fragment() {


    private lateinit var binding: FragmentFragmentkeinginanBinding
    private lateinit var adapterkeinginan: KeinginanAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFragmentkeinginanBinding.inflate(inflater, container, false)
        adapterkeinginan = KeinginanAdapter()
        binding.rvkeinginan.adapter = adapterkeinginan
        binding.rvkeinginan.setHasFixedSize(true)
        binding.rvkeinginan.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val mintadatakeinginan = retrofitService.getKeinginan()

            if (mintadatakeinginan.isSuccessful) {
                val datakeinginan = mintadatakeinginan.body() as List<Keiginanitem>
                adapterkeinginan.adddata(datakeinginan)
                adapterkeinginan.notifyDataSetChanged()
            }
        }
    }


}