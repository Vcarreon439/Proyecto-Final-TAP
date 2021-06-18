package com.example.graficarpixeles

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class FondoyLineas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fondoy_lienas)

        val layoutFondoLineas = findViewById<ConstraintLayout>(R.id.layoutFondoLineas)

        val fondo = Lienzo(this)
        layoutFondoLineas.addView(fondo)
    }

    class Lienzo(context: Context) : View(context) {
        override fun onDraw(canvas: Canvas) {
            canvas.drawRGB(255, 255, 0)
            val ancho = 10
            val pincel1 = Paint()
            pincel1.setARGB(34, 34, 34, 1)
            pincel1.setStrokeWidth(4f)
            canvas.drawLine(25f, 30f, ancho.toFloat(), 30f, pincel1)
            canvas.drawLine(25f, 60f, ancho.toFloat(), 60f, pincel1)
        }
    }
}