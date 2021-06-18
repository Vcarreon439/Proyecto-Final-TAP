package com.example.graficarpixeles

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ReproduccionAudio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproduccion_audio)

        val btnGato = findViewById<Button>(R.id.btnGato)
        val btnLeon = findViewById<Button>(R.id.btnLeon)

        btnGato.setOnClickListener {
            val gato = MediaPlayer.create(this, R.raw.gato)
            gato.start()
        }

        btnLeon.setOnClickListener {
            val leon = MediaPlayer.create(this, R.raw.leon)
            leon.start()
        }

    }
}