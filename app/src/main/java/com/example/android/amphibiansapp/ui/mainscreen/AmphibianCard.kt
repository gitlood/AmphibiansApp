package com.example.android.amphibiansapp.ui.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.android.amphibiansapp.data.response.Amphibian

@Composable
fun Amphibian(amphibian: Amphibian) {
    Card(elevation = 4.dp, modifier = Modifier.padding(vertical = 5.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(5.dp)) {
            Text(
                textAlign = TextAlign.Center,
                text = "${amphibian.name} (${amphibian.type})",
                style = MaterialTheme.typography.h6
            )
            Text(
                text = amphibian.description,
                style = MaterialTheme.typography.body1
            )
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibian.imgsrc)
                    .crossfade(true)
                    .build(),
                contentDescription = "Image for ${amphibian.type}",
                contentScale = ContentScale.FillWidth
            )
        }
    }
}