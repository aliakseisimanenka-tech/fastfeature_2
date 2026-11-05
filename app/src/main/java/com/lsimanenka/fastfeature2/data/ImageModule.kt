package com.lsimanenka.fastfeature2.data

import com.lsimanenka.fastfeature2.domain.ImageRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class ImageModule {

    @Binds
    abstract fun bindImageRepository(impl : ImageRepositoryImpl) : ImageRepository

    companion object {

        const val BASE_URL = "https://dog.ceo/api/"

       // val api : NetworkApi =
       //     Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create()


        //TODO 1: Can use provide for creating dependencies
        fun createDefaultJson(): Json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

        @Provides
        fun provideJson(): Json = createDefaultJson()

        @Provides
        @Singleton
        fun providesRetrofit(
            json: Json,
        ) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
                .build()
        }

        @Provides
        @Singleton
        fun providesApi(retrofit: Retrofit) : NetworkApi {
            return retrofit.create(NetworkApi::class.java)
        }

    }

}