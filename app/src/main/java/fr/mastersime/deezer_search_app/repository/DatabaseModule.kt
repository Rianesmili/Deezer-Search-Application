package fr.mastersime.deezer_search_app.repository

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.mastersime.deezer_search_app.data.daos.AuthorDao
import fr.mastersime.deezer_search_app.data.AppRoomDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAuthorDao(database: AppRoomDatabase): AuthorDao {
        return database.authorDao()
    }

    @Provides
    @Singleton
    fun provideDatabaseModule(@ApplicationContext appContext: Context): AppRoomDatabase {
        return  Room.databaseBuilder(
            appContext.applicationContext,
            AppRoomDatabase::class.java,
            "exam_database"
        ).build()
    }
}