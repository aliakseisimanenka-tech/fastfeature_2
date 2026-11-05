package com.lsimanenka.fastfeature2.data

import retrofit2.http.GET

interface NetworkApi {

    //TODO 3: use @Query for query params
    @GET("breeds/image/random/10")
    suspend fun getImages() : ImageDto


}