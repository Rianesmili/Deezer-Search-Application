package fr.mastersime.deezer_search_app.data


data class ListAuthorResponse(
    val data: List<SongData>
)

data class SongData(
    val id: Long,
    val title: String,
    val duration: Int,
    val album: Album,
    val type: String
)

data class Album(
    val id: Long,
    val title: String,
    val type: String
)