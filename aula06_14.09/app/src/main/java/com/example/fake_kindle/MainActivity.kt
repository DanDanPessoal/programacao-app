package com.example.fake_kindle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.fake_kindle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // lateinit é um contrato falando que vou dar valor para ela em outro momento
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // o inflate transforma oq é xml para uma classe
        binding = ActivityMainBinding.inflate(layoutInflater)

        // binding.root pega o xml, no root ele guarda o original, oq era antes do inflate
        setContentView(binding.root)

        binding.ivHpPedra.setOnClickListener{
            irTelaLeitor(

                getString(R.string.title_hpPedraFilosofal),
                getString(R.string.text_hpPedraFilosofal)

            )
        }

        binding.ivHpAzkaban.setOnClickListener{

            irTelaLeitor(

                getString(R.string.title_hpAzkaban),
                getString(R.string.text_hpAzkaban)

            )
        }

        binding.ivHpCalice.setOnClickListener {

            irTelaLeitor(

                getString(R.string.title_hpCaliceFogo),
                getString(R.string.text_hpCaliceFogo)

            )
        }

        binding.ivHpCamara.setOnClickListener {

            irTelaLeitor(
                getString(R.string.title_hpCamaraSecreta),
                getString(R.string.text_hpCamaraSecreta)

            )

        }

    }

    private fun irTelaLeitor(titulo: String, texto: String) {

        val telaLeitor = Intent(this, TelaLeitor::class.java)

        telaLeitor.putExtra("titulo", titulo)
        telaLeitor.putExtra("texto", texto)

        startActivity(telaLeitor)

    }
}