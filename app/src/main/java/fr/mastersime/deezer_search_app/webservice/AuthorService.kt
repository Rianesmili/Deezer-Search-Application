package fr.mastersime.deezer_search_app.webservice

import fr.mastersime.deezer_search_app.data.ListAuthorResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthorService {
    @GET("search")
    suspend fun getAuthorList(@Query("q") artistName: String): ListAuthorResponse
}