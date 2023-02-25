package com.gateway.marvel.models

import com.gateway.marvel.R

object HomeSections {
    val sections = ArrayList<HomeSection>()
    init {
        sections.add(HomeSection(R.drawable.m_characters,Destination.Characters))
        sections.add(HomeSection(R.drawable.m_comics,Destination.Comics))
        sections.add(HomeSection(R.drawable.m_events,Destination.Events))
        sections.add(HomeSection(R.drawable.m_cartoons,Destination.Cartoons))
        sections.add(HomeSection(R.drawable.m_series,Destination.Series))
        sections.add(HomeSection(R.drawable.m_stories,Destination.Stories))
    }
}
data class HomeSection(val img: Int,val destination: Destination) {
}
enum class Destination {
    Characters,
    Comics,
    Events,
    Cartoons,
    Series,
    Stories
}