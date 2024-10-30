package com.hadj.skillingo.di

//import com.hadj.skillingo.skillingoRoomDatabaseBuilder
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import ru.hadj.database.db.SkillingpRoomDatabase
import ru.hadj.database.db.skillingoRoomDatabaseBuilder
import ru.hadj.skillingo.common.PlatformContext
import ru.hadj.skillingo.common.Singleton
import ru.hadj.skillingo.data.implementation.TaskGroupRepositoryImpl
import ru.hadj.skillingo.data.implementation.TaskRepositoryImpl
import kotlin.properties.Delegates.notNull

@Component
@Singleton
abstract class AppComponent(
    protected val platformContext: PlatformContext,
    ) {
    abstract val taskRepository: TaskRepositoryImpl
    abstract val taskGroupRepository: TaskGroupRepositoryImpl

    abstract val skillingoDatabase: SkillingpRoomDatabase

    @Singleton
    @Provides
    internal fun providesSkillingoDatabase(
    ): SkillingpRoomDatabase {
        return SkillingpRoomDatabase(
            databaseBuilder = skillingoRoomDatabaseBuilder(platformContext),
        )
    }

    companion object {

        var appComponent: AppComponent by notNull()
            private set

        internal fun create(
            platformContext: PlatformContext,
        ): AppComponent {
            appComponent = createAppComponent(platformContext)
            return appComponent
        }
    }
}

internal expect fun createAppComponent(
    platformContext: PlatformContext,
): AppComponent