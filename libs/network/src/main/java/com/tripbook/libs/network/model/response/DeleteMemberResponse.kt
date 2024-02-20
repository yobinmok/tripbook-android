package com.tripbook.libs.network.model.response

import com.squareup.moshi.Json

data class DeleteMemberResponse (
    @Json(name = "status")
    val status: String?,
    @Json(name = "message")
    val message: List<String>?,
    @Json(name = "code")
    val code : String?
)