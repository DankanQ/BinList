package com.example.binlist.domain.repository

import com.example.binlist.domain.entity.BinInfo

interface BinInfoRepository {

    suspend fun getBinInfo(bin: Int): BinInfo

}