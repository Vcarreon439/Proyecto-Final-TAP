package com.example.graficarpixeles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout

class GraficarPixeles : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_graficar_pixeles)

            val layout1 = findViewById<ConstraintLayout>(R.id.layoutPixeles)
            val fondo = Lienzo(this)
            layout1.addView(fondo)
        }

        class Lienzo(context: Context) : View(context) {
            override fun onDraw(canvas: Canvas) {
                canvas.drawRGB(0, 0, 0)
                val ancho = getWidth()
                val alto = getHeight()
                val pincel1 = Paint()
                pincel1.setARGB(255, 255, 255, 255)
                for (x in 1..10000) {
                    var alex = (Math.random() * ancho).toFloat()
                    var aley = (Math.random() * alto).toFloat()
                    canvas.drawPoint(alex, aley, pincel1)
                }
            }
        }
    }
