package com.example.proyecto.models

class Pueblo (
    var name: String,
    var habitants: String,
    var image: String
) {
    override fun toString(): String {
        return "Pueblo(name='$name', habitants='$habitants', image='$image')"
    }
}