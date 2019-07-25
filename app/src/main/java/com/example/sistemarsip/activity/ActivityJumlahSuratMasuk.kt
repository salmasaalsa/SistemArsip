package com.example.sistemarsip.activity


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.sistemarsip.R
import com.example.sistemarsip.viewModel.SuratMasukViewModel
import com.example.sistemarsip.adapter.SuratMasukAdapter

class ActivityJumlahSuratMasuk : AppCompatActivity() {
    var rcView : RecyclerView? = null
    var suratMasukAdapter: SuratMasukAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jumlah_surat_masuk)
        rcView = findViewById(R.id.rcSuratMasuk)
        rcView!!.setHasFixedSize(true)
        rcView!!.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProviders.of(this).get(SuratMasukViewModel::class.java)
        viewModel.dataSurat.observeForever{
            suratMasukAdapter = SuratMasukAdapter(this@ActivityJumlahSuratMasuk, it!!)
            rcView!!.adapter = suratMasukAdapter
        }

    }

}