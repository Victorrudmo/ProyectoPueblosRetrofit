package com.example.proyecto

object UserList {
    private val users: MutableList<User> = mutableListOf()

    fun addUser(user: User) {
        users.add(user)
    }

    fun checkUsers(user: String): Boolean {
        for (u in users) {
            if (u.getUser() == user) {
                return true
            }
        }
        return false
    }
    fun checkUsersPassword(user: User): Boolean {
        for (u in users) {
            if (user.getUser() == u.getUser() && user.getPassword() == u.getPassword() ) {
                return true
            }
        }
        return false
    }
}