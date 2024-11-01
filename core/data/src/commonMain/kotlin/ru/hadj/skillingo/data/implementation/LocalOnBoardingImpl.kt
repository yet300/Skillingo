package ru.hadj.skillingo.data.implementation

import kotlinx.coroutines.flow.Flow
import ru.hadj.database.store.OnBoardingDataStore
import ru.hadj.skillingo.domain.repository.LocalOnBoarding

class LocalOnBoardingImpl(
    private val dataStore: OnBoardingDataStore
) : LocalOnBoarding {

    override suspend fun save(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    override fun read(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}