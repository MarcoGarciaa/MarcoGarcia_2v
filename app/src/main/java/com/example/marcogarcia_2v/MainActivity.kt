package com.example.marcogarcia_2v

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nombre: EditText
    private lateinit var valoracion: EditText
    private lateinit var btn: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nombre = findViewById(R.id.editText1)
        valoracion = findViewById(R.id.editText2)
        btn = findViewById(R.id.btn)


        var listaVideoJuego: ArrayList<videojuego>


        try{
            listaVideoJuego =  intent.getSerializableExtra("listaVideojuego") as ArrayList<videojuego>



        }catch(e: Exception){
            listaVideoJuego = ArrayList<videojuego>()
        }





        btn.setOnClickListener {

            if (nombre.text.toString() != null || valoracion.text.toString().toFloat() > 0  ) {

                var videojuego: videojuego =
                    videojuego(nombre.text.toString(), valoracion.text.toString().toFloat())

                val intent = Intent(this@MainActivity, SecondActivity::class.java)

                intent.putExtra("videojuego", videojuego)
                intent.putExtra("listaVideojuego", listaVideoJuego)
                startActivity(intent)
            }
        }
    }
}


