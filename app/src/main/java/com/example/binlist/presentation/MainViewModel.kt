package com.example.binlist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlist.data.repository.BinInfoRepositoryImpl
import com.example.binlist.domain.entity.BinInfo
import com.example.binlist.domain.usecases.GetBinInfoUseCase
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = BinInfoRepositoryImpl()

    private val getBinInfoUseCase = GetBinInfoUseCase(repository)

    private val _binInfo = MutableLiveData<BinInfo>()
    val binInfo: LiveData<BinInfo>
        get() = _binInfo

    private val _httpError = MutableLiveData<String>()
    val httpError: LiveData<String>
        get() = _httpError

    private val _errorInputBin = MutableLiveData<Boolean>()
    val errorInputBin: LiveData<Boolean>
        get() = _errorInputBin

    private fun validateInput(bin: String): Boolean {
        return if (bin.isBlank()) {
            _errorInputBin.postValue(true)
            false
        } else {
            true
        }
    }

    fun loadBinInfo(bin: String) {
        if (validateInput(bin)) {
            viewModelScope.launch {
                try {
                    resetHttpError()
                    _binInfo.postValue(getBinInfoUseCase(bin.toInt()))
                } catch (e: retrofit2.HttpException) {
                    val errorMessage = when (e.code()) {
                        HTTP_ERROR_404 -> "Matching cards are not found"
                        HTTP_ERROR_429 -> "Requests are throttled at 10 per minute"
                        else -> "Invalid card number for request"
                    }
                    showHttpError(errorMessage)
                } catch (e: Exception) {
                    showHttpError(e.toString())
                }
            }
        }
    }

    private fun showHttpError(errorMessage: String) {
        _httpError.postValue(errorMessage)
    }

    private fun resetHttpError() {
        _httpError.postValue(null)
    }

    companion object {
        private const val HTTP_ERROR_404 = 404
        private const val HTTP_ERROR_429 = 429
    }

}