package com.example.binlist.domain.entity

data class BinInfo(
    val number: Number?,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: Country?,
    val bank: Bank?
)