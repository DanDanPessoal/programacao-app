package br.com.mooviez.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {

    // Emulador
    val baseUrl = "http://192.168.15.13:3000"

    // Celular Fisico
    //  val baseUrl = "http://IP_DA_MAQUINA:3000/"

    fun getInstance(): Retrofit {

        return Retrofit.Builder().
        addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl).build()

    }

}