package com.tripbook.tripbook.data.model

import com.squareup.moshi.Json

data class User (
    @Json(name = "id")
    val id :String
)