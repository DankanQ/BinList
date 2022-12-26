package com.example.binlist.domain.usecases

import com.example.binlist.domain.repository.BinInfoRepository

class GetBinInfoUseCase(
    private val repository: BinInfoRepository
) {
    suspend operator fun invoke(bin: Int) = repository.getBinInfo(bin)
}