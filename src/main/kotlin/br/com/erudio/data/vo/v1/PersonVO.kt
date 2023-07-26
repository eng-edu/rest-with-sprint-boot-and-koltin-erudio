package br.com.erudio.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import jakarta.persistence.*

@JsonPropertyOrder("id","address","firstName","lastName","genero")
data class PersonVO(
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",

    @field:JsonIgnore
    var address: String = "",

    @field:JsonProperty("genero")
    var gender: String = ""
)
