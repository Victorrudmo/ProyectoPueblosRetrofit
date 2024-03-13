package com.example.proyecto

import android.content.Context
import android.content.SharedPreferences
/*
// Clase que gestiona las preferencias compartidas para almacenar información como el usuario autenticado.
class Preferences(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)

    // Método para guardar el usuario autenticado en las preferencias compartidas.
    fun guardarUsuario(usuario: String) {
        val editor = sharedPreferences.edit()
        editor.putString("usuario", usuario)
        editor.putBoolean("autenticado", true)
        editor.apply()
    }

    // Método para obtener el usuario autenticado de las preferencias compartidas.
    fun obtenerUsuario(): String? {
        return sharedPreferences.getString("usuario", null)
    }

    // Método para verificar si hay un usuario autenticado.
    fun isAutenticado(): Boolean {
        return sharedPreferences.getBoolean("autenticado", false)
    }

    // Método para limpiar todas las preferencias compartidas.
    fun limpiarPreferencias() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}
*/
