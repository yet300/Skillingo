package ru.hadj.skillingo.domain.repository

import kotlinx.coroutines.flow.Flow

interface LocalOnBoarding {

    suspend fun save(completed: Boolean)

    fun read(): Flow<Boolean>
}