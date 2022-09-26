package br.com.mooviez

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import br.com.mooviez.databinding.ActivityMainBinding
import br.com.mooviez.models.FilmeResponse
import br.com.mooviez.models.LoginRequest
import br.com.mooviez.models.LoginResponse
import br.com.mooviez.rest.Rest
import br.com.mooviez.services.Auth
import br.com.mooviez.services.Filme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var token = "Bearer ";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            tryLogin()

        }

    }

    private fun tryLogin(){

        val email = binding.emailET.text.toString()
        val password = binding.passwordET.text.toString()
        val body = LoginRequest(email, password)
        val request = Rest.getInstance().create(Auth::class.java)

        request.login(body).enqueue(object: Callback<LoginResponse>{

            // Recebendo a resposta
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                token += response.body()?.token
                print("Deu certo ao gerar o token")
                chamarFilmes()

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                print("Deu erro ao fazer login")
            }

        })

    }

    fun chamarFilmes(){

        val requestFilme = Rest.getInstance().create(Filme::class.java)

        requestFilme.listFIlme(token).enqueue(object: Callback<FilmeResponse>{

            override fun onResponse(call: Call<FilmeResponse>, response: Response<FilmeResponse>) {
                print(response.body().toString())
                print("Chegou aqui")
            }

            override fun onFailure(call: Call<FilmeResponse>, t: Throwable) {
                println("Deu erro ao chamar a lista de filmes")
                println(token)
            }


        })

    }
}