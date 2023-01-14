package com.example.android.amphibiansapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Block
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            ResourceState.SUCCESS -> ErrorIndicator()
            ResourceState.ERROR -> ErrorIndicator()
        }
    }
}

@Composable
fun Amphibians() {
    // CircularProgressIndicator(modifier = Modifier.fillMaxSize())
}

@Composable
fun LoadingIndicator() {
    CircularProgressIndicator()
}

@Composable
fun ErrorIndicator() {
    Image(
        imageVector = Icons.Rounded.Block,
        contentDescription = "Error",
        modifier = Modifier.size(100.dp)
    )
}


