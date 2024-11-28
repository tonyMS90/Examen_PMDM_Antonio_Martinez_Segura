package com.example.examen_antonio_martinez_segura

import android.content.Intent
import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//no entiendo por que las id y el layout de arriba me salen en rojo
       //recojo el elemento del boton
        findViewById<AppCompatButton>(R.id.btnEntrar).setOnClickListener {
            val usuario = findViewById<EditText>(R.id.editUsername)
            val password = findViewById<EditText>(R.id.editPassword)

            if (usuario.text.isNotEmpty() && password.text.isNotEmpty()){


                //navegar a la siguiente view

                val intent = Intent(this, MainActivity::class.java)

                //Añadimos los valores o parametros que queremos pasar a la otra activity

                intent.putExtra("usuario", usuario.text.toString())
                intent.putExtra("contraseña", password.text.toString())

                //Iniciamos la otra activity
                startActivity(intent)
            }
        }
    }
}
