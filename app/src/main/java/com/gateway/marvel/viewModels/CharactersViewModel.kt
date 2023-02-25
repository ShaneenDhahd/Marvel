package com.gateway.marvel.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gateway.marvel.interactors.CharactersInteractor
import com.gateway.marvel.models.MainResponse
import com.gateway.marvel.network.ResponseWrapper
import com.gateway.marvel.utils.logMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val charactersInteractor: CharactersInteractor): ViewModel() {
    private val _characters = MutableLiveData<ResponseWrapper<MainResponse>>()
    val characters:MutableState<ResponseWrapper<MainResponse>?> = mutableStateOf(null)
    val nameQuery: String? = null
    fun getCharacters() {
        viewModelScope.launch {
            logMessage("getting characters")
            charactersInteractor.getCharacters(name = nameQuery).collect {
                _characters.postValue(it)
                characters.value = it
                logMessage("getting characters 2 ${characters.value} and $it")
            }
        }
    }
}