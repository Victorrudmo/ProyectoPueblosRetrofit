package com.example.proyecto

import javax.inject.Inject

// Clase que proporciona un mensaje para ser utilizado en la inyección de dependencias.
class Hilt1 @Inject constructor() {

    // Método que devuelve un mensaje relacionado con la inyección de dependencias.
    fun hilt(): String {
        return "Inyección de dependencias con Hilt"
    }
}