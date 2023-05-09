package com.tripbook.tripbook.data.api

import com.tripbook.tripbook.data.model.User
import retrofit2.http.GET

interface RetrofitInstance {

    @GET("api/")
    suspend fun getAllApi() : List<User>

}
