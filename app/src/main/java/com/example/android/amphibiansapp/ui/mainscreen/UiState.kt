package com.example.android.amphibiansapp.ui.mainscreen

import com.example.android.amphibiansapp.data.response.Amphibian

enum class ResourceState {
    LOADING, SUCCESS, ERROR
}

data class UiState(
    val state: ResourceState = ResourceState.LOADING,
    val amphibians: List<Amphibian> = listOf()
)
