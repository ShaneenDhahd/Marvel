package com.gateway.marvel.interactors

import com.gateway.marvel.network.Api
import com.gateway.marvel.network.BaseNetworkInteractor
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class CharactersInteractor @Inject constructor(private val api: Api): BaseNetworkInteractor() {
    fun getCharacters() = safeApiCall { api.getCharacters() }
}