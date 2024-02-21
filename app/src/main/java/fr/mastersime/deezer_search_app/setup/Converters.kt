package fr.mastersime.deezer_search_app.setup

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import fr.mastersime.deezer_search_app.data.entities.Lines

class Converters {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @TypeConverter
    fun fromLines(lines: Lines): String {
        val jsonAdapter = moshi.adapter(Lines::class.java)
        return jsonAdapter.toJson(lines)
    }

    @TypeConverter
    fun toLines(linesString: String): Lines {
        val jsonAdapter = moshi.adapter(Lines::class.java)
        return jsonAdapter.fromJson(linesString)!!
    }
}