package com.lsimanenka.fastfeature2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lsimanenka.fastfeature2.domain.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val repository: ImageRepository
) : ViewModel() {

    private val _state = MutableStateFlow<ImageState>(ImageState.Loading)
    val state = _state.asStateFlow()

    init {
        loadImages()
    }

    private fun loadImages() {
        viewModelScope.launch {
            _state.value = ImageState.Loading

            repository.getImages()
                .onSuccess {
                    _state.value = ImageState.Success(it)
                }
                .onFailure {
                    _state.value = ImageState.Error(it.localizedMessage ?: "Unknown error")
                }

        }
    }

}