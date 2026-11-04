package com.lsimanenka.fastfeature2.data

import retrofit2.http.GET

interface NetworkApi {

    @GET("breeds/image/random/10")
    suspend fun getImages() : ImageDto


}