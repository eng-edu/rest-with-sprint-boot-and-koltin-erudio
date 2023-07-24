package br.com.erudio

import br.com.erudio.exceptions.UnsupportedMathOperationException
import br.com.erudio.math.MathOperation
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.sqrt

@RestController
class MathController {

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        return MathOperation.sum(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/subtract/{numberOne}/{numberTwo}"])
    fun subtract(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        return MathOperation.subtract(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/multiply/{numberOne}/{numberTwo}"])
    fun multiply(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {

        return MathOperation.multiply(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {

        return MathOperation.division(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/average/{numberOne}/{numberTwo}"])
    fun average(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        return MathOperation.average(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/square/{number}"])
    fun square(
        @PathVariable(value = "number") numberOne: String
    ): Double {
        return MathOperation.square(numberOne)
    }


}