package com.example.graficarpixeles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuProgramas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_programas)

        val btn01 = findViewById<Button>(R.id.btn01)
        val btn02 = findViewById<Button>(R.id.btn02)
        val btn03 = findViewById<Button>(R.id.btn03)
        val btn04 = findViewById<Button>(R.id.btn04)
        val btn05 = findViewById<Button>(R.id.btn05)
        val btn06 = findViewById<Button>(R.id.btn06)

        btn01.setOnClickListener {
            val intento = Intent(this, MediaRecorder::class.java)
            startActivity(intento)
        }

        btn02.setOnClickListener {
            val intento = Intent(this, GraficarPixeles::class.java)
            startActivity(intento)
        }

        btn03.setOnClickListener {
            val intento = Intent(this, FondoyLineas::class.java)
            startActivity(intento)
        }

        btn04.setOnClickListener {
            val intento = Intent(this, Circulo::class.java)
            startActivity(intento)
        }

        btn05.setOnClickListener {
            val intento = Intent(this, SQLActivity::class.java)
            startActivity(intento)
        }

        btn06.setOnClickListener {
            val intento = Intent(this, ReproduccionAudio::class.java)
            startActivity(intento)
        }

    }
}
