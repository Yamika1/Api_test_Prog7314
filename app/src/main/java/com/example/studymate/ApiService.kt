package com.example.studymate

import retrofit2.Response
import retrofit2.http.GET

data class HealthResponse(
    val status: String,
    val protocol: String,
    val firebase: String
)
interface ApiService {

    @GET("health")
    suspend fun checkHealth(): Response<HealthResponse>
}