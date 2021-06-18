package com.example.graficarpixeles

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SQLActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlactivity)

        val btnAlta = findViewById<Button>(R.id.btnAlta)
        val btnConsultaCod = findViewById<Button>(R.id.btnConsultaCod)
        val btnConsultaDesc = findViewById<Button>(R.id.btnConsultaDesc)
        val btnBajaCod = findViewById<Button>(R.id.btnBajaCod)
        val btnModificar = findViewById<Button>(R.id.btnModificacion)
        val edCodigo = findViewById<EditText>(R.id.edCodigo)
        val edDescripcion = findViewById<EditText>(R.id.edDescripcion)
        val edPrecio = findViewById<EditText>(R.id.edPrecio)

        btnAlta.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this,"administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("codigo", edCodigo.getText().toString().toInt())
            registro.put("descripcion", edDescripcion.getText().toString())
            registro.put("precio", edPrecio.getText().toString().toDouble())
            bd.insert("articulos", null, registro)
            bd.close()
            edCodigo.setText("")
            edDescripcion.setText("")
            edPrecio.setText("")
            Toast.makeText(this, "Se cargaron los datos del artículo", Toast.LENGTH_SHORT).show()
        }

        btnConsultaCod.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select descripcion, precio from articulos where codigo=${edCodigo.text.toString().toInt()}", null)
                if (fila.moveToFirst()) {
                    edDescripcion.setText(fila.getString(0))
                    edPrecio.setText(fila.getString(1))
                } else
                    Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show()
                    bd.close()
        }

        btnConsultaDesc.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select codigo,precio from articulos where descripcion='${edDescripcion.text.toString()}'", null)
                if (fila.moveToFirst()) {
                    edCodigo.setText(fila.getString(0))
                    edPrecio.setText(fila.getString(1))
                } else
                    Toast.makeText(this, "No existe un artículo con dicha descripción", Toast.LENGTH_SHORT).show()
                    bd.close()
        }

        btnBajaCod.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("articulos", "codigo=${edCodigo.text.toString()}",
                null)
            bd.close()
            edCodigo.setText("")
            edDescripcion.setText("")
            edDescripcion.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el artículo con dicho código", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show()
        }

        btnModificar.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("descripcion", edDescripcion.text.toString())
            registro.put("precio", edPrecio.text.toString().toDouble())
            val cant = bd.update("articulos", registro, "codigo=${edCodigo.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "no existe un artículo con el código ingresado", Toast.LENGTH_SHORT).show()
        }
    }
}
