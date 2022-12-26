package com.example.binlist.data.repository

import com.example.binlist.data.mapper.BinInfoMapper
import com.example.binlist.data.network.ApiFactory
import com.example.binlist.domain.entity.BinInfo
import com.example.binlist.domain.repository.BinInfoRepository

class BinInfoRepositoryImpl : BinInfoRepository {

    private val apiService = ApiFactory.apiService
    private val mapper = BinInfoMapper()

    override suspend fun getBinInfo(bin: Int): BinInfo {
        val binInfoDto = apiService.getBinInfo(bin)
        return mapper.mapBinInfoDtoToEntity(binInfoDto)
    }

}