package com.lsimanenka.fastfeature2.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ImageScreen(
    viewModel : ImageViewModel = hiltViewModel(),
    modifier: Modifier
) {

    val state by viewModel.state.collectAsState()

    when (val currentState = state) {
        is ImageState.Success -> {
            ImageList(currentState.data, modifier)
        }
        is ImageState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = currentState.error )
            }
        }
        ImageState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

    }

}