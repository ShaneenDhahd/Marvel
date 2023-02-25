package com.gateway.marvel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gateway.marvel.models.HomeSections
import com.gateway.marvel.network.ResponseWrapper
import com.gateway.marvel.ui.theme.MarvelTheme
import com.gateway.marvel.utils.getImage
import com.gateway.marvel.utils.logMessage
import com.gateway.marvel.viewModels.CharactersViewModel
import com.gateway.marvel.viewModels.EventsViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.nesyou.staggeredgrid.LazyStaggeredGrid
import com.nesyou.staggeredgrid.StaggeredCells
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val charactersVM by viewModels<CharactersViewModel>()
    private val eventsVM by viewModels<EventsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        charactersVM.getCharacters()
        eventsVM.getEvents()

        setContent {

            MarvelTheme {
                Surface() {
                    HomeScreen()
                }
            }
        }

    }


}

