package com.mysus.myfav.network


import com.mysus.myfav.model.Keiginanitem
import com.mysus.myfav.model.KesukaanItem
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("mydata/BarangKesukaan/Setup.json")
    suspend fun getkesukaan() : Response<List<KesukaanItem>>

    @GET("mydata/Barangkeiginan/Componen.json")
    suspend fun getKeinginan() : Response<List<Keiginanitem>>

}