package fr.mastersime.deezer_search_app.repository

import fr.mastersime.deezer_search_app.data.daos.AuthorDao
import fr.mastersime.deezer_search_app.data.entities.AuthorEntity
import fr.mastersime.deezer_search_app.webservice.AuthorService
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppRepositoryImpl @Inject constructor(
    private val authorDao: AuthorDao,
    private val authorService: AuthorService,
) : AppRepository {

    override val authorResponse: MutableStateFlow<AuthorResponse> = MutableStateFlow(
        AuthorResponse.Success(emptyList())
    )

    override suspend fun updateAuthor(artistName: String) {
        try {
            authorResponse.emit(AuthorResponse.Pending)
            val response = authorService.getAuthorList(artistName)
            val list = response.data.map { songData ->
                AuthorEntity(
                    id = songData.id,
                    title = songData.title,
                    author = songData.album.title,
                    duration = songData.duration
                )
            }
            authorDao.insertAll(list)
        } catch (e: IOException) {
            val errorMessage = "Network error"
            authorResponse.emit(AuthorResponse.Failure(errorMessage))
        } catch (e: HttpException) {
            val errorMessage = "Request error"
            authorResponse.emit(AuthorResponse.Failure(errorMessage))
        }
    }
}