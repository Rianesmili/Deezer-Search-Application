package fr.mastersime.deezer_search_app.repository

import kotlinx.coroutines.flow.Flow

interface AppRepository {
    val authorResponse: Flow<AuthorResponse>
    suspend fun updateAuthor(artistName: String)
}