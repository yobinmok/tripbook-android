package com.tripbook.tripbook.domain.repository

import com.tripbook.tripbook.domain.model.ArticleDetail
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

   fun likeArticle(articleId : Long) : Flow<Boolean>

   fun getArticleDetail(articleId : Long) : Flow<ArticleDetail?>

}