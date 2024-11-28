package com.example.examen_antonio_martinez_segura

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Resultado : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Recogemos el textView para poder acceder a el
        val resultado = findViewById<TextView>(R.id.TVresultado)

        //Recoger los putExtra de la activity anterior

        val user: String = intent.extras?.getString("usuario").orEmpty()
        val password: String = intent.extras?.getString(("contraseña")).orEmpty()

        //modificamos el contenido del resultTV

        resultado.text = "Se ha logueado correctamente \n Usuario: $user \n Contraseña: $password"
    }
}