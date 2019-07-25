package com.example.sistemarsip.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.w
import com.bumptech.glide.Glide
import com.example.sistemarsip.R
import kotlinx.android.synthetic.main.detail_surat_masuk.*

class DetailSuratMasukActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_surat_masuk)
        val gambar = intent.getStringExtra("gambar")
        val kode = intent.getStringExtra("kode")
        val nom_surat = intent.getStringExtra("no_surat")
        val nom_agenda = intent.getStringExtra("no_agenda")
        val asall_surat = intent.getStringExtra("asal_surat")
        val tgll_surat = intent.getStringExtra("tgl_surat")
        val tgll_terima = intent.getStringExtra("tgl_terima")
        val url = "http://172.16.10.127:8000/${gambar}"
        w("tag", "ttt $gambar")
        kode_surat.text = kode
        no_surat.text = nom_surat
        no_agenda.text = nom_agenda
        asal_surat.text = asall_surat
        tgl_surat.text = tgll_surat
        tgl_terima.text = tgll_terima
        Glide.with(this).load(url).into(gambar_surat)
    }
}