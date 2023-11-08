package com.tripbook.libs.network.service

import com.tripbook.libs.network.model.response.ArticleDetailResponse
import com.tripbook.libs.network.model.response.LikeArticleResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TripArticlesService {

    @POST("{articleId}/like")
    suspend fun likeArticle(
        @Path("articleId") articledId: Long
    ): LikeArticleResponse

    @GET("{articleId}")
    suspend fun getArticleDetail(
        @Path("articleId") articledId: Long
    ) : ArticleDetailResponse
}