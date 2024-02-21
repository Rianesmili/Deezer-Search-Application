package fr.mastersime.deezer_search_app.repository

import fr.mastersime.deezer_search_app.data.entities.AuthorEntity

sealed interface AuthorResponse {

    object Pending : AuthorResponse

    @JvmInline
    value class  Success(val list: List<AuthorEntity>) : AuthorResponse
    @JvmInline
    value class Failure(val errorMessage: String) : AuthorResponse

}