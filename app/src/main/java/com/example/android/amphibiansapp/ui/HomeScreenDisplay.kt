package com.example.android.amphibiansapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.android.amphibiansapp.ui.mainscreen.AmphibianViewModel
import com.example.android.amphibiansapp.ui.mainscreen.ResourceState

@Composable
fun HomeScreen(viewModel: AmphibianViewModel = hiltViewModel()) {

    viewModel.loadAmphibians()
    val uiState = viewModel.uiState.collectAsState()

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (uiState.value.state) {
            ResourceState.LOADING -> LoadingIndicator()
            ResourceState.SUCCESS -> Amphibians()
            ResourceState.ERROR -> ErrorIndicator()
        }
    }
}

@Composable
fun LoadingIndicator() {
    CircularProgressIndicator()
}

@Composable
fun Amphibians() {
    // CircularProgressIndicator(modifier = Modifier.fillMaxSize())
}

@Composable
fun ErrorIndicator() {
    //CircularProgressIndicator(modifier = Modifier.fillMaxSize())
}


