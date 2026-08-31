package com.clemente.consolasistemacuotas


data class Producto(
    val nombre: String,
    val precio: Double,
    val cantidad: Int
) {

    fun calcularMontoInicial(): Double {
        return precio * cantidad
    }
}