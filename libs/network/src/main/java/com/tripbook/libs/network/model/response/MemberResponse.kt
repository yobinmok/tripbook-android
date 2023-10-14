package com.tripbook.libs.network.model.response

import com.squareup.moshi.Json

data class MemberResponse (
    @Json(name = "email")
    val email: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "role")
    val role: String,
    @Json(name = "birth")
    val birth: String,
    @Json(name = "profile")
    val profile: String,
    @Json(name = "termsOfService")
    val termsOfService: Boolean,
    @Json(name = "termsOfPrivacy")
    val termsOfPrivacy: Boolean,
    @Json(name = "termsOfLocation")
    val termsOfLocation: Boolean,
    @Json(name = "marketingConsent")
    val marketingConsent: Boolean,
    @Json(name = "point")
    val point: Long,
    @Json(name = "status")
    val status: String,
)