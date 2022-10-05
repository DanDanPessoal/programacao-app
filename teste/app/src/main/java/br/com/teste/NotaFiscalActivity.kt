package br.com.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.teste.databinding.ActivityFigurinhaBinding
import br.com.teste.databinding.ActivityNotaFiscalBinding

class NotaFiscalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotaFiscalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotaFiscalBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setarTexto();
        binding.tvValorTotal.setText(intent.getStringExtra("total"))
    }

    private fun setarTexto(){

        var valores = "";
        var qtdNey = intent.getIntExtra("qtdNey", 0)
        var qtdCris = intent.getIntExtra("qtdCris", 0);
        var qtdMessi = intent.getIntExtra("qtdMessi", 0);

        var totalQtdFigurinhas = qtdNey + qtdCris + qtdMessi

        if(totalQtdFigurinhas == 0){

            valores = "Sem figurinhas compradas"

        }else {

            while (qtdNey != 0) {

                valores += "1x Neymar JR - R$ 30,00\n"
                qtdNey--

            }

            while (qtdCris != 0) {

                valores += "1x Cristiano Ronaldo - R$ 40,00\n"
                qtdCris--

            }

            while (qtdMessi != 0) {

                valores += "1x Lionel Messi - R$ 50,00\n"
                qtdMessi--

            }

        }
        binding.tvQtdEValor.setText(valores)

    }

}