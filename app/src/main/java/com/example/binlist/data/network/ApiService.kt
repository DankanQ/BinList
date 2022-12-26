package com.example.binlist.data.network

import com.example.binlist.data.network.model.BinInfoDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {

    @Headers(HEADER_PARAM_ACCEPT_VERSION)
    @GET("{bin}")
    suspend fun getBinInfo(
        @Path(PATH_PARAM_BIN) bin: Int,
    ): BinInfoDto

    companion object {
        private const val HEADER_PARAM_ACCEPT_VERSION = "Accept-version: 3"
        private const val PATH_PARAM_BIN = "bin"
    }

}