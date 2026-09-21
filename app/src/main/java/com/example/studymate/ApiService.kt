package com.example.studymate

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

data class HealthResponse(
    val status: String,
    val protocol: String,
    val firebase: String
)

data class Login(
    val email: String,
    val  password: String
)

data class Register(
val firstName: String,
val lastName: String,
val username: String,
val email: String,
val password: String
)
interface ApiService {

    @GET("health")
   suspend fun checkHealth(): Response<HealthResponse>


    @POST("user/login")
    fun login(email: String,password: String): Response<Login>



    @POST("user/register")
     fun register(): Response<Register>
}