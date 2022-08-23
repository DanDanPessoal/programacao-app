package com.example.aula01_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.math.RoundingMode
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cal(v: View){

        val alerta = AlertDialog.Builder(this);

        val etNome: EditText = findViewById(R.id.et_input_nome);
        val etIdade: EditText = findViewById(R.id.et_input_idade);
        val etAltura: EditText = findViewById(R.id.et_input_altura);
        val etPeso: EditText = findViewById(R.id.et_input_peso);

        val peso = etPeso.text.toString().toDouble();
        val altura = etAltura.text.toString().toInt() / 100.0;

        val imc = (peso / (altura * altura)).toBigDecimal();

        alerta.setTitle("\nResultado do IMC\n")
        alerta.setMessage(""" 
        Nome: ${etNome.text.toString()}"
        Idade: ${etIdade.text.toString()}
        Peso: ${peso}
        Altura: ${altura}
        
        O resultado do seu IMC é: ${imc.setScale(2,RoundingMode.CEILING)}  """.trimIndent())

        // Alerta mais bonitinho
        alerta.create().show();

        // Alerta mais simples
        Toast.makeText(this, "Olá ${etNome.text.toString()}, seu IMC é de:" +
                " ${imc.setScale(2,RoundingMode.CEILING)}", Toast.LENGTH_LONG).show()

    }
}