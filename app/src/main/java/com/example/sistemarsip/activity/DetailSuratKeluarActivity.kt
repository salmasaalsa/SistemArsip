package com.example.sistemarsip.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bumptech.glide.Glide
import com.example.sistemarsip.R
import kotlinx.android.synthetic.main.detail_surat_keluar.*
import kotlinx.android.synthetic.main.detail_surat_masuk.*

class DetailSuratKeluarActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_surat_keluar)
        val gambar = intent.getStringExtra("gambar")
        val nom_surat = intent.getStringExtra("no_surat")
        val kode_surat = intent.getStringExtra("kode")
        val nom_agenda = intent.getStringExtra("no_agenda")
        val tujuan = intent.getStringExtra("tujuan")
        val tgll_surat = intent.getStringExtra("tgl_surat")
        val tgll_catat = intent.getStringExtra("tgl_catat")
        val url = "http://172.16.10.127:8000/${gambar}"
        Log.w("tag", "ttt $gambar")
        no_surat_keluar.text = nom_surat
        kode_surat_keluar.text = kode_surat
        no_agenda_keluar.text = nom_agenda
        tujuan_surat_keluar.text = tujuan
        tgl_surat_keluar.text = tgll_surat
        tgl_catat.text = tgll_catat
        Glide.with(this).load(url).into(gambar_surat_keluar)
    }
}
