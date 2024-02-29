package com.example.marcogarcia_2v

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity  : AppCompatActivity(){
    private lateinit var textView: TextView
    private lateinit var btn: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        textView = findViewById(R.id.textView)
        btn = findViewById(R.id.btn)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)

        val videojuego: videojuego = intent.getSerializableExtra("videojuego") as videojuego
        var listaVideoJuego: ArrayList<videojuego> = intent.getSerializableExtra("listaVideojuego") as ArrayList<videojuego>




        textView.text = listaVideoJuego.joinToString ("\n")

        btn.setOnClickListener {
            val  intent = Intent(this@ThirdActivity,SecondActivity::class.java)
            intent.putExtra("listaVideojuego",listaVideoJuego)


            startActivity(intent)
        }

        btn2.setOnClickListener {

            val dbHelper = JuegosComprados(this)

            for (i in listaVideoJuego ){

                if (videojuego != null) {
                    try {
                        dbHelper.escribir(i)

                    }catch(e: Exception){


                    }

                }

            }

            listaVideoJuego = ArrayList<videojuego>()


            val intent = Intent(this@ThirdActivity, SaveActivity::class.java)
            intent.putExtra("listaVideojuego",listaVideoJuego)
            startActivity(intent)
        }

        btn3.setOnClickListener {

            val intent = Intent(this@ThirdActivity,MainActivity::class.java)
            intent.putExtra("listaVideojuego",listaVideoJuego)
            startActivity(intent)


        }


    }

}