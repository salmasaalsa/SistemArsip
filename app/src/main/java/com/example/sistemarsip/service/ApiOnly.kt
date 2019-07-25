package com.example.sistemarsip.service

import com.example.sistemarsip.model.Disposisi
import com.example.sistemarsip.model.SuratKeluar
import com.example.sistemarsip.model.SuratMasuk
import retrofit2.Call
import retrofit2.http.GET

interface ApiOnly {
    @GET("suratmasuk")
    fun getSurat(): Call<List<SuratMasuk>>
    @GET("suratkeluar")
    fun getSuratKeluar(): Call<List<SuratKeluar>>
    @GET("tampildisposisi")
    fun getDisposisi(): Call<List<Disposisi>>
}