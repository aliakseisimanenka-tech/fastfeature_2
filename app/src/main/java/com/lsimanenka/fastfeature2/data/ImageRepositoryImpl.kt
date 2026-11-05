package com.lsimanenka.fastfeature2.data

import com.lsimanenka.fastfeature2.domain.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val api: NetworkApi
) : ImageRepository {

    //TODO 6: You can check ability to use Result for return type
    override suspend fun getImages(): List<String> {
        val dto = api.getImages()
        //TODO 4: enum class for status
        if (dto.status == "success") {
            return dto.message
        } else {
            //TODO 5: ok for quick feature writing
            throw Exception("Invalid message status")
        }
    }

}