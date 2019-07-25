package com.example.sistemarsip.model

import com.google.gson.annotations.SerializedName

class SuratMasuk {
    @SerializedName("id_surat")
    lateinit var id_surat: String
    @SerializedName("no_agenda")
    lateinit var no_agenda: String
    @SerializedName("no_surat")
    lateinit var no_surat: String
    @SerializedName("asal_surat")
    lateinit var asal_surat: String
    @SerializedName("isi")
    lateinit var isi: String
    @SerializedName("kode")
    lateinit var kode: String
    @SerializedName("indeks")
    lateinit var indeks: String
    @SerializedName("tgl_surat")
    lateinit var tgl_surat: String
    @SerializedName("tgl_diterima")
    lateinit var tgl_diterima: String
    @SerializedName("file")
    lateinit var file: String
    @SerializedName("keterangan")
    lateinit var keterangan: String
    @SerializedName("id_user")
    lateinit var id_user: String
    constructor(){}
    constructor(asal_surat: String, tgl_diterima: String, keterangan: String){
        this.asal_surat = asal_surat
        this.tgl_diterima = tgl_diterima
        this.keterangan = keterangan

    }
}