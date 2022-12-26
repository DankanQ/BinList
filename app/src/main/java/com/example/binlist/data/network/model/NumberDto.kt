package com.example.binlist.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NumberDto(
    @SerializedName("length")
    @Expose
    val length: Int?,
    @SerializedName("luhn")
    @Expose
    val luhn: Boolean?
)
