package com.example.binlist.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BankDto(
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("url")
    @Expose
    val url: String?,
    @SerializedName("phone")
    @Expose
    val phone: String?,
    @SerializedName("city")
    @Expose
    val city: String?
)
