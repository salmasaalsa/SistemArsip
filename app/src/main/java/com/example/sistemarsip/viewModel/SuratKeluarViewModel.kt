package com.example.sistemarsip.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.sistemarsip.model.SuratKeluar
import com.example.sistemarsip.service.ApiOnly
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuratKeluarViewModel: ViewModel(){

    var listSurat : MutableLiveData<List<SuratKeluar>>? = null
    val dataSurat : LiveData<List<SuratKeluar>>
        get(){
            if (listSurat == null){
                listSurat = MutableLiveData()
                loadData()
            }
            return listSurat!!
        }
    fun loadData(){
        val retrofit = Retrofit.Builder().baseUrl("http://172.16.10.127:8000/api/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val apidata = retrofit!!.create(ApiOnly::class.java)
        val getSurat = apidata.getSuratKeluar()
        getSurat.enqueue(object : Callback<List<SuratKeluar>> {
            override fun onFailure(call: Call<List<SuratKeluar>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<SuratKeluar>>, response: Response<List<SuratKeluar>>) {
                listSurat!!.value = response.body()
            }

        })
    }
}