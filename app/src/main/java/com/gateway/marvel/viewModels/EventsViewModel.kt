package com.gateway.marvel.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gateway.marvel.interactors.EventsInteractor
import com.gateway.marvel.models.Events
import com.gateway.marvel.models.MainResponse
import com.gateway.marvel.network.ResponseWrapper
import com.gateway.marvel.utils.logMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(private val eventsInteractor: EventsInteractor): ViewModel() {
    private val _events = MutableLiveData<ResponseWrapper<MainResponse>>()
    val events: MutableState<ResponseWrapper<MainResponse>?> = mutableStateOf(null)
    fun getEvents() {
        viewModelScope.launch {
            logMessage("getting characters")
            eventsInteractor.getEvents().collect {
                _events.postValue(it)
                events.value = it
            }
        }
    }
}