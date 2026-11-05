package com.lsimanenka.fastfeature2.data

import com.lsimanenka.fastfeature2.domain.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val api: NetworkApi
) : ImageRepository {

    //TODO 6: You can check ability to use Result for return type
    override suspend fun getImages(): Result<List<String>> = runCatching  {
        val dto = api.getImages(10)
        //TODO 4: enum class for status
        val status = ApiStatus.fromString(dto.status)

        if (status == ApiStatus.SUCCESS) {
            dto.message
        } else {
            throw IllegalStateException("Invalid message status: ${dto.status}")
        }
    }

}