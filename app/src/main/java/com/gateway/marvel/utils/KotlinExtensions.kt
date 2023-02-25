package com.gateway.marvel.utils

import android.util.Log
import com.gateway.marvel.BuildConfig
import com.gateway.marvel.models.Extension
import com.gateway.marvel.models.Thumbnail

fun logMessage(msg: Any?){
    if(BuildConfig.DEBUG){
        msg?.let {
            Log.d("MarvelApp", it.toString())
        }
    }
}

fun Thumbnail.getImage(): String {
    return "${this.path}.${this.extension.value.lowercase()}"
}