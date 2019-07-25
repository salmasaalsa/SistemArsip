package com.example.sistemarsip.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.sistemarsip.model.Disposisi
import com.example.sistemarsip.model.SuratMasuk
import com.example.sistemarsip.service.ApiOnly
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DisposisiViewModel: ViewModel() {
    var listDisposisi : MutableLiveData<List<Disposisi>>? = null
    val dataDisposisi: LiveData<List<Disposisi>>
        get() {
            if (listDisposisi == null){
                listDisposisi = MutableLiveData()
                loadData()
            }
            return listDisposisi!!
        }
    fun loadData(){
        val retrofit = Retrofit.Builder().baseUrl("http://172.16.10.127:8000/api/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val apidata = retrofit!!.create(ApiOnly::class.java)
        val getDisposisi = apidata.getDisposisi()
        getDisposisi.enqueue(object : Callback<List<Disposisi>> {
            override fun onFailure(call: Call<List<Disposisi>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<Disposisi>>, response: Response<List<Disposisi>>) {
                listDisposisi!!.value = response.body()
            }

        })
    }
}