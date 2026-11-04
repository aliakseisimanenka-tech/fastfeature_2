package com.lsimanenka.fastfeature2.presentation

sealed interface ImageState {
    data object Loading : ImageState
    data class Success(val data : List<String>) : ImageState
    data class Error(val error: String) : ImageState
}
