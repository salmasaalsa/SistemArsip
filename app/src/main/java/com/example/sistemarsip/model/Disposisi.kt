package com.example.sistemarsip.model

import com.google.gson.annotations.SerializedName

class Disposisi {
    @SerializedName("id_disposisi")
    lateinit var id_disposisi: String
    @SerializedName("tujuan")
    lateinit var tujuan: String
    @SerializedName("isi_disposisi")
    lateinit var isi_disposisi: String
    @SerializedName("sifat")
    lateinit var sifat: String
    @SerializedName("batas_waktu")
    lateinit var batas_waktu: String
    @SerializedName("catatan")
    lateinit var catatan: String
    @SerializedName("id_surat")
    lateinit var id_surat: String
    @SerializedName("id_user")
    lateinit var id_user: String
    constructor(){}
    constructor(tujuan: String,
                sifat: String){
        this.tujuan = tujuan
        this.sifat = sifat
    }
}