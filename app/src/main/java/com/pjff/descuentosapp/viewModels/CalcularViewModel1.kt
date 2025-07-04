package com.pjff.descuentosapp.viewModels

import androidx.lifecycle.ViewModel

class CalcularViewModel1: ViewModel() {

     //Vid 77, Primera forma párametros desde el composable
    //Retornamos los tipos de datos  Pair<Double, Pair<Double, Boolean>>
    fun calcular(precio:String, descuento:String): Pair<Double, Pair<Double, Boolean>> {
        var precioDescuento = 0.0
        var totalDescuento = 0.0
        var showAlert = false

        if(precio != "" && descuento != ""){
            precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble())
            totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
        }else{
            showAlert = true
        }
        return Pair(precioDescuento, Pair(totalDescuento, showAlert))
    }

    //Vid 77, hacemos nuestras funciones privadas

    private fun calcularPrecio(precio:Double, descuento:Double): Double{
        val res = precio - calcularDescuento(precio, descuento )
        return kotlin.math.round(res * 100) /100.0
    }

    private fun calcularDescuento(precio:Double, descuento:Double): Double {
        val res = precio * ( 1 - descuento /100 )
        return kotlin.math.round(res * 100) /100.0
    }
}