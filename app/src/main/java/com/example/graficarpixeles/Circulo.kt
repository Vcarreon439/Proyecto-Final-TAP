package com.example.graficarpixeles

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.appcompat.app.AppCompatActivity

class Circulo: AppCompatActivity() {

    var cordX = 0f
    var cordY = 0f

    private lateinit var fondo: Circulo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circulo)

        val layout = findViewById<ConstraintLayout>(R.id.layoutCirculo)
        val fondo = Circulo(this)
        layout.addView(fondo)

        fondo.setOnTouchListener{
            view, motionEvent ->
            cordX = motionEvent.x
            cordY = motionEvent.y
            fondo.invalidate()
            true
        }

    }

    inner class Circulo(context: Context) : View(context) {
        override fun onDraw(canvas: Canvas) {
            canvas.drawRGB(255, 255, 0)
            val pincel1 = Paint()
            pincel1.setARGB(255, 255, 0, 0)
            pincel1.setStrokeWidth(4f)
            pincel1.setStyle(Paint.Style.STROKE)
            canvas.drawCircle(cordX, cordY, 20f, pincel1)
        }
    }



}
