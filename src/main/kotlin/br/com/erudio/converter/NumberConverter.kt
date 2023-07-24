package br.com.erudio.converter

import br.com.erudio.validate.NumberValidate.Companion.isNumeric

class NumberConverter {
    companion object {
        fun String?.convertToDouble(): Double {
            if (this.isNullOrBlank()) return 0.0
            //BR 10,20 US 10.20
            val number = this.replace(",".toRegex(), ".")
            return if (number.isNumeric()) number.toDouble() else 0.0
        }
    }
}