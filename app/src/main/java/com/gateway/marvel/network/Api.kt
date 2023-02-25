package com.gateway.marvel.network

import com.gateway.marvel.models.MainResponse
import com.gateway.marvel.models.Events
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
interface Api {

    @GET(BaseUrls.CHARACTERS_URL)
    suspend fun getCharacters(
        @Query("apikey") apikey: String = ApiKey.AUTH,
        @Query("ts") ts: String = ApiKey.timeStamp,
        @Query("hash") hash: String = ApiKey.hash(),
        @Query("name") name: String? = null
    ): Response<MainResponse>

    @GET(BaseUrls.EVENTS_URL)
    suspend fun getEventss(
        @Query("apikey") apikey: String = ApiKey.AUTH,
        @Query("ts") ts: String = ApiKey.timeStamp,
        @Query("hash") hash: String = ApiKey.hash(),
    ): Response<MainResponse>
    @GET(BaseUrls.EVENTS_URL)
    suspend fun getEvents(
        @Query("apikey") apikey: String = ApiKey.AUTH,
        @Query("ts") ts: String = ApiKey.timeStamp,
        @Query("hash") hash: String = ApiKey.hash(),
    ): Response<MainResponse>
}