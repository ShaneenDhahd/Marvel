package com.gateway.marvel.interactors

import com.gateway.marvel.network.Api
import com.gateway.marvel.network.BaseNetworkInteractor
import javax.inject.Inject

class EventsInteractor @Inject constructor(private val api: Api): BaseNetworkInteractor()  {
    fun getEvents() = safeApiCall { api.getEventss() }
}