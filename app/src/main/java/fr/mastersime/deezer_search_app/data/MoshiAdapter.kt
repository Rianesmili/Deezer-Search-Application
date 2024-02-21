package fr.mastersime.deezer_search_app.data

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import fr.mastersime.deezer_search_app.data.entities.AuthorEntity

class MoshiAdapter {
    @FromJson
    fun fromJson(songResponse: ListSongResponse): List<AuthorEntity> {
        return songResponse.data.map { songData ->
            AuthorEntity(
                id = songData.id,
                title = songData.title,
                author = songData.album.title,
                duration = songData.duration
            )
        }
    }

    @ToJson
    fun toJson(listSong: List<AuthorEntity>): ListSongResponse {
        return ListSongResponse(
            data = listSong.map { song ->
                SongData(
                    id = song.id,
                    title = song.title ?: "",
                    duration = song.duration ?: 0,
                    album = Album(id = 0L, title = song.author ?: "", type = "album"),
                    type = "track"
                )
            }
        )
    }
}