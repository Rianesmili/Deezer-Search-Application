package fr.mastersime.deezer_search_app.webservice

import fr.mastersime.deezer_search_app.data.ListAuthorResponse
import fr.mastersime.deezer_search_app.data.entities.AuthorEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthorService {
    @GET("/search?q={artistName}")
    suspend fun getAuthorList(@Path("artistName") artistName: String): ListAuthorResponse
}