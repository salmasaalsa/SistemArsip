package com.example.sistemarsip.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sistemarsip.R
import com.example.sistemarsip.activity.DetailDisposisiActivity
import com.example.sistemarsip.activity.DetailSuratKeluarActivity
import com.example.sistemarsip.model.Disposisi
import com.example.sistemarsip.model.SuratKeluar

class DisposisiAdapter: RecyclerView.Adapter<DisposisiAdapter.DisposisiViewHolder> {
    lateinit var listDisposisi: List<Disposisi>
    lateinit var mContext : Context
    constructor(){}
    constructor(mContext : Context, listDisposisi: List<Disposisi>){
        this.mContext = mContext
        this.listDisposisi = listDisposisi
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DisposisiViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_row_disposisi, p0, false)
        view.setOnClickListener {
            val surat = listDisposisi[p1]
            val intent = Intent (mContext, DetailDisposisiActivity::class.java)
            intent.putExtra("tujuan", surat.tujuan )
            intent.putExtra("isi_disposisi", surat.isi_disposisi )
            intent.putExtra("sifat", surat.sifat )
            intent.putExtra("batas_waktu", surat.batas_waktu )
            intent.putExtra("catatan", surat.catatan )
            mContext.startActivity(intent)
        }
        return DisposisiAdapter.DisposisiViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDisposisi.size
    }

    override fun onBindViewHolder(p0: DisposisiViewHolder, p1: Int) {
        val disposisi = listDisposisi[p1]
        p0.tujuan.text = disposisi.tujuan
        p0.sifat.text = disposisi.sifat
    }


    class DisposisiViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tujuan : TextView
        var sifat : TextView
        init {
            tujuan = v.findViewById(R.id.tujuan_disposisi)
            sifat = v.findViewById(R.id.sifat_surat)
        }
    }

}