package com.example.palindrome

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editText = findViewById<EditText>(R.id.inputText)
        val resultText = findViewById<TextView>(R.id.textResult)

        fun verifyPalidrome(view: View){
            val word = editText.text.toString()

            if(word.lowercase() == word.lowercase().reversed()) {
                resultText.text = "A palavra $word é um palidromo!"
            } else {
                resultText.text = "A palavra $word não é um palindromo!"
            }

        }

        findViewById<Button>(R.id.btnVerificar).setOnClickListener { view ->
            verifyPalidrome(view)
        }




    }

}

