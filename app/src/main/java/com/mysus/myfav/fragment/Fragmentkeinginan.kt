package com.mysus.myfav.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mysus.myfav.adapter.KeinginanAdapter
import com.mysus.myfav.databinding.FragmentFragmentkeinginanBinding
import com.mysus.myfav.model.Keiginanitem
import com.mysus.myfav.network.RetrofitInterface
import com.mysus.myfav.network.RetrofitService
import com.mysus.myfav.room.RoomDB
import kotlinx.coroutines.launch


class Fragmentkeinginan : Fragment() {


    private lateinit var binding: FragmentFragmentkeinginanBinding
    private lateinit var adapterkeinginan: KeinginanAdapter
    private lateinit var luroomDB: RoomDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFragmentkeinginanBinding.inflate(inflater, container, false)
        luroomDB = RoomDB.getRoomdatabase(context!!)
        adapterkeinginan = KeinginanAdapter()
        binding.rvkeinginan.adapter = adapterkeinginan
        binding.rvkeinginan.setHasFixedSize(true)
        binding.rvkeinginan.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //memberi nama data yang berasal dari itemkeinginan fragment
        val dataiTemKeiginan = luroomDB.roomDao().getDatabyType("Keinginan")

        dataiTemKeiginan.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                adapterkeinginan.adddata(it)
                adapterkeinginan.notifyDataSetChanged()
            } else {
                Toast.makeText(context, "Database Sedangkosong", Toast.LENGTH_SHORT).show()
            }
        })

        val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val mintadatakeinginan = retrofitService.getKeinginan()

            if (mintadatakeinginan.isSuccessful) {
                val datakeinginan = mintadatakeinginan.body() as List<Keiginanitem>
                datakeinginan.forEach {
                    it.type = "Keinginan"
                }
                luroomDB.roomDao().insertData(datakeinginan)
//                adapterkeinginan.adddata(datakeinginan)
//                adapterkeinginan.notifyDataSetChanged()
            }
        }
    }


}