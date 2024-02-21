package fr.mastersime.deezer_search_app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.mastersime.deezer_search_app.data.daos.AuthorDao
import fr.mastersime.deezer_search_app.data.entities.AuthorEntity

@Database(
    entities = [AuthorEntity::class],
    version = 1, exportSchema = false
)

abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun authorDao(): AuthorDao
}