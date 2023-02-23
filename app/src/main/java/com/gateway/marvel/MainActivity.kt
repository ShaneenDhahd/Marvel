package com.gateway.marvel

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.gateway.marvel.interactors.CharactersInteractor
import com.gateway.marvel.network.Api
import com.gateway.marvel.network.ApiBuilder
import com.gateway.marvel.network.BaseNetworkInteractor
import com.gateway.marvel.network.ResponseWrapper
import com.gateway.marvel.ui.theme.MarvelTheme
import com.gateway.marvel.viewModels.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val charactersVM by viewModels<CharactersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        charactersVM.getCharacters()
        charactersVM.characters.observe(this) {
            Log.d("home", "$it")
            when(it) {
                is ResponseWrapper.Failure -> Log.d("home", it.msg)

                ResponseWrapper.Loading -> Log.d("home", "$it")
                is ResponseWrapper.LocalFailure -> Log.d("home", getString(it.msgRes))
                is ResponseWrapper.Success -> Log.d("home", it.value.data.results.first().name)
            }
        }
        Log.d("home", "it")
        setContent {
            MarvelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Text(text = "Gateway ICT")
                }
            }
        }
    }
}
