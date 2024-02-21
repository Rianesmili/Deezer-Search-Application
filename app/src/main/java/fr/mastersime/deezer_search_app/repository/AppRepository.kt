package fr.mastersime.deezer_search_app.repository

import fr.mastersime.deezer_search_app.data.entities.AuthorEntity
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    val authorResponse: Flow<AuthorResponse>
    val songs: Flow<List<AuthorEntity>>
    suspend fun updateAuthor(artistName: String)
}