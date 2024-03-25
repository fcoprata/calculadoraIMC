package com.example.meuprimeiroaplicativo

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificao = findViewById<TextView>(R.id.textView_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT",0.1f)

        tvResult.text = result.toString()

        val classificacao = if (result < 18.5f){
            "Abaixo do peso"
        }else if (result in 18.5f..24.9f){
            "Normal"
        }else if(result in 25.0f..29.9f){
            "Sobrepeso"
        }else if(result in 30.0f..39.9f){
            "Obesidade"
        }else {
            "Obesidade grave"
        }
        tvClassificao.text = getString(R.string.message_classifier, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}