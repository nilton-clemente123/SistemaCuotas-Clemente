package com.clemente.consolasistemacuotas

import java.time.LocalDate

class RegistroPagos(
    val financiamiento: Financiamiento
) {

    private val pagos = mutableListOf<Cuota>()

    private var saldoPendiente = financiamiento.calcularMontoPagar()

    fun registrarPago() {

        if (saldoPendiente <= 0) {
            println("La deuda ya fue cancelada completamente.")
            return
        }

        val pagoMensual = financiamiento.calcularPagoMensual()

        val nuevoSaldo = saldoPendiente - pagoMensual

        val cuota = Cuota(
            numero = pagos.size + 1,
            fecha = LocalDate.now().toString(),
            monto = saldoPendiente,
            pagoMensual = pagoMensual,
            restaPago = if (nuevoSaldo < 0) 0.0 else nuevoSaldo
        )

        pagos.add(cuota)

        saldoPendiente = cuota.restaPago

        println()
        println("Pago registrado correctamente.")
        println("Cuota N°: ${cuota.numero}")
        println("Pago realizado: S/ %.2f".format(cuota.pagoMensual))
        println("Saldo restante: S/ %.2f".format(cuota.restaPago))

        if (saldoPendiente == 0.0) {
            println()
            println("La deuda ha sido cancelada completamente.")
        }
    }

    fun mostrarPagos() {

        if (pagos.isEmpty()) {
            println("Todavía no se han registrado pagos.")
            return
        }

        println()
        println("--------------------- PAGOS REGISTRADOS ---------------------")

        println(
            "%-5s %-12s %-12s %-12s %-12s".format(
                "N°",
                "Fecha",
                "Monto",
                "Pago",
                "Resta"
            )
        )

        for (cuota in pagos) {

            println(
                "%-5d %-12s %-12.2f %-12.2f %-12.2f".format(
                    cuota.numero,
                    cuota.fecha,
                    cuota.monto,
                    cuota.pagoMensual,
                    cuota.restaPago
                )
            )
        }
    }

    fun mostrarSaldoPendiente() {
        println("Saldo pendiente: S/ %.2f".format(saldoPendiente))
    }

    fun deudaCancelada(): Boolean {
        return saldoPendiente <= 0
    }
}