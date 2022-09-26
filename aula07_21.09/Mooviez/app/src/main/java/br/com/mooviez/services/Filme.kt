package br.com.mooviez.services

import br.com.mooviez.models.FilmeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface Filme {

    @GET("/filmes")
    fun listFIlme(@Header("Authorization") token: String): Call<FilmeResponse>

}