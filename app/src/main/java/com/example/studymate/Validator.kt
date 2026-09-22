package com.example.studymate

object Validator {

    fun isValidUsername(Username: String): Boolean {
        return Username.contains("#")
    }

        fun isValidPassword(Password: String): Boolean {
            return Password.length >=8 && Password.any {it.isDigit()} &&
               Password.any {!it.isLetterOrDigit()}
        }
    }
