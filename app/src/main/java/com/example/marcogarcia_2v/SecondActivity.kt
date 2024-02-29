package com.example.marcogarcia_2v

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class SecondActivity  : AppCompatActivity(){
    private lateinit var año: EditText
    private lateinit var empresa: EditText
    private lateinit var btn: Button
    private lateinit var btn2: Button

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        año = findViewById(R.id.editText1)
        empresa = findViewById(R.id.editText2)
        btn = findViewById(R.id.btn)
        btn2 = findViewById(R.id.btn2)

        val videojuego: videojuego? = intent.getSerializableExtra("videojuego") as videojuego
        val listaVideoJuego: ArrayList<videojuego> = intent.getSerializableExtra("listaVideojuego") as ArrayList<videojuego>





        btn.setOnClickListener {

            if (videojuego != null ) {
                videojuego.setAño(año.text.toString().toInt())
                videojuego.setEmpresa(empresa.text.toString())
                listaVideoJuego.add(videojuego)

            }


            val intent = Intent(this@SecondActivity,ThirdActivity::class.java)


            intent.putExtra("videojuego",videojuego)
            intent.putExtra("listaVideojuego",listaVideoJuego)
            startActivity(intent)

        }
        btn2.setOnClickListener {

            val intent = Intent(this@SecondActivity,MainActivity::class.java)
            intent.putExtra("listaVideojuego",listaVideoJuego)
            startActivity(intent)

        }





    }
}