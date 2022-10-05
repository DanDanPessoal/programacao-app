package br.com.mooviez.models

import java.math.BigInteger

data class FilmeResponse(

    val id: Int,
    val title: String,
    val year: String,
    val image: String,
    val profit: BigInteger,
    val synopsis: String,

)
