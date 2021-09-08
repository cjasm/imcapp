package com.cjasm.imcapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        calcularButton?.setOnClickListener {
            calcularIMC(pesoEdit.text.toString(), alturaEdit.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null){
            val imc = peso / (altura.pow(2))
            resultado?.text = "Seu imc é: %.2f".format(imc)
            resultado?.visibility = TextView.VISIBLE

            classificacao?.text = when(imc){
                in 0.0..18.49 -> "Magreza"
                in 18.5..24.99 -> "Saudável"
                in 25.0..29.99 -> "Sobrepeso"
                in 30.0..34.99 -> "Obesidade I"
                in 35.0..39.99 -> "Obesidade II"
                in 40.0..99.99 -> "Obesidade III"
                else -> "Não Classificado"
            }
            classificacao?.visibility = TextView.VISIBLE
        }
    }
}