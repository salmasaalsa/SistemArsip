package com.example.sistemarsip.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.sistemarsip.R
import com.example.sistemarsip.viewModel.SuratKeluarViewModel
import com.example.sistemarsip.adapter.SuratKeluarAdapter

class ActivityJumlahSuratKeluar : AppCompatActivity() {
    var rcView : RecyclerView? = null
    var suratKeluarAdapter: SuratKeluarAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jumlah_surat_keluar)
        rcView = findViewById(R.id.rcSuraKeluar)
        rcView!!.setHasFixedSize(true)
        rcView!!.layoutManager = LinearLayoutManager(this)

        val ViewModel = ViewModelProviders.of(this).get(SuratKeluarViewModel::class.java)
        ViewModel.dataSurat.observeForever{
            suratKeluarAdapter = SuratKeluarAdapter(this@ActivityJumlahSuratKeluar, it!!)
            rcView!!.adapter = suratKeluarAdapter
        }
    }
}