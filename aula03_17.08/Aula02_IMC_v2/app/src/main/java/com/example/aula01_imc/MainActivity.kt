package com.example.aula01_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun camposValidos(etNome: EditText, etAltura: EditText, etPeso: EditText):Boolean{

        if(etNome.text.isEmpty()){

            etNome.error = "Valor inválido para nome"
            return false;

        }else if(etAltura.text.isEmpty() || etAltura.text.toString().toInt() <= 0){

            etAltura.error = "Valor inválido para Altura"
            return false;

        }else if(etPeso.text.isEmpty() || etPeso.text.toString().toDouble() !in(1.0..600.0)){

            etPeso.error = "Valor inválido para Peso"
            return false;

        }

        return true;

    }

    fun mostrarResultado(nome: String, idade: String, peso: Double, altura: Double, imc: Double){

        val alerta = AlertDialog.Builder(this);

        findViewById<TextView>(R.id.tv_resultado_imc).text = "Olá, $nome seu imc é ${"%.2f".format(imc)}"

        alerta.setTitle("\nResultado do IMC\n")
        alerta.setMessage(
            """ 
            Nome: $nome
            Idade: $idade
            Peso: $peso
            Altura: $altura
        
        O resultado do seu IMC é: ${"%.2f".format(imc)}  """.trimIndent())

        // Alerta mais bonitinho
        alerta.create().show();

        // Alerta mais simples
//        Toast.makeText(this, "Olá ${etNome.text.toString()}, seu IMC é de:" +
//                " ${imc.setScale(2,RoundingMode.CEILING)}", Toast.LENGTH_LONG).show()

    }

    fun cal(v: View) {

        val etNome: EditText = findViewById(R.id.et_input_nome);
        val etIdade: EditText = findViewById(R.id.et_input_idade);
        val etAltura: EditText = findViewById(R.id.et_input_altura);
        val etPeso: EditText = findViewById(R.id.et_input_peso);


        if (camposValidos(etNome, etAltura, etPeso)) {

            val peso = etPeso.text.toString().toDouble();
            val altura = etAltura.text.toString().toInt() / 100.0;
            val imc = (peso / (altura * altura)).toDouble();
            val nome = etNome.text.toString();

            mostrarResultado(nome,etIdade.text.toString(),peso, altura, imc)
        }
    }

}