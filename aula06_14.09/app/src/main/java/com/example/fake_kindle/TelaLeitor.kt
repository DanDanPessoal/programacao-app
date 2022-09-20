package com.example.fake_kindle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fake_kindle.databinding.ActivityMainBinding
import com.example.fake_kindle.databinding.ActivityTelaLeitorBinding

class TelaLeitor : AppCompatActivity() {

    private lateinit var binding: ActivityTelaLeitorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaLeitorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitle.setText(intent.getStringExtra("titulo"))
        binding.tvTexto.setText(intent.getStringExtra("texto"))

    }
}