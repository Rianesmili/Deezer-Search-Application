package fr.mastersime.deezer_search_app.data

import android.util.Log
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import fr.mastersime.deezer_search_app.data.entities.AuthorEntity

class MoshiAdapter {
    @FromJson
    fun fromJson(songResponse: ListAuthorResponse): List<AuthorEntity> {
        Log.d("MoshiAdapter", "fromJson called with songResponse: $songResponse")
        return songResponse.data.map { songData ->
            AuthorEntity(
                id = songData.id,
                title = songData.title,
                album = songData.album.title,
                duration = songData.duration
            )
        }
    }

    @ToJson
    fun toJson(listSong: List<AuthorEntity>): ListAuthorResponse {
        return ListAuthorResponse(
            data = listSong.map { song ->
                SongData(
                    id = song.id,
                    title = song.title ?: "",
                    duration = song.duration ?: 0,
                    album = Album(id = 0L, title = song.album ?: "", type = "album"),
                    type = "track"
                )
            }
        )
    }
}