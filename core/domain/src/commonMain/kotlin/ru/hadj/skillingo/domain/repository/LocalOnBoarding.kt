package ru.hadj.skillingo.domain.repository


interface LocalOnBoarding {

    suspend fun save(completed: Boolean)

    fun read(): Boolean
}