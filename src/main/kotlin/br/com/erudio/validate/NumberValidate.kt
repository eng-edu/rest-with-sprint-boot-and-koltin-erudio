package br.com.erudio.validate

import br.com.erudio.exceptions.UnsupportedMathOperationException

class NumberValidate {
    companion object {
        fun String.isNumeric(): Boolean {

            val isNullOrBlankValidate = !this.isNullOrBlank()
            val number = this.replace(",".toRegex(), ".")
            val regexValidate = number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())

            if (isNullOrBlankValidate && regexValidate) {
                return true
            } else {
                throw UnsupportedMathOperationException("Please set a numeric value!")
            }

        }
    }

}