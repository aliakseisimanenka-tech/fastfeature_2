package com.lsimanenka.fastfeature2.data

import com.lsimanenka.fastfeature2.domain.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val api: NetworkApi
) : ImageRepository {
    override suspend fun getImages(): List<String> {
        val dto = api.getImages()
        if (dto.status == "success") {
            return dto.message
        } else {
            throw Exception("Invalid message status")
        }
    }

}