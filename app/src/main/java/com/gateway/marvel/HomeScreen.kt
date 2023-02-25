package com.gateway.marvel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.gateway.marvel.components.CenteredCompose
import com.gateway.marvel.components.RoundedImageCard
import com.gateway.marvel.models.HomeSections
import com.gateway.marvel.network.ResponseWrapper
import com.gateway.marvel.utils.getImage
import com.gateway.marvel.utils.logMessage
import com.gateway.marvel.viewModels.EventsViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.nesyou.staggeredgrid.LazyStaggeredGrid
import com.nesyou.staggeredgrid.StaggeredCells

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    eventsViewModel: EventsViewModel = hiltViewModel()
) {

    Box {

        Column {


            CenteredCompose(height = 10) {}
            CenteredCompose(height = 80) {
                AsyncImage(
                    model = R.drawable.marvel_texticon,
                    contentDescription = ""
                )
            }
            EventsPosters(eventsViewModel)
            SearchButton()
            Sections()
        }
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun EventsPosters(eventsViewModel: EventsViewModel) {
    val state = eventsViewModel.events.value

    logMessage(state)

    when (state) {
        is ResponseWrapper.Failure -> {
            logMessage("failure ${state.msg}")
        }
        ResponseWrapper.Loading -> {
            CenteredCompose(height = 150) {
                CircularProgressIndicator()
            }
        }
        is ResponseWrapper.LocalFailure -> {
            logMessage("local failure ${state.msgRes}")
        }
        is ResponseWrapper.Success -> {
            val results = state.value.data.results
            HorizontalPager(results.size, Modifier.height(180.dp)) { page ->
                RoundedImageCard(image = results[page].thumbnail.getImage())
            }
        }
        else -> {
        }
    }
}

@Composable
fun SearchButton() {
    val interactionSource = MutableInteractionSource()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.Transparent)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {

            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Filled.Search,
                contentDescription = "Search",
                modifier = Modifier.size(30.dp)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Search for Marvel Characters", fontSize = 14.sp)
        }
    }
}

@Preview
@Composable
fun Sections() {
    val sections = HomeSections.sections

    LazyStaggeredGrid(cells = StaggeredCells.Adaptive(minSize = 180.dp)) {
        items(sections) {

                Box {
                    AsyncImage(
                        model = it.img,
                        contentDescription = null,
                        modifier = Modifier
                            .height(120.dp)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
                Text(text = it.destination.name, Modifier.padding(horizontal = 10.dp))
        }
    }
}
