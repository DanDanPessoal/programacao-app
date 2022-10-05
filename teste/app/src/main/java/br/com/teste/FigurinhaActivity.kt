package br.com.teste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.teste.databinding.ActivityFigurinhaBinding

class FigurinhaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFigurinhaBinding;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityFigurinhaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.tvNome.setText(intent.getStringExtra("nome"))
        binding.tvNasc.setText(intent.getStringExtra("nascimento"))
        binding.tvPais.setText(intent.getStringExtra("pais"))

        when(intent.getStringExtra("img")){

            "img1" -> binding.ivImg.setImageDrawable(getDrawable(R.drawable.ney))
            "img2" -> binding.ivImg.setImageDrawable(getDrawable(R.drawable.cris))
            "img3" -> binding.ivImg.setImageDrawable(getDrawable(R.drawable.messi))

        }

        binding.btnBack.setOnClickListener {

           startActivity(Intent(this, MainActivity::class.java)).

        }

    }
}