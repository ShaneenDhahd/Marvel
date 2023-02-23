package com.gateway.marvel.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
interface Api {

    @GET(BaseUrls.CHARACTERS_URL)
    suspend fun getCharacters(
        @Query("apikey") apikey: String = BaseUrls.AUTH,
        @Query("ts") ts: String = BaseUrls.timeStamp,
        @Query("hash") hash: String = BaseUrls.hash()
    ): Response<Any>
}