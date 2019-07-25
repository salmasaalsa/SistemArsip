package com.example.sistemarsip.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bumptech.glide.Glide
import com.example.sistemarsip.R
import kotlinx.android.synthetic.main.detail_disposisi.*
import kotlinx.android.synthetic.main.detail_surat_keluar.*

class DetailDisposisiActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_disposisi)
        val tujuan = intent.getStringExtra("tujuan")
        val isi_disposisii = intent.getStringExtra("isi_disposisi")
        val sifat = intent.getStringExtra("sifat")
        val batas_waktuu = intent.getStringExtra("batas_waktu")
        val catatann = intent.getStringExtra("catatan")
        tujuan_surat_disposisi.text = tujuan
        isi_disposisi.text = isi_disposisii
        sifat_disposisi.text = sifat
        batas_waktu.text = batas_waktuu
        catatan.text = catatann
    }
}