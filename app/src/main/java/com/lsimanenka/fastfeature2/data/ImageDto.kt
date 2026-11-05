package com.lsimanenka.fastfeature2.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//TODO 2: use @SerialName
@Serializable
data class ImageDto(
    @SerialName("message")
    val message : List<String>,
    @SerialName("status")
    val status : String
)