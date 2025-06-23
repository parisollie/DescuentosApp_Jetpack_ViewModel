package com.pjff.descuentosapp.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pjff.descuentosapp.model.CalcularState

//Vid 81
class CalcularViewModel3 : ViewModel() {

    var state by mutableStateOf(CalcularState())
        private set

    fun onValue(value: String, text: String) {
        when (text) {
            //Ponemos copy para copiar u hcemos la modificacion de la variable.
            "precio" -> state = state.copy(precio = value)
            "descuento" -> state = state.copy(descuento = value)
        }
    }

    fun calcular() {
        //Vid 82
        val precio = state.precio
        val descuento = state.descuento
        state = if (precio != "" && descuento != "") {
            //Vid 82
            state.copy(
                precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble()),
                totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
            )
        } else {
            state.copy(
                showAlert = true
            )
        }
    }

    private fun calcularPrecio(precio: Double, descuento: Double): Double {
        val res = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(res * 100) / 100.0
    }

    private fun calcularDescuento(precio: Double, descuento: Double): Double {
        val res = precio * (1 - descuento / 100)
        return kotlin.math.round(res * 100) / 100.0
    }

    fun limpiar() {
        //Vid 82
        state = state.copy(
            precio = "",
            descuento = "",
            precioDescuento = 0.0,
            totalDescuento = 0.0
        )
    }

    //Vid 82
    fun cancelAlert() {
        state = state.copy(
            showAlert = false
        )
    }


}