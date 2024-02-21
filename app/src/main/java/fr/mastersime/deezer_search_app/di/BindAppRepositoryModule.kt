package fr.mastersime.deezer_search_app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.mastersime.deezer_search_app.repository.AppRepository
import fr.mastersime.deezer_search_app.repository.AppRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class providesAppRepositoryModule {
    @Binds
    abstract fun bindAppRepository(
        appRepositoryImpl: AppRepositoryImpl
    ): AppRepository
}