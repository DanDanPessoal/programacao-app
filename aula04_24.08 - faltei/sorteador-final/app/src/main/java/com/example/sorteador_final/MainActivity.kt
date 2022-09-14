package com.example.sorteador_final

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var saldoAtual = 100.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tvSaldoCarteira).text =
            "R$ %.2f".format(saldoAtual)
    }

    private fun camposValidos(
        etValorAposta: EditText,
        etPalpiteAposta: EditText,
    ): Boolean {
        return when {
            etValorAposta.text.isEmpty() ||
                    etValorAposta.text.toString().toDouble() <= 0.0 -> {
                etValorAposta.error = "Valor inválido para aposta"
                return false
            }
            etPalpiteAposta.text.isEmpty() ||
                    etPalpiteAposta.text.toString().toInt() !in 1..6 -> {
                etPalpiteAposta.error = "Palpite deve estar entre 1 e 6"
                return false
            }
            else -> true
        }
    }

    private fun atualizarImagem(numeroSorteado: Int) {
        val imagem = when (numeroSorteado) {
            1 -> R.drawable.ic_dado_1
            2 -> R.drawable.ic_dado_2
            3 -> R.drawable.ic_dado_3
            4 -> R.drawable.ic_dado_4
            5 -> R.drawable.ic_dado_5
            else -> R.drawable.ic_dado_6
        }
        findViewById<ImageView>(R.id.ivDado).setImageResource(imagem)
    }

    private fun atualizarCor() {
        if (saldoAtual <= 0.0) {
            val tvSaldoCarteira: TextView =
                findViewById(R.id.tvSaldoCarteira)

            val cor = getColor(R.color.primary_red)
            // AppCompatResources.getColorStateList(this, R.color.primary_red)
            tvSaldoCarteira.setTextColor(cor);
        }
    }

    private fun atualizarTexto(
        acertouAposta: Boolean,
        valorAposta: Double
    ) {
        val tvResultado: TextView = findViewById(R.id.tvResultado)
        if (acertouAposta) {
            tvResultado.text =
                "Parabéns, acertou + R$ %.2f".format(valorAposta)
        } else {
            tvResultado.text =
                "Infelizmente, errou - R$ %.2f".format(valorAposta)
        }
        atualizarCor()
    }

    private fun sortear(): Int = (1..6).random()

    private fun atualizarCarteira(numeroSorteado: Int) {
        val tvSaldoCarteira: TextView =
            findViewById(R.id.tvSaldoCarteira)
        val etPalpiteAposta: EditText =
            findViewById(R.id.etPalpiteAposta)
        val etValorAposta: EditText =
            findViewById(R.id.etValorAposta)

        var acertouAposta = false
        val valorAposta = etValorAposta.text.toString().toDouble()
        if (numeroSorteado == etPalpiteAposta.text.toString().toInt()) {
            saldoAtual += valorAposta
            acertouAposta = true
        } else {
            saldoAtual -= valorAposta
        }
        tvSaldoCarteira.text = "R$ %.2f".format(saldoAtual)
        atualizarTexto(acertouAposta, valorAposta)
    }

    fun apostar(v: View) {
        val etValorAposta: EditText = findViewById(R.id.etValorAposta)
        val etPalpiteAposta: EditText = findViewById(R.id.etPalpiteAposta)

        if (camposValidos(etValorAposta, etPalpiteAposta)) {
            val numeroSorteado = sortear()
            atualizarImagem(numeroSorteado)
            atualizarCarteira(numeroSorteado)
        }
    }
}