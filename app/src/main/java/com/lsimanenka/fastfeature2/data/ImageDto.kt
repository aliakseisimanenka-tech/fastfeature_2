package com.lsimanenka.fastfeature2.data

import kotlinx.serialization.Serializable

@Serializable
data class ImageDto(
    val message : List<String>,
    val status : String
)