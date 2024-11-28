package com.example.examenmiraveteperezjuan

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultLoginActivity : AppCompatActivity() {

    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        //el id esta en el layaut de la otra página

        //Recoger los putExtra de la activity anterior
        val user: String = intent.extras?.getString("user").orEmpty()
        val password: String = intent.extras?.getString("password").orEmpty()
        // ? -> En el caso que pueda ser o no null.

        //Modificamos el contenido del resultTV.
        resultTV.text = "Usuario: $user \n Ccontraseña: $password \n ¿Deseas cambiar estos parámetros?"
        resultTV.textSize = 22f
        resultTV.setTextColor(getColor(R.color.white))
        resultTV.setLineSpacing(1.5f, 1.0f)

    }

    private fun initComponents() {
        this.resultTV = findViewById<TextView>(R.id.resultTVLogin)
    }

}