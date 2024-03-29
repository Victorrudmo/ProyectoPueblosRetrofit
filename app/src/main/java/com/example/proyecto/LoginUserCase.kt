package com.example.proyecto

import javax.inject.Inject

class LoginUserCase  @Inject constructor(
    private val userRepository: UserRepository

){
    private lateinit var posibleUser : User
    fun setUser(_posibleUser : User){
        posibleUser = _posibleUser
    }

    suspend operator fun invoke(): User ?{
        return (userRepository.getUser(posibleUser))
    }
}