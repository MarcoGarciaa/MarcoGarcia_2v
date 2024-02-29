package com.example.marcogarcia_2v

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SaveActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var textView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)
        btn = findViewById(R.id.btn)
        textView = findViewById(R.id.textView)

        var listaVideoJuego: ArrayList<videojuego> = intent.getSerializableExtra("listaVideojuego") as ArrayList<videojuego>

        //Creamos la instancia de la clase DatabaseHelper, nos va a permitir acceder a los recursos de la aplicación
        val dbHelper = DatabaseHelper(this)


        val lista2 = dbHelper.lectura()

        textView.text = lista2.joinToString ("\n")

        val intent = Intent(this@SaveActivity, MainActivity::class.java)
        intent.putExtra("listaVideojuego",listaVideoJuego)
        startActivity(intent)




    }
}

