package fr.mastersime.deezer_search_app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.mastersime.deezer_search_app.data.daos.AuthorDao
import fr.mastersime.deezer_search_app.data.entities.AuthorEntity
import fr.mastersime.deezer_search_app.setup.Converters

@Database(
    entities = [AuthorEntity::class],
    version = 1, exportSchema = false
)

@TypeConverters(Converters::class)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun authorDao(): AuthorDao
}