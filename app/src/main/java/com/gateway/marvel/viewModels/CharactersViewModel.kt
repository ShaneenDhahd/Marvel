package com.gateway.marvel.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gateway.marvel.interactors.CharactersInteractor
import com.gateway.marvel.models.Characters
import com.gateway.marvel.network.ResponseWrapper
import com.gateway.marvel.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val charactersInteractor: CharactersInteractor): ViewModel() {
    private val _characters = MutableLiveData<ResponseWrapper<Characters>>()
    val characters = _characters.asLiveData()
    val nameQuery: String? = null
    fun getCharacters() {
        viewModelScope.launch {
            charactersInteractor.getCharacters(name = nameQuery).collect {
                _characters.postValue(it)
            }
        }
    }
}