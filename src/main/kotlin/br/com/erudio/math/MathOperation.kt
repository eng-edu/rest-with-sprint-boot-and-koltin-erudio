package br.com.erudio.math

import br.com.erudio.converter.NumberConverter.Companion.convertToDouble
import kotlin.math.sqrt

class MathOperation {
    companion object {
        fun sum(
            numberOne: String?,
            numberTwo: String?
        ): Double {
            return numberOne.convertToDouble() + numberTwo.convertToDouble()
        }

        fun subtract(
            numberOne: String?,
            numberTwo: String?
        ): Double {
            return numberOne.convertToDouble() - numberTwo.convertToDouble()
        }

        fun multiply(
            numberOne: String?,
            numberTwo: String?
        ): Double {
            return numberOne.convertToDouble() * numberTwo.convertToDouble()
        }

        fun division(
            numberOne: String?,
            numberTwo: String?
        ): Double {
            return numberOne.convertToDouble() / numberTwo.convertToDouble()
        }

        fun average(
            numberOne: String?,
            numberTwo: String?
        ): Double {
            return (numberOne.convertToDouble() + numberTwo.convertToDouble()) / 2
        }

        fun square(
            number: String?
        ): Double {
            return sqrt(number.convertToDouble())
        }

    }
}