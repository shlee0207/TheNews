package com.hyunny.data.network

import com.hyunny.data.network.model.NetworkHeadlines
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    companion object {
        const val BASE_URL = "https://newsapi.org"
    }

    @GET("/v2/top-headlines?country=us")
    suspend fun fetchHeadlines(
        @Query("country") country: String? = null,
        @Query("category") category: String? = null,
        @Query("pageSize") pageSize: Int? = null,
        @Query("page") page: Int? = null,
    ): NetworkHeadlines

}
