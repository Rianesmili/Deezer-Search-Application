package fr.mastersime.deezer_search_app.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AuthorEntity (
    @PrimaryKey
    val id: Long = 0L,
    val title: String? = "",
    val author: String? = "",
    val duration: Int? = null,
)