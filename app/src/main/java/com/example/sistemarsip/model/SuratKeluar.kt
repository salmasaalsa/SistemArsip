package com.example.sistemarsip.model

import com.google.gson.annotations.SerializedName

class SuratKeluar {
    @SerializedName ("id_surat")
    lateinit var id_surat: String
    @SerializedName ("no_agenda")
    lateinit var no_agenda: String
    @SerializedName ("tujuan")
    lateinit var tujuan: String
    @SerializedName ("no_surat")
    lateinit var no_surat : String
    @SerializedName ("isi")
    lateinit var isi: String
    @SerializedName ("kode")
    lateinit var kode: String
    @SerializedName ("tgl_surat")
    lateinit var tgl_surat: String
    @SerializedName ("tgl_catat")
    lateinit var tgl_catat: String
    @SerializedName ("file")
    lateinit var file: String
    @SerializedName ("keterangan")
    lateinit var keterangan: String
    @SerializedName("id_user")
    lateinit var id_user: String
    constructor(){}
    constructor(tujuan: String, keterangan: String, tgl_surat: String){
        this.tujuan = tujuan
        this.keterangan = keterangan
        this.tgl_surat = tgl_surat

    }

}