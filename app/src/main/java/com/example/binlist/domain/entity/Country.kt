package com.example.binlist.domain.entity

data class Country(
    val numeric: String,
    val alpha2: String,
    val name: String,
    val emoji: String,
    val currency: String,
    val latitude: Double,
    val longitude: Double
)