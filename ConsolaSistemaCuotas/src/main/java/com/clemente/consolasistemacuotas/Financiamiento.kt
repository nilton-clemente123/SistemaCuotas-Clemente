package com.clemente.consolasistemacuotas

class Financiamiento(
    val producto: Producto,
    val numeroCuotas: Int
) {

    fun obtenerPorcentajeInteres(): Double {
        return when (numeroCuotas) {
            6 -> 0.20
            12 -> 0.40
            24 -> 0.60
            else -> 0.0
        }
    }

    fun calcularInteres(): Double {
        return producto.calcularMontoInicial() * obtenerPorcentajeInteres()
    }

    fun calcularMontoPagar(): Double {
        return producto.calcularMontoInicial() + calcularInteres()
    }

    fun calcularPagoMensual(): Double {
        return calcularMontoPagar() / numeroCuotas
    }
}