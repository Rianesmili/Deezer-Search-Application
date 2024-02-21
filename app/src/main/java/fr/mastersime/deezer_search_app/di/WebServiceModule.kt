package fr.mastersime.deezer_search_app.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.mastersime.deezer_search_app.data.MoshiAdapter
import fr.mastersime.deezer_search_app.webservice.AuthorService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = " https://api.deezer.com/"

@Module
@InstallIn(SingletonComponent::class)
object WebServiceModule  {

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(MoshiAdapter())
            .build()
    }
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun provideAuthorWebservice(retrofit: Retrofit): AuthorService {
        return retrofit.create(AuthorService::class.java)
    }

}