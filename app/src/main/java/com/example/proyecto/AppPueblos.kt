package com.example.proyecto

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*
    Clase anotada con @HiltAndroidApp para indicar que Hilt debe generar
    un contenedor de inyección de dependencias para la aplicación.
*/

@HiltAndroidApp
class AppPueblos : Application() {

}