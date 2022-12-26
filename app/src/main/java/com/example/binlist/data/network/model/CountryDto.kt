package com.example.binlist.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("numeric")
    @Expose
    val numeric: String?,
    @SerializedName("alpha2")
    @Expose
    val alpha2: String?,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("emoji")
    @Expose
    val emoji: String?,
    @SerializedName("currency")
    @Expose
    val currency: String?,
    @SerializedName("latitude")
    @Expose
    val latitude: Double?,
    @SerializedName("longitude")
    @Expose
    val longitude: Double?
)