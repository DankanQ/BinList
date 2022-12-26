package com.example.binlist.data.mapper

import com.example.binlist.data.network.model.BankDto
import com.example.binlist.data.network.model.BinInfoDto
import com.example.binlist.data.network.model.CountryDto
import com.example.binlist.data.network.model.NumberDto
import com.example.binlist.domain.entity.Bank
import com.example.binlist.domain.entity.BinInfo
import com.example.binlist.domain.entity.Country
import com.example.binlist.domain.entity.Number

class BinInfoMapper {

    fun mapBinInfoDtoToEntity(binInfoDto: BinInfoDto?) = BinInfo(
        number = mapNumberDtoToEntity(binInfoDto?.number),
        scheme = binInfoDto?.scheme ?: EMPTY_STRING_VALUE,
        type = binInfoDto?.type ?: EMPTY_STRING_VALUE,
        brand = binInfoDto?.brand ?: EMPTY_STRING_VALUE,
        prepaid = binInfoDto?.prepaid ?: EMPTY_BOOLEAN_VALUE,
        country = mapCountryDtoToEntity(binInfoDto?.country),
        bank = mapBankDtoToEntity((binInfoDto?.bank))
    )

    private fun mapBankDtoToEntity(bankDto: BankDto?) = Bank(
        name = bankDto?.name ?: EMPTY_STRING_VALUE,
        url = bankDto?.url ?: EMPTY_STRING_VALUE,
        phone = bankDto?.phone ?: EMPTY_STRING_VALUE,
        city = bankDto?.city ?: EMPTY_STRING_VALUE
    )

    private fun mapCountryDtoToEntity(countryDto: CountryDto?) = Country(
        numeric = countryDto?.numeric ?: EMPTY_STRING_VALUE,
        alpha2 = countryDto?.alpha2 ?: EMPTY_STRING_VALUE,
        name = countryDto?.name ?: EMPTY_STRING_VALUE,
        emoji = countryDto?.emoji ?: EMPTY_STRING_VALUE,
        currency = countryDto?.currency ?: EMPTY_STRING_VALUE,
        latitude = countryDto?.latitude ?: EMPTY_DOUBLE_VALUE,
        longitude = countryDto?.longitude ?: EMPTY_DOUBLE_VALUE
    )

    private fun mapNumberDtoToEntity(numberDto: NumberDto?) = Number(
        length = numberDto?.length ?: EMPTY_INT_VALUE,
        luhn = numberDto?.luhn ?: EMPTY_BOOLEAN_VALUE
    )

    companion object {
        private const val EMPTY_STRING_VALUE = ""
        private const val EMPTY_INT_VALUE = 0
        private const val EMPTY_DOUBLE_VALUE = 0.0
        private const val EMPTY_BOOLEAN_VALUE = false
    }

}