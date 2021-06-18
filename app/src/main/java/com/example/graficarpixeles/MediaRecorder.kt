package com.example.graficarpixeles

import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Environment
import java.io.File
import java.io.IOException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MediaRecorder : AppCompatActivity(), MediaPlayer.OnCompletionListener{

    private lateinit var btnGrabar: Button
    private lateinit var btnDetenerGrabacion: Button
    private lateinit var btnReproducir: Button
    private lateinit var tvEstado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_recorder)

        lateinit var recorder: MediaRecorder
        lateinit var player: MediaPlayer
        lateinit var archivo: File

        btnGrabar = findViewById<Button>(R.id.btnGrabar)
        btnDetenerGrabacion = findViewById<Button>(R.id.btnDetenerGrabacion)
        btnReproducir = findViewById<Button>(R.id.btnReproducir)
        tvEstado = findViewById<TextView>(R.id.tvEstado)


        btnGrabar.setOnClickListener {
            recorder = MediaRecorder()
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC)
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            val path = File(Environment.getExternalStorageDirectory().getPath())

            try {
                archivo = File.createTempFile("temporal", ".3gp", path);
            } catch (e: IOException) {
            }

            recorder.setOutputFile(archivo.absolutePath)

            try {
                recorder.prepare()
            } catch (e: IOException) {
            }

            recorder.start()
            tvEstado.text ="Grabando"
            btnGrabar.setEnabled(false)
            btnDetenerGrabacion.setEnabled(true)
        }

        btnDetenerGrabacion.setOnClickListener {
            recorder.stop()
            recorder.release()
            player = MediaPlayer()
            player.setOnCompletionListener(this)

            try {
                player.setDataSource(archivo.absolutePath)
            } catch (e: IOException) {
            }

            try {
                player.prepare()
            } catch (e: IOException) {
            }

            btnGrabar.setEnabled(true)
            btnDetenerGrabacion.setEnabled(false)
            btnReproducir.setEnabled(true)
            tvEstado.text = "Listo para reproducir"
        }

        btnReproducir.setOnClickListener {
            player.start();
            btnGrabar.setEnabled(false);
            btnDetenerGrabacion.setEnabled(false);
            btnReproducir.setEnabled(false);
            tvEstado.setText("Reproduciendo");
        }
    }

    override fun onCompletion(mp: MediaPlayer?) {
        btnGrabar.setEnabled(true)
        btnDetenerGrabacion.setEnabled(true)
        btnReproducir.setEnabled(true)
        tvEstado.setText("Listo")
    }

}