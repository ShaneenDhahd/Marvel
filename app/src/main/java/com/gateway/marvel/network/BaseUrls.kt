package com.gateway.marvel.network

object BaseUrls {
    const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
    const val AUTH_URL = "?apikey=ca74e2a96a3f354a8dc3bf07a0bf62db"
    const val CHARACTERS_URL = "${BASE_URL}characters${AUTH_URL}"
    const val COMICS_URL = "${BASE_URL}comics${AUTH_URL}"
    const val STORIES_URL = "${BASE_URL}stories${AUTH_URL}"
    const val SERIES_URL = "${BASE_URL}series${AUTH_URL}"
    const val EVENTS_URL = "${BASE_URL}events${AUTH_URL}"
    const val CARTOONS_URL = "${BASE_URL}cartoon${AUTH_URL}"
}