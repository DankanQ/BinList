package com.example.binlist.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BinInfoDto(
    @SerializedName("number")
    @Expose
    val number: NumberDto?,
    @SerializedName("scheme")
    @Expose
    val scheme: String?,
    @SerializedName("type")
    @Expose
    val type: String?,
    @SerializedName("brand")
    @Expose
    val brand: String?,
    @SerializedName("prepaid")
    @Expose
    val prepaid: Boolean?,
    @SerializedName("country")
    @Expose
    val country: CountryDto?,
    @SerializedName("bank")
    @Expose
    val bank: BankDto?
)