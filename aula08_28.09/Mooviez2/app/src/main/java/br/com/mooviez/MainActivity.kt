package br.com.mooviez


import android.os.Bundle
import android.util.Log
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

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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

                var token = "Bearer " + response.body()!!.token
                chamarFilmes(token)

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.i("TAG", "ERRO: ${t.message}" )
            }

        })

        val teste = "";
    }

    private fun salvarToken(token: String){

        val preferences = getSharedPreferences(
            "CREDENCIAIS",
            MODE_PRIVATE
        )

        val editor = preferences.edit();

        editor.putString("token", token);

        editor.apply()

        irSegundaTela()
    }

    private fun irSegundaTela() {
        TODO("Not yet implemented")
    }

    fun chamarFilmes(token: String){

        val requestFilme = Rest.getInstance().create(Filme::class.java)

        requestFilme.listFIlme(token).enqueue(object: Callback<List<FilmeResponse>>{

            override fun onResponse(call: Call<List<FilmeResponse>>,
                                    response: Response<List<FilmeResponse>>) {
                val list = response.body()
            }

            override fun onFailure(call: Call<List<FilmeResponse>>, t: Throwable) {
                println("Deu erro ao chamar a lista de filmes")
                println(t.message)
            }

        })

    }
}