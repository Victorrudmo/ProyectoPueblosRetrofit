package com.example.proyecto

data class User (var id: Int, var token: String, var email:String, var passw:String, val disponible: Int, var imagen: String){

    //constructor primario
    constructor(email: String, passw: String):
            this(0, "", email, passw, 0, "")

    private lateinit var user: String
    private lateinit var password: String

    fun getUser(): String {
        return user
    }

    fun setUser(user: String) {
        this.user = user
    }

    fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }
}