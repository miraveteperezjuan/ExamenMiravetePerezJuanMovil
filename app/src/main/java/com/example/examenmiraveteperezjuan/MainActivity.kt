package com.example.examenmiraveteperezjuan

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    //Creamos las variables privadas con iniciacion tardia para recoger los elementos visuales
    private lateinit var emailET: EditText
    private lateinit var passwordET: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.loginButton).setOnClickListener {
            initComponents()

            if (emailET.text.isNotEmpty() && passwordET.text.isNotEmpty()) {
                val intent = Intent(this, ResultLoginActivity::class.java)
                intent.putExtra("user", emailET.text.toString())
                intent.putExtra("password", passwordET.text.toString())
                startActivity(intent)
            } else {
                emailET.setTextColor(Color.RED)
                emailET.setText("Debes rellenar el siguiente campo")
                passwordET.setTextColor(Color.RED)
                passwordET.setText("Debes rellenar el siguiente campo")
            }

        }
    }

    private fun initComponents() {
        this.emailET = findViewById(R.id.emailET)
        this.passwordET = findViewById(R.id.passwordET)
        this.loginButton = findViewById(R.id.loginButton)
    }

}