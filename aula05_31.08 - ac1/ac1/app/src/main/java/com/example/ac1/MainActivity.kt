package com.example.ac1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validarCampos(etNome: EditText,
                      etN1: EditText,
                      etN2: EditText,
                      etN3: EditText): Boolean{

        val textoErroNota = "A nota tem que estar entre 0 e 10"
        val textoErroCampoVazio = "Campo não pode estar vazio"

        return when{

            etNome.text.isEmpty() -> {

                etNome.error = textoErroCampoVazio
                return false

            }

            etNome.text.length < 3 -> {

                etNome.error = "Deve conter pelo menos 3 letras"
                return false

            }

            etN1.text.isEmpty() ->{

                etN1.error =  textoErroCampoVazio
                return false

            }

            etN1.text.toString().toInt() < 0 ||
                    etN1.text.toString().toInt() > 10 -> {

                etN1.error = textoErroNota
                return false

            }

            etN2.text.isEmpty() ->{

                etN2.error =  textoErroCampoVazio
                return false

            }


            etN2.text.toString().toInt() < 0 ||
                    etN2.text.toString().toInt() > 10 -> {

                etN2.error = textoErroNota
                return false

            }

            etN3.text.isEmpty() ->{

                etN3.error =  textoErroCampoVazio
                return false

            }


            etN3.text.toString().toInt() < 0 ||
                    etN3.text.toString().toInt() > 10 -> {

                etN3.error = textoErroNota
                return false

            }

            else -> true

        }
    }

    fun plotarTexto(nome: String, media: Int){

        val tvTextoResultado: TextView = findViewById(R.id.tv_textoResultado)

        when{

            media < 3 -> {
                tvTextoResultado.setTextColor(getColor(R.color.cinnabar))
                tvTextoResultado.setText("Aluno: $nome. Situação: Reprovado - sem sub")
            }
            media < 5 -> {
                tvTextoResultado.setTextColor(getColor(R.color.cyan_blue))
                tvTextoResultado.setText("Aluno: $nome. Situação: Reprovado - vai pra sub")
            }
            media <= 7 -> {
                tvTextoResultado.setTextColor(getColor(R.color.Curious_blue))
                tvTextoResultado.setText("Aluno: $nome. Situação: Simplesmente aprovado")
            }
            else -> {
                tvTextoResultado.setTextColor(getColor(R.color.medium_dark_shade))
                tvTextoResultado.setText("Aluno: $nome. Situação: Aprovado com honras")
            }
        }

    }


    fun calculaMedia(v: View){

        val etNome = findViewById<EditText>(R.id.et_nome)
        val etN1 = findViewById<EditText>(R.id.et_n1)
        val etN2 = findViewById<EditText>(R.id.et_n2)
        val etN3 = findViewById<EditText>(R.id.et_n3)

        if(validarCampos(etNome,etN1,etN2,etN3)){

            val media = (etN1.text.toString().toInt() + etN2.text.toString().toInt() + etN3.text.toString().toInt()) / 3

            plotarTexto(etNome.text.toString(), media)

        }

    }

}