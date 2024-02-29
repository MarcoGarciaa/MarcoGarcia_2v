package com.example.marcogarcia_2v

import java.io.Serializable

class videojuego(private var nombre:String,private var  Valoracion: Float): Serializable {
    companion object {

    }
    private var Empresa: String=""
    private var Año: Int=0

    fun setEmpresa(empresa: String){
        Empresa = empresa
    }
    fun setAño(año: Int){
        Año = año
    }

    fun getNombre(): String{
        return nombre

    }
    fun getEmpresa(): String{
        return Empresa

    }
    fun getAño(): Int{
        return Año

    }
    fun getValoracion(): Float{
        return Valoracion

    }

    fun ToString(): String{
        return "Nombre: ${nombre}, Valoracion: ${Valoracion}, Año: ${Año}, Empresa ${Empresa}"
    }
}