package com.lsimanenka.fastfeature2.domain

interface ImageRepository {
    suspend fun getImages() : List<String>
}