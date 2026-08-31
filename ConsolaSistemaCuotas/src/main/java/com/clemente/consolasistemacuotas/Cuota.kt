package com.clemente.consolasistemacuotas

data class Cuota(
    val numero: Int,
    val fecha: String,
    val monto: Double,
    val pagoMensual: Double,
    val restaPago: Double
)