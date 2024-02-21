package fr.mastersime.deezer_search_app.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.mastersime.deezer_search_app.data.entities.AuthorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<AuthorEntity>)


    @Query("SELECT * FROM AuthorEntity")
    fun getFirstListFlow(): Flow<List<AuthorEntity>>

    @Query("DELETE FROM AuthorEntity")
    suspend fun clearTabs()

}