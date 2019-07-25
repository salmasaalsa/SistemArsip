package com.example.sistemarsip.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.sistemarsip.R
import com.example.sistemarsip.adapter.DisposisiAdapter
import com.example.sistemarsip.adapter.SuratKeluarAdapter
import com.example.sistemarsip.viewModel.DisposisiViewModel
import com.example.sistemarsip.viewModel.SuratKeluarViewModel

class ActivityJumlahDisposisi : AppCompatActivity() {
    var rcView : RecyclerView? = null
    var DisposisiAdapter: DisposisiAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jumlah_disposisi)
        rcView = findViewById(R.id.rcDisposisi)
        rcView!!.setHasFixedSize(true)
        rcView!!.layoutManager = LinearLayoutManager(this)

        val ViewModel = ViewModelProviders.of(this).get(DisposisiViewModel::class.java)
        ViewModel.dataDisposisi.observeForever{
            DisposisiAdapter = DisposisiAdapter(this@ActivityJumlahDisposisi, it!!)
            rcView!!.adapter = DisposisiAdapter
        }
    }

}