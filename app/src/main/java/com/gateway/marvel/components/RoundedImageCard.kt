package com.gateway.marvel.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun RoundedImageCard(image: Any) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
            .fillMaxWidth()
            .fillMaxHeight(50f)
            .padding(10.dp)
    ) {
        AsyncImage(model = image, contentDescription = "", contentScale = ContentScale.Crop)
    }
}