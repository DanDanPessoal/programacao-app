package br.com.mooviez.services

import br.com.mooviez.models.LoginRequest
import br.com.mooviez.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Auth {

    @POST("/auth/login")
    fun login(@Body body: LoginRequest): Call<LoginResponse>

}