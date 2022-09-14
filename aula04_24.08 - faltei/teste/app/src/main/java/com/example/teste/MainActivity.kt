package com.example.teste

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

    fun validarCampos(etCandidato1: EditText,
                      etCandidato2: EditText,
                      etVotos1: EditText,
                      etVotos2: EditText): Boolean{

        return when{

            etCandidato1.text.isEmpty() -> {

                etCandidato1.error = "Campo Vazio"
                return false

            }
            etCandidato1.text.length < 2-> {

                etCandidato1.error = "Nome deve conter pelo menos 2 caracteres"
                return false

            }

            etCandidato2.text.isEmpty() -> {

                etCandidato2.error = "Campo Vazio"
                return false

            }

            etCandidato2.text.length < 2-> {

                etCandidato1.error = "Nome deve conter pelo menos 2 caracteres"
                return false

            }

            etVotos1.text.isEmpty() ||
            etVotos1.text.toString().toInt() <= 0 -> {

                etVotos1.error = "Campo vazio ou valor inválido"
                return false

            }

            etVotos2.text.isEmpty() ||
            etVotos2.text.toString().toInt() <= 0 ->{

                etVotos2.error = "Campo vazio ou valor inválido"
                return false

            }

            etVotos1.text.toString().toInt() == etVotos2.text.toString().toInt() ->{

                etVotos1.error = "Não pode haver empate"
                etVotos2.error = "Não pode haver empate"
                return false

            }
            else -> true

        }
    }

    fun editaTextoResultado(vencedor: EditText, porcentagem: Double, cor: Int){

        val tv_textoResultado: TextView = findViewById(R.id.tv_textoResultado)
        val texto = "Candidato ${vencedor.text.toString()} " +
                "venceu com ${"%.2f".format(porcentagem)}% dos votos";

        tv_textoResultado.setTextColor(cor)
        tv_textoResultado.setText(texto)

    }

    fun calculaVencedor(v: View){

        val etNomeCandidato1: EditText = findViewById(R.id.et_candidato1)
        val etNomeCandidato2: EditText = findViewById(R.id.et_candidato2)
        val etVotos1: EditText = findViewById(R.id.et_votos1)
        val etVotos2: EditText = findViewById(R.id.et_votos2)


        if(validarCampos(etNomeCandidato1,etNomeCandidato2,etVotos1,etVotos2)){

            val valorVotos1 = etVotos1.text.toString().toDouble();
            val valorVotos2 = etVotos2.text.toString().toDouble();

            val total = valorVotos1 + valorVotos2

            if( valorVotos1 > valorVotos2){

                editaTextoResultado(etNomeCandidato1, ((valorVotos1/total)*100),
                    getColor(R.color.candidato1))

            }else{

                editaTextoResultado(etNomeCandidato2, ((valorVotos2/total)*100),
                    getColor(R.color.candidato2))

            }
        }
    }

}