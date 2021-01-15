package com.shashi.week6_assignment1softuserreplica.model

class User {
    fun LoginOperation(username: String, password: String): Boolean {
        return username.trim().toLowerCase().equals("softwarica") && password.trim().toLowerCase()
            .equals("coventry");
    }
}