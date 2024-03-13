package com.example.proyecto

import javax.inject.Inject

// Clase que utiliza una instancia de Hilt1 para proporcionar un mensaje relacionado con la inyección de dependencias.
class Hilt2 @Inject constructor(private val uno: Hilt1) {

    // Método que devuelve el mensaje de Hilt1.
    fun pruebaHilt(): String {
        return uno.hilt()
    }
}