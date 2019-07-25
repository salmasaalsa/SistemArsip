package com.example.sistemarsip.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sistemarsip.R
import com.example.sistemarsip.activity.DetailSuratKeluarActivity
import com.example.sistemarsip.model.SuratKeluar

class SuratKeluarAdapter: RecyclerView.Adapter<SuratKeluarAdapter.SuratKeluarViewHolder> {
    lateinit var listSuratKeluar: List<SuratKeluar>
    lateinit var mContext : Context
    constructor(){}
    constructor(mContext : Context, listSuratKeluar: List<SuratKeluar>){
        this.mContext = mContext
        this.listSuratKeluar = listSuratKeluar
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SuratKeluarViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_row, p0, false)
        view.setOnClickListener {
            val surat = listSuratKeluar[p1]
            val intent = Intent (mContext, DetailSuratKeluarActivity::class.java)
            intent.putExtra("gambar", surat.file )
            intent.putExtra("no_surat", surat.no_surat )
            intent.putExtra("kode", surat.kode )
            intent.putExtra("no_agenda", surat.no_agenda )
            intent.putExtra("tujuan", surat.tujuan )
            intent.putExtra("tgl_surat", surat.tgl_surat )
            intent.putExtra("tgl_catat", surat.tgl_catat )
            mContext.startActivity(intent)
        }
        return SuratKeluarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSuratKeluar.size
    }

    override fun onBindViewHolder(p0: SuratKeluarViewHolder, p1: Int) {
        val suratkeluar = listSuratKeluar[p1]
        p0.tujuan.text = suratkeluar.tujuan
        p0.keterangan.text = suratkeluar.keterangan
        p0.tgl_surat.text = suratkeluar.tgl_surat
    }

    class SuratKeluarViewHolder(v: View): RecyclerView.ViewHolder(v) {
        var tujuan : TextView
        var keterangan : TextView
        var tgl_surat : TextView
        init {
            tujuan = v.findViewById(R.id.tujuan_surat)
            keterangan = v.findViewById(R.id.keterangan)
            tgl_surat = v.findViewById(R.id.tgl_surat)
        }

    }
}