package com.clemente.consolasistemacuotas



class SistemaCuotas {

    fun ejecutar() {

        println("=================================")
        println("      SISTEMA DE CUOTAS")
        println("=================================")

        print("Nombre del producto: ")
        val nombre = readln()

        print("Precio del producto: ")
        val precio = readln().toDouble()

        print("Cantidad: ")
        val cantidad = readln().toInt()

        val producto = Producto(
            nombre,
            precio,
            cantidad
        )

        println()
        println("Número de cuotas disponibles:")
        println("6 cuotas")
        println("12 cuotas")
        println("24 cuotas")

        var numeroCuotas: Int

        while (true) {

            print("Seleccione número de cuotas: ")
            numeroCuotas = readln().toInt()

            when (numeroCuotas) {
                6, 12, 24 -> break

                else -> {
                    println("Número de cuotas inválido.")
                    println("Solo puede seleccionar 6, 12 o 24.")
                }
            }
        }

        val financiamiento = Financiamiento(
            producto,
            numeroCuotas
        )

        val registroPagos = RegistroPagos(financiamiento)

        mostrarResumen(producto, financiamiento)

        var opcion: Int

        do {

            println()
            println("=================================")
            println("              MENÚ")
            println("=================================")
            println("1. Registrar pago")
            println("2. Ver pagos realizados")
            println("3. Ver resumen")
            println("4. Salir")

            print("Seleccione una opción: ")
            opcion = readln().toInt()

            when (opcion) {

                1 -> {
                    registroPagos.registrarPago()
                }

                2 -> {
                    registroPagos.mostrarPagos()
                }

                3 -> {
                    mostrarResumen(producto, financiamiento)
                }

                4 -> {
                    println("Saliendo del sistema...")
                }



                else -> {
                    println("Opción inválida.")
                }
            }

        } while (opcion != 4)
    }

    fun mostrarResumen(
        producto: Producto,
        financiamiento: Financiamiento
    ) {

        println()
        println("--------- RESUMEN ---------")
        println("Producto: ${producto.nombre}")
        println("Precio: S/ %.2f".format(producto.precio))
        println("Cantidad: ${producto.cantidad}")

        println(
            "Monto inicial: S/ %.2f"
                .format(producto.calcularMontoInicial())
        )

        println(
            "Interés: %.0f%%"
                .format(financiamiento.obtenerPorcentajeInteres() * 100)
        )

        println(
            "Monto del interés: S/ %.2f"
                .format(financiamiento.calcularInteres())
        )

        println(
            "Monto a pagar: S/ %.2f"
                .format(financiamiento.calcularMontoPagar())
        )

        println(
            "Número de cuotas: ${financiamiento.numeroCuotas}"
        )

        println(
            "Pago mensual: S/ %.2f"
                .format(financiamiento.calcularPagoMensual())
        )
    }
}