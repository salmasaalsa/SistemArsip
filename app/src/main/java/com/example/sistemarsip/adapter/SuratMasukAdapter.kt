package com.example.sistemarsip.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sistemarsip.R
import com.example.sistemarsip.activity.DetailSuratMasukActivity
import com.example.sistemarsip.model.SuratMasuk

class SuratMasukAdapter:RecyclerView.Adapter<SuratMasukAdapter.SuratMasukViewHolder> {
    lateinit var listSuratMasuk : List<SuratMasuk>
    lateinit var mContext : Context
    constructor(){}
    constructor(mContext: Context, listSuratMasuk: List<SuratMasuk>){
        this.mContext = mContext
        this.listSuratMasuk = listSuratMasuk
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SuratMasukViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_row_suratkeluar, p0, false)
        view.setOnClickListener {
            val surat = listSuratMasuk[p1]
            val intent = Intent(mContext, DetailSuratMasukActivity::class.java)
            intent.putExtra("gambar", surat.file )
            intent.putExtra("no_surat", surat.no_surat)
            intent.putExtra("kode", surat.kode)
            intent.putExtra("no_agenda", surat.no_agenda)
            intent.putExtra("asal_surat", surat.asal_surat)
            intent.putExtra("tgl_surat", surat.tgl_surat)
            intent.putExtra("tgl_terima", surat.tgl_diterima)
            mContext.startActivity(intent)
        }
        return SuratMasukViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSuratMasuk.size
    }

    override fun onBindViewHolder(p0: SuratMasukViewHolder, p1: Int) {
        val suratmasuk = listSuratMasuk[p1]
        p0.asalsurat.text = suratmasuk.asal_surat
        p0.keterangan.text = suratmasuk.keterangan
        p0.tgl_diterima.text = suratmasuk.tgl_diterima
    }

    class SuratMasukViewHolder(v: View):RecyclerView.ViewHolder(v) {
        var asalsurat :TextView
        var tgl_diterima : TextView
        var keterangan : TextView
        init {
            asalsurat = v.findViewById(R.id.asal_surat)
            tgl_diterima = v.findViewById(R.id.tgl_terima)
            keterangan = v.findViewById(R.id.keterangan)
        }

    }
}