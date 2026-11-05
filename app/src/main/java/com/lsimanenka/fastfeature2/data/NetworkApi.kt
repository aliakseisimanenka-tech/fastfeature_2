package com.lsimanenka.fastfeature2.data

import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkApi {

    //TODO 3: use @Query for query params
    @GET("breeds/image/random/{count}")
    suspend fun getImages(
        @Path("count") count: Int
    ) : ImageDto


}