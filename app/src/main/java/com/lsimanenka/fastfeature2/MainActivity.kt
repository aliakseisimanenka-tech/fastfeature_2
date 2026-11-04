package com.lsimanenka.fastfeature2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.lsimanenka.fastfeature2.presentation.ImageScreen
import com.lsimanenka.fastfeature2.ui.theme.Fastfeature2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Fastfeature2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    ImageScreen(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}

