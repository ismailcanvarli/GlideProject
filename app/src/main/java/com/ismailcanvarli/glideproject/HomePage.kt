//Created by canVarli on 12/28/2024

package com.ismailcanvarli.glideproject

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import kotlin.random.Random

@Composable
fun HomePage() {
    val context = LocalContext.current
    val imageNames = getImageNames(context)
    val imageName = remember { mutableStateOf(imageNames[0]) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val url = "http://kasimadalan.pe.hu/movies/images/${imageName.value}"

        GlideImage(
            imageModel = url,
            contentDescription = "Glide Image",
            modifier = Modifier.size(200.dp, 300.dp)
        )
        Button(onClick = {
            imageName.value = imageNames[Random.nextInt(imageNames.size)]
        }) {
            Text(text = "Rastgele Resim")
        }
        Button(onClick = {
            imageName.value = imageNames[0]
        }) {
            Text(text = "İlk Resim")
        }
        Button(onClick = {
            imageName.value = imageNames[imageNames.size - 1]
        }) {
            Text(text = "Son Resim")
        }
    }
}

fun getImageNames(context: Context): List<String> {
    return context.resources.getStringArray(R.array.image_names).toList()
}