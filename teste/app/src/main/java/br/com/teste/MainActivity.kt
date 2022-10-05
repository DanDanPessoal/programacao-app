package br.com.teste

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.teste.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var total = 0.0;
    private var qtdNey = 0;
    private var qtdCris = 0;
    private var qtdMessi = 0;
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnNey.setOnClickListener {

            adicionarValor(30.0)
            qtdNey++

        }

        binding.btnCris.setOnClickListener {

            adicionarValor(40.0)
            qtdCris++

        }

        binding.btnMessi.setOnClickListener {

            adicionarValor(50.0)
            qtdMessi++

        }

        binding.ivNey.setOnClickListener {

            irFigurinhaActivity("Neymar",
                "05/02/1992", "Brasil", "img1")

        }

        binding.ivCris.setOnClickListener {

            irFigurinhaActivity("Cristiano Ronaldo",
                "10/03/1990", "Portugal", "img2")

        }

        binding.ivMessi.setOnClickListener {

            irFigurinhaActivity("Lionel Messi",
                "10/10/1989", "Argentina", "img3")

        }

        binding.btnNotaFiscal.setOnClickListener {

            irNotaFiscalActivity()

        }
    }

    private fun adicionarValor(valor: Double){

        total += valor;

        binding.tvValorTotal.setText(total.toString())

    }

    private fun irFigurinhaActivity(nome: String, nascimento: String, pais: String, img: String) {

        val figurinha = Intent(this, FigurinhaActivity::class.java)

        figurinha.putExtra("nome", nome)
        figurinha.putExtra("nascimento", nascimento)
        figurinha.putExtra("pais", pais)
        figurinha.putExtra("img", img)

        startActivity(figurinha)

    }

    private fun irNotaFiscalActivity() {

        val nota = Intent(this, NotaFiscalActivity::class.java)

        nota.putExtra("qtdNey", qtdNey)
        nota.putExtra("qtdCris", qtdCris)
        nota.putExtra("qtdMessi", qtdMessi)
        nota.putExtra("total", total.toString())

        startActivity(nota)

    }
}