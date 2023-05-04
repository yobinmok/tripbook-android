package com.tripbook.tripbook.data.mapper

import com.tripbook.tripbook.data.model.User

fun setUserInfo (user : List<User>) : List<User> {
    return user.toList().map {
        User(
            it.id
        )
    }
}